/*    */ package com.rongdu.cashloan.core.common.util.base64;
/*    */ 
/*    */ import java.io.IOException;
/*    */ import java.io.OutputStream;
/*    */ 
/*    */ public class Base64Decoder extends CharacterDecoder
/*    */ {
/*    */   public Base64Decoder()
/*    */   {
/* 10 */     this.decode_buffer = new byte[4];
/*    */   }
/*    */   
/*    */   protected int bytesPerAtom() {
/* 14 */     return 4;
/*    */   }
/*    */   
/*    */   protected int bytesPerLine() {
/* 18 */     return 72;
/*    */   }
/*    */   
/*    */   protected void decodeAtom(java.io.InputStream inputstream, OutputStream outputstream, int i) throws IOException {
/* 22 */     byte byte0 = -1;
/* 23 */     byte byte1 = -1;
/* 24 */     byte byte2 = -1;
/* 25 */     byte byte3 = -1;
/* 26 */     if (i < 2) {
/* 27 */       throw new IOException("BASE64Decoder: Not enough bytes for an atom.");
/*    */     }
             int j =0;
/*    */     do {
/* 30 */       j = inputstream.read();
/* 31 */       if (j == -1)
/* 32 */         throw new IOException("StreamExhausted");
/* 33 */     } while ((j == 10) || (j == 13));
/* 34 */     this.decode_buffer[0] = ((byte)j);
/* 35 */     j = readFully(inputstream, this.decode_buffer, 1, i - 1);
/* 36 */     if (j == -1)
/* 37 */       throw new IOException("StreamExhausted");
/* 38 */     if ((i > 3) && (this.decode_buffer[3] == 61))
/* 39 */       i = 3;
/* 40 */     if ((i > 2) && (this.decode_buffer[2] == 61))
/* 41 */       i = 2;
/* 42 */     switch (i) {
/*    */     case 4: 
/* 44 */       byte3 = pem_convert_array[(this.decode_buffer[3] & 0xFF)];
/*    */     
/*    */ 
/*    */     case 3: 
/* 48 */       byte2 = pem_convert_array[(this.decode_buffer[2] & 0xFF)];
/*    */     
/*    */ 
/*    */     case 2: 
/* 52 */       byte1 = pem_convert_array[(this.decode_buffer[1] & 0xFF)];
/* 53 */       byte0 = pem_convert_array[(this.decode_buffer[0] & 0xFF)];
/*    */     }
/*    */     
/*    */     
/* 57 */     switch (i) {
/*    */     case 2: 
/* 59 */       outputstream.write((byte)(byte0 << 2 & 0xFC | byte1 >>> 4 & 0x3));
/* 60 */       break;
/*    */     
/*    */     case 3: 
/* 63 */       outputstream.write((byte)(byte0 << 2 & 0xFC | byte1 >>> 4 & 0x3));
/* 64 */       outputstream.write((byte)(byte1 << 4 & 0xF0 | byte2 >>> 2 & 0xF));
/* 65 */       break;
/*    */     
/*    */     case 4: 
/* 68 */       outputstream.write((byte)(byte0 << 2 & 0xFC | byte1 >>> 4 & 0x3));
/* 69 */       outputstream.write((byte)(byte1 << 4 & 0xF0 | byte2 >>> 2 & 0xF));
/* 70 */       outputstream.write((byte)(byte2 << 6 & 0xC0 | byte3 & 0x3F));
/*    */     }
/*    */     
/*    */   }
/*    */   
/*    */ 
/*    */ 
/* 77 */   private static final char[] pem_array = { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 
/* 78 */     'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 
/* 79 */     'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', '0', '1', '2', '3', 
/* 80 */     '4', '5', '6', '7', '8', '9', '+', '/' };
/*    */   
/*    */ 
/*    */ 
/*    */ 
/* 85 */   private static final byte[] pem_convert_array = new byte['Ā'];
/* 86 */   static { for (int i = 0; i < 255; i++) {
/* 87 */       pem_convert_array[i] = -1;
/*    */     }
/* 89 */     for (int j = 0; j < pem_array.length; j++) {
/* 90 */       pem_convert_array[pem_array[j]] = ((byte)j);
/*    */     }
/*    */   }
/*    */   
/*    */   byte[] decode_buffer;
/*    */ }


/* base64\Base64Decoder.class

 */