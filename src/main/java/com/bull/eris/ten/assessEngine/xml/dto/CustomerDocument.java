/*
 * An XML document type.
 * Localname: customer
 * Namespace: 
 * Java type: com.bull.eris.ten.assessEngine.xml.dto.CustomerDocument
 *
 * Automatically generated - do not modify.
 */
package com.bull.eris.ten.assessEngine.xml.dto;


/**
 * A document containing one customer(@) element.
 *
 * This is a complex type.
 */
public interface CustomerDocument extends org.apache.xmlbeans.XmlObject
{
    public static final org.apache.xmlbeans.SchemaType type = (org.apache.xmlbeans.SchemaType)
        org.apache.xmlbeans.XmlBeans.typeSystemForClassLoader(CustomerDocument.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.s105DB67ABAF7458D481DE4B55B9D43EA").resolveHandle("customerff57doctype");
    
    /**
     * Gets the "customer" element
     */
    com.bull.eris.ten.assessEngine.xml.dto.CustomerDocument.Customer getCustomer();
    
    /**
     * Sets the "customer" element
     */
    void setCustomer(com.bull.eris.ten.assessEngine.xml.dto.CustomerDocument.Customer customer);
    
    /**
     * Appends and returns a new empty "customer" element
     */
    com.bull.eris.ten.assessEngine.xml.dto.CustomerDocument.Customer addNewCustomer();
    
    /**
     * An XML customer(@).
     *
     * This is a complex type.
     */
    public interface Customer extends org.apache.xmlbeans.XmlObject
    {
        public static final org.apache.xmlbeans.SchemaType type = (org.apache.xmlbeans.SchemaType)
            org.apache.xmlbeans.XmlBeans.typeSystemForClassLoader(Customer.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.s105DB67ABAF7458D481DE4B55B9D43EA").resolveHandle("customerb6adelemtype");
        
        /**
         * Gets the "id" element
         */
        int getId();
        
        /**
         * Gets (as xml) the "id" element
         */
        org.apache.xmlbeans.XmlInt xgetId();
        
        /**
         * Sets the "id" element
         */
        void setId(int id);
        
        /**
         * Sets (as xml) the "id" element
         */
        void xsetId(org.apache.xmlbeans.XmlInt id);
        
        /**
         * Gets the "gender" element
         */
        com.bull.eris.ten.assessEngine.xml.dto.GenderDocument.Gender.Enum getGender();
        
        /**
         * Gets (as xml) the "gender" element
         */
        com.bull.eris.ten.assessEngine.xml.dto.GenderDocument.Gender xgetGender();
        
        /**
         * Sets the "gender" element
         */
        void setGender(com.bull.eris.ten.assessEngine.xml.dto.GenderDocument.Gender.Enum gender);
        
        /**
         * Sets (as xml) the "gender" element
         */
        void xsetGender(com.bull.eris.ten.assessEngine.xml.dto.GenderDocument.Gender gender);
        
        /**
         * Gets the "firstname" element
         */
        java.lang.String getFirstname();
        
        /**
         * Gets (as xml) the "firstname" element
         */
        org.apache.xmlbeans.XmlString xgetFirstname();
        
        /**
         * Sets the "firstname" element
         */
        void setFirstname(java.lang.String firstname);
        
        /**
         * Sets (as xml) the "firstname" element
         */
        void xsetFirstname(org.apache.xmlbeans.XmlString firstname);
        
        /**
         * Gets the "lastname" element
         */
        java.lang.String getLastname();
        
        /**
         * Gets (as xml) the "lastname" element
         */
        org.apache.xmlbeans.XmlString xgetLastname();
        
        /**
         * Sets the "lastname" element
         */
        void setLastname(java.lang.String lastname);
        
        /**
         * Sets (as xml) the "lastname" element
         */
        void xsetLastname(org.apache.xmlbeans.XmlString lastname);
        
        /**
         * Gets the "phoneNumber" element
         */
        java.lang.String getPhoneNumber();
        
        /**
         * Gets (as xml) the "phoneNumber" element
         */
        org.apache.xmlbeans.XmlString xgetPhoneNumber();
        
        /**
         * Sets the "phoneNumber" element
         */
        void setPhoneNumber(java.lang.String phoneNumber);
        
        /**
         * Sets (as xml) the "phoneNumber" element
         */
        void xsetPhoneNumber(org.apache.xmlbeans.XmlString phoneNumber);
        
        /**
         * Gets the "address" element
         */
        com.bull.eris.ten.assessEngine.xml.dto.AddressDocument.Address getAddress();
        
        /**
         * Sets the "address" element
         */
        void setAddress(com.bull.eris.ten.assessEngine.xml.dto.AddressDocument.Address address);
        
        /**
         * Appends and returns a new empty "address" element
         */
        com.bull.eris.ten.assessEngine.xml.dto.AddressDocument.Address addNewAddress();
        
        /**
         * A factory class with static methods for creating instances
         * of this type.
         */
        
        public static final class Factory
        {
            public static com.bull.eris.ten.assessEngine.xml.dto.CustomerDocument.Customer newInstance() {
              return (com.bull.eris.ten.assessEngine.xml.dto.CustomerDocument.Customer) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, null ); }
            
            public static com.bull.eris.ten.assessEngine.xml.dto.CustomerDocument.Customer newInstance(org.apache.xmlbeans.XmlOptions options) {
              return (com.bull.eris.ten.assessEngine.xml.dto.CustomerDocument.Customer) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, options ); }
            
            private Factory() { } // No instance of this class allowed
        }
    }
    
