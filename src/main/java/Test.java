import java.util.ArrayList;
import java.util.List;


public class Test {

	
	
	
	
	public static void main(String[] args){
//		Date d1 = new Date();
//		System.out.println("year:"+d1.getYear());
//		Calendar c1 = Calendar.getInstance();
//		System.out.println("CYear:"+c1.get(Calendar.YEAR));
		
		Person person = new Person();
		List<Fruit> fruitList = new ArrayList<Fruit>();
		fruitList.add(new Apple());
		fruitList.add(new Orange());
		
		for(Fruit fruit: fruitList){
//			fruit.accept(person);
			person.eat(fruit);
		}
	}
}

class Person{
	public void eat(Fruit fruit){
		System.out.println(fruit.getName());
	}
	
		
}

abstract class Fruit{
	public void accept(Person person) {
		person.eat(this);
		
	}
	public String getName(){
		return "FRUIT";
	}
}
class Apple extends Fruit{

	@Override
	public String getName() {
		return "APPLE";
	}
	
}
class Orange extends Fruit{

	@Override
	public String getName() {
		return "ORANGE";
	}
	
	public void a(){
		com.bull.eris.cam.service.CaseService caseService = 
			springContext.getBean("caseService", com.bull.eris.cam.service.impl.CaseServiceImpl.class);
			    caseService.setEntityManager(EntityMgr);
			    String caseReference = CASE_REFERENCE.getStringValue();
			    String caseStage = CASE_STAGE.getStringValue();
			    String caseStepDefId = CASE_STEP_DEF_ID.getStringValue();
			    log.var("caseStage", caseStage);
			    log.var("caseReference", caseReference);
			    log.var("caseStepDefId", caseStepDefId);
			    java.util.List list = caseService.getPredecessors(caseReference, Long.parseLong(caseStage), Long.valueOf(caseStepDefId));
			    log.var("is there some pre step not completed?", list == null ? 0 : list.size());
			    if (list != null && !list.isEmpty()) {
			      CAN_BE_PERFORMED.setValue("N");
			      context.setMessage("warning", com.bull.eris.cam.constant.MessageID.PREDECESSORS_NOT_COMPLETE);
			    }
			    // get setp def
			    com.bull.eris.cam.service.CaseStepDefService caseStepDefService = 
			springContext.getBean("caseStepDefService", com.bull.eris.cam.service.impl.CaseStepDefServiceImpl.class);
			    caseStepDefService.setEntityManager(EntityMgr);
			    boolean canBeperformed = caseStepDefService.getCanBePerformed(caseReference, caseStage, caseStepDefId); 
			    if (canBeperformed) {
			        CAN_BE_PERFORMED.setValue("N");
			        context.setMessage("warning", com.bull.eris.cam.constant.MessageID.CANNOT_START_BEFORE_DUEDAY);
			    }	
			    com.bull.eris.cam.vo.TE09_CASE_STEP_DEF stepDef = caseStepDefService.getStepDefByKey(Long.valueOf(caseStepDefId));
			    START_ACTION_DIRECTLY.setValue(stepDef.getCe09_start_action_directly());
			    STATUS_CONTR_BY_ACTION.setValue(stepDef.getCe09_status_contr_by_action());
			    RESULT_MANATORY.setValue(stepDef.getCe09_results_mandatory());
			    CAN_BE_SKIP.setValue(stepDef.getCe09_can_be_skipped());
			    
			    com.bull.eris.cam.service.impl.CaseStepHelper caseStepHelper = 
			springContext.getBean("caseStepHelper", com.bull.eris.cam.service.impl.CaseStepHelper.class);
			    caseStepHelper.setEntityManager(EntityMgr);
			    java.util.List stepActionList = caseStepHelper.getStepActions(caseStepDefId);
			    log.var("stepActionList", stepActionList);
			    if (stepActionList != null && stepActionList.size() > 0) {
			      com.bull.eris.cam.vo.VE10_ACTIONS action = (com.bull.eris.cam.vo.VE10_ACTIONS) stepActionList.get(0);
			      STEP_DETAILS_ID.setValue(action.getCe10_step_detail_id());
			logger.debug("VE10_ACTIONS:" + action.toXml());
			logger.debug("STEP_DETAILS_ID:"+STEP_DETAILS_ID.getValue());
			      ENTITY_CODE.setValue(action.getCstd_entity());
			    }
			    log.info("get ENTITY_ID");
			    com.bull.eris.cam.vo.TE22_ENTITY_LINK_TO_CASE te22 = new com.bull.eris.cam.vo.TE22_ENTITY_LINK_TO_CASE();
			    java.util.List te22List = EntityMgr.customFind("TE22_ENTITY_LINK_TO_CASE","searchContentofCreateCase",new Object[]{caseStage, caseReference, CASE_CONTENT_TYPE.getStringValue()});
			    if(te22List!=null && te22List.size()>0){
			      te22= (com.bull.eris.cam.vo.TE22_ENTITY_LINK_TO_CASE)te22List.get(0);
			      log.var("entity id",te22.getCe22_entity_id());    
			      ENTITY_ID.setValue(te22.getCe22_entity_id());
			    }
			    CAM_FLAG.setValue("Y");		
	}
	
	
	public void b(){
		
		log.debug("show perform step");
	    String caseReference = CASE_REFERENCE.getStringValue();
	    String caseStage = CASE_STAGE.getStringValue();
	    String caseStepDefId = CASE_STEP_DEF_ID.getStringValue();    

	    // get step info
	    com.bull.eris.cam.service.impl.CaseStepHelper caseStepHelper = 
	springContext.getBean("caseStepHelper", com.bull.eris.cam.service.impl.CaseStepHelper.class);
	    caseStepHelper.setEntityManager(EntityMgr);
	    com.bull.eris.cam.vo.STEP_INFO stepInfo = caseStepHelper.getStepInfo(caseReference, caseStage, caseStepDefId);
	    String stepInfoXml = EntityMgr.toXml("STEP_INFO", stepInfo);    
	    com.bull.eris.cam.vo.TE12_CASE_STEPS step = (com.bull.eris.cam.vo.TE12_CASE_STEPS) EntityMgr
	        .customFind("TE12_CASE_STEPS", "findByCaseNoAndCaseStepDefId",
	            new Object[] { caseStage,caseReference, caseStepDefId }).get(0);
	    String attachXML = EntityMgr.toXml("TE12_CASE_STEPS", step);    
	    // get step action
	    java.util.List stepActionList = caseStepHelper.getStepActions(caseStepDefId);
	    String stepActionXml = EntityMgr.toXml("VE10_ACTIONS", stepActionList);
	    log.var("stepaction xml to step form", stepActionList);
	    // get step document
	    java.util.List stepDocumentList = caseStepHelper.getStepDocuments(caseStepDefId);
	    String stepDocumentXml = EntityMgr.toXml("VE10_DOCUMENTS", stepDocumentList);
	    log.var("stepdocument xml to step form", stepDocumentXml);
	    context.addClientResponseData(stepInfoXml + stepActionXml + stepDocumentXml + attachXML);
	    log.var("step detail info xml to step form", stepInfoXml + stepActionXml + stepDocumentXml + attachXML);
	    if (CAN_BE_PERFORMED.getStringValue()!=null && CAN_BE_PERFORMED.getStringValue().equals("N")) {
	      context.setFormAttribute("ReadonlyFlag", "value", "Y");
	    }	
	    context.setFormAttribute("InternalIdHidden", "value", context.getParameter("internalId"));
	    context.setFormAttribute("StatusCtrlByAction", "value", STATUS_CONTR_BY_ACTION.getStringValue());
	    context.setFormAttribute("ResultMandatory", "value", RESULT_MANATORY.getStringValue());    
	    context.setFormAttribute("HiddenForStepStatusUDS", "value", CAN_BE_SKIP.getStringValue() + "," + stepInfo.getStep_status());		
		
	}
}