package com.study.javase.refacting.conditional;
/**
 * 合并条件表达式
 * 1.只有一次检查，只不过有多个并列条件需要检查
 * 2.将条件提升为一个独立的函数便于理清代码
 * @author BULL
 *
 */
public class Rule9_2_ConsolidateConditionalExpression {
	private double _seniority;
	private double _monthDisabled;
	private boolean _isPartTime;
	
	//badmethod
	double disabilityAmount(){
		if(_seniority<2) return 0;
		if(_monthDisabled>12) return 0;
		if(_isPartTime) return 0;
		
		return 1;
	}
	
	//goodmethod
	double disabilityAmount_good(){
		if(isNotEligibleForDisability()) return 0;
		return 1;
	}
	
	private boolean isNotEligibleForDisability(){
		return (((_seniority<2)) || (_monthDisabled>12) || (_isPartTime));
	}
}
