/*
 * An XML document type.
 * Localname: billingAddress
 * Namespace: 
 * Java type: com.bull.eris.ten.assessEngine.xml.dto.BillingAddressDocument
 *
 * Automatically generated - do not modify.
 */
package com.bull.eris.ten.assessEngine.xml.dto.impl;
/**
 * A document containing one billingAddress(@) element.
 *
 * This is a complex type.
 */
public class BillingAddressDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements com.bull.eris.ten.assessEngine.xml.dto.BillingAddressDocument
{
    private static final long serialVersionUID = 1L;
    
    public BillingAddressDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName BILLINGADDRESS$0 = 
        new javax.xml.namespace.QName("", "billingAddress");
    
    
    /**
     * Gets the "billingAddress" element
     */
    public com.bull.eris.ten.assessEngine.xml.dto.BillingAddressDocument.BillingAddress getBillingAddress()
    {
        synchronized (monitor())
        {
            check_orphaned();
            com.bull.eris.ten.assessEngine.xml.dto.BillingAddressDocument.BillingAddress target = null;
            target = (com.bull.eris.ten.assessEngine.xml.dto.BillingAddressDocument.BillingAddress)get_store().find_element_user(BILLINGADDRESS$0, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * Sets the "billingAddress" element
     */
    public void setBillingAddress(com.bull.eris.ten.assessEngine.xml.dto.BillingAddressDocument.BillingAddress billingAddress)
    {
        generatedSetterHelperImpl(billingAddress, BILLINGADDRESS$0, 0, org.apache.xmlbeans.impl.values.XmlObjectBase.KIND_SETTERHELPER_SINGLETON);
    }
    
    /**
     * Appends and returns a new empty "billingAddress" element
     */
    public com.bull.eris.ten.assessEngine.xml.dto.BillingAddressDocument.BillingAddress addNewBillingAddress()
    {
        synchronized (monitor())
        {
            check_orphaned();
            com.bull.eris.ten.assessEngine.xml.dto.BillingAddressDocument.BillingAddress target = null;
            target = (com.bull.eris.ten.assessEngine.xml.dto.BillingAddressDocument.BillingAddress)get_store().add_element_user(BILLINGADDRESS$0);
            return target;
        }
    }
    /**
     * An XML billingAddress(@).
     *
     * This is a complex type.
     */
    public static class BillingAddressImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements com.bull.eris.ten.assessEngine.xml.dto.BillingAddressDocument.BillingAddress
    {
        private static final long serialVersionUID = 1L;
        
        public BillingAddressImpl(org.apache.xmlbeans.SchemaType sType)
        {
            super(sType);
        }
        
        private static final javax.xml.namespace.QName RECEIVER$0 = 
            new javax.xml.namespace.QName("", "receiver");
        private static final javax.xml.namespace.QName POSTALCODE$2 = 
            new javax.xml.namespace.QName("", "postalCode");
        private static final javax.xml.namespace.QName ADDRESSLINE1$4 = 
            new javax.xml.namespace.QName("", "addressLine1");
        private static final javax.xml.namespace.QName ADDRESSLINE2$6 = 
            new javax.xml.namespace.QName("", "addressLine2");
        
        
        /**
         * Gets the "receiver" element
         */
        public java.lang.String getReceiver()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(RECEIVER$0, 0);
                if (target == null)
                {
                    return null;
                }
                return target.getStringValue();
            }
        }
        
        /**
         * Gets (as xml) the "receiver" element
         */
        public org.apache.xmlbeans.XmlString xgetReceiver()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlString target = null;
                target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(RECEIVER$0, 0);
                return target;
            }
        }
        
        /**
         * Sets the "receiver" element
         */
        public void setReceiver(java.lang.String receiver)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(RECEIVER$0, 0);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(RECEIVER$0);
                }
                target.setStringValue(receiver);
            }
        }
        
        /**
         * Sets (as xml) the "receiver" element
         */
        public void xsetReceiver(org.apache.xmlbeans.XmlString receiver)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlString target = null;
                target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(RECEIVER$0, 0);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.XmlString)get_store().add_element_user(RECEIVER$0);
                }
                target.set(receiver);
            }
        }
        
        /**
         * Gets the "postalCode" element
         */
        public java.lang.String getPostalCode()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(POSTALCODE$2, 0);
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
                target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(POSTALCODE$2, 0);
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
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(POSTALCODE$2, 0);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(POSTALCODE$2);
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
                target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(POSTALCODE$2, 0);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.XmlString)get_store().add_element_user(POSTALCODE$2);
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
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(ADDRESSLINE1$4, 0);
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
                target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(ADDRESSLINE1$4, 0);
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
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(ADDRESSLINE1$4, 0);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(ADDRESSLINE1$4);
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
                target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(ADDRESSLINE1$4, 0);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.XmlString)get_store().add_element_user(ADDRESSLINE1$4);
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
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(ADDRESSLINE2$6, 0);
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
                target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(ADDRESSLINE2$6, 0);
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
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(ADDRESSLINE2$6, 0);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(ADDRESSLINE2$6);
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
                target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(ADDRESSLINE2$6, 0);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.XmlString)get_store().add_element_user(ADDRESSLINE2$6);
                }
                target.set(addressLine2);
            }
        }
    }
}
