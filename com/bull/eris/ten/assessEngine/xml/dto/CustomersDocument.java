/*
 * An XML document type.
 * Localname: Customers
 * Namespace: 
 * Java type: com.bull.eris.ten.assessEngine.xml.dto.CustomersDocument
 *
 * Automatically generated - do not modify.
 */
package com.bull.eris.ten.assessEngine.xml.dto;


/**
 * A document containing one Customers(@) element.
 *
 * This is a complex type.
 */
public interface CustomersDocument extends org.apache.xmlbeans.XmlObject
{
    public static final org.apache.xmlbeans.SchemaType type = (org.apache.xmlbeans.SchemaType)
        org.apache.xmlbeans.XmlBeans.typeSystemForClassLoader(CustomersDocument.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.s105DB67ABAF7458D481DE4B55B9D43EA").resolveHandle("customers0bdcdoctype");
    
    /**
     * Gets the "Customers" element
     */
    com.bull.eris.ten.assessEngine.xml.dto.CustomersDocument.Customers getCustomers();
    
    /**
     * Sets the "Customers" element
     */
    void setCustomers(com.bull.eris.ten.assessEngine.xml.dto.CustomersDocument.Customers customers);
    
    /**
     * Appends and returns a new empty "Customers" element
     */
    com.bull.eris.ten.assessEngine.xml.dto.CustomersDocument.Customers addNewCustomers();
    
    /**
     * An XML Customers(@).
     *
     * This is a complex type.
     */
    public interface Customers extends org.apache.xmlbeans.XmlObject
    {
        public static final org.apache.xmlbeans.SchemaType type = (org.apache.xmlbeans.SchemaType)
            org.apache.xmlbeans.XmlBeans.typeSystemForClassLoader(Customers.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.s105DB67ABAF7458D481DE4B55B9D43EA").resolveHandle("customers750delemtype");
        
        /**
         * Gets array of all "customer" elements
         */
        com.bull.eris.ten.assessEngine.xml.dto.CustomerDocument.Customer[] getCustomerArray();
        
        /**
         * Gets ith "customer" element
         */
        com.bull.eris.ten.assessEngine.xml.dto.CustomerDocument.Customer getCustomerArray(int i);
        
        /**
         * Returns number of "customer" element
         */
        int sizeOfCustomerArray();
        
        /**
         * Sets array of all "customer" element
         */
        void setCustomerArray(com.bull.eris.ten.assessEngine.xml.dto.CustomerDocument.Customer[] customerArray);
        
        /**
         * Sets ith "customer" element
         */
        void setCustomerArray(int i, com.bull.eris.ten.assessEngine.xml.dto.CustomerDocument.Customer customer);
        
        /**
         * Inserts and returns a new empty value (as xml) as the ith "customer" element
         */
        com.bull.eris.ten.assessEngine.xml.dto.CustomerDocument.Customer insertNewCustomer(int i);
        
        /**
         * Appends and returns a new empty value (as xml) as the last "customer" element
         */
        com.bull.eris.ten.assessEngine.xml.dto.CustomerDocument.Customer addNewCustomer();
        
        /**
         * Removes the ith "customer" element
         */
        void removeCustomer(int i);
        
        /**
         * A factory class with static methods for creating instances
         * of this type.
         */
        
        public static final class Factory
        {
            public static com.bull.eris.ten.assessEngine.xml.dto.CustomersDocument.Customers newInstance() {
              return (com.bull.eris.ten.assessEngine.xml.dto.CustomersDocument.Customers) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, null ); }
            
            public static com.bull.eris.ten.assessEngine.xml.dto.CustomersDocument.Customers newInstance(org.apache.xmlbeans.XmlOptions options) {
              return (com.bull.eris.ten.assessEngine.xml.dto.CustomersDocument.Customers) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, options ); }
            
            private Factory() { } // No instance of this class allowed
        }
    }
    
    /**
     * A factory class with static methods for creating instances
     * of this type.
     */
    
    public static final class Factory
    {
        public static com.bull.eris.ten.assessEngine.xml.dto.CustomersDocument newInstance() {
          return (com.bull.eris.ten.assessEngine.xml.dto.CustomersDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, null ); }
        
        public static com.bull.eris.ten.assessEngine.xml.dto.CustomersDocument newInstance(org.apache.xmlbeans.XmlOptions options) {
          return (com.bull.eris.ten.assessEngine.xml.dto.CustomersDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, options ); }
        
