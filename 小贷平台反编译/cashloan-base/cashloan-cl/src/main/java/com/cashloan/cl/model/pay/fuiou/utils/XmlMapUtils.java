/*     */ package com.cashloan.cl.model.pay.fuiou.utils;
/*     */ 
/*     */ import java.io.IOException;
/*     */ import java.io.StringWriter;
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashMap;
/*     */ import java.util.Iterator;
/*     */ import java.util.LinkedHashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import java.util.Set;
/*     */ import org.dom4j.Attribute;
/*     */ import org.dom4j.Document;
/*     */ import org.dom4j.DocumentException;
/*     */ import org.dom4j.DocumentHelper;
/*     */ import org.dom4j.Element;
/*     */ import org.dom4j.io.OutputFormat;
/*     */ import org.dom4j.io.XMLWriter;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class XmlMapUtils
/*     */ {
/*     */   public static Map xml2map(String xmlStr, boolean needRootKey)
/*     */     throws DocumentException
/*     */   {
/*  36 */     Document doc = DocumentHelper.parseText(xmlStr);
/*  37 */     Element root = doc.getRootElement();
/*  38 */     Map<String, Object> map = xml2map(root);
/*  39 */     if ((root.elements().size() == 0) && (root.attributes().size() == 0)) {
/*  40 */       return map;
/*     */     }
/*  42 */     if (needRootKey)
/*     */     {
/*  44 */       Map<String, Object> rootMap = new HashMap();
/*  45 */       rootMap.put(root.getName(), map);
/*  46 */       return rootMap;
/*     */     }
/*  48 */     return map;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static Map xml2mapWithAttr(String xmlStr, boolean needRootKey)
/*     */     throws DocumentException
/*     */   {
/*  59 */     Document doc = DocumentHelper.parseText(xmlStr);
/*  60 */     Element root = doc.getRootElement();
/*  61 */     Map<String, Object> map = xml2mapWithAttr(root);
/*  62 */     if ((root.elements().size() == 0) && (root.attributes().size() == 0)) {
/*  63 */       return map;
/*     */     }
/*  65 */     if (needRootKey)
/*     */     {
/*  67 */       Map<String, Object> rootMap = new HashMap();
/*  68 */       rootMap.put(root.getName(), map);
/*  69 */       return rootMap;
/*     */     }
/*  71 */     return map;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private static Map xml2map(Element e)
/*     */   {
/*  80 */     Map map = new LinkedHashMap();
/*  81 */     List list = e.elements();
/*  82 */     if (list.size() > 0) {
/*  83 */       for (int i = 0; i < list.size(); i++) {
/*  84 */         Element iter = (Element)list.get(i);
/*  85 */         List mapList = new ArrayList();
/*     */         
/*  87 */         if (iter.elements().size() > 0) {
/*  88 */           Map m = xml2map(iter);
/*  89 */           if (map.get(iter.getName()) != null) {
/*  90 */             Object obj = map.get(iter.getName());
/*  91 */             if (!(obj instanceof List)) {
/*  92 */               mapList = new ArrayList();
/*  93 */               mapList.add(obj);
/*  94 */               mapList.add(m);
/*     */             }
/*  96 */             if ((obj instanceof List)) {
/*  97 */               mapList = (List)obj;
/*  98 */               mapList.add(m);
/*     */             }
/* 100 */             map.put(iter.getName(), mapList);
/*     */           } else {
/* 102 */             map.put(iter.getName(), m);
/*     */           }
/* 104 */         } else if (map.get(iter.getName()) != null) {
/* 105 */           Object obj = map.get(iter.getName());
/* 106 */           if (!(obj instanceof List)) {
/* 107 */             mapList = new ArrayList();
/* 108 */             mapList.add(obj);
/* 109 */             mapList.add(iter.getText());
/*     */           }
/* 111 */           if ((obj instanceof List)) {
/* 112 */             mapList = (List)obj;
/* 113 */             mapList.add(iter.getText());
/*     */           }
/* 115 */           map.put(iter.getName(), mapList);
/*     */         } else {
/* 117 */           map.put(iter.getName(), iter.getText());
/*     */         }
/*     */       }
/*     */     } else
/* 121 */       map.put(e.getName(), e.getText());
/* 122 */     return map;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private static Map xml2mapWithAttr(Element element)
/*     */   {
/* 131 */     Map<String, Object> map = new LinkedHashMap();
/*     */     
/* 133 */     List<Element> list = element.elements();
/* 134 */     List<Attribute> listAttr0 = element.attributes();
/* 135 */     for (Attribute attr : listAttr0) {
/* 136 */       map.put("@" + attr.getName(), attr.getValue());
/*     */     }
/* 138 */     if (list.size() > 0)
/*     */     {
/* 140 */       for (int i = 0; i < list.size(); i++) {
/* 141 */         Element iter = (Element)list.get(i);
/* 142 */         List mapList = new ArrayList();
/*     */         
/* 144 */         if (iter.elements().size() > 0) {
/* 145 */           Map m = xml2mapWithAttr(iter);
/* 146 */           if (map.get(iter.getName()) != null) {
/* 147 */             Object obj = map.get(iter.getName());
/* 148 */             if (!(obj instanceof List)) {
/* 149 */               mapList = new ArrayList();
/* 150 */               mapList.add(obj);
/* 151 */               mapList.add(m);
/*     */             }
/* 153 */             if ((obj instanceof List)) {
/* 154 */               mapList = (List)obj;
/* 155 */               mapList.add(m);
/*     */             }
/* 157 */             map.put(iter.getName(), mapList);
/*     */           } else {
/* 159 */             map.put(iter.getName(), m);
/*     */           }
/*     */         } else {
/* 162 */           List<Attribute> listAttr = iter.attributes();
/* 163 */           Map<String, Object> attrMap = null;
/* 164 */           boolean hasAttributes = false;
/* 165 */           if (listAttr.size() > 0) {
/* 166 */             hasAttributes = true;
/* 167 */             attrMap = new LinkedHashMap();
/* 168 */             for (Attribute attr : listAttr) {
/* 169 */               attrMap.put("@" + attr.getName(), attr.getValue());
/*     */             }
/*     */           }
/*     */           
/* 173 */           if (map.get(iter.getName()) != null) {
/* 174 */             Object obj = map.get(iter.getName());
/* 175 */             if (!(obj instanceof List)) {
/* 176 */               mapList = new ArrayList();
/* 177 */               mapList.add(obj);
/*     */               
/* 179 */               if (hasAttributes) {
/* 180 */                 attrMap.put("#text", iter.getText());
/* 181 */                 mapList.add(attrMap);
/*     */               } else {
/* 183 */                 mapList.add(iter.getText());
/*     */               }
/*     */             }
/* 186 */             if ((obj instanceof List)) {
/* 187 */               mapList = (List)obj;
/*     */               
/* 189 */               if (hasAttributes) {
/* 190 */                 attrMap.put("#text", iter.getText());
/* 191 */                 mapList.add(attrMap);
/*     */               } else {
/* 193 */                 mapList.add(iter.getText());
/*     */               }
/*     */             }
/* 196 */             map.put(iter.getName(), mapList);
/*     */ 
/*     */           }
/* 199 */           else if (hasAttributes) {
/* 200 */             attrMap.put("#text", iter.getText());
/* 201 */             map.put(iter.getName(), attrMap);
/*     */           } else {
/* 203 */             map.put(iter.getName(), iter.getText());
/*     */           }
/*     */           
/*     */         }
/*     */         
/*     */       }
/*     */       
/* 210 */     } else if (listAttr0.size() > 0) {
/* 211 */       map.put("#text", element.getText());
/*     */     } else {
/* 213 */       map.put(element.getName(), element.getText());
/*     */     }
/*     */     
/* 216 */     return map;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static Document map2xml(Map<String, Object> map, String rootName)
/*     */     throws DocumentException, IOException
/*     */   {
/* 227 */     Document doc = DocumentHelper.createDocument();
/* 228 */     Element root = DocumentHelper.createElement(rootName);
/* 229 */     doc.add(root);
/* 230 */     map2xml(map, root);
/*     */     
/*     */ 
/* 233 */     return doc;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static Document map2xml(Map<String, Object> map)
/*     */     throws DocumentException, IOException
/*     */   {
/* 243 */     Iterator<Map.Entry<String, Object>> entries = map.entrySet().iterator();
/* 244 */     if (entries.hasNext()) {
/* 245 */       Map.Entry<String, Object> entry = (Map.Entry)entries.next();
/* 246 */       Document doc = DocumentHelper.createDocument();
/* 247 */       Element root = DocumentHelper.createElement((String)entry.getKey());
/* 248 */       doc.add(root);
/* 249 */       map2xml((Map)entry.getValue(), root);
/*     */       
/*     */ 
/* 252 */       return doc;
/*     */     }
/* 254 */     return null;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private static Element map2xml(Map<String, Object> map, Element body)
/*     */   {
/* 264 */     Iterator<Map.Entry<String, Object>> entries = map.entrySet().iterator();
/* 265 */     while (entries.hasNext()) {
/* 266 */       Map.Entry<String, Object> entry = (Map.Entry)entries.next();
/* 267 */       String key = (String)entry.getKey();
/* 268 */       Object value = entry.getValue();
/* 269 */       if (key.startsWith("@")) {
/* 270 */         body.addAttribute(key.substring(1, key.length()), value.toString());
/* 271 */       } else if (key.equals("#text")) {
/* 272 */         body.setText(value.toString());
/*     */       }
/* 274 */       else if ((value instanceof List)) {
/* 275 */         List list = (List)value;
/*     */         
/* 277 */         for (int i = 0; i < list.size(); i++) {
/* 278 */           Object obj = list.get(i);
/*     */           
/* 280 */           if ((obj instanceof Map)) {
/* 281 */             Element subElement = body.addElement(key);
/* 282 */             map2xml((Map)list.get(i), subElement);
/*     */           } else {
/* 284 */             body.addElement(key).setText((String)list.get(i));
/*     */           }
/*     */         }
/* 287 */       } else if ((value instanceof Map)) {
/* 288 */         Element subElement = body.addElement(key);
/* 289 */         map2xml((Map)value, subElement);
/*     */       } else {
/* 291 */         body.addElement(key).setText(value != null ? value.toString() : "");
/*     */       }
/*     */     }
/*     */     
/*     */ 
/* 296 */     return body;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static String formatXml(String xmlStr)
/*     */     throws DocumentException, IOException
/*     */   {
/* 307 */     Document document = DocumentHelper.parseText(xmlStr);
/* 308 */     return formatXml(document);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static String formatXml(Document document)
/*     */     throws DocumentException, IOException
/*     */   {
/* 320 */     OutputFormat format = OutputFormat.createPrettyPrint();
/*     */     
/* 322 */     StringWriter writer = new StringWriter();
/*     */     
/* 324 */     XMLWriter xmlWriter = new XMLWriter(writer, format);
/* 325 */     document.getRootElement().asXML();
/*     */     
/* 327 */     xmlWriter.write(document);
/* 328 */     xmlWriter.close();
/* 329 */     return writer.toString();
/*     */   }
/*     */ }
