/*
 * An XML document type.
 * Localname: Customers
 * Namespace: 
 * Java type: com.bull.eris.ten.assessEngine.xml.dto.CustomersDocument
 *
 * Automatically generated - do not modify.
 */
package com.bull.eris.ten.assessEngine.xml.dto.impl;
/**
 * A document containing one Customers(@) element.
 *
 * This is a complex type.
 */
public class CustomersDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements com.bull.eris.ten.assessEngine.xml.dto.CustomersDocument
{
    private static final long serialVersionUID = 1L;
    
    public CustomersDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName CUSTOMERS$0 = 
        new javax.xml.namespace.QName("", "Customers");
    
    
    /**
     * Gets the "Customers" element
     */
    public com.bull.eris.ten.assessEngine.xml.dto.CustomersDocument.Customers getCustomers()
    {
        synchronized (monitor())
        {
            check_orphaned();
            com.bull.eris.ten.assessEngine.xml.dto.CustomersDocument.Customers target = null;
            target = (com.bull.eris.ten.assessEngine.xml.dto.CustomersDocument.Customers)get_store().find_element_user(CUSTOMERS$0, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * Sets the "Customers" element
     */
    public void setCustomers(com.bull.eris.ten.assessEngine.xml.dto.CustomersDocument.Customers customers)
    {
        generatedSetterHelperImpl(customers, CUSTOMERS$0, 0, org.apache.xmlbeans.impl.values.XmlObjectBase.KIND_SETTERHELPER_SINGLETON);
    }
    
    /**
     * Appends and returns a new empty "Customers" element
     */
    public com.bull.eris.ten.assessEngine.xml.dto.CustomersDocument.Customers addNewCustomers()
    {
        synchronized (monitor())
        {
            check_orphaned();
            com.bull.eris.ten.assessEngine.xml.dto.CustomersDocument.Customers target = null;
            target = (com.bull.eris.ten.assessEngine.xml.dto.CustomersDocument.Customers)get_store().add_element_user(CUSTOMERS$0);
            return target;
        }
    }
    /**
     * An XML Customers(@).
     *
     * This is a complex type.
     */
    public static class CustomersImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements com.bull.eris.ten.assessEngine.xml.dto.CustomersDocument.Customers
    {
        private static final long serialVersionUID = 1L;
        
        public CustomersImpl(org.apache.xmlbeans.SchemaType sType)
        {
            super(sType);
        }
        
        private static final javax.xml.namespace.QName CUSTOMER$0 = 
            new javax.xml.namespace.QName("", "customer");
        
        
        /**
         * Gets array of all "customer" elements
         */
        public com.bull.eris.ten.assessEngine.xml.dto.CustomerDocument.Customer[] getCustomerArray()
        {
            synchronized (monitor())
            {
                check_orphaned();
                java.util.List targetList = new java.util.ArrayList();
                get_store().find_all_element_users(CUSTOMER$0, targetList);
                com.bull.eris.ten.assessEngine.xml.dto.CustomerDocument.Customer[] result = new com.bull.eris.ten.assessEngine.xml.dto.CustomerDocument.Customer[targetList.size()];
                targetList.toArray(result);
                return result;
            }
        }
        
        /**
         * Gets ith "customer" element
         */
        public com.bull.eris.ten.assessEngine.xml.dto.CustomerDocument.Customer getCustomerArray(int i)
        {
            synchronized (monitor())
            {
                check_orphaned();
                com.bull.eris.ten.assessEngine.xml.dto.CustomerDocument.Customer target = null;
                target = (com.bull.eris.ten.assessEngine.xml.dto.CustomerDocument.Customer)get_store().find_element_user(CUSTOMER$0, i);
                if (target == null)
                {
                    throw new IndexOutOfBoundsException();
                }
                return target;
            }
        }
        
        /**
         * Returns number of "customer" element
         */
        public int sizeOfCustomerArray()
        {
            synchronized (monitor())
            {
                check_orphaned();
                return get_store().count_elements(CUSTOMER$0);
            }
        }
        
        /**
         * Sets array of all "customer" element  WARNING: This method is not atomicaly synchronized.
         */
        public void setCustomerArray(com.bull.eris.ten.assessEngine.xml.dto.CustomerDocument.Customer[] customerArray)
        {
            check_orphaned();
            arraySetterHelper(customerArray, CUSTOMER$0);
        }
        
        /**
         * Sets ith "customer" element
         */
        public void setCustomerArray(int i, com.bull.eris.ten.assessEngine.xml.dto.CustomerDocument.Customer customer)
        {
            synchronized (monitor())
            {
                check_orphaned();
                com.bull.eris.ten.assessEngine.xml.dto.CustomerDocument.Customer target = null;
                target = (com.bull.eris.ten.assessEngine.xml.dto.CustomerDocument.Customer)get_store().find_element_user(CUSTOMER$0, i);
                if (target == null)
                {
                    throw new IndexOutOfBoundsException();
                }
                target.set(customer);
            }
        }
        
        /**
         * Inserts and returns a new empty value (as xml) as the ith "customer" element
         */
        public com.bull.eris.ten.assessEngine.xml.dto.CustomerDocument.Customer insertNewCustomer(int i)
        {
            synchronized (monitor())
            {
                check_orphaned();
                com.bull.eris.ten.assessEngine.xml.dto.CustomerDocument.Customer target = null;
                target = (com.bull.eris.ten.assessEngine.xml.dto.CustomerDocument.Customer)get_store().insert_element_user(CUSTOMER$0, i);
                return target;
            }
        }
        
        /**
         * Appends and returns a new empty value (as xml) as the last "customer" element
         */
        public com.bull.eris.ten.assessEngine.xml.dto.CustomerDocument.Customer addNewCustomer()
        {
            synchronized (monitor())
            {
                check_orphaned();
                com.bull.eris.ten.assessEngine.xml.dto.CustomerDocument.Customer target = null;
                target = (com.bull.eris.ten.assessEngine.xml.dto.CustomerDocument.Customer)get_store().add_element_user(CUSTOMER$0);
                return target;
            }
        }
        
        /**
         * Removes the ith "customer" element
         */
        public void removeCustomer(int i)
        {
            synchronized (monitor())
            {
                check_orphaned();
                get_store().remove_element(CUSTOMER$0, i);
            }
        }
    }
}
