/*
 * An XML document type.
 * Localname: receiver
 * Namespace: 
 * Java type: com.study.open.xmlbean.person.ReceiverDocument
 *
 * Automatically generated - do not modify.
 */
package com.study.open.xmlbean.person.impl;
/**
 * A document containing one receiver(@) element.
 *
 * This is a complex type.
 */
public class ReceiverDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements com.study.open.xmlbean.person.ReceiverDocument
{
    private static final long serialVersionUID = 1L;
    
    public ReceiverDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName RECEIVER$0 = 
        new javax.xml.namespace.QName("", "receiver");
    
    
    /**
     * Gets the "receiver" element
     */
    public com.study.open.xmlbean.person.ReceiverDocument.Receiver.Enum getReceiver()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(RECEIVER$0, 0);
            if (target == null)
            {
                return null;
            }
            return (com.study.open.xmlbean.person.ReceiverDocument.Receiver.Enum)target.getEnumValue();
        }
    }
    
    /**
     * Gets (as xml) the "receiver" element
     */
    public com.study.open.xmlbean.person.ReceiverDocument.Receiver xgetReceiver()
    {
        synchronized (monitor())
        {
            check_orphaned();
            com.study.open.xmlbean.person.ReceiverDocument.Receiver target = null;
            target = (com.study.open.xmlbean.person.ReceiverDocument.Receiver)get_store().find_element_user(RECEIVER$0, 0);
            return target;
        }
    }
    
    /**
     * Sets the "receiver" element
     */
    public void setReceiver(com.study.open.xmlbean.person.ReceiverDocument.Receiver.Enum receiver)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(RECEIVER$0, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(RECEIVER$0);
            }
            target.setEnumValue(receiver);
        }
    }
    
    /**
     * Sets (as xml) the "receiver" element
     */
    public void xsetReceiver(com.study.open.xmlbean.person.ReceiverDocument.Receiver receiver)
    {
        synchronized (monitor())
        {
            check_orphaned();
            com.study.open.xmlbean.person.ReceiverDocument.Receiver target = null;
            target = (com.study.open.xmlbean.person.ReceiverDocument.Receiver)get_store().find_element_user(RECEIVER$0, 0);
            if (target == null)
            {
                target = (com.study.open.xmlbean.person.ReceiverDocument.Receiver)get_store().add_element_user(RECEIVER$0);
            }
            target.set(receiver);
        }
    }
    /**
     * An XML receiver(@).
     *
     * This is an atomic type that is a restriction of com.study.open.xmlbean.person.ReceiverDocument$Receiver.
     */
    public static class ReceiverImpl extends org.apache.xmlbeans.impl.values.JavaStringEnumerationHolderEx implements com.study.open.xmlbean.person.ReceiverDocument.Receiver
    {
        private static final long serialVersionUID = 1L;
        
        public ReceiverImpl(org.apache.xmlbeans.SchemaType sType)
        {
            super(sType, false);
        }
        
        protected ReceiverImpl(org.apache.xmlbeans.SchemaType sType, boolean b)
        {
            super(sType, b);
        }
    }
}
