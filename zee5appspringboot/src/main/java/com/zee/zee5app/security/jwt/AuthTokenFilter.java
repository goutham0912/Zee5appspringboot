package com.zee.zee5app.security.jwt;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import com.zee.zee5app.security.services.UserDetailsImpl;
import com.zee.zee5app.security.services.UserDetailsServiceImpl;

public class AuthTokenFilter extends OncePerRequestFilter {

	@Autowired
	private JwtUtils jwtUtils;
	
	@Autowired
	private UserDetailsServiceImpl userDetailsServiceImpl;
	
	private static final Logger logger=LoggerFactory.getLogger(AuthTokenFilter.class);
	
	@Override
	//validate the token
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String jwt=parseJwt(request);
		try {
			if(jwt!=null && jwtUtils.validateJwtToken(jwt))
			{
				String username=jwtUtils.getUserNameFromJwtToken(jwt);
				UserDetails userDetails=userDetailsServiceImpl.loadUserByUsername(username);
				UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken=new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
				usernamePasswordAuthenticationToken.setDetails(new WebAuthenticationDetails(request));
				SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
				
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			logger.error("cannot set user authentication{}",e);
		}
		filterChain.doFilter(request, response);//internally it calls next filter

	}
	private String parseJwt(HttpServletRequest request)
	{
		String headerAuth=request.getHeader("Authorization");
		if(StringUtils.hasText(headerAuth) && headerAuth.startsWith("Bearer "))
		{
			return headerAuth.substring(7, headerAuth.length());
		}
		return null;
	}

}
