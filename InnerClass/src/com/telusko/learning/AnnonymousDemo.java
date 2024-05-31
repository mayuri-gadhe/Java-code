package com.telusko.learning;

 abstract class A
{
	 public abstract void show();
	 public abstract void print();
	 public abstract void print1();
	
}
public class AnnonymousDemo {
public static void main(String[] args) {
	A a=new A()
			{ // Annonymous class is a class
		public void show()
		{
			System.out.println("print something");
		}
		public void print()
		{
			System.out.println("2nd annonymous method");
		}
		public void print1()
		{
			System.out.println("3rd annonymous method");
		}
			};
			a.show();
			a.print();
			a.print1();
			
		
}
}
