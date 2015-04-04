/*
 * An XML document type.
 * Localname: phoneNumber
 * Namespace: 
 * Java type: com.study.open.xmlbean.person.PhoneNumberDocument
 *
 * Automatically generated - do not modify.
 */
package com.study.open.xmlbean.person;


/**
 * A document containing one phoneNumber(@) element.
 *
 * This is a complex type.
 */
public interface PhoneNumberDocument extends org.apache.xmlbeans.XmlObject
{
    public static final org.apache.xmlbeans.SchemaType type = (org.apache.xmlbeans.SchemaType)
        org.apache.xmlbeans.XmlBeans.typeSystemForClassLoader(PhoneNumberDocument.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.s316E62E84601EC4291FF44E979524A19").resolveHandle("phonenumberdc3edoctype");
    
    /**
     * Gets the "phoneNumber" element
     */
    int getPhoneNumber();
    
    /**
     * Gets (as xml) the "phoneNumber" element
     */
    com.study.open.xmlbean.person.PhoneNumberDocument.PhoneNumber xgetPhoneNumber();
    
    /**
     * Sets the "phoneNumber" element
     */
    void setPhoneNumber(int phoneNumber);
    
    /**
     * Sets (as xml) the "phoneNumber" element
     */
    void xsetPhoneNumber(com.study.open.xmlbean.person.PhoneNumberDocument.PhoneNumber phoneNumber);
    
    /**
     * An XML phoneNumber(@).
     *
     * This is an atomic type that is a restriction of com.study.open.xmlbean.person.PhoneNumberDocument$PhoneNumber.
     */
    public interface PhoneNumber extends org.apache.xmlbeans.XmlInt
    {
        public static final org.apache.xmlbeans.SchemaType type = (org.apache.xmlbeans.SchemaType)
            org.apache.xmlbeans.XmlBeans.typeSystemForClassLoader(PhoneNumber.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.s316E62E84601EC4291FF44E979524A19").resolveHandle("phonenumber39d1elemtype");
        
        /**
         * A factory class with static methods for creating instances
         * of this type.
         */
        
        public static final class Factory
        {
            public static com.study.open.xmlbean.person.PhoneNumberDocument.PhoneNumber newValue(java.lang.Object obj) {
              return (com.study.open.xmlbean.person.PhoneNumberDocument.PhoneNumber) type.newValue( obj ); }
            
            public static com.study.open.xmlbean.person.PhoneNumberDocument.PhoneNumber newInstance() {
              return (com.study.open.xmlbean.person.PhoneNumberDocument.PhoneNumber) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, null ); }
            
            public static com.study.open.xmlbean.person.PhoneNumberDocument.PhoneNumber newInstance(org.apache.xmlbeans.XmlOptions options) {
              return (com.study.open.xmlbean.person.PhoneNumberDocument.PhoneNumber) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, options ); }
            
            private Factory() { } // No instance of this class allowed
        }
    }
    
    /**
     * A factory class with static methods for creating instances
     * of this type.
     */
    
    public static final class Factory
    {
        public static com.study.open.xmlbean.person.PhoneNumberDocument newInstance() {
          return (com.study.open.xmlbean.person.PhoneNumberDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, null ); }
        
        public static com.study.open.xmlbean.person.PhoneNumberDocument newInstance(org.apache.xmlbeans.XmlOptions options) {
          return (com.study.open.xmlbean.person.PhoneNumberDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, options ); }
        
        /** @param xmlAsString the string value to parse */
        public static com.study.open.xmlbean.person.PhoneNumberDocument parse(java.lang.String xmlAsString) throws org.apache.xmlbeans.XmlException {
          return (com.study.open.xmlbean.person.PhoneNumberDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xmlAsString, type, null ); }
        
        public static com.study.open.xmlbean.person.PhoneNumberDocument parse(java.lang.String xmlAsString, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (com.study.open.xmlbean.person.PhoneNumberDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xmlAsString, type, options ); }
        
        /** @param file the file from which to load an xml document */
        public static com.study.open.xmlbean.person.PhoneNumberDocument parse(java.io.File file) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (com.study.open.xmlbean.person.PhoneNumberDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( file, type, null ); }
        
        public static com.study.open.xmlbean.person.PhoneNumberDocument parse(java.io.File file, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (com.study.open.xmlbean.person.PhoneNumberDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( file, type, options ); }
        
        public static com.study.open.xmlbean.person.PhoneNumberDocument parse(java.net.URL u) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (com.study.open.xmlbean.person.PhoneNumberDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( u, type, null ); }
        
        public static com.study.open.xmlbean.person.PhoneNumberDocument parse(java.net.URL u, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (com.study.open.xmlbean.person.PhoneNumberDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( u, type, options ); }
        
        public static com.study.open.xmlbean.person.PhoneNumberDocument parse(java.io.InputStream is) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (com.study.open.xmlbean.person.PhoneNumberDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( is, type, null ); }
        
        public static com.study.open.xmlbean.person.PhoneNumberDocument parse(java.io.InputStream is, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (com.study.open.xmlbean.person.PhoneNumberDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( is, type, options ); }
        
        public static com.study.open.xmlbean.person.PhoneNumberDocument parse(java.io.Reader r) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (com.study.open.xmlbean.person.PhoneNumberDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( r, type, null ); }
        
        public static com.study.open.xmlbean.person.PhoneNumberDocument parse(java.io.Reader r, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (com.study.open.xmlbean.person.PhoneNumberDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( r, type, options ); }
        
        public static com.study.open.xmlbean.person.PhoneNumberDocument parse(javax.xml.stream.XMLStreamReader sr) throws org.apache.xmlbeans.XmlException {
          return (com.study.open.xmlbean.person.PhoneNumberDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( sr, type, null ); }
        
        public static com.study.open.xmlbean.person.PhoneNumberDocument parse(javax.xml.stream.XMLStreamReader sr, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (com.study.open.xmlbean.person.PhoneNumberDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( sr, type, options ); }
        
        public static com.study.open.xmlbean.person.PhoneNumberDocument parse(org.w3c.dom.Node node) throws org.apache.xmlbeans.XmlException {
          return (com.study.open.xmlbean.person.PhoneNumberDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( node, type, null ); }
        
        public static com.study.open.xmlbean.person.PhoneNumberDocument parse(org.w3c.dom.Node node, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (com.study.open.xmlbean.person.PhoneNumberDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( node, type, options ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static com.study.open.xmlbean.person.PhoneNumberDocument parse(org.apache.xmlbeans.xml.stream.XMLInputStream xis) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return (com.study.open.xmlbean.person.PhoneNumberDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xis, type, null ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static com.study.open.xmlbean.person.PhoneNumberDocument parse(org.apache.xmlbeans.xml.stream.XMLInputStream xis, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return (com.study.open.xmlbean.person.PhoneNumberDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xis, type, options ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static org.apache.xmlbeans.xml.stream.XMLInputStream newValidatingXMLInputStream(org.apache.xmlbeans.xml.stream.XMLInputStream xis) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newValidatingXMLInputStream( xis, type, null ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static org.apache.xmlbeans.xml.stream.XMLInputStream newValidatingXMLInputStream(org.apache.xmlbeans.xml.stream.XMLInputStream xis, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newValidatingXMLInputStream( xis, type, options ); }
        
        private Factory() { } // No instance of this class allowed
    }
}
