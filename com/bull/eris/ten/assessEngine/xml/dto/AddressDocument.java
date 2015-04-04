/*
 * An XML document type.
 * Localname: address
 * Namespace: 
 * Java type: com.bull.eris.ten.assessEngine.xml.dto.AddressDocument
 *
 * Automatically generated - do not modify.
 */
package com.bull.eris.ten.assessEngine.xml.dto;


/**
 * A document containing one address(@) element.
 *
 * This is a complex type.
 */
public interface AddressDocument extends org.apache.xmlbeans.XmlObject
{
    public static final org.apache.xmlbeans.SchemaType type = (org.apache.xmlbeans.SchemaType)
        org.apache.xmlbeans.XmlBeans.typeSystemForClassLoader(AddressDocument.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.s105DB67ABAF7458D481DE4B55B9D43EA").resolveHandle("addressc95bdoctype");
    
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
     * An XML address(@).
     *
     * This is a complex type.
     */
    public interface Address extends org.apache.xmlbeans.XmlObject
    {
        public static final org.apache.xmlbeans.SchemaType type = (org.apache.xmlbeans.SchemaType)
            org.apache.xmlbeans.XmlBeans.typeSystemForClassLoader(Address.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.s105DB67ABAF7458D481DE4B55B9D43EA").resolveHandle("address25cbelemtype");
        
        /**
         * Gets the "primaryAddress" element
         */
        com.bull.eris.ten.assessEngine.xml.dto.PrimaryAddressDocument.PrimaryAddress getPrimaryAddress();
        
        /**
         * Sets the "primaryAddress" element
         */
        void setPrimaryAddress(com.bull.eris.ten.assessEngine.xml.dto.PrimaryAddressDocument.PrimaryAddress primaryAddress);
        
        /**
         * Appends and returns a new empty "primaryAddress" element
         */
        com.bull.eris.ten.assessEngine.xml.dto.PrimaryAddressDocument.PrimaryAddress addNewPrimaryAddress();
        
        /**
         * Gets the "billingAddress" element
         */
        com.bull.eris.ten.assessEngine.xml.dto.BillingAddressDocument.BillingAddress getBillingAddress();
        
        /**
         * Sets the "billingAddress" element
         */
        void setBillingAddress(com.bull.eris.ten.assessEngine.xml.dto.BillingAddressDocument.BillingAddress billingAddress);
        
        /**
         * Appends and returns a new empty "billingAddress" element
         */
        com.bull.eris.ten.assessEngine.xml.dto.BillingAddressDocument.BillingAddress addNewBillingAddress();
        
        /**
         * A factory class with static methods for creating instances
         * of this type.
         */
        
        public static final class Factory
        {
            public static com.bull.eris.ten.assessEngine.xml.dto.AddressDocument.Address newInstance() {
              return (com.bull.eris.ten.assessEngine.xml.dto.AddressDocument.Address) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, null ); }
            
            public static com.bull.eris.ten.assessEngine.xml.dto.AddressDocument.Address newInstance(org.apache.xmlbeans.XmlOptions options) {
              return (com.bull.eris.ten.assessEngine.xml.dto.AddressDocument.Address) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, options ); }
            
            private Factory() { } // No instance of this class allowed
        }
    }
    
    /**
     * A factory class with static methods for creating instances
     * of this type.
     */
    
    public static final class Factory
    {
        public static com.bull.eris.ten.assessEngine.xml.dto.AddressDocument newInstance() {
          return (com.bull.eris.ten.assessEngine.xml.dto.AddressDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, null ); }
        
        public static com.bull.eris.ten.assessEngine.xml.dto.AddressDocument newInstance(org.apache.xmlbeans.XmlOptions options) {
          return (com.bull.eris.ten.assessEngine.xml.dto.AddressDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, options ); }
        
        /** @param xmlAsString the string value to parse */
        public static com.bull.eris.ten.assessEngine.xml.dto.AddressDocument parse(java.lang.String xmlAsString) throws org.apache.xmlbeans.XmlException {
          return (com.bull.eris.ten.assessEngine.xml.dto.AddressDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xmlAsString, type, null ); }
        
