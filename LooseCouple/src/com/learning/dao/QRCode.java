package com.learning.dao;

import com.learning.service.IPay;

public class QRCode implements IPay {

	@Override
	public boolean payBill(double amount) {
		System.out.println("Payment successful through QRCode Card with amount"+amount);
		return false;
	}

}
