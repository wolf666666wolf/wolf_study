package com.study.open.activemq;

import javax.jms.ConnectionFactory;

import org.apache.activemq.ActiveMQConnectionFactory;

public class JmsBroker {
    public static String brokerURL = "tcp://localhost:61616";  
    
    // mvn clean compile exec:java  
    // -Dexec.mainClass=net.sunbeta.test.jms.JmsBroker  
    public static void main(String[] args) throws Exception {  
        // setup the connection to ActiveMQ  
        ConnectionFactory factory = new ActiveMQConnectionFactory(brokerURL);  
  
        JmsProducer producer = new JmsProducer(factory, "test");  
        producer.run();  
        producer.close();  
    } 
}
