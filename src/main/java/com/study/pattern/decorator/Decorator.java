package com.study.pattern.decorator;

import java.util.Date;

/**  
 * 装饰器接口，维持一个指向组件对象的接口对象，并定义一个与组件接口一致的接口  
 */  
public abstract  class Decorator extends Component {   
   /**  
    * 持有组件对象  
    */  
   protected Component component;   
   /**  
     * 构造方法，传入组件对象  
     * @param component 组件对象  
     */  
    public Decorator(Component component) {   
        this.component = component;   
    }  
    @Override
    public double calcPrize(String user, Date begin, Date end) {   
        //转发请求给组件对象，可以在转发前后执行一些附加动作   
        return component.calcPrize(user, begin, end);   
    }
	  
}