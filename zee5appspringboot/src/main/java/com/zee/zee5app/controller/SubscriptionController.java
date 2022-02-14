package com.zee.zee5app.controller;

import java.sql.Date;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zee.zee5app.dto.Series;
import com.zee.zee5app.dto.Subscriptions;
import com.zee.zee5app.exception.LocationNotFound;
import com.zee.zee5app.exception.NameNotFound;
import com.zee.zee5app.exception.RecordExists;
import com.zee.zee5app.payload.request.SeriesRequest;
import com.zee.zee5app.payload.request.SubscriptionRequest;
import com.zee.zee5app.repository.UserRepository;
import com.zee.zee5app.service.Subscription_Service1;

@RestController
@RequestMapping("/api/subscription")
public class SubscriptionController {
	@Autowired
	UserRepository repository;
	@Autowired
	Subscription_Service1 subscription_Service1;
	@PostMapping("/addSubscription")
	@PreAuthorize("hasRole('ROLE_USER') or hasRole('ROLE_ADMIN')")
	public ResponseEntity<?> addSeries(@Valid @RequestBody SubscriptionRequest subscriptionRequest) throws RecordExists

	{
		Subscriptions subscriptions=new Subscriptions(Date.valueOf(subscriptionRequest.getDateOfPurchase()), 
				Date.valueOf(subscriptionRequest.getExpiryDate()), 
				subscriptionRequest.getSubscriptionCost(), subscriptionRequest.getPaymentMode(), 
				subscriptionRequest.getStatus(), subscriptionRequest.getType(), subscriptionRequest.getAutoRenewal(),
				subscriptionRequest.getPackCountry(),
				repository.findByUsername(subscriptionRequest.getUser()).get()
				);
		Subscriptions subscriptionDetails=subscription_Service1.addSubscription(subscriptions);
		
		
		
		return ResponseEntity.status(200).body(subscriptionDetails);
	}
	@GetMapping("/{id}")
	@PreAuthorize("hasRole('ROLE_USER')")
	public ResponseEntity<?> getAllDetails(@PathVariable("id") long id ) throws NameNotFound, LocationNotFound
	{
		Optional<Subscriptions> seriesDetails=subscription_Service1.getSubscription(id);
		return ResponseEntity.status(200).body(seriesDetails.get());
	}

}
