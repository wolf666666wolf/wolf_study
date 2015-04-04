/*
 * An XML document type.
 * Localname: gender
 * Namespace: 
 * Java type: com.bull.eris.ten.assessEngine.xml.dto.GenderDocument
 *
 * Automatically generated - do not modify.
 */
package com.bull.eris.ten.assessEngine.xml.dto.impl;
/**
 * A document containing one gender(@) element.
 *
 * This is a complex type.
 */
public class GenderDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements com.bull.eris.ten.assessEngine.xml.dto.GenderDocument
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
    public com.bull.eris.ten.assessEngine.xml.dto.GenderDocument.Gender.Enum getGender()
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
            return (com.bull.eris.ten.assessEngine.xml.dto.GenderDocument.Gender.Enum)target.getEnumValue();
        }
    }
    
    /**
     * Gets (as xml) the "gender" element
     */
    public com.bull.eris.ten.assessEngine.xml.dto.GenderDocument.Gender xgetGender()
    {
        synchronized (monitor())
        {
            check_orphaned();
            com.bull.eris.ten.assessEngine.xml.dto.GenderDocument.Gender target = null;
            target = (com.bull.eris.ten.assessEngine.xml.dto.GenderDocument.Gender)get_store().find_element_user(GENDER$0, 0);
            return target;
        }
    }
    
    /**
     * Sets the "gender" element
     */
    public void setGender(com.bull.eris.ten.assessEngine.xml.dto.GenderDocument.Gender.Enum gender)
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
    public void xsetGender(com.bull.eris.ten.assessEngine.xml.dto.GenderDocument.Gender gender)
    {
        synchronized (monitor())
        {
            check_orphaned();
            com.bull.eris.ten.assessEngine.xml.dto.GenderDocument.Gender target = null;
            target = (com.bull.eris.ten.assessEngine.xml.dto.GenderDocument.Gender)get_store().find_element_user(GENDER$0, 0);
            if (target == null)
            {
                target = (com.bull.eris.ten.assessEngine.xml.dto.GenderDocument.Gender)get_store().add_element_user(GENDER$0);
            }
            target.set(gender);
        }
    }
    /**
     * An XML gender(@).
     *
     * This is an atomic type that is a restriction of com.bull.eris.ten.assessEngine.xml.dto.GenderDocument$Gender.
     */
    public static class GenderImpl extends org.apache.xmlbeans.impl.values.JavaStringEnumerationHolderEx implements com.bull.eris.ten.assessEngine.xml.dto.GenderDocument.Gender
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