    /**
     * A factory class with static methods for creating instances
     * of this type.
     */
    
    public static final class Factory
    {
        public static com.bull.eris.ten.assessEngine.xml.dto.CustomerDocument newInstance() {
          return (com.bull.eris.ten.assessEngine.xml.dto.CustomerDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, null ); }
        
        public static com.bull.eris.ten.assessEngine.xml.dto.CustomerDocument newInstance(org.apache.xmlbeans.XmlOptions options) {
          return (com.bull.eris.ten.assessEngine.xml.dto.CustomerDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, options ); }
        
        /** @param xmlAsString the string value to parse */
        public static com.bull.eris.ten.assessEngine.xml.dto.CustomerDocument parse(java.lang.String xmlAsString) throws org.apache.xmlbeans.XmlException {
          return (com.bull.eris.ten.assessEngine.xml.dto.CustomerDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xmlAsString, type, null ); }
        
        public static com.bull.eris.ten.assessEngine.xml.dto.CustomerDocument parse(java.lang.String xmlAsString, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (com.bull.eris.ten.assessEngine.xml.dto.CustomerDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xmlAsString, type, options ); }
        
        /** @param file the file from which to load an xml document */
        public static com.bull.eris.ten.assessEngine.xml.dto.CustomerDocument parse(java.io.File file) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (com.bull.eris.ten.assessEngine.xml.dto.CustomerDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( file, type, null ); }
        
        public static com.bull.eris.ten.assessEngine.xml.dto.CustomerDocument parse(java.io.File file, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (com.bull.eris.ten.assessEngine.xml.dto.CustomerDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( file, type, options ); }
        
        public static com.bull.eris.ten.assessEngine.xml.dto.CustomerDocument parse(java.net.URL u) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (com.bull.eris.ten.assessEngine.xml.dto.CustomerDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( u, type, null ); }
        
        public static com.bull.eris.ten.assessEngine.xml.dto.CustomerDocument parse(java.net.URL u, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (com.bull.eris.ten.assessEngine.xml.dto.CustomerDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( u, type, options ); }
        
        public static com.bull.eris.ten.assessEngine.xml.dto.CustomerDocument parse(java.io.InputStream is) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (com.bull.eris.ten.assessEngine.xml.dto.CustomerDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( is, type, null ); }
        
        public static com.bull.eris.ten.assessEngine.xml.dto.CustomerDocument parse(java.io.InputStream is, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (com.bull.eris.ten.assessEngine.xml.dto.CustomerDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( is, type, options ); }
        
        public static com.bull.eris.ten.assessEngine.xml.dto.CustomerDocument parse(java.io.Reader r) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (com.bull.eris.ten.assessEngine.xml.dto.CustomerDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( r, type, null ); }
        
        public static com.bull.eris.ten.assessEngine.xml.dto.CustomerDocument parse(java.io.Reader r, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (com.bull.eris.ten.assessEngine.xml.dto.CustomerDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( r, type, options ); }
        
        public static com.bull.eris.ten.assessEngine.xml.dto.CustomerDocument parse(javax.xml.stream.XMLStreamReader sr) throws org.apache.xmlbeans.XmlException {
          return (com.bull.eris.ten.assessEngine.xml.dto.CustomerDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( sr, type, null ); }
        
        public static com.bull.eris.ten.assessEngine.xml.dto.CustomerDocument parse(javax.xml.stream.XMLStreamReader sr, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (com.bull.eris.ten.assessEngine.xml.dto.CustomerDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( sr, type, options ); }
        
        public static com.bull.eris.ten.assessEngine.xml.dto.CustomerDocument parse(org.w3c.dom.Node node) throws org.apache.xmlbeans.XmlException {
          return (com.bull.eris.ten.assessEngine.xml.dto.CustomerDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( node, type, null ); }
        
        public static com.bull.eris.ten.assessEngine.xml.dto.CustomerDocument parse(org.w3c.dom.Node node, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (com.bull.eris.ten.assessEngine.xml.dto.CustomerDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( node, type, options ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static com.bull.eris.ten.assessEngine.xml.dto.CustomerDocument parse(org.apache.xmlbeans.xml.stream.XMLInputStream xis) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return (com.bull.eris.ten.assessEngine.xml.dto.CustomerDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xis, type, null ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static com.bull.eris.ten.assessEngine.xml.dto.CustomerDocument parse(org.apache.xmlbeans.xml.stream.XMLInputStream xis, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return (com.bull.eris.ten.assessEngine.xml.dto.CustomerDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xis, type, options ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static org.apache.xmlbeans.xml.stream.XMLInputStream newValidatingXMLInputStream(org.apache.xmlbeans.xml.stream.XMLInputStream xis) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newValidatingXMLInputStream( xis, type, null ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static org.apache.xmlbeans.xml.stream.XMLInputStream newValidatingXMLInputStream(org.apache.xmlbeans.xml.stream.XMLInputStream xis, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newValidatingXMLInputStream( xis, type, options ); }
        
        private Factory() { } // No instance of this class allowed
    }
}
