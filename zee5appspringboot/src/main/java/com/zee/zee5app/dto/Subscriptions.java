package com.zee.zee5app.dto;

import java.math.BigDecimal;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

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
@AllArgsConstructor
public class Subscriptions {
	@Id
	@Column(name="id")
	private String id;
	@NotNull
	private Date dateofpurchase;
	@NotNull
	private Date expirydate;
	@NotNull
	private int subscription_cost;
	private String paymentmode;
	@NotBlank //it used for string
	private String status;
	@NotBlank
	private String type;
	
	@NotBlank
	private String autorenewal;
	@NotBlank
	private String regid;
	@NotBlank
	private String packcountry;
	
	
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
//	public Subscriptions(String id, String dateofpurchase, String expirydate, int subscription_cost,
//			String paymentmode, String status, String type, String autorenewal, String regid) {
//		super();
//		this.id = id;
//		this.dateofpurchase = dateofpurchase;
//		this.expirydate = expirydate;
//		this.subscription_cost = subscription_cost;
//		this.paymentmode = paymentmode;
//		this.status = status;
//		this.type = type;
//		this.autorenewal = autorenewal;
//		this.regid = regid;
//	}
}
