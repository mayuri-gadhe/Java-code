package com.learning.dao;

import com.learning.service.IPay;

public class CreditCard implements IPay{

	@Override
	public boolean payBill(double amount) {
		System.out.println("Payment successful through Credit Card with amount"+amount);
		return false;
	}

}
