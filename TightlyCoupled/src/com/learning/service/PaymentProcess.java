package com.learning.service;

import com.learning.dao.CreditCard;
import com.learning.dao.DebitCard;
import com.learning.dao.QRcode;

public class PaymentProcess {
	
	public boolean doPayment(double amount,String type)
	{
		if(type=="Debit")
		{
		DebitCard db=new DebitCard();
		db.payBill(amount);	
		}
		else if(type=="Credit")
		{
			CreditCard cc=new CreditCard();
			cc.payBill(amount);
		}
		
		else if(type=="QRCode") 
		{
		QRcode qc=new QRcode();
		qc.payBill(amount);
		}
		else
		{
			System.out.println("Again select");
		}
		return true;
	}
	

}
