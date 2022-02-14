package com.zee.zee5app.dto;

import java.math.BigDecimal;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;
import com.zee.zee5app.dto.UserBankDetails;
import com.zee.zee5app.exception.InvalidAmountException;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Data
@Entity
@Table(name="subscriptions")
@Setter
@Getter
@NoArgsConstructor
//@AllArgsConstructor
public class Subscriptions {
	@Id
	@Column(name="id")
	 @GeneratedValue(strategy = GenerationType.AUTO)
	 private Long id;
	@NotNull
	private Date dateOfPurchase;
	@NotNull
	private Date expiryDate;
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
	
	@OneToOne
	@JoinColumn(name="regId")
	@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
	@JsonProperty(access=Access.WRITE_ONLY)
	private User register;

	public Subscriptions(@NotNull Date dateOfPurchase, @NotNull Date expiryDate, @NotNull int subscriptionCost,
			String paymentMode, @NotBlank String status, @NotBlank String type, @NotBlank String autoRenewal,
			@NotBlank String packCountry, User register) {
		super();
		this.dateOfPurchase = dateOfPurchase;
		this.expiryDate = expiryDate;
		this.subscriptionCost = subscriptionCost;
		this.paymentMode = paymentMode;
		this.status = status;
		this.type = type;
		this.autoRenewal = autoRenewal;
		this.packCountry = packCountry;
		this.register = register;
	}
	
	
//	public void setAmount(int amount) throws InvalidAmountException {
//		int subscription_cost = 2000;
//		UserBankDetails userdetails=new UserBankDetails();
//		System.out.println(this.amount);
//		if(subscription_cost<userdetails.getBankbalance())
//			throw new InvalidAmountException("bank balance is less than the subscription amount cost");
//		if(amount<subscription_cost)
//			throw new InvalidAmountException("Please enter valid amount");
//		this.amount = amount;
//	}
//	public Subscriptions() {
//		
//	}
//

}
