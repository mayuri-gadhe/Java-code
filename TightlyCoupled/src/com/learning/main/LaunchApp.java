package com.learning.main;

import com.learning.service.PaymentProcess;

public class LaunchApp {
	public static void main(String arg[])
	{
		PaymentProcess pp=new PaymentProcess();
		pp.doPayment(679.6 ,"QRCode");
	}

}
