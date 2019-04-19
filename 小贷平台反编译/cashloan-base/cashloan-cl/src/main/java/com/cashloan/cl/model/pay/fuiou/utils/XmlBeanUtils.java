/*    */ package com.cashloan.cl.model.pay.fuiou.utils;
/*    */ 
/*    */ import java.io.StringReader;
/*    */ import java.io.StringWriter;
/*    */ import javax.xml.bind.JAXBContext;
/*    */ import javax.xml.bind.JAXBException;
/*    */ import javax.xml.bind.Marshaller;
/*    */ import javax.xml.bind.Unmarshaller;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class XmlBeanUtils
/*    */ {
/*    */   public static <T> String convertBean2Xml(T bean)
/*    */     throws JAXBException
/*    */   {
/* 31 */     return convertBean2Xml(bean, "UTF-8", true);
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public static <T> String convertBean2Xml(T bean, String charSet, boolean containHeader)
/*    */     throws JAXBException
/*    */   {
/* 42 */     JAXBContext jc = JAXBContext.newInstance(new Class[] { bean.getClass() });
/* 43 */     Marshaller ms = jc.createMarshaller();
/* 44 */     ms.setProperty("jaxb.encoding", charSet);
/* 45 */     if (!containHeader)
/*    */     {
/* 47 */       ms.setProperty("jaxb.fragment", Boolean.valueOf(true));
/*    */     }
/* 49 */     StringWriter sw = new StringWriter();
/* 50 */     ms.marshal(bean, sw);
/* 51 */     return sw.toString();
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public static <T> T convertXml2Bean(String xml, Class<T> clazz)
/*    */     throws JAXBException
/*    */   {
/* 64 */     JAXBContext context = JAXBContext.newInstance(new Class[] { clazz });
/* 65 */     Unmarshaller unmarshaller = context.createUnmarshaller();
/* 66 */     return (T)unmarshaller.unmarshal(new StringReader(xml));
/*    */   }
/*    */ }
