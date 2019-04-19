/*     */ package com.rongdu.cashloan.core.common.util.base64;
/*     */ 
/*     */ import java.io.ByteArrayInputStream;
/*     */ import java.io.ByteArrayOutputStream;
/*     */ import java.io.IOException;
/*     */ import java.io.InputStream;
/*     */ import java.io.OutputStream;
/*     */ import java.io.PrintStream;
/*     */ import java.io.UnsupportedEncodingException;
/*     */ import org.slf4j.Logger;
/*     */ import org.slf4j.LoggerFactory;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public abstract class CharacterEncoder
/*     */ {
/*  19 */   public static final Logger logger = LoggerFactory.getLogger(CharacterEncoder.class);
/*     */   
/*     */   protected PrintStream pStream;
/*     */   
/*     */   protected abstract int bytesPerAtom();
/*     */   
/*     */   protected abstract int bytesPerLine();
/*     */   
/*     */   protected void encodeBufferPrefix(OutputStream outputstream)
/*     */     throws IOException
/*     */   {
/*  30 */     this.pStream = new PrintStream(outputstream);
/*     */   }
/*     */   
/*     */   protected void encodeBufferSuffix(OutputStream outputstream) throws IOException
/*     */   {}
/*     */   
/*     */   protected void encodeLinePrefix(OutputStream outputstream, int i) throws IOException
/*     */   {}
/*     */   
/*     */   protected void encodeLineSuffix(OutputStream outputstream) throws IOException
/*     */   {}
/*     */   
/*     */   protected abstract void encodeAtom(OutputStream paramOutputStream, byte[] paramArrayOfByte, int paramInt1, int paramInt2) throws IOException;
/*     */   
/*     */   protected int readFully(InputStream inputstream, byte[] abyte0) throws IOException
/*     */   {
/*  46 */     for (int i = 0; i < abyte0.length; i++) {
/*  47 */       int j = inputstream.read();
/*  48 */       if (j == -1)
/*  49 */         return i;
/*  50 */       abyte0[i] = ((byte)j);
/*     */     }
/*     */     
/*  53 */     return abyte0.length;
/*     */   }
/*     */   
/*     */   public void encode(InputStream inputstream, OutputStream outputstream) throws IOException {
/*  57 */     byte[] abyte0 = new byte[bytesPerLine()];
/*  58 */     encodeBufferPrefix(outputstream);
/*     */     for (;;) {
/*  60 */       int j = readFully(inputstream, abyte0);
/*  61 */       if (j == 0)
/*     */         break;
/*  63 */       encodeLinePrefix(outputstream, j);
/*  64 */       for (int i = 0; i < j; i += bytesPerAtom()) {
/*  65 */         if (i + bytesPerAtom() <= j) {
/*  66 */           encodeAtom(outputstream, abyte0, i, bytesPerAtom());
/*     */         } else
/*  68 */           encodeAtom(outputstream, abyte0, i, j - i);
/*     */       }
/*  70 */       if (j < bytesPerLine())
/*     */         break;
/*  72 */       encodeLineSuffix(outputstream);
/*     */     }
/*  74 */     encodeBufferSuffix(outputstream);
/*     */   }
/*     */   
/*     */   public void encode(byte[] abyte0, OutputStream outputstream) throws IOException {
/*  78 */     ByteArrayInputStream bytearrayinputstream = new ByteArrayInputStream(abyte0);
/*  79 */     encode(bytearrayinputstream, outputstream);
/*     */   }
/*     */   
/*     */   public String encode(byte[] abyte0) {
/*  83 */     ByteArrayOutputStream bytearrayoutputstream = new ByteArrayOutputStream();
/*  84 */     ByteArrayInputStream bytearrayinputstream = new ByteArrayInputStream(abyte0);
/*  85 */     String s = null;
/*     */     try {
/*  87 */       encode(bytearrayinputstream, bytearrayoutputstream);
/*  88 */       s = bytearrayoutputstream.toString("8859_1");
/*     */     } catch (UnsupportedEncodingException e) {
/*  90 */       logger.error(e.getMessage(), e);
/*     */     } catch (IOException e) {
/*  92 */       logger.error(e.getMessage(), e);
/*     */     }
/*  94 */     return s;
/*     */   }
/*     */   
/*     */   public void encodeBuffer(InputStream inputstream, OutputStream outputstream) throws IOException {
/*  98 */     byte[] abyte0 = new byte[bytesPerLine()];
/*  99 */     encodeBufferPrefix(outputstream);
/*     */     int j;
/*     */     do {
/* 102 */       j = readFully(inputstream, abyte0);
/* 103 */       if (j == 0)
/*     */         break;
/* 105 */       encodeLinePrefix(outputstream, j);
/* 106 */       for (int i = 0; i < j; i += bytesPerAtom()) {
/* 107 */         if (i + bytesPerAtom() <= j) {
/* 108 */           encodeAtom(outputstream, abyte0, i, bytesPerAtom());
/*     */         } else
/* 110 */           encodeAtom(outputstream, abyte0, i, j - i);
/*     */       }
/* 112 */       encodeLineSuffix(outputstream);
/* 101 */     } while (
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
/* 113 */       j >= bytesPerLine());
/* 114 */     encodeBufferSuffix(outputstream);
/*     */   }
/*     */   
/*     */   public void encodeBuffer(byte[] abyte0, OutputStream outputstream) throws IOException {
/* 118 */     ByteArrayInputStream bytearrayinputstream = new ByteArrayInputStream(abyte0);
/* 119 */     encodeBuffer(bytearrayinputstream, outputstream);
/*     */   }
/*     */   
/*     */   public String encodeBuffer(byte[] abyte0) {
/* 123 */     ByteArrayOutputStream bytearrayoutputstream = new ByteArrayOutputStream();
/* 124 */     ByteArrayInputStream bytearrayinputstream = new ByteArrayInputStream(abyte0);
/*     */     try {
/* 126 */       encodeBuffer(bytearrayinputstream, bytearrayoutputstream);
/*     */     } catch (IOException e) {
/* 128 */       logger.error(e.getMessage(), e);
/*     */     }
/* 130 */     return bytearrayoutputstream.toString();
/*     */   }
/*     */ }


/* base64\CharacterEncoder.class

 */