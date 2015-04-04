package com.study.javase.current;

import java.util.LinkedList;
import java.util.List;

/**
 * this pool store the internalid temporarily
 * this is a single instance
 * @author BULL
 *
 */
public class ViolationInternalidPool {

//	private static final LogUtils LOGGER = LogUtils.getLogger(ViolationInternalidPool.class);
	private static final ViolationInternalidPool singleInstance = new ViolationInternalidPool();
	
	private static List<String> INTERNALID_POOL = new LinkedList<String>();
	private ViolationInternalidPool(){}
		
	public  void removeInternalIdFromPool(String internalId){
//		LOGGER.info("remove from pool:"+internalId);
		synchronized(this){
			INTERNALID_POOL.remove(internalId);	
			System.out.println("remove from queue:"+internalId);
			this.notifyAll();
		}
	}
	public void addInternalIdToPool(String internalId){
		synchronized(ViolationInternalidPool.class){
			if(!INTERNALID_POOL.contains(internalId)){
				INTERNALID_POOL.add(internalId);
				System.out.println(Thread.currentThread().getId()+"add internalId:"+internalId);
				return;
			}
		}
//		LOGGER.info("add to pool:"+internalId);
		synchronized(this){
			while(INTERNALID_POOL.contains(internalId)){
				try {
					System.out.println(Thread.currentThread().getId()+"add internalId blocked:"+internalId);
					this.wait();
				} catch (InterruptedException e) {
	//				LOGGER.err("Wait for to execute: [" + internalId + "]");
					throw new RuntimeException(e);
				}
			}	
			INTERNALID_POOL.add(internalId);
			System.out.println("add internalId:"+internalId);
		}
	}
    
    public static ViolationInternalidPool getInstance(){  
    	return singleInstance;
    }    
 
    public static void main(String[] args) throws InterruptedException{
    	for(int i=0; i<20; i++){
    		int index=i%2;
//    		int index=i;
    		if(i>10){
    			
    			index=i;
    		}
    		String internalId = "Hello:"+index;
    		System.out.println("#########send InteranlId:"+internalId);
    		new Thread(new TestThread(internalId)).start();
    	}

    	new Thread(new RemoveThread()).start();
    }
    public static List<String> getPool(){
    	return INTERNALID_POOL;
    }
    
}

class TestThread implements Runnable{
	private String internalId;
	public TestThread(String internalId){
		this.internalId = internalId;
	}
	@Override
	public void run() {
		ViolationInternalidPool.getInstance().addInternalIdToPool(internalId);	
		System.out.println(Thread.currentThread().getId()+"###########:"+internalId);
	}
}

class RemoveThread implements Runnable{

	@Override
	public void run() {
		List<String> list = ViolationInternalidPool.getPool();
    	while(true){
    		if(list.size()==0){
    			try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
    		}
    		String internalId = list.get(0);
    		ViolationInternalidPool.getInstance().removeInternalIdFromPool(internalId);
//    		try {
//				Thread.sleep(1000);
//			} catch (InterruptedException e) {
//				e.printStackTrace();
//			}
    	}
		
	}
	
}