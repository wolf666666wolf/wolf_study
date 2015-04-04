/*
 * An XML document type.
 * Localname: addressLine1
 * Namespace: 
 * Java type: com.study.open.xmlbean.person.AddressLine1Document
 *
 * Automatically generated - do not modify.
 */
package com.study.open.xmlbean.person;


/**
 * A document containing one addressLine1(@) element.
 *
 * This is a complex type.
 */
public interface AddressLine1Document extends org.apache.xmlbeans.XmlObject
{
    public static final org.apache.xmlbeans.SchemaType type = (org.apache.xmlbeans.SchemaType)
        org.apache.xmlbeans.XmlBeans.typeSystemForClassLoader(AddressLine1Document.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.s316E62E84601EC4291FF44E979524A19").resolveHandle("addressline13622doctype");
    
    /**
     * Gets the "addressLine1" element
     */
    com.study.open.xmlbean.person.AddressLine1Document.AddressLine1.Enum getAddressLine1();
    
    /**
     * Gets (as xml) the "addressLine1" element
     */
    com.study.open.xmlbean.person.AddressLine1Document.AddressLine1 xgetAddressLine1();
    
    /**
     * Sets the "addressLine1" element
     */
    void setAddressLine1(com.study.open.xmlbean.person.AddressLine1Document.AddressLine1.Enum addressLine1);
    
    /**
     * Sets (as xml) the "addressLine1" element
     */
    void xsetAddressLine1(com.study.open.xmlbean.person.AddressLine1Document.AddressLine1 addressLine1);
    
    /**
     * An XML addressLine1(@).
     *
     * This is an atomic type that is a restriction of com.study.open.xmlbean.person.AddressLine1Document$AddressLine1.
     */
    public interface AddressLine1 extends org.apache.xmlbeans.XmlString
    {
        public static final org.apache.xmlbeans.SchemaType type = (org.apache.xmlbeans.SchemaType)
            org.apache.xmlbeans.XmlBeans.typeSystemForClassLoader(AddressLine1.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.s316E62E84601EC4291FF44E979524A19").resolveHandle("addressline15bcdelemtype");
        
        org.apache.xmlbeans.StringEnumAbstractBase enumValue();
        void set(org.apache.xmlbeans.StringEnumAbstractBase e);
        
        static final Enum X_167 = Enum.forString("#167");
        static final Enum X_25_1 = Enum.forString("#25-1");
        static final Enum X_1033_WS_ST = Enum.forString("1033 WS St.");
        
        static final int INT_X_167 = Enum.INT_X_167;
        static final int INT_X_25_1 = Enum.INT_X_25_1;
        static final int INT_X_1033_WS_ST = Enum.INT_X_1033_WS_ST;
        
        /**
         * Enumeration value class for com.study.open.xmlbean.person.AddressLine1Document$AddressLine1.
         * These enum values can be used as follows:
         * <pre>
         * enum.toString(); // returns the string value of the enum
         * enum.intValue(); // returns an int value, useful for switches
         * // e.g., case Enum.INT_X_167
         * Enum.forString(s); // returns the enum value for a string
         * Enum.forInt(i); // returns the enum value for an int
         * </pre>
         * Enumeration objects are immutable singleton objects that
         * can be compared using == object equality. They have no
         * public constructor. See the constants defined within this
         * class for all the valid values.
         */
        static final class Enum extends org.apache.xmlbeans.StringEnumAbstractBase
        {
            /**
             * Returns the enum value for a string, or null if none.
             */
            public static Enum forString(java.lang.String s)
                { return (Enum)table.forString(s); }
            /**
             * Returns the enum value corresponding to an int, or null if none.
             */
            public static Enum forInt(int i)
                { return (Enum)table.forInt(i); }
            
            private Enum(java.lang.String s, int i)
                { super(s, i); }
            
            static final int INT_X_167 = 1;
            static final int INT_X_25_1 = 2;
            static final int INT_X_1033_WS_ST = 3;
            
            public static final org.apache.xmlbeans.StringEnumAbstractBase.Table table =
                new org.apache.xmlbeans.StringEnumAbstractBase.Table
            (
                new Enum[]
                {
                    new Enum("#167", INT_X_167),
                    new Enum("#25-1", INT_X_25_1),
                    new Enum("1033 WS St.", INT_X_1033_WS_ST),
                }
            );
            private static final long serialVersionUID = 1L;
            private java.lang.Object readResolve() { return forInt(intValue()); } 
        }
        
        /**
         * A factory class with static methods for creating instances
         * of this type.
         */
        
        public static final class Factory
        {
            public static com.study.open.xmlbean.person.AddressLine1Document.AddressLine1 newValue(java.lang.Object obj) {
              return (com.study.open.xmlbean.person.AddressLine1Document.AddressLine1) type.newValue( obj ); }
            
            public static com.study.open.xmlbean.person.AddressLine1Document.AddressLine1 newInstance() {
              return (com.study.open.xmlbean.person.AddressLine1Document.AddressLine1) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, null ); }
            
            public static com.study.open.xmlbean.person.AddressLine1Document.AddressLine1 newInstance(org.apache.xmlbeans.XmlOptions options) {
              return (com.study.open.xmlbean.person.AddressLine1Document.AddressLine1) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, options ); }
            
            private Factory() { } // No instance of this class allowed
        }
    }
    
