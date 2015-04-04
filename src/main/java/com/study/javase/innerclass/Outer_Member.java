package com.study.javase.innerclass;

/**
 * 成员内部类的优点： 
⑴ 内部类作为外部类的成员，可以访问外部类的私有成员或属性。（即使将外部类声明为PRIVATE，但是对于处于其内部的内部类还是可见的。） 
⑵ 用内部类定义在外部类中不可访问的属性。这样就在外部类中实现了比外部类的private还要小的访问权限。 
注意：内部类是一个编译时的概念，一旦编译成功，就会成为完全不同的两类。对于一个名为outer的外部类和其内部定义的名为inner的内部类。编译完成后出现outer.class和outer$inner.class两类。
 * @author BULL
 *
 */
public class Outer_Member {

	private static int i =1;
	private int j = 10;
	private int k = 20;
	
	public static void outer_f1(){
		System.out.println("Outer's outer_f1");
	}
	public void outer_f2(){
		System.out.println("Outer's outer_f2");
	}
	
	//成员内部类
	class Inner{
		//static int inner_i = 100; //内部类中不允许定义静态变量
		int j=100;
		int inner_i =1;
		void inner_f1(){
			System.out.println(i);//外部类的变量如果和内部类的变量没有同名的，则可以直接用变量名访问外部类的变量
			System.out.println(j);//在内部类中访问内部类自己的变量直接用变量名 
			System.out.println(this.j);//也可以在内部类中用"this.变量名"来访问内部类变量
			System.out.println(Outer_Member.this.j);//访问外部类中与内部类同名的实例变量可用"外部类名.this.变量名"。
			
			outer_f1();
			outer_f2();
			Outer_Member.this.outer_f2();
			//outer_f3();
		}
	}
	
	//外部类的非静态方法访问成员内部类
	public void outer_f3(){
		System.out.println("*****************************outer_f3 start ");
		Inner inner = new Inner();
		inner.inner_f1();
		System.out.println("*****************************outer_f3 end ");
	}
	//外部类的静态方法访问成员内部类，与在外部类外部访问成员内部类一样
	public static void outer_f4(){
		System.out.println("*****************************outer_f4 start ");
		Outer_Member outer = new Outer_Member();
		Outer_Member.Inner inner = outer.new Inner();
		inner.inner_f1();
		System.out.println("*****************************outer_f4 end ");
	}
	public static void main(String[] args){
		Outer_Member outer = new Outer_Member();
		Outer_Member.Inner inner = outer.new Inner();
		inner.inner_f1();
		
		//outer.outer_f3();
		outer_f4();   
		
	}
}
