/*
 * An XML document type.
 * Localname: id
 * Namespace: 
 * Java type: com.study.open.xmlbean.person.IdDocument
 *
 * Automatically generated - do not modify.
 */
package com.study.open.xmlbean.person.impl;
/**
 * A document containing one id(@) element.
 *
 * This is a complex type.
 */
public class IdDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements com.study.open.xmlbean.person.IdDocument
{
    private static final long serialVersionUID = 1L;
    
    public IdDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName ID$0 = 
        new javax.xml.namespace.QName("", "id");
    
    
    /**
     * Gets the "id" element
     */
    public byte getId()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(ID$0, 0);
            if (target == null)
            {
                return 0;
            }
            return target.getByteValue();
        }
    }
    
    /**
     * Gets (as xml) the "id" element
     */
    public com.study.open.xmlbean.person.IdDocument.Id xgetId()
    {
        synchronized (monitor())
        {
            check_orphaned();
            com.study.open.xmlbean.person.IdDocument.Id target = null;
            target = (com.study.open.xmlbean.person.IdDocument.Id)get_store().find_element_user(ID$0, 0);
            return target;
        }
    }
    
    /**
     * Sets the "id" element
     */
    public void setId(byte id)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(ID$0, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(ID$0);
            }
            target.setByteValue(id);
        }
    }
    
    /**
     * Sets (as xml) the "id" element
     */
    public void xsetId(com.study.open.xmlbean.person.IdDocument.Id id)
    {
        synchronized (monitor())
        {
            check_orphaned();
            com.study.open.xmlbean.person.IdDocument.Id target = null;
            target = (com.study.open.xmlbean.person.IdDocument.Id)get_store().find_element_user(ID$0, 0);
            if (target == null)
            {
                target = (com.study.open.xmlbean.person.IdDocument.Id)get_store().add_element_user(ID$0);
            }
            target.set(id);
        }
    }
    /**
     * An XML id(@).
     *
     * This is an atomic type that is a restriction of com.study.open.xmlbean.person.IdDocument$Id.
     */
    public static class IdImpl extends org.apache.xmlbeans.impl.values.JavaIntHolderEx implements com.study.open.xmlbean.person.IdDocument.Id
    {
        private static final long serialVersionUID = 1L;
        
        public IdImpl(org.apache.xmlbeans.SchemaType sType)
        {
            super(sType, false);
        }
        
        protected IdImpl(org.apache.xmlbeans.SchemaType sType, boolean b)
        {
            super(sType, b);
        }
    }
}
