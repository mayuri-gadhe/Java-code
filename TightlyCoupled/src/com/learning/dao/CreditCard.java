package com.learning.dao;

public class CreditCard {
	
	public CreditCard()
	{
		System.out.println("CreditCard object created..");
	}
	public boolean payBill(double amount)
	{
		System.out.println("Bill pay by credit card.."+amount);
		return true;
	}

}
