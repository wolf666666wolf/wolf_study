/*
 * An XML document type.
 * Localname: postalCode
 * Namespace: 
 * Java type: com.study.open.xmlbean.person.PostalCodeDocument
 *
 * Automatically generated - do not modify.
 */
package com.study.open.xmlbean.person.impl;
/**
 * A document containing one postalCode(@) element.
 *
 * This is a complex type.
 */
public class PostalCodeDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements com.study.open.xmlbean.person.PostalCodeDocument
{
    private static final long serialVersionUID = 1L;
    
    public PostalCodeDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName POSTALCODE$0 = 
        new javax.xml.namespace.QName("", "postalCode");
    
    
    /**
     * Gets the "postalCode" element
     */
    public int getPostalCode()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(POSTALCODE$0, 0);
            if (target == null)
            {
                return 0;
            }
            return target.getIntValue();
        }
    }
    
    /**
     * Gets (as xml) the "postalCode" element
     */
    public com.study.open.xmlbean.person.PostalCodeDocument.PostalCode xgetPostalCode()
    {
        synchronized (monitor())
        {
            check_orphaned();
            com.study.open.xmlbean.person.PostalCodeDocument.PostalCode target = null;
            target = (com.study.open.xmlbean.person.PostalCodeDocument.PostalCode)get_store().find_element_user(POSTALCODE$0, 0);
            return target;
        }
    }
    
    /**
     * Sets the "postalCode" element
     */
    public void setPostalCode(int postalCode)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(POSTALCODE$0, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(POSTALCODE$0);
            }
            target.setIntValue(postalCode);
        }
    }
    
    /**
     * Sets (as xml) the "postalCode" element
     */
    public void xsetPostalCode(com.study.open.xmlbean.person.PostalCodeDocument.PostalCode postalCode)
    {
        synchronized (monitor())
        {
            check_orphaned();
            com.study.open.xmlbean.person.PostalCodeDocument.PostalCode target = null;
            target = (com.study.open.xmlbean.person.PostalCodeDocument.PostalCode)get_store().find_element_user(POSTALCODE$0, 0);
            if (target == null)
            {
                target = (com.study.open.xmlbean.person.PostalCodeDocument.PostalCode)get_store().add_element_user(POSTALCODE$0);
            }
            target.set(postalCode);
        }
    }
    /**
     * An XML postalCode(@).
     *
     * This is an atomic type that is a restriction of com.study.open.xmlbean.person.PostalCodeDocument$PostalCode.
     */
    public static class PostalCodeImpl extends org.apache.xmlbeans.impl.values.JavaIntHolderEx implements com.study.open.xmlbean.person.PostalCodeDocument.PostalCode
    {
        private static final long serialVersionUID = 1L;
        
        public PostalCodeImpl(org.apache.xmlbeans.SchemaType sType)
        {
            super(sType, false);
        }
        
        protected PostalCodeImpl(org.apache.xmlbeans.SchemaType sType, boolean b)
        {
            super(sType, b);
        }
    }
}
