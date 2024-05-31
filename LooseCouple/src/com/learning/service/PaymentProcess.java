package com.learning.service;

public class PaymentProcess {

	IPay pay;
	//constructor
	public PaymentProcess(IPay pay) {
		super();
		this.pay = pay;
	}

	//setter
//	public void setPay(IPay pay) {
//		this.pay = pay;
//	}
	
	public boolean doPayment(double amount)
	{
		pay.payBill(amount);
		return true;
	}

	
}
