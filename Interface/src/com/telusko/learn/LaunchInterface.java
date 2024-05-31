package com.telusko.learn;
interface A
{
	void add();
	int sub();
	int a=4;// by default public static final
}
interface B
{
	void add();
	int sub();
}
class Hello 
{
	void print()
	{
		System.out.println("Hey hello...");
	}
}
class Demo extends Hello implements A,B 
{

	
	public void add() {
		int a=8;
		int b=7;
		System.out.println(a+b);
		
	}



	public int sub() {
		int a=5;
		int b=1;
		return a-b;
	}
	
}
public class LaunchInterface{
	public static void main(String[] args)
	{
		Demo b=new Demo();
		System.out.println(A.a);
		b.add();
		b.print();
		System.out.println(b.sub());
	}

	

}
