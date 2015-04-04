/*
 * An XML document type.
 * Localname: customer
 * Namespace: 
 * Java type: com.study.open.xmlbean.person.CustomerDocument
 *
 * Automatically generated - do not modify.
 */
package com.study.open.xmlbean.person.impl;
/**
 * A document containing one customer(@) element.
 *
 * This is a complex type.
 */
public class CustomerDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements com.study.open.xmlbean.person.CustomerDocument
{
    private static final long serialVersionUID = 1L;
    
    public CustomerDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName CUSTOMER$0 = 
        new javax.xml.namespace.QName("", "customer");
    
    
    /**
     * Gets the "customer" element
     */
    public com.study.open.xmlbean.person.CustomerDocument.Customer getCustomer()
    {
        synchronized (monitor())
        {
            check_orphaned();
            com.study.open.xmlbean.person.CustomerDocument.Customer target = null;
            target = (com.study.open.xmlbean.person.CustomerDocument.Customer)get_store().find_element_user(CUSTOMER$0, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * Sets the "customer" element
     */
    public void setCustomer(com.study.open.xmlbean.person.CustomerDocument.Customer customer)
    {
        generatedSetterHelperImpl(customer, CUSTOMER$0, 0, org.apache.xmlbeans.impl.values.XmlObjectBase.KIND_SETTERHELPER_SINGLETON);
    }
    
    /**
     * Appends and returns a new empty "customer" element
     */
    public com.study.open.xmlbean.person.CustomerDocument.Customer addNewCustomer()
    {
        synchronized (monitor())
        {
            check_orphaned();
            com.study.open.xmlbean.person.CustomerDocument.Customer target = null;
            target = (com.study.open.xmlbean.person.CustomerDocument.Customer)get_store().add_element_user(CUSTOMER$0);
            return target;
        }
    }
    /**
     * An XML customer(@).
     *
     * This is a complex type.
     */
    public static class CustomerImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements com.study.open.xmlbean.person.CustomerDocument.Customer
    {
        private static final long serialVersionUID = 1L;
        
        public CustomerImpl(org.apache.xmlbeans.SchemaType sType)
        {
            super(sType);
        }
        
        private static final javax.xml.namespace.QName ID$0 = 
            new javax.xml.namespace.QName("", "id");
        private static final javax.xml.namespace.QName GENDER$2 = 
            new javax.xml.namespace.QName("", "gender");
        private static final javax.xml.namespace.QName FIRSTNAME$4 = 
            new javax.xml.namespace.QName("", "firstname");
        private static final javax.xml.namespace.QName LASTNAME$6 = 
            new javax.xml.namespace.QName("", "lastname");
        private static final javax.xml.namespace.QName PHONENUMBER$8 = 
            new javax.xml.namespace.QName("", "phoneNumber");
        private static final javax.xml.namespace.QName ADDRESS$10 = 
            new javax.xml.namespace.QName("", "address");
        
        
        /**
         * Gets the "id" element
         */
        public int getId()
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
                return target.getIntValue();
            }
        }
        
        /**
         * Gets (as xml) the "id" element
         */
        public org.apache.xmlbeans.XmlInt xgetId()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlInt target = null;
                target = (org.apache.xmlbeans.XmlInt)get_store().find_element_user(ID$0, 0);
                return target;
            }
        }
        
