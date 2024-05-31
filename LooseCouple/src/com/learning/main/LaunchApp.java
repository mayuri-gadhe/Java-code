package com.learning.main;

import com.learning.dao.CreditCard;
import com.learning.dao.DebitCard;
import com.learning.dao.QRCode;
import com.learning.service.PaymentProcess;

public class LaunchApp {
	public static void main(String[] args) {
		//PaymentProcess pp=new PaymentProcess();
		
		//setter injection
		//pp.setPay(new QRCode());
		
		//constructor injection
		PaymentProcess pp=new PaymentProcess(new QRCode());
		
		
		pp.doPayment(500);
	}

}
