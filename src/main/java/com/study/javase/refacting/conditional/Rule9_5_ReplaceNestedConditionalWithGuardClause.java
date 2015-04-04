package com.study.javase.refacting.conditional;
/**
 * 所谓的卫语句 就是执行的时候先吧不满足的条件排除掉
 * @author BULL
 *
 */
public class Rule9_5_ReplaceNestedConditionalWithGuardClause {

	private boolean _isDead;
	private boolean _isSeperated;
	private boolean _isRetrived;
	
	// bad method
	double getPayAmount(){
		double result;
		if(_isDead) result = deadAmount();
		else{
			if(_isSeperated) result = this.seperateAmount();
			else if(_isRetrived) result = this.retriveAmount();
			else result = this.normalAmount();
		}
		return result;	
	}
	
	//good method
	double getPayAmount_good(){
		if(_isDead) return deadAmount();
		if(_isSeperated) return  this.seperateAmount();
		if(_isRetrived) return  this.retriveAmount();
		return this.normalAmount();	
	}
	
	private double deadAmount(){return 1;}
	private double seperateAmount(){return 2;}
	private double retriveAmount(){return 3;}
	private double normalAmount(){return 4;}
}
