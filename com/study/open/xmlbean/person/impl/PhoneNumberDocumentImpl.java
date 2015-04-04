/*
 * An XML document type.
 * Localname: phoneNumber
 * Namespace: 
 * Java type: com.study.open.xmlbean.person.PhoneNumberDocument
 *
 * Automatically generated - do not modify.
 */
package com.study.open.xmlbean.person.impl;
/**
 * A document containing one phoneNumber(@) element.
 *
 * This is a complex type.
 */
public class PhoneNumberDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements com.study.open.xmlbean.person.PhoneNumberDocument
{
    private static final long serialVersionUID = 1L;
    
    public PhoneNumberDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName PHONENUMBER$0 = 
        new javax.xml.namespace.QName("", "phoneNumber");
    
    
    /**
     * Gets the "phoneNumber" element
     */
    public int getPhoneNumber()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(PHONENUMBER$0, 0);
            if (target == null)
            {
                return 0;
            }
            return target.getIntValue();
        }
    }
    
    /**
     * Gets (as xml) the "phoneNumber" element
     */
    public com.study.open.xmlbean.person.PhoneNumberDocument.PhoneNumber xgetPhoneNumber()
    {
        synchronized (monitor())
        {
            check_orphaned();
            com.study.open.xmlbean.person.PhoneNumberDocument.PhoneNumber target = null;
            target = (com.study.open.xmlbean.person.PhoneNumberDocument.PhoneNumber)get_store().find_element_user(PHONENUMBER$0, 0);
            return target;
        }
    }
    
    /**
     * Sets the "phoneNumber" element
     */
    public void setPhoneNumber(int phoneNumber)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(PHONENUMBER$0, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(PHONENUMBER$0);
            }
            target.setIntValue(phoneNumber);
        }
    }
    
    /**
     * Sets (as xml) the "phoneNumber" element
     */
    public void xsetPhoneNumber(com.study.open.xmlbean.person.PhoneNumberDocument.PhoneNumber phoneNumber)
    {
        synchronized (monitor())
        {
            check_orphaned();
            com.study.open.xmlbean.person.PhoneNumberDocument.PhoneNumber target = null;
            target = (com.study.open.xmlbean.person.PhoneNumberDocument.PhoneNumber)get_store().find_element_user(PHONENUMBER$0, 0);
            if (target == null)
            {
                target = (com.study.open.xmlbean.person.PhoneNumberDocument.PhoneNumber)get_store().add_element_user(PHONENUMBER$0);
            }
            target.set(phoneNumber);
        }
    }
    /**
     * An XML phoneNumber(@).
     *
     * This is an atomic type that is a restriction of com.study.open.xmlbean.person.PhoneNumberDocument$PhoneNumber.
     */
    public static class PhoneNumberImpl extends org.apache.xmlbeans.impl.values.JavaIntHolderEx implements com.study.open.xmlbean.person.PhoneNumberDocument.PhoneNumber
    {
        private static final long serialVersionUID = 1L;
        
        public PhoneNumberImpl(org.apache.xmlbeans.SchemaType sType)
        {
            super(sType, false);
        }
        
        protected PhoneNumberImpl(org.apache.xmlbeans.SchemaType sType, boolean b)
        {
            super(sType, b);
        }
    }
}
