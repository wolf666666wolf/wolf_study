package com.study.open.htmlparser.visitor;

import org.htmlparser.Tag;
import org.htmlparser.tags.LinkTag;
import org.htmlparser.tags.Span;
import org.htmlparser.visitors.NodeVisitor;

public class NextPageVisitor  extends NodeVisitor{
	//private List<Span> list = new ArrayList<Span>();
    private String nextPage = "下一页";
	private String link;
	@Override
	public void visitTag(Tag tag){
        if (tag instanceof LinkTag) {
        	LinkTag link = (LinkTag)tag;
        	
        	
//        	System.out.println("htmlString:" + link.toHtml());
//        	System.out.println("String:" + link.toString());
//        	System.out.println("text:"+ link.getText());
//        	//System.out.println("Stringtext:"+ link.getStringText());
//        	System.out.println("LinkText:"+ link.getLinkText());
//        	System.out.println("getNextSibling:"+ link.getNextSibling().toHtml());
//        	System.out.println("toPlainTextString:"+ link.getNextSibling().toPlainTextString());
        	if(link !=null && link.getNextSibling()!=null){
	        	String text=link.getNextSibling().toPlainTextString();
	        	if(text!=null && text.indexOf(nextPage)>=0){
	        		this.link = link.getLink();	
	        		//System.out.println("link:"+link.getLink());
	        	}
        	}
        }
//	      if (tag instanceof Span) {
//	    	  Span span = (Span)tag;
////	    	System.out.println("htmlString:" + span.toHtml());
////	    	System.out.println("String:" + span.toString());
////	    	System.out.println("text:"+ span.getText());
////	    	System.out.println("Stringtext:"+ span.getStringText());
//	    	//System.out.println("Stringtext:"+ link.getStringText());
//	    	  
//	    	if(nextPage.equals(span.getStringText())){
//	    		System.out.println("span.getParent():" + span.getParent().toHtml());
//	    		LinkTag link = (LinkTag)span.getParent();
//	    		System.out.println("LINKhtmlString:" + link.toHtml());
//	    		System.out.println("LINKhtmlString:" + link.getLink());
//	    		this.link = link.getLink();	
//	    		//System.out.println("link:"+link.getLink());
//	    	}
//	    }		
	}
	public String getLink() {
		return link;
	}
	public void setLink(String link) {
		this.link = link;
	}
	
}
