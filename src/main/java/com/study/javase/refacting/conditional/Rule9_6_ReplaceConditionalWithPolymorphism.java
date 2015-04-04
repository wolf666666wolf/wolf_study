package com.study.javase.refacting.conditional;
/**
 * 加入你的条件表达式里有根据条件的不同选择不同的行为，那么可以将这些不同的行为放到子类里
 * @author BULL
 *
 */
public class Rule9_6_ReplaceConditionalWithPolymorphism {

}
class EmployeeType{
	public static int ENGINEER = 1;
	public static int SALSMEN = 2;
	public static int MANAGER = 3;
}
//bad class
class Employee{
	int _monthlySalary;
	int _commonsion;
	int _bouns;
	int payAmount(){
		switch(getType()){
//			case EmployeeType.ENGINEER:
//				return _monthlySalary;
//			case EmployeeType.SALSMEN:
//				return _monthlySalary + _commonsion;
//			case EmployeeType.MANAGER:
//				return _monthlySalary + _bouns;
			default:
				throw new RuntimeException("Incorrect Employee");	
		}
	}
	private int getType(){
		return 0;
	}
}
