/*
 * An XML document type.
 * Localname: addressLine2
 * Namespace: 
 * Java type: com.study.open.xmlbean.person.AddressLine2Document
 *
 * Automatically generated - do not modify.
 */
package com.study.open.xmlbean.person.impl;
/**
 * A document containing one addressLine2(@) element.
 *
 * This is a complex type.
 */
public class AddressLine2DocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements com.study.open.xmlbean.person.AddressLine2Document
{
    private static final long serialVersionUID = 1L;
    
    public AddressLine2DocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName ADDRESSLINE2$0 = 
        new javax.xml.namespace.QName("", "addressLine2");
    
    
    /**
     * Gets the "addressLine2" element
     */
    public com.study.open.xmlbean.person.AddressLine2Document.AddressLine2.Enum getAddressLine2()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(ADDRESSLINE2$0, 0);
            if (target == null)
            {
                return null;
            }
            return (com.study.open.xmlbean.person.AddressLine2Document.AddressLine2.Enum)target.getEnumValue();
        }
    }
    
    /**
     * Gets (as xml) the "addressLine2" element
     */
    public com.study.open.xmlbean.person.AddressLine2Document.AddressLine2 xgetAddressLine2()
    {
        synchronized (monitor())
        {
            check_orphaned();
            com.study.open.xmlbean.person.AddressLine2Document.AddressLine2 target = null;
            target = (com.study.open.xmlbean.person.AddressLine2Document.AddressLine2)get_store().find_element_user(ADDRESSLINE2$0, 0);
            return target;
        }
    }
    
    /**
     * Sets the "addressLine2" element
     */
    public void setAddressLine2(com.study.open.xmlbean.person.AddressLine2Document.AddressLine2.Enum addressLine2)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(ADDRESSLINE2$0, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(ADDRESSLINE2$0);
            }
            target.setEnumValue(addressLine2);
        }
    }
    
    /**
     * Sets (as xml) the "addressLine2" element
     */
    public void xsetAddressLine2(com.study.open.xmlbean.person.AddressLine2Document.AddressLine2 addressLine2)
    {
        synchronized (monitor())
        {
            check_orphaned();
            com.study.open.xmlbean.person.AddressLine2Document.AddressLine2 target = null;
            target = (com.study.open.xmlbean.person.AddressLine2Document.AddressLine2)get_store().find_element_user(ADDRESSLINE2$0, 0);
            if (target == null)
            {
                target = (com.study.open.xmlbean.person.AddressLine2Document.AddressLine2)get_store().add_element_user(ADDRESSLINE2$0);
            }
            target.set(addressLine2);
        }
    }
    /**
     * An XML addressLine2(@).
     *
     * This is an atomic type that is a restriction of com.study.open.xmlbean.person.AddressLine2Document$AddressLine2.
     */
    public static class AddressLine2Impl extends org.apache.xmlbeans.impl.values.JavaStringEnumerationHolderEx implements com.study.open.xmlbean.person.AddressLine2Document.AddressLine2
    {
        private static final long serialVersionUID = 1L;
        
        public AddressLine2Impl(org.apache.xmlbeans.SchemaType sType)
        {
            super(sType, false);
        }
        
        protected AddressLine2Impl(org.apache.xmlbeans.SchemaType sType, boolean b)
        {
            super(sType, b);
        }
    }
}
