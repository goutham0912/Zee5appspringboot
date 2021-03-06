package com.zee.zee5app.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.zee.zee5app.dto.Subscriptions;
import com.zee.zee5app.exception.NameNotFound;

public interface Subscription_Service1 {
	public Subscriptions addSubscription(Subscriptions s);
	public String deleteSubscription(Long id) throws NameNotFound;
	public Optional<Subscriptions> getSubscription(Long id) throws NameNotFound;
	public Optional<List<Subscriptions>> getallSubscription();
	public String updatesubscription(Long id,Subscriptions s) throws NameNotFound;
}
