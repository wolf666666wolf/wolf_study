/*
 * An XML document type.
 * Localname: addressLine2
 * Namespace: 
 * Java type: com.study.open.xmlbean.person.AddressLine2Document
 *
 * Automatically generated - do not modify.
 */
package com.study.open.xmlbean.person;


/**
 * A document containing one addressLine2(@) element.
 *
 * This is a complex type.
 */
public interface AddressLine2Document extends org.apache.xmlbeans.XmlObject
{
    public static final org.apache.xmlbeans.SchemaType type = (org.apache.xmlbeans.SchemaType)
        org.apache.xmlbeans.XmlBeans.typeSystemForClassLoader(AddressLine2Document.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.s316E62E84601EC4291FF44E979524A19").resolveHandle("addressline23623doctype");
    
    /**
     * Gets the "addressLine2" element
     */
    com.study.open.xmlbean.person.AddressLine2Document.AddressLine2.Enum getAddressLine2();
    
    /**
     * Gets (as xml) the "addressLine2" element
     */
    com.study.open.xmlbean.person.AddressLine2Document.AddressLine2 xgetAddressLine2();
    
    /**
     * Sets the "addressLine2" element
     */
    void setAddressLine2(com.study.open.xmlbean.person.AddressLine2Document.AddressLine2.Enum addressLine2);
    
    /**
     * Sets (as xml) the "addressLine2" element
     */
    void xsetAddressLine2(com.study.open.xmlbean.person.AddressLine2Document.AddressLine2 addressLine2);
    
    /**
     * An XML addressLine2(@).
     *
     * This is an atomic type that is a restriction of com.study.open.xmlbean.person.AddressLine2Document$AddressLine2.
     */
    public interface AddressLine2 extends org.apache.xmlbeans.XmlString
    {
        public static final org.apache.xmlbeans.SchemaType type = (org.apache.xmlbeans.SchemaType)
            org.apache.xmlbeans.XmlBeans.typeSystemForClassLoader(AddressLine2.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.s316E62E84601EC4291FF44E979524A19").resolveHandle("addressline239adelemtype");
        
        org.apache.xmlbeans.StringEnumAbstractBase enumValue();
        void set(org.apache.xmlbeans.StringEnumAbstractBase e);
        
        static final Enum NORTH_TOWER_HARBOUR_CITY = Enum.forString("NORTH TOWER HARBOUR CITY");
        static final Enum SHINSAYAMA_2_CHOME = Enum.forString("SHINSAYAMA 2-CHOME");
        static final Enum TIMA_ROAD = Enum.forString("Tima Road");
        
        static final int INT_NORTH_TOWER_HARBOUR_CITY = Enum.INT_NORTH_TOWER_HARBOUR_CITY;
        static final int INT_SHINSAYAMA_2_CHOME = Enum.INT_SHINSAYAMA_2_CHOME;
        static final int INT_TIMA_ROAD = Enum.INT_TIMA_ROAD;
        
        /**
         * Enumeration value class for com.study.open.xmlbean.person.AddressLine2Document$AddressLine2.
         * These enum values can be used as follows:
         * <pre>
         * enum.toString(); // returns the string value of the enum
         * enum.intValue(); // returns an int value, useful for switches
         * // e.g., case Enum.INT_NORTH_TOWER_HARBOUR_CITY
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
            
            static final int INT_NORTH_TOWER_HARBOUR_CITY = 1;
            static final int INT_SHINSAYAMA_2_CHOME = 2;
            static final int INT_TIMA_ROAD = 3;
            
            public static final org.apache.xmlbeans.StringEnumAbstractBase.Table table =
                new org.apache.xmlbeans.StringEnumAbstractBase.Table
            (
                new Enum[]
                {
                    new Enum("NORTH TOWER HARBOUR CITY", INT_NORTH_TOWER_HARBOUR_CITY),
                    new Enum("SHINSAYAMA 2-CHOME", INT_SHINSAYAMA_2_CHOME),
                    new Enum("Tima Road", INT_TIMA_ROAD),
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
            public static com.study.open.xmlbean.person.AddressLine2Document.AddressLine2 newValue(java.lang.Object obj) {
              return (com.study.open.xmlbean.person.AddressLine2Document.AddressLine2) type.newValue( obj ); }
            
            public static com.study.open.xmlbean.person.AddressLine2Document.AddressLine2 newInstance() {
              return (com.study.open.xmlbean.person.AddressLine2Document.AddressLine2) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, null ); }
            
            public static com.study.open.xmlbean.person.AddressLine2Document.AddressLine2 newInstance(org.apache.xmlbeans.XmlOptions options) {
              return (com.study.open.xmlbean.person.AddressLine2Document.AddressLine2) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, options ); }
            
            private Factory() { } // No instance of this class allowed
        }
    }
    
    /**
     * A factory class with static methods for creating instances
     * of this type.
     */
    
    public static final class Factory
    {
        public static com.study.open.xmlbean.person.AddressLine2Document newInstance() {
          return (com.study.open.xmlbean.person.AddressLine2Document) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, null ); }
        
        public static com.study.open.xmlbean.person.AddressLine2Document newInstance(org.apache.xmlbeans.XmlOptions options) {
          return (com.study.open.xmlbean.person.AddressLine2Document) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, options ); }
        
        /** @param xmlAsString the string value to parse */
        public static com.study.open.xmlbean.person.AddressLine2Document parse(java.lang.String xmlAsString) throws org.apache.xmlbeans.XmlException {
          return (com.study.open.xmlbean.person.AddressLine2Document) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xmlAsString, type, null ); }
        
        public static com.study.open.xmlbean.person.AddressLine2Document parse(java.lang.String xmlAsString, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (com.study.open.xmlbean.person.AddressLine2Document) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xmlAsString, type, options ); }
        
