/*
 * An XML document type.
 * Localname: primaryAddress
 * Namespace: 
 * Java type: com.bull.eris.ten.assessEngine.xml.dto.PrimaryAddressDocument
 *
 * Automatically generated - do not modify.
 */
package com.bull.eris.ten.assessEngine.xml.dto.impl;
/**
 * A document containing one primaryAddress(@) element.
 *
 * This is a complex type.
 */
public class PrimaryAddressDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements com.bull.eris.ten.assessEngine.xml.dto.PrimaryAddressDocument
{
    private static final long serialVersionUID = 1L;
    
    public PrimaryAddressDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName PRIMARYADDRESS$0 = 
        new javax.xml.namespace.QName("", "primaryAddress");
    
    
    /**
     * Gets the "primaryAddress" element
     */
    public com.bull.eris.ten.assessEngine.xml.dto.PrimaryAddressDocument.PrimaryAddress getPrimaryAddress()
    {
        synchronized (monitor())
        {
            check_orphaned();
            com.bull.eris.ten.assessEngine.xml.dto.PrimaryAddressDocument.PrimaryAddress target = null;
            target = (com.bull.eris.ten.assessEngine.xml.dto.PrimaryAddressDocument.PrimaryAddress)get_store().find_element_user(PRIMARYADDRESS$0, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * Sets the "primaryAddress" element
     */
    public void setPrimaryAddress(com.bull.eris.ten.assessEngine.xml.dto.PrimaryAddressDocument.PrimaryAddress primaryAddress)
    {
        generatedSetterHelperImpl(primaryAddress, PRIMARYADDRESS$0, 0, org.apache.xmlbeans.impl.values.XmlObjectBase.KIND_SETTERHELPER_SINGLETON);
    }
    
    /**
     * Appends and returns a new empty "primaryAddress" element
     */
    public com.bull.eris.ten.assessEngine.xml.dto.PrimaryAddressDocument.PrimaryAddress addNewPrimaryAddress()
    {
        synchronized (monitor())
        {
            check_orphaned();
            com.bull.eris.ten.assessEngine.xml.dto.PrimaryAddressDocument.PrimaryAddress target = null;
            target = (com.bull.eris.ten.assessEngine.xml.dto.PrimaryAddressDocument.PrimaryAddress)get_store().add_element_user(PRIMARYADDRESS$0);
            return target;
        }
    }
    /**
     * An XML primaryAddress(@).
     *
     * This is a complex type.
     */
    public static class PrimaryAddressImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements com.bull.eris.ten.assessEngine.xml.dto.PrimaryAddressDocument.PrimaryAddress
    {
        private static final long serialVersionUID = 1L;
        
        public PrimaryAddressImpl(org.apache.xmlbeans.SchemaType sType)
        {
            super(sType);
        }
        
        private static final javax.xml.namespace.QName POSTALCODE$0 = 
            new javax.xml.namespace.QName("", "postalCode");
        private static final javax.xml.namespace.QName ADDRESSLINE1$2 = 
            new javax.xml.namespace.QName("", "addressLine1");
        private static final javax.xml.namespace.QName ADDRESSLINE2$4 = 
            new javax.xml.namespace.QName("", "addressLine2");
        
        
        /**
         * Gets the "postalCode" element
         */
        public java.lang.String getPostalCode()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(POSTALCODE$0, 0);
                if (target == null)
                {
                    return null;
                }
                return target.getStringValue();
            }
        }
        
        /**
         * Gets (as xml) the "postalCode" element
         */
        public org.apache.xmlbeans.XmlString xgetPostalCode()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlString target = null;
                target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(POSTALCODE$0, 0);
                return target;
            }
        }
        
        /**
         * Sets the "postalCode" element
         */
        public void setPostalCode(java.lang.String postalCode)
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
                target.setStringValue(postalCode);
            }
        }
        
        /**
         * Sets (as xml) the "postalCode" element
         */
        public void xsetPostalCode(org.apache.xmlbeans.XmlString postalCode)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlString target = null;
                target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(POSTALCODE$0, 0);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.XmlString)get_store().add_element_user(POSTALCODE$0);
                }
                target.set(postalCode);
            }
        }
        
        /**
         * Gets the "addressLine1" element
         */
        public java.lang.String getAddressLine1()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(ADDRESSLINE1$2, 0);
                if (target == null)
                {
                    return null;
                }
                return target.getStringValue();
            }
        }
        
        /**
         * Gets (as xml) the "addressLine1" element
         */
        public org.apache.xmlbeans.XmlString xgetAddressLine1()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlString target = null;
                target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(ADDRESSLINE1$2, 0);
                return target;
            }
        }
        
        /**
         * Sets the "addressLine1" element
         */
        public void setAddressLine1(java.lang.String addressLine1)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(ADDRESSLINE1$2, 0);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(ADDRESSLINE1$2);
                }
                target.setStringValue(addressLine1);
            }
        }
        
        /**
         * Sets (as xml) the "addressLine1" element
         */
        public void xsetAddressLine1(org.apache.xmlbeans.XmlString addressLine1)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlString target = null;
                target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(ADDRESSLINE1$2, 0);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.XmlString)get_store().add_element_user(ADDRESSLINE1$2);
                }
                target.set(addressLine1);
            }
        }
        
        /**
         * Gets the "addressLine2" element
         */
        public java.lang.String getAddressLine2()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(ADDRESSLINE2$4, 0);
                if (target == null)
                {
                    return null;
                }
                return target.getStringValue();
            }
        }
        
        /**
         * Gets (as xml) the "addressLine2" element
         */
        public org.apache.xmlbeans.XmlString xgetAddressLine2()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlString target = null;
                target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(ADDRESSLINE2$4, 0);
                return target;
            }
        }
        
        /**
         * Sets the "addressLine2" element
         */
        public void setAddressLine2(java.lang.String addressLine2)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(ADDRESSLINE2$4, 0);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(ADDRESSLINE2$4);
                }
                target.setStringValue(addressLine2);
            }
        }
        
        /**
         * Sets (as xml) the "addressLine2" element
         */
        public void xsetAddressLine2(org.apache.xmlbeans.XmlString addressLine2)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlString target = null;
                target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(ADDRESSLINE2$4, 0);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.XmlString)get_store().add_element_user(ADDRESSLINE2$4);
                }
                target.set(addressLine2);
            }
        }
    }
}
