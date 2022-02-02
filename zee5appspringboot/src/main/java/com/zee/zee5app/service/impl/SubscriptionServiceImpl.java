package com.zee.zee5app.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zee.zee5app.dto.Movies;
import com.zee.zee5app.dto.Subscriptions;
import com.zee.zee5app.exception.NameNotFound;
import com.zee.zee5app.repository.SubscriptionRepository;
import com.zee.zee5app.service.Subscription_Service1;
@Service
public class SubscriptionServiceImpl implements Subscription_Service1 {
	@Autowired
SubscriptionRepository repo;
	@Override
	public String addSubscription(Subscriptions s) {
		// TODO Auto-generated method stub
		Subscriptions subscriptions= repo.save(s);
		if(subscriptions!=null)
			return "Success";
		else
			return "fail";
	}

	@Override
	public String deleteSubscription(String id) throws NameNotFound {
		// TODO Auto-generated method stub
		Optional<Subscriptions> optional=this.getSubscription(id);
		if(optional.isEmpty())
			throw new NameNotFound("Subscription not found");
		else
		{
			repo.deleteById(id);
			return "Successfully deleted";
		}
	}

	@Override
	public Optional<Subscriptions> getSubscription(String id) throws NameNotFound {
		// TODO Auto-generated method stub
		return repo.findById(id);
	}

	@Override
	public Optional<List<Subscriptions>> getallSubscription() {
		// TODO Auto-generated method stub
		List<Subscriptions> m=repo.findAll();
		return Optional.ofNullable(m);
	}

	@Override
	public String updatesubscription(String id, Subscriptions s) throws NameNotFound {
		// TODO Auto-generated method stub
		return null;
	}

}
