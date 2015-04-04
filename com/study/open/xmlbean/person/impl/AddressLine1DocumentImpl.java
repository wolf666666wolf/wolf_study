/*
 * An XML document type.
 * Localname: addressLine1
 * Namespace: 
 * Java type: com.study.open.xmlbean.person.AddressLine1Document
 *
 * Automatically generated - do not modify.
 */
package com.study.open.xmlbean.person.impl;
/**
 * A document containing one addressLine1(@) element.
 *
 * This is a complex type.
 */
public class AddressLine1DocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements com.study.open.xmlbean.person.AddressLine1Document
{
    private static final long serialVersionUID = 1L;
    
    public AddressLine1DocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName ADDRESSLINE1$0 = 
        new javax.xml.namespace.QName("", "addressLine1");
    
    
    /**
     * Gets the "addressLine1" element
     */
    public com.study.open.xmlbean.person.AddressLine1Document.AddressLine1.Enum getAddressLine1()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(ADDRESSLINE1$0, 0);
            if (target == null)
            {
                return null;
            }
            return (com.study.open.xmlbean.person.AddressLine1Document.AddressLine1.Enum)target.getEnumValue();
        }
    }
    
    /**
     * Gets (as xml) the "addressLine1" element
     */
    public com.study.open.xmlbean.person.AddressLine1Document.AddressLine1 xgetAddressLine1()
    {
        synchronized (monitor())
        {
            check_orphaned();
            com.study.open.xmlbean.person.AddressLine1Document.AddressLine1 target = null;
            target = (com.study.open.xmlbean.person.AddressLine1Document.AddressLine1)get_store().find_element_user(ADDRESSLINE1$0, 0);
            return target;
        }
    }
    
    /**
     * Sets the "addressLine1" element
     */
    public void setAddressLine1(com.study.open.xmlbean.person.AddressLine1Document.AddressLine1.Enum addressLine1)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(ADDRESSLINE1$0, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(ADDRESSLINE1$0);
            }
            target.setEnumValue(addressLine1);
        }
    }
    
    /**
     * Sets (as xml) the "addressLine1" element
     */
    public void xsetAddressLine1(com.study.open.xmlbean.person.AddressLine1Document.AddressLine1 addressLine1)
    {
        synchronized (monitor())
        {
            check_orphaned();
            com.study.open.xmlbean.person.AddressLine1Document.AddressLine1 target = null;
            target = (com.study.open.xmlbean.person.AddressLine1Document.AddressLine1)get_store().find_element_user(ADDRESSLINE1$0, 0);
            if (target == null)
            {
                target = (com.study.open.xmlbean.person.AddressLine1Document.AddressLine1)get_store().add_element_user(ADDRESSLINE1$0);
            }
            target.set(addressLine1);
        }
    }
    /**
     * An XML addressLine1(@).
     *
     * This is an atomic type that is a restriction of com.study.open.xmlbean.person.AddressLine1Document$AddressLine1.
     */
    public static class AddressLine1Impl extends org.apache.xmlbeans.impl.values.JavaStringEnumerationHolderEx implements com.study.open.xmlbean.person.AddressLine1Document.AddressLine1
    {
        private static final long serialVersionUID = 1L;
        
        public AddressLine1Impl(org.apache.xmlbeans.SchemaType sType)
        {
            super(sType, false);
        }
        
        protected AddressLine1Impl(org.apache.xmlbeans.SchemaType sType, boolean b)
        {
            super(sType, b);
        }
    }
}
