/*
 * An XML document type.
 * Localname: gender
 * Namespace: 
 * Java type: com.study.open.xmlbean.person.GenderDocument
 *
 * Automatically generated - do not modify.
 */
package com.study.open.xmlbean.person.impl;
/**
 * A document containing one gender(@) element.
 *
 * This is a complex type.
 */
public class GenderDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements com.study.open.xmlbean.person.GenderDocument
{
    private static final long serialVersionUID = 1L;
    
    public GenderDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName GENDER$0 = 
        new javax.xml.namespace.QName("", "gender");
    
    
    /**
     * Gets the "gender" element
     */
    public com.study.open.xmlbean.person.GenderDocument.Gender.Enum getGender()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(GENDER$0, 0);
            if (target == null)
            {
                return null;
            }
            return (com.study.open.xmlbean.person.GenderDocument.Gender.Enum)target.getEnumValue();
        }
    }
    
    /**
     * Gets (as xml) the "gender" element
     */
    public com.study.open.xmlbean.person.GenderDocument.Gender xgetGender()
    {
        synchronized (monitor())
        {
            check_orphaned();
            com.study.open.xmlbean.person.GenderDocument.Gender target = null;
            target = (com.study.open.xmlbean.person.GenderDocument.Gender)get_store().find_element_user(GENDER$0, 0);
            return target;
        }
    }
    
    /**
     * Sets the "gender" element
     */
    public void setGender(com.study.open.xmlbean.person.GenderDocument.Gender.Enum gender)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(GENDER$0, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(GENDER$0);
            }
            target.setEnumValue(gender);
        }
    }
    
    /**
     * Sets (as xml) the "gender" element
     */
    public void xsetGender(com.study.open.xmlbean.person.GenderDocument.Gender gender)
    {
        synchronized (monitor())
        {
            check_orphaned();
            com.study.open.xmlbean.person.GenderDocument.Gender target = null;
            target = (com.study.open.xmlbean.person.GenderDocument.Gender)get_store().find_element_user(GENDER$0, 0);
            if (target == null)
            {
                target = (com.study.open.xmlbean.person.GenderDocument.Gender)get_store().add_element_user(GENDER$0);
            }
            target.set(gender);
        }
    }
    /**
     * An XML gender(@).
     *
     * This is an atomic type that is a restriction of com.study.open.xmlbean.person.GenderDocument$Gender.
     */
    public static class GenderImpl extends org.apache.xmlbeans.impl.values.JavaStringEnumerationHolderEx implements com.study.open.xmlbean.person.GenderDocument.Gender
    {
        private static final long serialVersionUID = 1L;
        
        public GenderImpl(org.apache.xmlbeans.SchemaType sType)
        {
            super(sType, false);
        }
        
        protected GenderImpl(org.apache.xmlbeans.SchemaType sType, boolean b)
        {
            super(sType, b);
        }
    }
}