        /** @param xmlAsString the string value to parse */
        public static com.bull.eris.ten.assessEngine.xml.dto.CustomersDocument parse(java.lang.String xmlAsString) throws org.apache.xmlbeans.XmlException {
          return (com.bull.eris.ten.assessEngine.xml.dto.CustomersDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xmlAsString, type, null ); }
        
        public static com.bull.eris.ten.assessEngine.xml.dto.CustomersDocument parse(java.lang.String xmlAsString, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (com.bull.eris.ten.assessEngine.xml.dto.CustomersDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xmlAsString, type, options ); }
        
        /** @param file the file from which to load an xml document */
        public static com.bull.eris.ten.assessEngine.xml.dto.CustomersDocument parse(java.io.File file) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (com.bull.eris.ten.assessEngine.xml.dto.CustomersDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( file, type, null ); }
        
        public static com.bull.eris.ten.assessEngine.xml.dto.CustomersDocument parse(java.io.File file, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (com.bull.eris.ten.assessEngine.xml.dto.CustomersDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( file, type, options ); }
        
        public static com.bull.eris.ten.assessEngine.xml.dto.CustomersDocument parse(java.net.URL u) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (com.bull.eris.ten.assessEngine.xml.dto.CustomersDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( u, type, null ); }
        
        public static com.bull.eris.ten.assessEngine.xml.dto.CustomersDocument parse(java.net.URL u, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (com.bull.eris.ten.assessEngine.xml.dto.CustomersDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( u, type, options ); }
        
        public static com.bull.eris.ten.assessEngine.xml.dto.CustomersDocument parse(java.io.InputStream is) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (com.bull.eris.ten.assessEngine.xml.dto.CustomersDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( is, type, null ); }
        
        public static com.bull.eris.ten.assessEngine.xml.dto.CustomersDocument parse(java.io.InputStream is, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (com.bull.eris.ten.assessEngine.xml.dto.CustomersDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( is, type, options ); }
        
        public static com.bull.eris.ten.assessEngine.xml.dto.CustomersDocument parse(java.io.Reader r) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (com.bull.eris.ten.assessEngine.xml.dto.CustomersDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( r, type, null ); }
        
        public static com.bull.eris.ten.assessEngine.xml.dto.CustomersDocument parse(java.io.Reader r, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (com.bull.eris.ten.assessEngine.xml.dto.CustomersDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( r, type, options ); }
        
        public static com.bull.eris.ten.assessEngine.xml.dto.CustomersDocument parse(javax.xml.stream.XMLStreamReader sr) throws org.apache.xmlbeans.XmlException {
          return (com.bull.eris.ten.assessEngine.xml.dto.CustomersDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( sr, type, null ); }
        
        public static com.bull.eris.ten.assessEngine.xml.dto.CustomersDocument parse(javax.xml.stream.XMLStreamReader sr, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (com.bull.eris.ten.assessEngine.xml.dto.CustomersDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( sr, type, options ); }
        
        public static com.bull.eris.ten.assessEngine.xml.dto.CustomersDocument parse(org.w3c.dom.Node node) throws org.apache.xmlbeans.XmlException {
          return (com.bull.eris.ten.assessEngine.xml.dto.CustomersDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( node, type, null ); }
        
        public static com.bull.eris.ten.assessEngine.xml.dto.CustomersDocument parse(org.w3c.dom.Node node, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (com.bull.eris.ten.assessEngine.xml.dto.CustomersDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( node, type, options ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static com.bull.eris.ten.assessEngine.xml.dto.CustomersDocument parse(org.apache.xmlbeans.xml.stream.XMLInputStream xis) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return (com.bull.eris.ten.assessEngine.xml.dto.CustomersDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xis, type, null ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static com.bull.eris.ten.assessEngine.xml.dto.CustomersDocument parse(org.apache.xmlbeans.xml.stream.XMLInputStream xis, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return (com.bull.eris.ten.assessEngine.xml.dto.CustomersDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xis, type, options ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static org.apache.xmlbeans.xml.stream.XMLInputStream newValidatingXMLInputStream(org.apache.xmlbeans.xml.stream.XMLInputStream xis) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newValidatingXMLInputStream( xis, type, null ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static org.apache.xmlbeans.xml.stream.XMLInputStream newValidatingXMLInputStream(org.apache.xmlbeans.xml.stream.XMLInputStream xis, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newValidatingXMLInputStream( xis, type, options ); }
        
        private Factory() { } // No instance of this class allowed
    }
}
