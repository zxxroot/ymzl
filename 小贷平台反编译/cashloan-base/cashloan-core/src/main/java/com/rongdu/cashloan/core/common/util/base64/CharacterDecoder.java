/*    */ package com.rongdu.cashloan.core.common.util.base64;
/*    */ 
/*    */ import java.io.ByteArrayInputStream;
/*    */ import java.io.ByteArrayOutputStream;
/*    */ import java.io.IOException;
/*    */ import java.io.InputStream;
/*    */ import java.io.OutputStream;
/*    */ 
/*    */ 
/*    */ 
/*    */ public abstract class CharacterDecoder
/*    */ {
/*    */   protected abstract int bytesPerAtom();
/*    */   
/*    */   protected abstract int bytesPerLine();
/*    */   
/*    */   protected void decodeBufferPrefix(InputStream inputstream, OutputStream outputstream)
/*    */     throws IOException
/*    */   {}
/*    */   
/*    */   protected void decodeBufferSuffix(InputStream inputstream, OutputStream outputstream)
/*    */     throws IOException
/*    */   {}
/*    */   
/*    */   protected int decodeLinePrefix(InputStream inputstream, OutputStream outputstream)
/*    */     throws IOException
/*    */   {
/* 28 */     return bytesPerLine();
/*    */   }
/*    */   
/*    */   protected void decodeLineSuffix(InputStream inputstream, OutputStream outputstream) throws IOException
/*    */   {}
/*    */   
/*    */   protected void decodeAtom(InputStream inputstream, OutputStream outputstream, int i) throws IOException {
/* 35 */     throw new IOException("StreamExhausted");
/*    */   }
/*    */   
/*    */   protected int readFully(InputStream inputstream, byte[] abyte0, int i, int j) throws IOException {
/* 39 */     for (int k = 0; k < j; k++) {
/* 40 */       int l = inputstream.read();
/* 41 */       if (l == -1)
/* 42 */         return k != 0 ? k : -1;
/* 43 */       abyte0[(k + i)] = ((byte)l);
/*    */     }
/*    */     
/* 46 */     return j;
/*    */   }
/*    */   
/*    */   public void decodeBuffer(InputStream inputstream, OutputStream outputstream) throws IOException
/*    */   {
/* 51 */     int j = 0;
/* 52 */     decodeBufferPrefix(inputstream, outputstream);
/*    */     try {
/*    */       for (;;) {
/* 55 */         int k = decodeLinePrefix(inputstream, outputstream);
/*    */         int i = 0;
/* 57 */         for (i = 0; i + bytesPerAtom() < k; i += bytesPerAtom()) {
/* 58 */           decodeAtom(inputstream, outputstream, bytesPerAtom());
/* 59 */           j += bytesPerAtom();
/*    */         }
/*    */         
/* 62 */         if (i + bytesPerAtom() == k) {
/* 63 */           decodeAtom(inputstream, outputstream, bytesPerAtom());
/* 64 */           j += bytesPerAtom();
/*    */         } else {
/* 66 */           decodeAtom(inputstream, outputstream, k - i);
/* 67 */           j += k - i;
/*    */         }
/* 69 */         decodeLineSuffix(inputstream, outputstream);
/*    */       }
/*    */     } catch (IOException e) {
/* 72 */       if ("StreamExhausted".equals(e.getMessage())) {
/* 73 */         decodeBufferSuffix(inputstream, outputstream);
/*    */       } else
/* 75 */         throw e;
/*    */     }
/*    */   }
/*    */   
/*    */   public byte[] decodeBuffer(String s) throws IOException {
/* 80 */     byte[] abyte0 = s.getBytes();
/* 81 */     ByteArrayInputStream bytearrayinputstream = new ByteArrayInputStream(abyte0);
/* 82 */     ByteArrayOutputStream bytearrayoutputstream = new ByteArrayOutputStream();
/* 83 */     decodeBuffer(bytearrayinputstream, bytearrayoutputstream);
/* 84 */     return bytearrayoutputstream.toByteArray();
/*    */   }
/*    */   
/*    */   public String decodeStr(String s) throws IOException {
/* 88 */     return new String(decodeBuffer(s));
/*    */   }
/*    */   
/*    */   public byte[] decodeBuffer(InputStream inputstream) throws IOException {
/* 92 */     ByteArrayOutputStream bytearrayoutputstream = new ByteArrayOutputStream();
/* 93 */     decodeBuffer(inputstream, bytearrayoutputstream);
/* 94 */     return bytearrayoutputstream.toByteArray();
/*    */   }
/*    */ }


/*CharacterDecoder
 */