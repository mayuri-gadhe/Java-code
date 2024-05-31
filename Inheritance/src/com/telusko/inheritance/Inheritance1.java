package com.telusko.inheritance;
class Parent{
	void display()
	{
		System.out.println("Display in parent class..");
	}
	void display1()
	{
		System.out.println("Display1 in parent class..");
	}
}

class Child extends Parent
{
	void display1()
	{
		System.out.println("Display1 in child class..");
	}
	void show()
	{
		System.out.println("show in child class..");
	}
	
}

public class Inheritance1 {
	public static void main(String[] args) {
		Parent c=new Child();
		c.display();
		((Child) c).show();
		c.display1();
		
	}

}
