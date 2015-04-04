/*
 * An XML document type.
 * Localname: address
 * Namespace: 
 * Java type: com.study.open.xmlbean.person.AddressDocument
 *
 * Automatically generated - do not modify.
 */
package com.study.open.xmlbean.person.impl;
/**
 * A document containing one address(@) element.
 *
 * This is a complex type.
 */
public class AddressDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements com.study.open.xmlbean.person.AddressDocument
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
    public com.study.open.xmlbean.person.AddressDocument.Address getAddress()
    {
        synchronized (monitor())
        {
            check_orphaned();
            com.study.open.xmlbean.person.AddressDocument.Address target = null;
            target = (com.study.open.xmlbean.person.AddressDocument.Address)get_store().find_element_user(ADDRESS$0, 0);
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
    public void setAddress(com.study.open.xmlbean.person.AddressDocument.Address address)
    {
        generatedSetterHelperImpl(address, ADDRESS$0, 0, org.apache.xmlbeans.impl.values.XmlObjectBase.KIND_SETTERHELPER_SINGLETON);
    }
    
    /**
     * Appends and returns a new empty "address" element
     */
    public com.study.open.xmlbean.person.AddressDocument.Address addNewAddress()
    {
        synchronized (monitor())
        {
            check_orphaned();
            com.study.open.xmlbean.person.AddressDocument.Address target = null;
            target = (com.study.open.xmlbean.person.AddressDocument.Address)get_store().add_element_user(ADDRESS$0);
            return target;
        }
    }
    /**
     * An XML address(@).
     *
     * This is a complex type.
     */
    public static class AddressImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements com.study.open.xmlbean.person.AddressDocument.Address
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
        public com.study.open.xmlbean.person.PrimaryAddressDocument.PrimaryAddress getPrimaryAddress()
        {
            synchronized (monitor())
            {
                check_orphaned();
                com.study.open.xmlbean.person.PrimaryAddressDocument.PrimaryAddress target = null;
                target = (com.study.open.xmlbean.person.PrimaryAddressDocument.PrimaryAddress)get_store().find_element_user(PRIMARYADDRESS$0, 0);
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
        public void setPrimaryAddress(com.study.open.xmlbean.person.PrimaryAddressDocument.PrimaryAddress primaryAddress)
        {
            generatedSetterHelperImpl(primaryAddress, PRIMARYADDRESS$0, 0, org.apache.xmlbeans.impl.values.XmlObjectBase.KIND_SETTERHELPER_SINGLETON);
        }
        
        /**
         * Appends and returns a new empty "primaryAddress" element
         */
        public com.study.open.xmlbean.person.PrimaryAddressDocument.PrimaryAddress addNewPrimaryAddress()
        {
            synchronized (monitor())
            {
                check_orphaned();
                com.study.open.xmlbean.person.PrimaryAddressDocument.PrimaryAddress target = null;
                target = (com.study.open.xmlbean.person.PrimaryAddressDocument.PrimaryAddress)get_store().add_element_user(PRIMARYADDRESS$0);
                return target;
            }
        }
        
        /**
         * Gets the "billingAddress" element
         */
        public com.study.open.xmlbean.person.BillingAddressDocument.BillingAddress getBillingAddress()
        {
            synchronized (monitor())
            {
                check_orphaned();
                com.study.open.xmlbean.person.BillingAddressDocument.BillingAddress target = null;
                target = (com.study.open.xmlbean.person.BillingAddressDocument.BillingAddress)get_store().find_element_user(BILLINGADDRESS$2, 0);
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
        public void setBillingAddress(com.study.open.xmlbean.person.BillingAddressDocument.BillingAddress billingAddress)
        {
            generatedSetterHelperImpl(billingAddress, BILLINGADDRESS$2, 0, org.apache.xmlbeans.impl.values.XmlObjectBase.KIND_SETTERHELPER_SINGLETON);
        }
        
        /**
         * Appends and returns a new empty "billingAddress" element
         */
        public com.study.open.xmlbean.person.BillingAddressDocument.BillingAddress addNewBillingAddress()
        {
            synchronized (monitor())
            {
                check_orphaned();
                com.study.open.xmlbean.person.BillingAddressDocument.BillingAddress target = null;
                target = (com.study.open.xmlbean.person.BillingAddressDocument.BillingAddress)get_store().add_element_user(BILLINGADDRESS$2);
                return target;
            }
        }
    }
}
