package com.study.open.xstream;

import java.io.InputStream;
import java.util.List;

import com.thoughtworks.xstream.XStream;

public class CovertTest {

	public static void main(String[] args){
		InputStream is1=CovertTest.class.getResourceAsStream("convert.xml");
		
		XStream xstream = new XStream();
		xstream.alias("Assessment", Assessment.class);

		xstream.alias("assessedField", AssessedField.class);
		xstream.addImplicitCollection(AssessedField.class, "assessedValue");
		Assessment test1 = (Assessment)xstream.fromXML(is1);
		System.out.println(test1.toString());
	}
}

class Assessment{
	private List<AssessedField>  assessmentDetail;

	public List<AssessedField> getAssessmentDetail() {
		return assessmentDetail;
	}

	public void setAssessmentDetail(List<AssessedField> assessmentDetail) {
		this.assessmentDetail = assessmentDetail;
	}
	@Override
	public String toString(){
		StringBuilder sb = new StringBuilder();
		if(assessmentDetail!=null){
			for(AssessedField field: assessmentDetail){
				sb.append(field.toString()).append("\n");
			} 
		}
		return sb.toString();
	}
	
}
class AssessedField{
	private String id;
	private List<String> assessedValue;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public List<String> getAssessedValue() {
		return assessedValue;
	}
	public void setAssessedValue(List<String> assessedValue) {
		this.assessedValue = assessedValue;
	}
	
	@Override
	public String toString(){
		return new StringBuilder().append("[id:").append(id).append("]")
								  .append("[assessedValue:"+assessedValue +"]").toString();
	}
}
