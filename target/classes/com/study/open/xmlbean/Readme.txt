cd E:/workspace/wolf-study/study/xmlbeans-2.5.0/bin

generate source
scomp -src E:/workspace/wolf-study/src/main/java -srconly E:/workspace/wolf-study/src/main/java/com/study/open/xmlbean/person.xsd -compiler javac E:/workspace/wolf-study/src/main/java/com/study/open/xmlbean/customer.xsdconfig

generate jar
scomp -src E:/workspace/wolf-study/ -out E:/workspace/wolf-study/person.jar E:/workspace/wolf-study/src/main/java/com/study/open/xmlbean/person.xsd -compiler javac E:/workspace/wolf-study/src/main/java/com/study/open/xmlbean/customer.xsdconfig





1.一、关于XML解析     
2.         
3.    　　XML在Java应用程序里变得越来越重要, 广泛应用于数据存储和交换. 比如我们常见的配置文件,都是以XML方式存储的. XML还应用于Java Message Service和Web Services等技术作为数据交换.因此,正确读写XML文档是XML应用的基础.     
4.         
5.    　　Java提供了SAX和DOM两种方式用于解析XML,但即便如此,要读写一个稍微复杂的XML,也不是一件容易的事.     
6.         
7.    　　二、XMLBean简介     
8.         
9.    　　Hibernate已经成为目前流行的面向Java环境的对象/关系数据库映射工具.在Hibernate等对象/关系数据库映射工具出现之前,对数据库的操作是通过JDBC来实现的,对数据库的任何操作,开发人员都要自己写SQL语句来实现. 对象/关系数据库映射工具出现后,对数据库的操作转成对JavaBean的操作,极大方便了数据库开发. 所以如果有一个类似的工具能够实现将对XML的读写转成对JavaBean的操作,将会简化XML的读写,即使对XML不熟悉的开发人员也能方便地读写XML. 这个工具就是XMLBean.     
10.         
11.    　　三、准备XMLBean和XML文档     
12.         
13.    　　XMLBean是Apache的一个开源项目,可以从http://www.apache.org下载,最新的版本是2.0. 解压后目录如下:     
14.         
15.    xmlbean2.0.0     
16.         +---bin     
17.         +---docs     
18.         +---lib     
19.         +---samples     
20.         +---schemas     
21.         
22.    　　另外还要准备一个XML文档(customers.xml),     
23.         
24.    　　在本文的例子里,我们将对这个文档进行读写操作. 文档源码如下:     
25.         
26.    <?xml version="1.0" encoding="UTF-8"?>     
27.    <Customers>     
28.        <customer>     
29.                <id>1</id>     
30.                <gender>female</gender>     
31.                <firstname>Jessica</firstname>     
32.                <lastname>Lim</lastname>     
33.                <phoneNumber>1234567</phoneNumber>     
34.                <address>     
35.                    <primaryAddress>     
36.                            <postalCode>350106</postalCode>     
37.                            <addressLine1>#25-1</addressLine1>     
38.                            <addressLine2>SHINSAYAMA 2-CHOME</addressLine2>     
39.                    </primaryAddress>     
40.                    <billingAddress>     
41.                            <receiver>Ms Danielle</receiver>     
42.                            <postalCode>350107</postalCode>     
43.                            <addressLine1>#167</addressLine1>     
44.                            <addressLine2>NORTH TOWER HARBOUR CITY</addressLine2>     
45.                    </billingAddress>     
46.                </address>     
47.        </customer>     
48.        <customer>     
49.                <id>2</id>     
50.                <gender>male</gender>     
51.                <firstname>David</firstname>     
52.                <lastname>Bill</lastname>     
53.                <phoneNumber>808182</phoneNumber>     
54.                <address>     
55.                    <primaryAddress>     
56.                            <postalCode>319087</postalCode>     
57.                            <addressLine1>1033 WS St.</addressLine1>     
58.                            <addressLine2>Tima Road</addressLine2>     
59.                    </primaryAddress>     
60.                    <billingAddress>     
61.                            <receiver>Mr William</receiver>     
62.                            <postalCode>672993</postalCode>     
63.                            <addressLine1>1033 WS St.</addressLine1>     
64.                            <addressLine2>Tima Road</addressLine2>     
65.                    </billingAddress>     
66.                </address>     
67.        </customer>     
68.    </Customers>     
69.         
70.    　　这是一个客户的数据模型,每个客户都有客户编号(ID),姓名,性别(gender),电话号码(phoneNumber)和地址,其中地址有两个: 首要地址(PrimaryAddress)和帐单地址(BillingAddress),每个地址有邮编,地址1,和地址2组成.其中帐单地址还有收件人(receiver).此外,还要准备一个配置文件(文件名customer.xsdconfig),这个文件的作用我后面会讲,它的内容如下:     
71.         
72.    <xb:config xmlns:xb="http://xml.apache.org/xmlbeans/2004/02/xbean/config">     
73.         
74.      <xb:namespace>     
75.        <xb:package>sample.xmlbean</xb:package>     
76.      </xb:namespace>     
77.         
78.    </xb:config>     
79.         
80.    　　四、XMLBean使用步骤     
81.         
82.    　　和其他面向Java环境的对象/关系数据库映射工具的使用步骤一样,在正式使用XMLBean前,我们要作两个准备.     
83.         
84.    　　1. 生成XML Schema文件     
85.         
86.    　　什么是XML Schema文件? 正常情况下,每个XML文件都有一个Schema文件,XML Schema文件是一个XML的约束文件,它定义了XML文件的结构和元素.以及对元素和结构的约束. 通俗地讲,如果说XML文件是数据库里的记录,那么Schema就是表结构定义.     
87.         
88.    　　为什么需要这个文件? XMLBean需要通过这个文件知道一个XML文件的结构以及约束,比如数据类型等. 利用这个Schema文件,XMLBean将会产生一系列相关的Java Classes来实现对XML的操作. 而作为开发人员,则是利用XMLBean产生的Java Classes来完成对XML的操作而不需要SAX或DOM.怎样产生这个Schema文件呢? 如果对于熟悉XML的开发人员,可以自己来写这个Schema文件,对于不熟悉XML的开发人员,可以通过一些工具来完成.比较有名的如XMLSPY和Stylus Studio都可以通过XML文件来生成Schema文件. 加入我们已经生成这个Schema文件(customer.xsd):     
89.         
90.           <?xml version="1.0" encoding="UTF-8"?>     
91.           <xs:schema xmlns:xs="http://www.w3.org/2001/XMLSchema"     
92.                      elementFormDefault="qualified">     
93.             <xs:element name="Customers">     
94.               <xs:complexType>     
95.                 <xs:sequence>     
96.                   <xs:element maxOccurs="unbounded" name="customer"     
97.                               type="customerType"/>     
98.                 </xs:sequence>     
99.               </xs:complexType>     
100.             </xs:element>     
101.           <xs:complexType name="customerType">     
102.                 <xs:sequence>     
103.                   <xs:element name="id" type="xs:int"/>     
104.                   <xs:element name="gender" type="xs:string"/>     
105.                   <xs:element name="firstname" type="xs:string"/>     
106.                   <xs:element name="lastname" type="xs:string"/>     
107.                   <xs:element name="phoneNumber" type="xs:string"/>     
108.                   <xs:element name="address" type="addressType"/>     
109.                 </xs:sequence>     
110.           </xs:complexType>     
111.             <xs:complexType name="addressType">     
112.                 <xs:sequence>     
113.                   <xs:element name="primaryAddress" type="primaryAddressType"/>     
114.                   <xs:element name="billingAddress" type="billingAddressType"/>     
115.                 </xs:sequence>     
116.             </xs:complexType>     
117.         
118.       <xs:complexType name="primaryAddressType">     
119.                 <xs:sequence>     
120.                   <xs:element name="postalCode" type="xs:string"/>     
121.                   <xs:element name="addressLine1" type="xs:string"/>     
122.                   <xs:element name="addressLine2" type="xs:string"/>     
123.                 </xs:sequence>     
124.             </xs:complexType>     
125.             <xs:complexType name="billingAddressType">     
126.                 <xs:sequence>     
127.                       <xs:element name="receiver" type="xs:string"/>     
128.                   <xs:element name="postalCode" type="xs:string"/>     
129.                   <xs:element name="addressLine1" type="xs:string"/>     
130.                   <xs:element name="addressLine2" type="xs:string"/>     
131.                 </xs:sequence>     
132.             </xs:complexType>     
133.           </xs:schema>     
134.         
135.    　　2. 利用scomp来生成Java Classes     
136.         
137.    　　scomp是XMLBean提供的一个编译工具,它在bin的目录下. 通过这个工具,我们可以将以上的Schema文件生成Java Classes.scomp的语法如下:-     
138.         
139.    　　scomp [options] [dirs]* [schemaFile.xsd]* [service.wsdl]* [config.xsdconfig]*     
140.         
141.    　　主要参数说明:     
142.         
143.    　　-src [dir] -- 生成的Java Classes存放目录     
144.         
145.    　　-srconly -- 不编译Java Classes,不产生Jar文件     
146.         
147.    　　-out [jarFileName] -- 生成的Jar文件,缺省是xmltypes.jar     
148.         
149.    　　-compiler -- Java编译器的路径,即Javac的位置     
150.         
151.    　　schemaFile.xsd -- XML Schema文件位置     
152.         
153.    　　config.xsdconfig -- xsdconfig文件的位置, 这个文件主要用来制定生成的Java Class的一些文件名规则和Package的名称,在本文,package是sample.xmlbean     
154.         
155.    　　在本文,我是这样运行的:     
156.         
157.          scomp -src build\src  -out build\customerXmlBean.jar schema\customer.xsd     
158.                 -compiler C:\jdk142_04\bin\javac customer.xsdconfig     
159.         
160.    　　这个命令行的意思是告诉scomp生成customerXmlBean.jar,放在build目录下,同时生成源代码放在build\src下, Schema文件是customer.xsd,xsdconfig文件是customer.xsdconfig.其实, 生成的Java源代码没有多大作用,我们要的是jar文件.我们先看一下build\src\sample\xmlbean下生成的Classes.     
161.         
162.    　　CustomersDocument.java -- 整个XML文档的Java Class映射     
163.         
164.    　　CustomerType.java -- 节点sustomer的映射     
165.         
166.    　　AddressType.java -- 节点address的映射     
167.         
168.    　　BillingAddressType.java -- 节点billingAddress的映射     
169.         
170.    　　PrimaryAddressType.java -- 节点primaryAddress的映射     
171.         
172.    　　好了,到此我们所有的准备工作已经完成了. 下面就开始进入重点:利用刚才生成的jar文件读写XML.     
173.         
174.    　　五、利用XMLBean读XML文件     
175.         
176.    　　新建一个Java Project,将XMLBean2.0.0\lib\下的Jar文件和刚才我们生成的customerXmlBean.jar加入到Project的ClassPath.     
177.         
178.    　　新建一个Java Class: CustomerXMLBean. 源码如下:     
179.         
180.        package com.sample.reader;     
181.         
182.        import java.io.File;     
183.             
184.        import sample.xmlbean.*;     
185.        import org.apache.commons.beanutils.BeanUtils;     
186.        import org.apache.xmlbeans.XmlOptions;     
187.        public class CustomerXMLBean {     
188.        private String filename = null;     
189.             
190.        public CustomerXMLBean(String filename) {     
191.                super();     
192.                this.filename = filename;     
193.        }     
194.         
195.        public void customerReader() {     
196.                try {     
197.                  File xmlFile = new File(filename);     
198.                  CustomersDocument doc = CustomersDocument.Factory.parse(xmlFile);     
199.                  CustomerType[] customers = doc.getCustomers().getCustomerArray();     
200.                   
201.                  for (int i = 0; i < customers.length; i++) {     
202.                    CustomerType customer = customers[i];     
203.                    println("Customer#" + i);     
204.                    println("Customer ID:" + customer.getId());     
205.                    println("First name:" + customer.getFirstname());     
206.                    println("Last name:" + customer.getLastname());     
207.                    println("Gender:" + customer.getGender());     
208.                    println("PhoneNumber:" + customer.getPhoneNumber());     
209.                    // Primary address     
210.                    PrimaryAddressType primaryAddress = customer.getAddress().getPrimaryAddress();     
211.                    println("PrimaryAddress:");     
212.                    println("PostalCode:" + primaryAddress.getPostalCode());     
213.                    println("AddressLine1:" + primaryAddress.getAddressLine1());     
214.                    println("AddressLine2:" + primaryAddress.getAddressLine2());     
215.                    // Billing address     
216.                    BillingAddressType billingAddress = customer.getAddress().getBillingAddress();     
217.                    println("BillingAddress:");     
218.                    println("Receiver:" + billingAddress.getReceiver());     
219.                    println("PostalCode:" + billingAddress.getPostalCode());     
220.                    println("AddressLine1:" + billingAddress.getAddressLine1());     
221.                    println("AddressLine2:" + billingAddress.getAddressLine2());     
222.                     
223.                  }     
224.                } catch (Exception ex) {     
225.                        ex.printStackTrace();     
226.                }     
227.        }     
228.        private void println(String str) {     
229.              System.out.println(str);     
230.        }     
231.       public static void main(String[] args) {     
232.          String filename = "F://JavaTest//Eclipse//XMLBean//xml//customers.xml";     
233.                            
234.         CustomerXMLBean customerXMLBean = new CustomerXMLBean(filename);     
235.                       customerXMLBean.customerReader();     
236.        }     
237.         
238.    }     
239.         
240.    　　运行它,参看输出结果:     
241.         
242.           Customer#0     
243.           Customer ID:1     
244.           First name:Jessica     
245.           Last name:Lim     
246.           Gender:female     
247.           PhoneNumber:1234567     
248.           PrimaryAddress:     
249.           PostalCode:350106     
250.           AddressLine1:#25-1     
251.           AddressLine2:SHINSAYAMA 2-CHOME     
252.           BillingAddress:     
253.           Receiver:Ms Danielle     
254.           PostalCode:350107     
255.           AddressLine1:#167     
256.           AddressLine2:NORTH TOWER HARBOUR CITY     
257.         
258.           Customer#1     
259.           Customer ID:2     
260.           First name:David     
261.           Last name:Bill     
262.           Gender:male     
263.           PhoneNumber:808182     
264.           PrimaryAddress:     
265.           PostalCode:319087     
266.           AddressLine1:1033 WS St.     
267.           AddressLine2:Tima Road     
268.           BillingAddress:     
269.           Receiver:Mr William     
270.           PostalCode:672993     
271.           AddressLine1:1033 WS St.     
272.           AddressLine2:Tima Road     
273.         
274.    　　怎么样,是不是很轻松? XMLBean的威力.     
275.         
276.    　　六、利用XMLBean写XML文件     
277.         
278.    　　利用XMLBean创建一个XML文档也是一件轻而易举的事.我们再增加一个Method,     
279.         
280.    　　请看一下的Java Class:     
281.         
282.        public void createCustomer() {     
283.        try {     
284.            // Create Document     
285.            CustomersDocument doc = CustomersDocument.Factory.newInstance();     
286.            // Add new customer     
287.            CustomerType customer = doc.addNewCustomers().addNewCustomer();     
288.            // set customer info     
289.            customer.setId(3);     
290.            customer.setFirstname("Jessica");     
291.            customer.setLastname("Lim");     
292.            customer.setGender("female");     
293.            customer.setPhoneNumber("1234567");     
294.            // Add new address     
295.            AddressType address = customer.addNewAddress();     
296.            // Add new PrimaryAddress     
297.            PrimaryAddressType primaryAddress = address.addNewPrimaryAddress();     
298.            primaryAddress.setPostalCode("350106");     
299.            primaryAddress.setAddressLine1("#25-1");     
300.            primaryAddress.setAddressLine2("SHINSAYAMA 2-CHOME");     
301.         
302.    // Add new BillingAddress     
303.            BillingAddressType billingAddress = address.addNewBillingAddress();     
304.            billingAddress.setReceiver("Ms Danielle");     
305.            billingAddress.setPostalCode("350107");     
306.            billingAddress.setAddressLine1("#167");     
307.            billingAddress.setAddressLine2("NORTH TOWER HARBOUR CITY");     
308.         
309.            File xmlFile = new File(filename);     
310.            doc.save(xmlFile);     
311.            } catch (Exception ex) {     
312.                    ex.printStackTrace();     
313.            }     
314.         
315.      }     
316.         
317.    　　修改main method.     
318.         
319.        public static void main(String[] args) {     
320.        String filename = "F://JavaTest//Eclipse//XMLBean//xml//customers_new.xml";     
321.            CustomerXMLBean customerXMLBean = new CustomerXMLBean(filename);     
322.            customerXMLBean.createCustomer();     
323.        }     
324.         
325.    　　运行,打开customers_new.xml:     
326.         
327.        <?xml version="1.0" encoding="UTF-8"?>     
328.        <Customers>     
329.        <customer>     
330.                <id>3</id>     
331.                <gender>female</gender>     
332.                <firstname>Jessica</firstname>     
333.                <lastname>Lim</lastname>     
334.                <phoneNumber>1234567</phoneNumber>     
335.                <address>     
336.                        <primaryAddress>     
337.                             <postalCode>350106</postalCode>     
338.                             <addressLine1>#25-1</addressLine1>     
339.                                           <addressLine2>SHINSAYAMA 2-CHOME</addressLine2>     
340.                        </primaryAddress>     
341.                        <billingAddress>     
342.                            <receiver>Ms Danielle</receiver>     
343.                            <postalCode>350107</postalCode>     
344.                           <addressLine1>#167</addressLine1>     
345.                           <addressLine2>NORTH TOWER HARBOUR CITY</addressLine2>     
346.                        </billingAddress>     
347.                        </address>     
348.                </customer>     
349.        </Customers>     
350.         
351.    　　七、利用XMLBean修改XML文件     
352.         
353.    　　我们再增加一个Method:     
354.         
355.          public void updateCustomer(int id,String lastname) {     
356.             try {     
357.            File xmlFile = new File(filename);     
358.            CustomersDocument doc = CustomersDocument.Factory.parse(xmlFile);     
359.            CustomerType[] customers = doc.getCustomers().getCustomerArray();     
360.               
361.            for (int i = 0; i < customers.length; i++) {     
362.               CustomerType customer = customers[i];     
363.              if(customer.getId()==id){     
364.                    customer.setLastname(lastname);     
365.                    break;     
366.                }     
367.            }     
368.            doc.save(xmlFile);     
369.             } catch (Exception ex) {     
370.              ex.printStackTrace();     
371.             }     
372.               }     
373.         
374.    　　main method:     
375.         
376.        public static void main(String[] args) {     
377.         String filename = "F://JavaTest//Eclipse//XMLBean//xml//customers_new.xml";     
378.                             
379.        CustomerXMLBean customerXMLBean = new CustomerXMLBean(filename);     
380.                             
381.        customerXMLBean.updateCustomer(3,"last");     
382.        }     
383.         
384.    　　运行之后,我们将会看到客户编号为3的客户的lastname已经改为last.     
385.         
386.    　　八、利用XMLBean删除一个customer     
387.         
388.    　　再增加一个Method:     
389.         
390.        public void deleteCustomer(int id) {     
391.         try {     
392.          File xmlFile = new File(filename);     
393.         CustomersDocument doc = CustomersDocument.Factory.parse(xmlFile);     
394.        CustomerType[] customers = doc.getCustomers().getCustomerArray();     
395.         
396.       for (int i = 0; i < customers.length; i++) {     
397.            CustomerType customer = customers[i];     
398.            if(customer.getId()==id){     
399.                            customer.setNil() ;     
400.                            break;     
401.                   }     
402.       }     
403.       doc.save(xmlFile);     
404.       } catch (Exception ex) {     
405.            ex.printStackTrace();     
406.            }     
407.       }     
408.         
409.    main method:     
410.         
411.        public static void main(String[] args) {     
412.        String filename = "F://JavaTest//Eclipse//XMLBean//xml//customers_new.xml";     
413.                             
414.        CustomerXMLBean customerXMLBean = new CustomerXMLBean(filename);     
415.                             
416.        customerXMLBean.deleteCustomer(3);     
417.        }     
418.         
419.    　　运行,我们将会看到客户编号为3的客户的资料已经被删除.     
420.         
421.    　　九、查询XML     
422.         
423.    　　除了本文在以上讲述的,利用XMLBean能轻轻松松完成XML的读写操作外,结合XPath和XQuery,XMLBean还能完成象SQL查询数据库一样方便地查询XML数据. 关于XML查询以及如何创建XML数据库, 我将在另一篇文章里讨论.     
424.         
425.    　　十、结束语     
426.         
427.    　　XMLBean能帮助我们轻易读写XML,这将有助于我们降低XML的学习和使用,有了这个基础,开发人员将为学习更多地XML相关技术和Web Services,JMS等其他J2EE技术打下良好地基础.     
一、关于XML解析  
      
    　　XML在Java应用程序里变得越来越重要, 广泛应用于数据存储和交换. 比如我们常见的配置文件,都是以XML方式存储的. XML还应用于Java Message Service和Web Services等技术作为数据交换.因此,正确读写XML文档是XML应用的基础.  
      
    　　Java提供了SAX和DOM两种方式用于解析XML,但即便如此,要读写一个稍微复杂的XML,也不是一件容易的事.  
      
    　　二、XMLBean简介  
      
    　　Hibernate已经成为目前流行的面向Java环境的对象/关系数据库映射工具.在Hibernate等对象/关系数据库映射工具出现之前,对数据库的操作是通过JDBC来实现的,对数据库的任何操作,开发人员都要自己写SQL语句来实现. 对象/关系数据库映射工具出现后,对数据库的操作转成对JavaBean的操作,极大方便了数据库开发. 所以如果有一个类似的工具能够实现将对XML的读写转成对JavaBean的操作,将会简化XML的读写,即使对XML不熟悉的开发人员也能方便地读写XML. 这个工具就是XMLBean.  
      
    　　三、准备XMLBean和XML文档  
      
    　　XMLBean是Apache的一个开源项目,可以从http://www.apache.org下载,最新的版本是2.0. 解压后目录如下:  
      
    xmlbean2.0.0  
         +---bin  
         +---docs  
         +---lib  
         +---samples  
         +---schemas  
      
    　　另外还要准备一个XML文档(customers.xml),  
      
    　　在本文的例子里,我们将对这个文档进行读写操作. 文档源码如下:  
      
    <?xml version="1.0" encoding="UTF-8"?>  
    <Customers>  
        <customer>  
                <id>1</id>  
                <gender>female</gender>  
                <firstname>Jessica</firstname>  
                <lastname>Lim</lastname>  
                <phoneNumber>1234567</phoneNumber>  
                <address>  
                    <primaryAddress>  
                            <postalCode>350106</postalCode>  
                            <addressLine1>#25-1</addressLine1>  
                            <addressLine2>SHINSAYAMA 2-CHOME</addressLine2>  
                    </primaryAddress>  
                    <billingAddress>  
                            <receiver>Ms Danielle</receiver>  
                            <postalCode>350107</postalCode>  
                            <addressLine1>#167</addressLine1>  
                            <addressLine2>NORTH TOWER HARBOUR CITY</addressLine2>  
                    </billingAddress>  
                </address>  
        </customer>  
        <customer>  
                <id>2</id>  
                <gender>male</gender>  
                <firstname>David</firstname>  
                <lastname>Bill</lastname>  
                <phoneNumber>808182</phoneNumber>  
                <address>  
                    <primaryAddress>  
                            <postalCode>319087</postalCode>  
                            <addressLine1>1033 WS St.</addressLine1>  
                            <addressLine2>Tima Road</addressLine2>  
                    </primaryAddress>  
                    <billingAddress>  
                            <receiver>Mr William</receiver>  
                            <postalCode>672993</postalCode>  
                            <addressLine1>1033 WS St.</addressLine1>  
                            <addressLine2>Tima Road</addressLine2>  
                    </billingAddress>  
                </address>  
        </customer>  
    </Customers>  
      
    　　这是一个客户的数据模型,每个客户都有客户编号(ID),姓名,性别(gender),电话号码(phoneNumber)和地址,其中地址有两个: 首要地址(PrimaryAddress)和帐单地址(BillingAddress),每个地址有邮编,地址1,和地址2组成.其中帐单地址还有收件人(receiver).此外,还要准备一个配置文件(文件名customer.xsdconfig),这个文件的作用我后面会讲,它的内容如下:  
      
    <xb:config xmlns:xb="http://xml.apache.org/xmlbeans/2004/02/xbean/config">  
      
      <xb:namespace>  
        <xb:package>sample.xmlbean</xb:package>  
      </xb:namespace>  
      
    </xb:config>  
      
    　　四、XMLBean使用步骤  
      
    　　和其他面向Java环境的对象/关系数据库映射工具的使用步骤一样,在正式使用XMLBean前,我们要作两个准备.  
      
    　　1. 生成XML Schema文件  
      
    　　什么是XML Schema文件? 正常情况下,每个XML文件都有一个Schema文件,XML Schema文件是一个XML的约束文件,它定义了XML文件的结构和元素.以及对元素和结构的约束. 通俗地讲,如果说XML文件是数据库里的记录,那么Schema就是表结构定义.  
      
    　　为什么需要这个文件? XMLBean需要通过这个文件知道一个XML文件的结构以及约束,比如数据类型等. 利用这个Schema文件,XMLBean将会产生一系列相关的Java Classes来实现对XML的操作. 而作为开发人员,则是利用XMLBean产生的Java Classes来完成对XML的操作而不需要SAX或DOM.怎样产生这个Schema文件呢? 如果对于熟悉XML的开发人员,可以自己来写这个Schema文件,对于不熟悉XML的开发人员,可以通过一些工具来完成.比较有名的如XMLSPY和Stylus Studio都可以通过XML文件来生成Schema文件. 加入我们已经生成这个Schema文件(customer.xsd):  
      
           <?xml version="1.0" encoding="UTF-8"?>  
           <xs:schema xmlns:xs="http://www.w3.org/2001/XMLSchema"  
                      elementFormDefault="qualified">  
             <xs:element name="Customers">  
               <xs:complexType>  
                 <xs:sequence>  
                   <xs:element maxOccurs="unbounded" name="customer"  
                               type="customerType"/>  
                 </xs:sequence>  
               </xs:complexType>  
             </xs:element>  
           <xs:complexType name="customerType">  
                 <xs:sequence>  
                   <xs:element name="id" type="xs:int"/>  
                   <xs:element name="gender" type="xs:string"/>  
                   <xs:element name="firstname" type="xs:string"/>  
                   <xs:element name="lastname" type="xs:string"/>  
                   <xs:element name="phoneNumber" type="xs:string"/>  
                   <xs:element name="address" type="addressType"/>  
                 </xs:sequence>  
           </xs:complexType>  
             <xs:complexType name="addressType">  
                 <xs:sequence>  
                   <xs:element name="primaryAddress" type="primaryAddressType"/>  
                   <xs:element name="billingAddress" type="billingAddressType"/>  
                 </xs:sequence>  
             </xs:complexType>  
      
       <xs:complexType name="primaryAddressType">  
                 <xs:sequence>  
                   <xs:element name="postalCode" type="xs:string"/>  
                   <xs:element name="addressLine1" type="xs:string"/>  
                   <xs:element name="addressLine2" type="xs:string"/>  
                 </xs:sequence>  
             </xs:complexType>  
             <xs:complexType name="billingAddressType">  
                 <xs:sequence>  
                       <xs:element name="receiver" type="xs:string"/>  
                   <xs:element name="postalCode" type="xs:string"/>  
                   <xs:element name="addressLine1" type="xs:string"/>  
                   <xs:element name="addressLine2" type="xs:string"/>  
                 </xs:sequence>  
             </xs:complexType>  
           </xs:schema>  
      
    　　2. 利用scomp来生成Java Classes  
      
    　　scomp是XMLBean提供的一个编译工具,它在bin的目录下. 通过这个工具,我们可以将以上的Schema文件生成Java Classes.scomp的语法如下:-  
      
    　　scomp [options] [dirs]* [schemaFile.xsd]* [service.wsdl]* [config.xsdconfig]*  
      
    　　主要参数说明:  
      
    　　-src [dir] -- 生成的Java Classes存放目录  
      
    　　-srconly -- 不编译Java Classes,不产生Jar文件  
      
    　　-out [jarFileName] -- 生成的Jar文件,缺省是xmltypes.jar  
      
    　　-compiler -- Java编译器的路径,即Javac的位置  
      
    　　schemaFile.xsd -- XML Schema文件位置  
      
    　　config.xsdconfig -- xsdconfig文件的位置, 这个文件主要用来制定生成的Java Class的一些文件名规则和Package的名称,在本文,package是sample.xmlbean  
      
    　　在本文,我是这样运行的:  
      
          scomp -src build\src  -out build\customerXmlBean.jar schema\customer.xsd  
                 -compiler C:\jdk142_04\bin\javac customer.xsdconfig  
      
    　　这个命令行的意思是告诉scomp生成customerXmlBean.jar,放在build目录下,同时生成源代码放在build\src下, Schema文件是customer.xsd,xsdconfig文件是customer.xsdconfig.其实, 生成的Java源代码没有多大作用,我们要的是jar文件.我们先看一下build\src\sample\xmlbean下生成的Classes.  
      
    　　CustomersDocument.java -- 整个XML文档的Java Class映射  
      
    　　CustomerType.java -- 节点sustomer的映射  
      
    　　AddressType.java -- 节点address的映射  
      
    　　BillingAddressType.java -- 节点billingAddress的映射  
      
    　　PrimaryAddressType.java -- 节点primaryAddress的映射  
      
    　　好了,到此我们所有的准备工作已经完成了. 下面就开始进入重点:利用刚才生成的jar文件读写XML.  
      
    　　五、利用XMLBean读XML文件  
      
    　　新建一个Java Project,将XMLBean2.0.0\lib\下的Jar文件和刚才我们生成的customerXmlBean.jar加入到Project的ClassPath.  
      
    　　新建一个Java Class: CustomerXMLBean. 源码如下:  
      
        package com.sample.reader;  
      
        import java.io.File;  
          
        import sample.xmlbean.*;  
        import org.apache.commons.beanutils.BeanUtils;  
        import org.apache.xmlbeans.XmlOptions;  
        public class CustomerXMLBean {  
        private String filename = null;  
          
        public CustomerXMLBean(String filename) {  
                super();  
                this.filename = filename;  
        }  
      
        public void customerReader() {  
                try {  
                  File xmlFile = new File(filename);  
                  CustomersDocument doc = CustomersDocument.Factory.parse(xmlFile);  
                  CustomerType[] customers = doc.getCustomers().getCustomerArray();  
                
                  for (int i = 0; i < customers.length; i++) {  
                    CustomerType customer = customers[i];  
                    println("Customer#" + i);  
                    println("Customer ID:" + customer.getId());  
                    println("First name:" + customer.getFirstname());  
                    println("Last name:" + customer.getLastname());  
                    println("Gender:" + customer.getGender());  
                    println("PhoneNumber:" + customer.getPhoneNumber());  
                    // Primary address  
                    PrimaryAddressType primaryAddress = customer.getAddress().getPrimaryAddress();  
                    println("PrimaryAddress:");  
                    println("PostalCode:" + primaryAddress.getPostalCode());  
                    println("AddressLine1:" + primaryAddress.getAddressLine1());  
                    println("AddressLine2:" + primaryAddress.getAddressLine2());  
                    // Billing address  
                    BillingAddressType billingAddress = customer.getAddress().getBillingAddress();  
                    println("BillingAddress:");  
                    println("Receiver:" + billingAddress.getReceiver());  
                    println("PostalCode:" + billingAddress.getPostalCode());  
                    println("AddressLine1:" + billingAddress.getAddressLine1());  
                    println("AddressLine2:" + billingAddress.getAddressLine2());  
                  
                  }  
                } catch (Exception ex) {  
                        ex.printStackTrace();  
                }  
        }  
        private void println(String str) {  
              System.out.println(str);  
        }  
       public static void main(String[] args) {  
          String filename = "F://JavaTest//Eclipse//XMLBean//xml//customers.xml";  
                         
         CustomerXMLBean customerXMLBean = new CustomerXMLBean(filename);  
                       customerXMLBean.customerReader();  
        }  
      
    }  
      
    　　运行它,参看输出结果:  
      
           Customer#0  
           Customer ID:1  
           First name:Jessica  
           Last name:Lim  
           Gender:female  
           PhoneNumber:1234567  
           PrimaryAddress:  
           PostalCode:350106  
           AddressLine1:#25-1  
           AddressLine2:SHINSAYAMA 2-CHOME  
           BillingAddress:  
           Receiver:Ms Danielle  
           PostalCode:350107  
           AddressLine1:#167  
           AddressLine2:NORTH TOWER HARBOUR CITY  
      
           Customer#1  
           Customer ID:2  
           First name:David  
           Last name:Bill  
           Gender:male  
           PhoneNumber:808182  
           PrimaryAddress:  
           PostalCode:319087  
           AddressLine1:1033 WS St.  
           AddressLine2:Tima Road  
           BillingAddress:  
           Receiver:Mr William  
           PostalCode:672993  
           AddressLine1:1033 WS St.  
           AddressLine2:Tima Road  
      
    　　怎么样,是不是很轻松? XMLBean的威力.  
      
    　　六、利用XMLBean写XML文件  
      
    　　利用XMLBean创建一个XML文档也是一件轻而易举的事.我们再增加一个Method,  
      
    　　请看一下的Java Class:  
      
        public void createCustomer() {  
        try {  
            // Create Document  
            CustomersDocument doc = CustomersDocument.Factory.newInstance();  
            // Add new customer  
            CustomerType customer = doc.addNewCustomers().addNewCustomer();  
            // set customer info  
            customer.setId(3);  
            customer.setFirstname("Jessica");  
            customer.setLastname("Lim");  
            customer.setGender("female");  
            customer.setPhoneNumber("1234567");  
            // Add new address  
            AddressType address = customer.addNewAddress();  
            // Add new PrimaryAddress  
            PrimaryAddressType primaryAddress = address.addNewPrimaryAddress();  
            primaryAddress.setPostalCode("350106");  
            primaryAddress.setAddressLine1("#25-1");  
            primaryAddress.setAddressLine2("SHINSAYAMA 2-CHOME");  
      
    // Add new BillingAddress  
            BillingAddressType billingAddress = address.addNewBillingAddress();  
            billingAddress.setReceiver("Ms Danielle");  
            billingAddress.setPostalCode("350107");  
            billingAddress.setAddressLine1("#167");  
            billingAddress.setAddressLine2("NORTH TOWER HARBOUR CITY");  
      
            File xmlFile = new File(filename);  
            doc.save(xmlFile);  
            } catch (Exception ex) {  
                    ex.printStackTrace();  
            }  
      
      }  
      
    　　修改main method.  
      
        public static void main(String[] args) {  
        String filename = "F://JavaTest//Eclipse//XMLBean//xml//customers_new.xml";  
            CustomerXMLBean customerXMLBean = new CustomerXMLBean(filename);  
            customerXMLBean.createCustomer();  
        }  
      
    　　运行,打开customers_new.xml:  
      
        <?xml version="1.0" encoding="UTF-8"?>  
        <Customers>  
        <customer>  
                <id>3</id>  
                <gender>female</gender>  
                <firstname>Jessica</firstname>  
                <lastname>Lim</lastname>  
                <phoneNumber>1234567</phoneNumber>  
                <address>  
                        <primaryAddress>  
                             <postalCode>350106</postalCode>  
                             <addressLine1>#25-1</addressLine1>  
                                           <addressLine2>SHINSAYAMA 2-CHOME</addressLine2>  
                        </primaryAddress>  
                        <billingAddress>  
                            <receiver>Ms Danielle</receiver>  
                            <postalCode>350107</postalCode>  
                           <addressLine1>#167</addressLine1>  
                           <addressLine2>NORTH TOWER HARBOUR CITY</addressLine2>  
                        </billingAddress>  
                        </address>  
                </customer>  
        </Customers>  
      
    　　七、利用XMLBean修改XML文件  
      
    　　我们再增加一个Method:  
      
          public void updateCustomer(int id,String lastname) {  
             try {  
            File xmlFile = new File(filename);  
            CustomersDocument doc = CustomersDocument.Factory.parse(xmlFile);  
            CustomerType[] customers = doc.getCustomers().getCustomerArray();  
            
            for (int i = 0; i < customers.length; i++) {  
               CustomerType customer = customers[i];  
              if(customer.getId()==id){  
                    customer.setLastname(lastname);  
                    break;  
                }  
            }  
            doc.save(xmlFile);  
             } catch (Exception ex) {  
              ex.printStackTrace();  
             }  
               }  
      
    　　main method:  
      
        public static void main(String[] args) {  
         String filename = "F://JavaTest//Eclipse//XMLBean//xml//customers_new.xml";  
                          
        CustomerXMLBean customerXMLBean = new CustomerXMLBean(filename);  
                          
        customerXMLBean.updateCustomer(3,"last");  
        }  
      
    　　运行之后,我们将会看到客户编号为3的客户的lastname已经改为last.  
      
    　　八、利用XMLBean删除一个customer  
      
    　　再增加一个Method:  
      
        public void deleteCustomer(int id) {  
         try {  
          File xmlFile = new File(filename);  
         CustomersDocument doc = CustomersDocument.Factory.parse(xmlFile);  
        CustomerType[] customers = doc.getCustomers().getCustomerArray();  
      
       for (int i = 0; i < customers.length; i++) {  
            CustomerType customer = customers[i];  
            if(customer.getId()==id){  
                            customer.setNil() ;  
                            break;  
                   }  
       }  
       doc.save(xmlFile);  
       } catch (Exception ex) {  
            ex.printStackTrace();  
            }  
       }  
      
    main method:  
      
        public static void main(String[] args) {  
        String filename = "F://JavaTest//Eclipse//XMLBean//xml//customers_new.xml";  
                          
        CustomerXMLBean customerXMLBean = new CustomerXMLBean(filename);  
                          
        customerXMLBean.deleteCustomer(3);  
        }  
      
    　　运行,我们将会看到客户编号为3的客户的资料已经被删除.  
      
    　　九、查询XML  
      
    　　除了本文在以上讲述的,利用XMLBean能轻轻松松完成XML的读写操作外,结合XPath和XQuery,XMLBean还能完成象SQL查询数据库一样方便地查询XML数据. 关于XML查询以及如何创建XML数据库, 我将在另一篇文章里讨论.  
      
    　　十、结束语  
      
    　　XMLBean能帮助我们轻易读写XML,这将有助于我们降低XML的学习和使用,有了这个基础,开发人员将为学习更多地XML相关技术和Web Services,JMS等其他J2EE技术打下良好地基础.   


