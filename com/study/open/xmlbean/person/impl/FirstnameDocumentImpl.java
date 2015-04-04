/*
 * An XML document type.
 * Localname: firstname
 * Namespace: 
 * Java type: com.study.open.xmlbean.person.FirstnameDocument
 *
 * Automatically generated - do not modify.
 */
package com.study.open.xmlbean.person.impl;
/**
 * A document containing one firstname(@) element.
 *
 * This is a complex type.
 */
public class FirstnameDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements com.study.open.xmlbean.person.FirstnameDocument
{
    private static final long serialVersionUID = 1L;
    
    public FirstnameDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName FIRSTNAME$0 = 
        new javax.xml.namespace.QName("", "firstname");
    
    
    /**
     * Gets the "firstname" element
     */
    public com.study.open.xmlbean.person.FirstnameDocument.Firstname.Enum getFirstname()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(FIRSTNAME$0, 0);
            if (target == null)
            {
                return null;
            }
            return (com.study.open.xmlbean.person.FirstnameDocument.Firstname.Enum)target.getEnumValue();
        }
    }
    
    /**
     * Gets (as xml) the "firstname" element
     */
    public com.study.open.xmlbean.person.FirstnameDocument.Firstname xgetFirstname()
    {
        synchronized (monitor())
        {
            check_orphaned();
            com.study.open.xmlbean.person.FirstnameDocument.Firstname target = null;
            target = (com.study.open.xmlbean.person.FirstnameDocument.Firstname)get_store().find_element_user(FIRSTNAME$0, 0);
            return target;
        }
    }
    
    /**
     * Sets the "firstname" element
     */
    public void setFirstname(com.study.open.xmlbean.person.FirstnameDocument.Firstname.Enum firstname)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(FIRSTNAME$0, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(FIRSTNAME$0);
            }
            target.setEnumValue(firstname);
        }
    }
    
    /**
     * Sets (as xml) the "firstname" element
     */
    public void xsetFirstname(com.study.open.xmlbean.person.FirstnameDocument.Firstname firstname)
    {
        synchronized (monitor())
        {
            check_orphaned();
            com.study.open.xmlbean.person.FirstnameDocument.Firstname target = null;
            target = (com.study.open.xmlbean.person.FirstnameDocument.Firstname)get_store().find_element_user(FIRSTNAME$0, 0);
            if (target == null)
            {
                target = (com.study.open.xmlbean.person.FirstnameDocument.Firstname)get_store().add_element_user(FIRSTNAME$0);
            }
            target.set(firstname);
        }
    }
    /**
     * An XML firstname(@).
     *
     * This is an atomic type that is a restriction of com.study.open.xmlbean.person.FirstnameDocument$Firstname.
     */
    public static class FirstnameImpl extends org.apache.xmlbeans.impl.values.JavaStringEnumerationHolderEx implements com.study.open.xmlbean.person.FirstnameDocument.Firstname
    {
        private static final long serialVersionUID = 1L;
        
        public FirstnameImpl(org.apache.xmlbeans.SchemaType sType)
        {
            super(sType, false);
        }
        
        protected FirstnameImpl(org.apache.xmlbeans.SchemaType sType, boolean b)
        {
            super(sType, b);
        }
    }
}
