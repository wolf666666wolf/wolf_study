package com.study.open.htmlparser.visitor;

import org.htmlparser.Tag;
import org.htmlparser.tags.LinkTag;
import org.htmlparser.visitors.NodeVisitor;

public class LinkVisitor  extends NodeVisitor{
	//private List<Span> list = new ArrayList<Span>();
    private String name;
	private String link;
	@Override
	public void visitTag(Tag tag){
        if (tag instanceof LinkTag) {
        	LinkTag link = (LinkTag)tag;
        	this.link = link.getLink();
        	this.name = link.getStringText();
        	//System.out.println("link:"+link.getLink());
        } 		
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLink() {
		return link;
	}
	public void setLink(String link) {
		this.link = link;
	}
}