        /**
         * Sets the "id" element
         */
        public void setId(int id)
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
                target.setIntValue(id);
            }
        }
        
        /**
         * Sets (as xml) the "id" element
         */
        public void xsetId(org.apache.xmlbeans.XmlInt id)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlInt target = null;
                target = (org.apache.xmlbeans.XmlInt)get_store().find_element_user(ID$0, 0);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.XmlInt)get_store().add_element_user(ID$0);
                }
                target.set(id);
            }
        }
        
        /**
         * Gets the "gender" element
         */
        public com.study.open.xmlbean.person.GenderDocument.Gender.Enum getGender()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(GENDER$2, 0);
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
                target = (com.study.open.xmlbean.person.GenderDocument.Gender)get_store().find_element_user(GENDER$2, 0);
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
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(GENDER$2, 0);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(GENDER$2);
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
                target = (com.study.open.xmlbean.person.GenderDocument.Gender)get_store().find_element_user(GENDER$2, 0);
                if (target == null)
                {
                    target = (com.study.open.xmlbean.person.GenderDocument.Gender)get_store().add_element_user(GENDER$2);
                }
                target.set(gender);
            }
        }
        
        /**
         * Gets the "firstname" element
         */
        public java.lang.String getFirstname()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(FIRSTNAME$4, 0);
                if (target == null)
                {
                    return null;
                }
                return target.getStringValue();
            }
        }
        
        /**
         * Gets (as xml) the "firstname" element
         */
        public org.apache.xmlbeans.XmlString xgetFirstname()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlString target = null;
                target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(FIRSTNAME$4, 0);
                return target;
            }
        }
        
        /**
         * Sets the "firstname" element
         */
        public void setFirstname(java.lang.String firstname)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(FIRSTNAME$4, 0);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(FIRSTNAME$4);
                }
                target.setStringValue(firstname);
            }
        }
        
        /**
         * Sets (as xml) the "firstname" element
         */
        public void xsetFirstname(org.apache.xmlbeans.XmlString firstname)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlString target = null;
                target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(FIRSTNAME$4, 0);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.XmlString)get_store().add_element_user(FIRSTNAME$4);
                }
                target.set(firstname);
            }
        }
        
        /**
         * Gets the "lastname" element
         */
        public java.lang.String getLastname()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(LASTNAME$6, 0);
                if (target == null)
                {
                    return null;
                }
                return target.getStringValue();
            }
        }
        
        /**
         * Gets (as xml) the "lastname" element
         */
        public org.apache.xmlbeans.XmlString xgetLastname()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlString target = null;
                target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(LASTNAME$6, 0);
                return target;
            }
        }
        
        /**
         * Sets the "lastname" element
         */
        public void setLastname(java.lang.String lastname)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(LASTNAME$6, 0);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(LASTNAME$6);
                }
                target.setStringValue(lastname);
            }
        }
        
        /**
         * Sets (as xml) the "lastname" element
         */
        public void xsetLastname(org.apache.xmlbeans.XmlString lastname)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlString target = null;
                target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(LASTNAME$6, 0);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.XmlString)get_store().add_element_user(LASTNAME$6);
                }
                target.set(lastname);
            }
        }
        
        /**
         * Gets the "phoneNumber" element
         */
        public java.lang.String getPhoneNumber()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(PHONENUMBER$8, 0);
                if (target == null)
                {
                    return null;
                }
                return target.getStringValue();
            }
        }
        
        /**
         * Gets (as xml) the "phoneNumber" element
         */
        public org.apache.xmlbeans.XmlString xgetPhoneNumber()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlString target = null;
                target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(PHONENUMBER$8, 0);
                return target;
            }
        }
        
        /**
         * Sets the "phoneNumber" element
         */
        public void setPhoneNumber(java.lang.String phoneNumber)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(PHONENUMBER$8, 0);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(PHONENUMBER$8);
                }
                target.setStringValue(phoneNumber);
            }
        }
        
        /**
         * Sets (as xml) the "phoneNumber" element
         */
        public void xsetPhoneNumber(org.apache.xmlbeans.XmlString phoneNumber)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlString target = null;
                target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(PHONENUMBER$8, 0);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.XmlString)get_store().add_element_user(PHONENUMBER$8);
                }
                target.set(phoneNumber);
            }
        }
        
        /**
         * Gets the "address" element
         */
        public com.study.open.xmlbean.person.AddressDocument.Address getAddress()
        {
            synchronized (monitor())
            {
                check_orphaned();
                com.study.open.xmlbean.person.AddressDocument.Address target = null;
                target = (com.study.open.xmlbean.person.AddressDocument.Address)get_store().find_element_user(ADDRESS$10, 0);
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
            generatedSetterHelperImpl(address, ADDRESS$10, 0, org.apache.xmlbeans.impl.values.XmlObjectBase.KIND_SETTERHELPER_SINGLETON);
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
                target = (com.study.open.xmlbean.person.AddressDocument.Address)get_store().add_element_user(ADDRESS$10);
                return target;
            }
        }
    }
}
