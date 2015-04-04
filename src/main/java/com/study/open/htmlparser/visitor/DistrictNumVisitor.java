package com.study.open.htmlparser.visitor;

import org.htmlparser.Tag;
import org.htmlparser.tags.Div;
import org.htmlparser.tags.Span;
import org.htmlparser.visitors.NodeVisitor;

public class DistrictNumVisitor  extends NodeVisitor{
	private String num;
	/**
	 * 		<div class="total_fy clearfix">
			<p>共找到<span class="red">1028</span>个小区</p>
			<ul>
				<li class="map_display"><a href="/ditu/" target="_blank" class="black">在地图上显示</a></li>
				<li><a href="/xiaoqu/d1/czo0/" class="price_area">涨幅</a></li>

				<li><a href="/xiaoqu/d1/cuo0/" class="price_area">均价</a></li>
				<li>
				<select class="total_selt" onchange="zz_zufang_url('sort',this.value)">
				<option value="">默认排序</option>
								<option value="cuo0" >按均价大到小</option>
								<option value="cuo9" >按均价小到大</option>

								<option value="czo9" >按涨幅小到大</option>
								<option value="czo0" >按涨幅大到小</option>
								</select>
				</li>
				<li class="ghf">排序：</li>
			</ul>
		</div>

	 */
	@Override
	public void visitTag(Tag tag){
        if (tag instanceof Div) {    
            Div div = (Div) tag;    
            String attr = div.getAttribute("class"); //detailed_rig
            
            
            if("total_fy clearfix".equals(attr)){ //
            	NumSpanVisitor nsv = new NumSpanVisitor();
            	div.accept(nsv);
            	num = nsv.getNum();
            }
        }
	}
	public String getNum() {
		return num;
	}
	public void setNum(String num) {
		this.num = num;
	}
	
	private class NumSpanVisitor  extends NodeVisitor{
	private String num;
	/**
	 * <p>共找到<span class="red">1028</span>个小区</p>
	 */
	@Override
	public void visitTag(Tag tag){
        if (tag instanceof Span) {
        	Span span = (Span)tag;
        	num = span.getStringText();
        } 		
	}
	public String getNum() {
		return num;
	}
	public void setNum(String num) {
		this.num = num;
	}
}	
}

	