    /**
     * A factory class with static methods for creating instances
     * of this type.
     */
    
    public static final class Factory
    {
        public static com.study.open.xmlbean.person.AddressLine1Document newInstance() {
          return (com.study.open.xmlbean.person.AddressLine1Document) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, null ); }
        
        public static com.study.open.xmlbean.person.AddressLine1Document newInstance(org.apache.xmlbeans.XmlOptions options) {
          return (com.study.open.xmlbean.person.AddressLine1Document) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, options ); }
        
        /** @param xmlAsString the string value to parse */
        public static com.study.open.xmlbean.person.AddressLine1Document parse(java.lang.String xmlAsString) throws org.apache.xmlbeans.XmlException {
          return (com.study.open.xmlbean.person.AddressLine1Document) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xmlAsString, type, null ); }
        
        public static com.study.open.xmlbean.person.AddressLine1Document parse(java.lang.String xmlAsString, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (com.study.open.xmlbean.person.AddressLine1Document) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xmlAsString, type, options ); }
        
        /** @param file the file from which to load an xml document */
        public static com.study.open.xmlbean.person.AddressLine1Document parse(java.io.File file) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (com.study.open.xmlbean.person.AddressLine1Document) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( file, type, null ); }
        
        public static com.study.open.xmlbean.person.AddressLine1Document parse(java.io.File file, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (com.study.open.xmlbean.person.AddressLine1Document) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( file, type, options ); }
        
        public static com.study.open.xmlbean.person.AddressLine1Document parse(java.net.URL u) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (com.study.open.xmlbean.person.AddressLine1Document) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( u, type, null ); }
        
        public static com.study.open.xmlbean.person.AddressLine1Document parse(java.net.URL u, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (com.study.open.xmlbean.person.AddressLine1Document) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( u, type, options ); }
        
        public static com.study.open.xmlbean.person.AddressLine1Document parse(java.io.InputStream is) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (com.study.open.xmlbean.person.AddressLine1Document) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( is, type, null ); }
        
        public static com.study.open.xmlbean.person.AddressLine1Document parse(java.io.InputStream is, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (com.study.open.xmlbean.person.AddressLine1Document) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( is, type, options ); }
        
        public static com.study.open.xmlbean.person.AddressLine1Document parse(java.io.Reader r) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (com.study.open.xmlbean.person.AddressLine1Document) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( r, type, null ); }
        
        public static com.study.open.xmlbean.person.AddressLine1Document parse(java.io.Reader r, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (com.study.open.xmlbean.person.AddressLine1Document) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( r, type, options ); }
        
        public static com.study.open.xmlbean.person.AddressLine1Document parse(javax.xml.stream.XMLStreamReader sr) throws org.apache.xmlbeans.XmlException {
          return (com.study.open.xmlbean.person.AddressLine1Document) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( sr, type, null ); }
        
        public static com.study.open.xmlbean.person.AddressLine1Document parse(javax.xml.stream.XMLStreamReader sr, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (com.study.open.xmlbean.person.AddressLine1Document) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( sr, type, options ); }
        
        public static com.study.open.xmlbean.person.AddressLine1Document parse(org.w3c.dom.Node node) throws org.apache.xmlbeans.XmlException {
          return (com.study.open.xmlbean.person.AddressLine1Document) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( node, type, null ); }
        
        public static com.study.open.xmlbean.person.AddressLine1Document parse(org.w3c.dom.Node node, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (com.study.open.xmlbean.person.AddressLine1Document) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( node, type, options ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static com.study.open.xmlbean.person.AddressLine1Document parse(org.apache.xmlbeans.xml.stream.XMLInputStream xis) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return (com.study.open.xmlbean.person.AddressLine1Document) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xis, type, null ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static com.study.open.xmlbean.person.AddressLine1Document parse(org.apache.xmlbeans.xml.stream.XMLInputStream xis, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return (com.study.open.xmlbean.person.AddressLine1Document) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xis, type, options ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static org.apache.xmlbeans.xml.stream.XMLInputStream newValidatingXMLInputStream(org.apache.xmlbeans.xml.stream.XMLInputStream xis) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newValidatingXMLInputStream( xis, type, null ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static org.apache.xmlbeans.xml.stream.XMLInputStream newValidatingXMLInputStream(org.apache.xmlbeans.xml.stream.XMLInputStream xis, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newValidatingXMLInputStream( xis, type, options ); }
        
        private Factory() { } // No instance of this class allowed
    }
}
