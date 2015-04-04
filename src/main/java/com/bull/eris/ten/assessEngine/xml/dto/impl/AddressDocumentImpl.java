/*
 * An XML document type.
 * Localname: address
 * Namespace: 
 * Java type: com.bull.eris.ten.assessEngine.xml.dto.AddressDocument
 *
 * Automatically generated - do not modify.
 */
package com.bull.eris.ten.assessEngine.xml.dto.impl;
/**
 * A document containing one address(@) element.
 *
 * This is a complex type.
 */
public class AddressDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements com.bull.eris.ten.assessEngine.xml.dto.AddressDocument
{
    private static final long serialVersionUID = 1L;
    
    public AddressDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName ADDRESS$0 = 
        new javax.xml.namespace.QName("", "address");
    
    
    /**
     * Gets the "address" element
     */
    public com.bull.eris.ten.assessEngine.xml.dto.AddressDocument.Address getAddress()
    {
        synchronized (monitor())
        {
            check_orphaned();
            com.bull.eris.ten.assessEngine.xml.dto.AddressDocument.Address target = null;
            target = (com.bull.eris.ten.assessEngine.xml.dto.AddressDocument.Address)get_store().find_element_user(ADDRESS$0, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * Sets the "address" element
     */
    public void setAddress(com.bull.eris.ten.assessEngine.xml.dto.AddressDocument.Address address)
    {
        generatedSetterHelperImpl(address, ADDRESS$0, 0, org.apache.xmlbeans.impl.values.XmlObjectBase.KIND_SETTERHELPER_SINGLETON);
    }
    
    /**
     * Appends and returns a new empty "address" element
     */
    public com.bull.eris.ten.assessEngine.xml.dto.AddressDocument.Address addNewAddress()
    {
        synchronized (monitor())
        {
            check_orphaned();
            com.bull.eris.ten.assessEngine.xml.dto.AddressDocument.Address target = null;
            target = (com.bull.eris.ten.assessEngine.xml.dto.AddressDocument.Address)get_store().add_element_user(ADDRESS$0);
            return target;
        }
    }
    /**
     * An XML address(@).
     *
     * This is a complex type.
     */
    public static class AddressImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements com.bull.eris.ten.assessEngine.xml.dto.AddressDocument.Address
    {
        private static final long serialVersionUID = 1L;
        
        public AddressImpl(org.apache.xmlbeans.SchemaType sType)
        {
            super(sType);
        }
        
        private static final javax.xml.namespace.QName PRIMARYADDRESS$0 = 
            new javax.xml.namespace.QName("", "primaryAddress");
        private static final javax.xml.namespace.QName BILLINGADDRESS$2 = 
            new javax.xml.namespace.QName("", "billingAddress");
        
        
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
         * Gets the "billingAddress" element
         */
        public com.bull.eris.ten.assessEngine.xml.dto.BillingAddressDocument.BillingAddress getBillingAddress()
        {
            synchronized (monitor())
            {
                check_orphaned();
                com.bull.eris.ten.assessEngine.xml.dto.BillingAddressDocument.BillingAddress target = null;
                target = (com.bull.eris.ten.assessEngine.xml.dto.BillingAddressDocument.BillingAddress)get_store().find_element_user(BILLINGADDRESS$2, 0);
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
            generatedSetterHelperImpl(billingAddress, BILLINGADDRESS$2, 0, org.apache.xmlbeans.impl.values.XmlObjectBase.KIND_SETTERHELPER_SINGLETON);
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
                target = (com.bull.eris.ten.assessEngine.xml.dto.BillingAddressDocument.BillingAddress)get_store().add_element_user(BILLINGADDRESS$2);
                return target;
            }
        }
    }
}