        /** @param file the file from which to load an xml document */
        public static com.study.open.xmlbean.person.AddressLine2Document parse(java.io.File file) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (com.study.open.xmlbean.person.AddressLine2Document) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( file, type, null ); }
        
        public static com.study.open.xmlbean.person.AddressLine2Document parse(java.io.File file, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (com.study.open.xmlbean.person.AddressLine2Document) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( file, type, options ); }
        
        public static com.study.open.xmlbean.person.AddressLine2Document parse(java.net.URL u) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (com.study.open.xmlbean.person.AddressLine2Document) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( u, type, null ); }
        
        public static com.study.open.xmlbean.person.AddressLine2Document parse(java.net.URL u, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (com.study.open.xmlbean.person.AddressLine2Document) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( u, type, options ); }
        
        public static com.study.open.xmlbean.person.AddressLine2Document parse(java.io.InputStream is) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (com.study.open.xmlbean.person.AddressLine2Document) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( is, type, null ); }
        
        public static com.study.open.xmlbean.person.AddressLine2Document parse(java.io.InputStream is, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (com.study.open.xmlbean.person.AddressLine2Document) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( is, type, options ); }
        
        public static com.study.open.xmlbean.person.AddressLine2Document parse(java.io.Reader r) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (com.study.open.xmlbean.person.AddressLine2Document) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( r, type, null ); }
        
        public static com.study.open.xmlbean.person.AddressLine2Document parse(java.io.Reader r, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (com.study.open.xmlbean.person.AddressLine2Document) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( r, type, options ); }
        
        public static com.study.open.xmlbean.person.AddressLine2Document parse(javax.xml.stream.XMLStreamReader sr) throws org.apache.xmlbeans.XmlException {
          return (com.study.open.xmlbean.person.AddressLine2Document) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( sr, type, null ); }
        
        public static com.study.open.xmlbean.person.AddressLine2Document parse(javax.xml.stream.XMLStreamReader sr, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (com.study.open.xmlbean.person.AddressLine2Document) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( sr, type, options ); }
        
        public static com.study.open.xmlbean.person.AddressLine2Document parse(org.w3c.dom.Node node) throws org.apache.xmlbeans.XmlException {
          return (com.study.open.xmlbean.person.AddressLine2Document) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( node, type, null ); }
        
        public static com.study.open.xmlbean.person.AddressLine2Document parse(org.w3c.dom.Node node, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (com.study.open.xmlbean.person.AddressLine2Document) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( node, type, options ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static com.study.open.xmlbean.person.AddressLine2Document parse(org.apache.xmlbeans.xml.stream.XMLInputStream xis) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return (com.study.open.xmlbean.person.AddressLine2Document) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xis, type, null ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static com.study.open.xmlbean.person.AddressLine2Document parse(org.apache.xmlbeans.xml.stream.XMLInputStream xis, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return (com.study.open.xmlbean.person.AddressLine2Document) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xis, type, options ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static org.apache.xmlbeans.xml.stream.XMLInputStream newValidatingXMLInputStream(org.apache.xmlbeans.xml.stream.XMLInputStream xis) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newValidatingXMLInputStream( xis, type, null ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static org.apache.xmlbeans.xml.stream.XMLInputStream newValidatingXMLInputStream(org.apache.xmlbeans.xml.stream.XMLInputStream xis, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newValidatingXMLInputStream( xis, type, options ); }
        
        private Factory() { } // No instance of this class allowed
    }
}
