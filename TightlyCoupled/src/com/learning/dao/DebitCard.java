package com.learning.dao;

public class DebitCard {
	public DebitCard()
	{
		System.out.println("DebitCard object created..");
	}
	public boolean payBill(double amount)
	{
		System.out.println("Bill pay by debit card.."+amount);
		return true;
	}

}
