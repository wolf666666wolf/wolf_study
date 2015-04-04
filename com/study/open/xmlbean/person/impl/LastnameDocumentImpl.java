/*
 * An XML document type.
 * Localname: lastname
 * Namespace: 
 * Java type: com.study.open.xmlbean.person.LastnameDocument
 *
 * Automatically generated - do not modify.
 */
package com.study.open.xmlbean.person.impl;
/**
 * A document containing one lastname(@) element.
 *
 * This is a complex type.
 */
public class LastnameDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements com.study.open.xmlbean.person.LastnameDocument
{
    private static final long serialVersionUID = 1L;
    
    public LastnameDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName LASTNAME$0 = 
        new javax.xml.namespace.QName("", "lastname");
    
    
    /**
     * Gets the "lastname" element
     */
    public com.study.open.xmlbean.person.LastnameDocument.Lastname.Enum getLastname()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(LASTNAME$0, 0);
            if (target == null)
            {
                return null;
            }
            return (com.study.open.xmlbean.person.LastnameDocument.Lastname.Enum)target.getEnumValue();
        }
    }
    
    /**
     * Gets (as xml) the "lastname" element
     */
    public com.study.open.xmlbean.person.LastnameDocument.Lastname xgetLastname()
    {
        synchronized (monitor())
        {
            check_orphaned();
            com.study.open.xmlbean.person.LastnameDocument.Lastname target = null;
            target = (com.study.open.xmlbean.person.LastnameDocument.Lastname)get_store().find_element_user(LASTNAME$0, 0);
            return target;
        }
    }
    
    /**
     * Sets the "lastname" element
     */
    public void setLastname(com.study.open.xmlbean.person.LastnameDocument.Lastname.Enum lastname)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(LASTNAME$0, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(LASTNAME$0);
            }
            target.setEnumValue(lastname);
        }
    }
    
    /**
     * Sets (as xml) the "lastname" element
     */
    public void xsetLastname(com.study.open.xmlbean.person.LastnameDocument.Lastname lastname)
    {
        synchronized (monitor())
        {
            check_orphaned();
            com.study.open.xmlbean.person.LastnameDocument.Lastname target = null;
            target = (com.study.open.xmlbean.person.LastnameDocument.Lastname)get_store().find_element_user(LASTNAME$0, 0);
            if (target == null)
            {
                target = (com.study.open.xmlbean.person.LastnameDocument.Lastname)get_store().add_element_user(LASTNAME$0);
            }
            target.set(lastname);
        }
    }
    /**
     * An XML lastname(@).
     *
     * This is an atomic type that is a restriction of com.study.open.xmlbean.person.LastnameDocument$Lastname.
     */
    public static class LastnameImpl extends org.apache.xmlbeans.impl.values.JavaStringEnumerationHolderEx implements com.study.open.xmlbean.person.LastnameDocument.Lastname
    {
        private static final long serialVersionUID = 1L;
        
        public LastnameImpl(org.apache.xmlbeans.SchemaType sType)
        {
            super(sType, false);
        }
        
        protected LastnameImpl(org.apache.xmlbeans.SchemaType sType, boolean b)
        {
            super(sType, b);
        }
    }
}