** 最后 以上编译xsd文件是用命令行 也可以使用java程序来写 ** 

Java代码  
1.String rootPah = System.getProperty("user.dir")+"/WebContent";   
2.String[] xmlBeanArgs = new String[] {   
3.                  "-d", rootPah,   
4.                  "-src",rootPah,   
5.                  "-out", "sudokuXB.jar",   
6.                  "-javasource", "1.5",   
7.                  rootPah +"schema/customer.xsd",   
8.                  rootPah +"schema/comer.xsdconfig"  
9.                };   
10.org.apache.xmlbeans.impl.tool.SchemaCompiler.main(xmlBeanArgs);  
String rootPah = System.getProperty("user.dir")+"/WebContent";
String[] xmlBeanArgs = new String[] {
			      "-d", rootPah,
			      "-src",rootPah,
			      "-out", "sudokuXB.jar",
			      "-javasource", "1.5",
			      rootPah +"schema/customer.xsd",
			      rootPah +"schema/comer.xsdconfig"
			    };
org.apache.xmlbeans.impl.tool.SchemaCompiler.main(xmlBeanArgs);

使用tool包下的 SchemaCompiler 类的main方法就可以实现！ 


//cd 
cd E:\workspace\wolf-study\study\xmlbeans-2.5.0\bin
scomp -src E:/workspace/wolf-study/src/main/java/com/study/open/xmlbean/  -out E:/workspace/wolf-study/lib/customerXmlBean.jar E:/workspace/wolf-study/src/main/java/com/study/open/xmlbean/person.xsd -compiler javac E:/workspace/wolf-study/src/main/java/com/study/open/xmlbean/customer.xsdconfig
