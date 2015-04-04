package com.study.open.htmlparser.visitor;

import org.htmlparser.Tag;
import org.htmlparser.visitors.NodeVisitor;

public class CommunityNumVisitor extends NodeVisitor{

	private String num;
	/**
	 * <li class="bg"><a href="/c-tianherenjia574/esf/" class="district_blv">二手房<span>65套</span></a></li>
	 */
	@Override
	public void visitTag(Tag tag){
		String attr = tag.getAttribute("class");
		if("district_blv".equals(attr)){
			String text = tag.toPlainTextString();
			num = text.substring("二手房".length(), text.indexOf("套"));
			            //line = textnode.toPlainTextString().trim();    
            //line = textnode.getText();    
        } 		
	}
	public String getNum() {
		return num;
	}
	public void setNum(String num) {
		this.num = num;
	}
	
}
