/*    */ package com.rongdu.cashloan.core.common.util.base64;
/*    */ 
/*    */ import java.io.IOException;
/*    */ import java.io.OutputStream;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class Base64Encoder
/*    */   extends CharacterEncoder
/*    */ {
/*    */   protected int bytesPerAtom()
/*    */   {
/* 17 */     return 3;
/*    */   }
/*    */   
/*    */   protected int bytesPerLine() {
/* 21 */     return 57;
/*    */   }
/*    */   
/*    */   protected void encodeAtom(OutputStream outputstream, byte[] abyte0, int i, int j) throws IOException {
/* 25 */     if (j == 1) {
/* 26 */       byte byte0 = abyte0[i];
/* 27 */       int k = 0;
/* 28 */       outputstream.write(pem_array[(byte0 >>> 2 & 0x3F)]);
/* 29 */       outputstream.write(pem_array[((byte0 << 4 & 0x30) + (k >>> 4 & 0xF))]);
/* 30 */       outputstream.write(61);
/* 31 */       outputstream.write(61);
/* 32 */     } else if (j == 2) {
/* 33 */       byte byte1 = abyte0[i];
/* 34 */       byte byte3 = abyte0[(i + 1)];
/* 35 */       int l = 0;
/* 36 */       outputstream.write(pem_array[(byte1 >>> 2 & 0x3F)]);
/* 37 */       outputstream.write(pem_array[((byte1 << 4 & 0x30) + (byte3 >>> 4 & 0xF))]);
/* 38 */       outputstream.write(pem_array[((byte3 << 2 & 0x3C) + (l >>> 6 & 0x3))]);
/* 39 */       outputstream.write(61);
/*    */     } else {
/* 41 */       byte byte2 = abyte0[i];
/* 42 */       byte byte4 = abyte0[(i + 1)];
/* 43 */       byte byte5 = abyte0[(i + 2)];
/* 44 */       outputstream.write(pem_array[(byte2 >>> 2 & 0x3F)]);
/* 45 */       outputstream.write(pem_array[((byte2 << 4 & 0x30) + (byte4 >>> 4 & 0xF))]);
/* 46 */       outputstream.write(pem_array[((byte4 << 2 & 0x3C) + (byte5 >>> 6 & 0x3))]);
/* 47 */       outputstream.write(pem_array[(byte5 & 0x3F)]);
/*    */     }
/*    */   }
/*    */   
/* 51 */   private static final char[] pem_array = { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 
/* 52 */     'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 
/* 53 */     'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', '0', '1', '2', '3', 
/* 54 */     '4', '5', '6', '7', '8', '9', '+', '/' };
/*    */ }