        public static com.bull.eris.ten.assessEngine.xml.dto.AddressDocument parse(java.lang.String xmlAsString, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (com.bull.eris.ten.assessEngine.xml.dto.AddressDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xmlAsString, type, options ); }
        
        /** @param file the file from which to load an xml document */
        public static com.bull.eris.ten.assessEngine.xml.dto.AddressDocument parse(java.io.File file) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (com.bull.eris.ten.assessEngine.xml.dto.AddressDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( file, type, null ); }
        
        public static com.bull.eris.ten.assessEngine.xml.dto.AddressDocument parse(java.io.File file, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (com.bull.eris.ten.assessEngine.xml.dto.AddressDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( file, type, options ); }
        
        public static com.bull.eris.ten.assessEngine.xml.dto.AddressDocument parse(java.net.URL u) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (com.bull.eris.ten.assessEngine.xml.dto.AddressDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( u, type, null ); }
        
        public static com.bull.eris.ten.assessEngine.xml.dto.AddressDocument parse(java.net.URL u, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (com.bull.eris.ten.assessEngine.xml.dto.AddressDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( u, type, options ); }
        
        public static com.bull.eris.ten.assessEngine.xml.dto.AddressDocument parse(java.io.InputStream is) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (com.bull.eris.ten.assessEngine.xml.dto.AddressDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( is, type, null ); }
        
        public static com.bull.eris.ten.assessEngine.xml.dto.AddressDocument parse(java.io.InputStream is, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (com.bull.eris.ten.assessEngine.xml.dto.AddressDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( is, type, options ); }
        
        public static com.bull.eris.ten.assessEngine.xml.dto.AddressDocument parse(java.io.Reader r) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (com.bull.eris.ten.assessEngine.xml.dto.AddressDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( r, type, null ); }
        
        public static com.bull.eris.ten.assessEngine.xml.dto.AddressDocument parse(java.io.Reader r, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (com.bull.eris.ten.assessEngine.xml.dto.AddressDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( r, type, options ); }
        
        public static com.bull.eris.ten.assessEngine.xml.dto.AddressDocument parse(javax.xml.stream.XMLStreamReader sr) throws org.apache.xmlbeans.XmlException {
          return (com.bull.eris.ten.assessEngine.xml.dto.AddressDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( sr, type, null ); }
        
        public static com.bull.eris.ten.assessEngine.xml.dto.AddressDocument parse(javax.xml.stream.XMLStreamReader sr, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (com.bull.eris.ten.assessEngine.xml.dto.AddressDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( sr, type, options ); }
        
        public static com.bull.eris.ten.assessEngine.xml.dto.AddressDocument parse(org.w3c.dom.Node node) throws org.apache.xmlbeans.XmlException {
          return (com.bull.eris.ten.assessEngine.xml.dto.AddressDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( node, type, null ); }
        
        public static com.bull.eris.ten.assessEngine.xml.dto.AddressDocument parse(org.w3c.dom.Node node, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (com.bull.eris.ten.assessEngine.xml.dto.AddressDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( node, type, options ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static com.bull.eris.ten.assessEngine.xml.dto.AddressDocument parse(org.apache.xmlbeans.xml.stream.XMLInputStream xis) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return (com.bull.eris.ten.assessEngine.xml.dto.AddressDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xis, type, null ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static com.bull.eris.ten.assessEngine.xml.dto.AddressDocument parse(org.apache.xmlbeans.xml.stream.XMLInputStream xis, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return (com.bull.eris.ten.assessEngine.xml.dto.AddressDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xis, type, options ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static org.apache.xmlbeans.xml.stream.XMLInputStream newValidatingXMLInputStream(org.apache.xmlbeans.xml.stream.XMLInputStream xis) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newValidatingXMLInputStream( xis, type, null ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static org.apache.xmlbeans.xml.stream.XMLInputStream newValidatingXMLInputStream(org.apache.xmlbeans.xml.stream.XMLInputStream xis, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newValidatingXMLInputStream( xis, type, options ); }
        
        private Factory() { } // No instance of this class allowed
    }
}
