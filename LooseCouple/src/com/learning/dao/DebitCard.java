package com.learning.dao;

import com.learning.service.IPay;

public class DebitCard implements IPay {

	@Override
	public boolean payBill(double amount) {
		System.out.println("Payment successful through Debit Card with amount"+amount);
		return false;
	}

}
