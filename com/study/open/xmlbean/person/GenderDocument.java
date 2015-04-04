/*
 * An XML document type.
 * Localname: gender
 * Namespace: 
 * Java type: com.study.open.xmlbean.person.GenderDocument
 *
 * Automatically generated - do not modify.
 */
package com.study.open.xmlbean.person;


/**
 * A document containing one gender(@) element.
 *
 * This is a complex type.
 */
public interface GenderDocument extends org.apache.xmlbeans.XmlObject
{
    public static final org.apache.xmlbeans.SchemaType type = (org.apache.xmlbeans.SchemaType)
        org.apache.xmlbeans.XmlBeans.typeSystemForClassLoader(GenderDocument.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.s105DB67ABAF7458D481DE4B55B9D43EA").resolveHandle("genderfc7adoctype");
    
    /**
     * Gets the "gender" element
     */
    com.study.open.xmlbean.person.GenderDocument.Gender.Enum getGender();
    
    /**
     * Gets (as xml) the "gender" element
     */
    com.study.open.xmlbean.person.GenderDocument.Gender xgetGender();
    
    /**
     * Sets the "gender" element
     */
    void setGender(com.study.open.xmlbean.person.GenderDocument.Gender.Enum gender);
    
    /**
     * Sets (as xml) the "gender" element
     */
    void xsetGender(com.study.open.xmlbean.person.GenderDocument.Gender gender);
    
    /**
     * An XML gender(@).
     *
     * This is an atomic type that is a restriction of com.study.open.xmlbean.person.GenderDocument$Gender.
     */
    public interface Gender extends org.apache.xmlbeans.XmlString
    {
        public static final org.apache.xmlbeans.SchemaType type = (org.apache.xmlbeans.SchemaType)
            org.apache.xmlbeans.XmlBeans.typeSystemForClassLoader(Gender.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.s105DB67ABAF7458D481DE4B55B9D43EA").resolveHandle("genderebcdelemtype");
        
        org.apache.xmlbeans.StringEnumAbstractBase enumValue();
        void set(org.apache.xmlbeans.StringEnumAbstractBase e);
        
        static final Enum MALE = Enum.forString("male");
        static final Enum FEMALE = Enum.forString("female");
        static final Enum TAIJIAN = Enum.forString("taijian");
        static final Enum RENYAO = Enum.forString("renyao");
        
        static final int INT_MALE = Enum.INT_MALE;
        static final int INT_FEMALE = Enum.INT_FEMALE;
        static final int INT_TAIJIAN = Enum.INT_TAIJIAN;
        static final int INT_RENYAO = Enum.INT_RENYAO;
        
        /**
         * Enumeration value class for com.study.open.xmlbean.person.GenderDocument$Gender.
         * These enum values can be used as follows:
         * <pre>
         * enum.toString(); // returns the string value of the enum
         * enum.intValue(); // returns an int value, useful for switches
         * // e.g., case Enum.INT_MALE
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
            
            static final int INT_MALE = 1;
            static final int INT_FEMALE = 2;
            static final int INT_TAIJIAN = 3;
            static final int INT_RENYAO = 4;
            
            public static final org.apache.xmlbeans.StringEnumAbstractBase.Table table =
                new org.apache.xmlbeans.StringEnumAbstractBase.Table
            (
                new Enum[]
                {
                    new Enum("male", INT_MALE),
                    new Enum("female", INT_FEMALE),
                    new Enum("taijian", INT_TAIJIAN),
                    new Enum("renyao", INT_RENYAO),
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
            public static com.study.open.xmlbean.person.GenderDocument.Gender newValue(java.lang.Object obj) {
              return (com.study.open.xmlbean.person.GenderDocument.Gender) type.newValue( obj ); }
            
            public static com.study.open.xmlbean.person.GenderDocument.Gender newInstance() {
              return (com.study.open.xmlbean.person.GenderDocument.Gender) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, null ); }
            
            public static com.study.open.xmlbean.person.GenderDocument.Gender newInstance(org.apache.xmlbeans.XmlOptions options) {
              return (com.study.open.xmlbean.person.GenderDocument.Gender) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, options ); }
            
            private Factory() { } // No instance of this class allowed
        }
    }
    
    /**
     * A factory class with static methods for creating instances
     * of this type.
     */
    
    public static final class Factory
    {
        public static com.study.open.xmlbean.person.GenderDocument newInstance() {
          return (com.study.open.xmlbean.person.GenderDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, null ); }
        
        public static com.study.open.xmlbean.person.GenderDocument newInstance(org.apache.xmlbeans.XmlOptions options) {
          return (com.study.open.xmlbean.person.GenderDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, options ); }
        
        /** @param xmlAsString the string value to parse */
        public static com.study.open.xmlbean.person.GenderDocument parse(java.lang.String xmlAsString) throws org.apache.xmlbeans.XmlException {
          return (com.study.open.xmlbean.person.GenderDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xmlAsString, type, null ); }
        
        public static com.study.open.xmlbean.person.GenderDocument parse(java.lang.String xmlAsString, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (com.study.open.xmlbean.person.GenderDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xmlAsString, type, options ); }
        
        /** @param file the file from which to load an xml document */
        public static com.study.open.xmlbean.person.GenderDocument parse(java.io.File file) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (com.study.open.xmlbean.person.GenderDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( file, type, null ); }
        
        public static com.study.open.xmlbean.person.GenderDocument parse(java.io.File file, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (com.study.open.xmlbean.person.GenderDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( file, type, options ); }
        
        public static com.study.open.xmlbean.person.GenderDocument parse(java.net.URL u) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (com.study.open.xmlbean.person.GenderDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( u, type, null ); }
        
        public static com.study.open.xmlbean.person.GenderDocument parse(java.net.URL u, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (com.study.open.xmlbean.person.GenderDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( u, type, options ); }
        
        public static com.study.open.xmlbean.person.GenderDocument parse(java.io.InputStream is) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (com.study.open.xmlbean.person.GenderDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( is, type, null ); }
        
        public static com.study.open.xmlbean.person.GenderDocument parse(java.io.InputStream is, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (com.study.open.xmlbean.person.GenderDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( is, type, options ); }
        
        public static com.study.open.xmlbean.person.GenderDocument parse(java.io.Reader r) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (com.study.open.xmlbean.person.GenderDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( r, type, null ); }
        
        public static com.study.open.xmlbean.person.GenderDocument parse(java.io.Reader r, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (com.study.open.xmlbean.person.GenderDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( r, type, options ); }
        
        public static com.study.open.xmlbean.person.GenderDocument parse(javax.xml.stream.XMLStreamReader sr) throws org.apache.xmlbeans.XmlException {
          return (com.study.open.xmlbean.person.GenderDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( sr, type, null ); }
        
        public static com.study.open.xmlbean.person.GenderDocument parse(javax.xml.stream.XMLStreamReader sr, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (com.study.open.xmlbean.person.GenderDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( sr, type, options ); }
        
        public static com.study.open.xmlbean.person.GenderDocument parse(org.w3c.dom.Node node) throws org.apache.xmlbeans.XmlException {
          return (com.study.open.xmlbean.person.GenderDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( node, type, null ); }
        
        public static com.study.open.xmlbean.person.GenderDocument parse(org.w3c.dom.Node node, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (com.study.open.xmlbean.person.GenderDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( node, type, options ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static com.study.open.xmlbean.person.GenderDocument parse(org.apache.xmlbeans.xml.stream.XMLInputStream xis) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return (com.study.open.xmlbean.person.GenderDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xis, type, null ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static com.study.open.xmlbean.person.GenderDocument parse(org.apache.xmlbeans.xml.stream.XMLInputStream xis, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return (com.study.open.xmlbean.person.GenderDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xis, type, options ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static org.apache.xmlbeans.xml.stream.XMLInputStream newValidatingXMLInputStream(org.apache.xmlbeans.xml.stream.XMLInputStream xis) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newValidatingXMLInputStream( xis, type, null ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static org.apache.xmlbeans.xml.stream.XMLInputStream newValidatingXMLInputStream(org.apache.xmlbeans.xml.stream.XMLInputStream xis, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newValidatingXMLInputStream( xis, type, options ); }
        
        private Factory() { } // No instance of this class allowed
    }
}
