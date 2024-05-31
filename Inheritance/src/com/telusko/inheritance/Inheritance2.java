package com.telusko.inheritance;
class Demo
{
	int i=4;
}

class Demo1 extends Demo
{
  int j=7;
  
}

class Demo2 extends Demo1
{
	void display()
	{
   System.out.println(super.i);
	}
}
public class Inheritance2 {
public static void main(String[] args) {
	Demo2 d =new Demo2();
	d.display();
}
}
