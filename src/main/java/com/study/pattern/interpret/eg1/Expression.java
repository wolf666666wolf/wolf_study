package com.study.pattern.interpret.eg1;

import java.util.Hashtable;
import java.util.Map;


public abstract class Expression {

	protected Map<String, Integer> TABLE = new Hashtable<String, Integer>();
	
	public Expression(){
//		TABLE.put("壹", 1);
//		TABLE.put("贰", 2);
//		TABLE.put("参", 3);
//		TABLE.put("肆", 4);
//		TABLE.put("伍", 5);
//		TABLE.put("陆", 6);
//		TABLE.put("柒", 7);
//		TABLE.put("捌", 8);
//		TABLE.put("玖", 9);	
		
		
	      TABLE.put("一", 1);
	      TABLE.put("二", 2);
	      TABLE.put("三", 3);
	      TABLE.put("四", 4);
	      TABLE.put("五", 5);
	      TABLE.put("六", 6);
	      TABLE.put("七", 7);
	      TABLE.put("八", 8);
	      TABLE.put("九", 9);		
	}
	public void interpret(Context context){
	    if (context.getStatement().length() == 0){
	      return;
	    }
	    
	    for(java.util.Iterator<String> it=TABLE.keySet().iterator(); it.hasNext();){
	    	String key = it.next();
	    	if(context.getStatement().endsWith(key+this.getPostFix())){
	    		context.setData(context.getData() + TABLE.get(key)*this.getMulitiplier());
	    		context.setStatement(context.getStatement().substring(0, context.getStatement().length()-1-this.getPostFix().length()));
	    	}else if(context.getStatement().endsWith("零")){
	    		context.setStatement(context.getStatement().substring(0, context.getStatement().length()-1));
	    	}
	    	
	    }	
	}
	
	 //表达式的后缀是以什么表示的(十、百....)
	public abstract String getPostFix();
	//表达式的数量级
	public abstract int getMulitiplier();
}
