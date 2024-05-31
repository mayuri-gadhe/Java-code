package com.learning.dao;

public class QRcode {
	public QRcode()
	{
		System.out.println("QRcode object created..");
	}
	public boolean payBill(double amount)
	{
		System.out.println("Bill pay by QRcode..." +amount);
		return true;
	}

}
