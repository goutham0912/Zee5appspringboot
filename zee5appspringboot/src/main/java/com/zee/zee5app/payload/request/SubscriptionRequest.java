package com.zee.zee5app.payload.request;

import java.sql.Date;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.Data;
@Data
public class SubscriptionRequest {
	@NotNull
	private String dateOfPurchase;
	@NotNull
	private String expiryDate;
	@NotNull
	private int subscriptionCost;
	private String paymentMode;
	@NotBlank //it used for string
	private String status;
	@NotBlank
	private String type;
	
	@NotBlank
	private String autoRenewal;
//	@NotBlank
//	private String regId;
	@NotBlank
	private String packCountry;
	private String user;
}
