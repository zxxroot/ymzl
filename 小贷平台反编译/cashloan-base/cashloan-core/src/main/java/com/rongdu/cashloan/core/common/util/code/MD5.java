/*     */ package com.rongdu.cashloan.core.common.util.code;
/*     */
/*     */
/*     */ public class MD5
/*     */ {
/*     */   static final int S11 = 7;
/*     */
/*     */   static final int S12 = 12;
/*     */
/*     */   static final int S13 = 17;
/*     */
/*     */   static final int S14 = 22;
/*     */
/*     */   static final int S21 = 5;
/*     */
/*     */   static final int S22 = 9;
/*     */
/*     */   static final int S23 = 14;
/*     */
/*     */   static final int S24 = 20;
/*     */
/*     */   static final int S31 = 4;
/*     */
/*     */   static final int S32 = 11;
/*     */
/*     */   static final int S33 = 16;
/*     */   static final int S34 = 23;
/*     */   static final int S41 = 6;
/*     */   static final int S42 = 10;
/*     */   static final int S43 = 15;
/*     */   static final int S44 = 21;
/*  32 */   static final byte[] PADDING = { Byte.MIN_VALUE };
/*     */
/*     */
/*     */
/*     */
/*     */
/*     */
/*  39 */   private static long[] state = new long[4];
/*  40 */   private static long[] count = new long[2];
/*     */
/*     */
/*  43 */   private static byte[] buffer = new byte[64];
/*     */
/*     */
/*     */
/*     */
/*     */   public static String digestHexStr;
/*     */
/*     */
/*     */
/*     */
/*  53 */   private static byte[] digest = new byte[16];
/*     */
/*     */   public MD5() {
/*  56 */     md5Init();
/*     */   }
/*     */
/*     */
/*     */   private static void md5Init()
/*     */   {
/*  62 */     count[0] = 0L;
/*  63 */     count[1] = 0L;
/*     */
/*     */
/*  66 */     state[0] = 1732584193L;
/*  67 */     state[1] = 4023233417L;
/*  68 */     state[2] = 2562383102L;
/*  69 */     state[3] = 271733878L;
/*     */   }
/*     */
/*     */
/*     */
/*     */
/*     */
/*     */   private static long F(long x, long y, long z)
/*     */   {
/*  80 */     return x & y | (x ^ 0xFFFFFFFFFFFFFFFFl) & z;
/*     */   }
/*     */
/*     */   private static long G(long x, long y, long z)
/*     */   {
/*  85 */     return x & z | y & (z ^ 0xFFFFFFFFFFFFFFFFl);
/*     */   }
/*     */
/*     */   private static long H(long x, long y, long z)
/*     */   {
/*  90 */     return x ^ y ^ z;
/*     */   }
/*     */
/*     */   private static long I(long x, long y, long z) {
/*  94 */     return y ^ (x | z ^ 0xFFFFFFFFFFFFFFFFl);
/*     */   }
/*     */
/*     */
/*     */
/*     */
/*     */
/*     */
/*     */
/*     */   private static long FF(long a, long b, long c, long d, long x, long s, long ac)
/*     */   {
/* 105 */     a += F(b, c, d) + x + ac;
/* 106 */     a = (int)a << (int)s | (int)a >>> (int)(32L - s);
/* 107 */     a += b;
/* 108 */     return a;
/*     */   }
/*     */
/*     */   private static long GG(long a, long b, long c, long d, long x, long s, long ac)
/*     */   {
/* 113 */     a += G(b, c, d) + x + ac;
/* 114 */     a = (int)a << (int)s | (int)a >>> (int)(32L - s);
/* 115 */     a += b;
/* 116 */     return a;
/*     */   }
/*     */
/*     */   private static long HH(long a, long b, long c, long d, long x, long s, long ac)
/*     */   {
/* 121 */     a += H(b, c, d) + x + ac;
/* 122 */     a = (int)a << (int)s | (int)a >>> (int)(32L - s);
/* 123 */     a += b;
/* 124 */     return a;
/*     */   }
/*     */
/*     */   private static long II(long a, long b, long c, long d, long x, long s, long ac)
/*     */   {
/* 129 */     a += I(b, c, d) + x + ac;
/* 130 */     a = (int)a << (int)s | (int)a >>> (int)(32L - s);
/* 131 */     a += b;
/* 132 */     return a;
/*     */   }
/*     */
/*     */
/*     */
/*     */
/*     */
/*     */
/*     */   private static void md5Update(byte[] inbuf, int inputLen)
/*     */   {
/* 142 */     byte[] block = new byte[64];
/* 143 */     int index = (int)(count[0] >>> 3) & 0x3F;
/*     */
///* 145 */     if (count[0] += (inputLen << 3) < inputLen << 3)
/* 146 */       count[1] += 1L;
/* 147 */     count[1] += (inputLen >>> 29);
/*     */
/* 149 */     int partLen = 64 - index;
/*     */
/*     */     int i;
/* 152 */     if (inputLen >= partLen) {
/* 153 */       md5Memcpy(buffer, inbuf, index, 0, partLen);
/* 154 */       md5Transform(buffer);
/*     */
/* 156 */       for (i = partLen; i + 63 < inputLen; i += 64)
/*     */       {
/* 158 */         md5Memcpy(block, inbuf, 0, i, 64);
/* 159 */         md5Transform(block);
/*     */       }
/* 161 */       index = 0;
/*     */     }
/*     */     else
/*     */     {
/* 165 */       i = 0;
/*     */     }
/*     */
/* 168 */     md5Memcpy(buffer, inbuf, index, i, inputLen - i);
/*     */   }
/*     */
/*     */
/*     */
/*     */
/*     */   private static void md5Final()
/*     */   {
/* 176 */     byte[] bits = new byte[8];
/*     */
/*     */
/*     */
/* 180 */     Encode(bits, count, 8);
/*     */
/*     */
/* 183 */     int index = (int)(count[0] >>> 3) & 0x3F;
/* 184 */     int padLen = index < 56 ? 56 - index : 120 - index;
/* 185 */     md5Update(PADDING, padLen);
/*     */
/*     */
/* 188 */     md5Update(bits, 8);
/*     */
/*     */
/* 191 */     Encode(digest, state, 16);
/*     */   }
/*     */
/*     */
/*     */
/*     */
/*     */
/*     */
/*     */
/*     */
/*     */
/*     */   private static void md5Memcpy(byte[] output, byte[] input, int outpos, int inpos, int len)
/*     */   {
/* 204 */     for (int i = 0; i < len; i++) {
/* 205 */       output[(outpos + i)] = input[(inpos + i)];
/*     */     }
/*     */   }
/*     */
/*     */
/*     */   private static void md5Transform(byte[] block)
/*     */   {
/* 212 */     long a = state[0];long b = state[1];long c = state[2];long d = state[3];
/* 213 */     long[] x = new long[16];
/*     */
/* 215 */     Decode(x, block, 64);
/*     */
/*     */
/* 218 */     a = FF(a, b, c, d, x[0], 7L, 3614090360L);
/* 219 */     d = FF(d, a, b, c, x[1], 12L, 3905402710L);
/* 220 */     c = FF(c, d, a, b, x[2], 17L, 606105819L);
/* 221 */     b = FF(b, c, d, a, x[3], 22L, 3250441966L);
/* 222 */     a = FF(a, b, c, d, x[4], 7L, 4118548399L);
/* 223 */     d = FF(d, a, b, c, x[5], 12L, 1200080426L);
/* 224 */     c = FF(c, d, a, b, x[6], 17L, 2821735955L);
/* 225 */     b = FF(b, c, d, a, x[7], 22L, 4249261313L);
/* 226 */     a = FF(a, b, c, d, x[8], 7L, 1770035416L);
/* 227 */     d = FF(d, a, b, c, x[9], 12L, 2336552879L);
/* 228 */     c = FF(c, d, a, b, x[10], 17L, 4294925233L);
/* 229 */     b = FF(b, c, d, a, x[11], 22L, 2304563134L);
/* 230 */     a = FF(a, b, c, d, x[12], 7L, 1804603682L);
/* 231 */     d = FF(d, a, b, c, x[13], 12L, 4254626195L);
/* 232 */     c = FF(c, d, a, b, x[14], 17L, 2792965006L);
/* 233 */     b = FF(b, c, d, a, x[15], 22L, 1236535329L);
/*     */
/*     */
/* 236 */     a = GG(a, b, c, d, x[1], 5L, 4129170786L);
/* 237 */     d = GG(d, a, b, c, x[6], 9L, 3225465664L);
/* 238 */     c = GG(c, d, a, b, x[11], 14L, 643717713L);
/* 239 */     b = GG(b, c, d, a, x[0], 20L, 3921069994L);
/* 240 */     a = GG(a, b, c, d, x[5], 5L, 3593408605L);
/* 241 */     d = GG(d, a, b, c, x[10], 9L, 38016083L);
/* 242 */     c = GG(c, d, a, b, x[15], 14L, 3634488961L);
/* 243 */     b = GG(b, c, d, a, x[4], 20L, 3889429448L);
/* 244 */     a = GG(a, b, c, d, x[9], 5L, 568446438L);
/* 245 */     d = GG(d, a, b, c, x[14], 9L, 3275163606L);
/* 246 */     c = GG(c, d, a, b, x[3], 14L, 4107603335L);
/* 247 */     b = GG(b, c, d, a, x[8], 20L, 1163531501L);
/* 248 */     a = GG(a, b, c, d, x[13], 5L, 2850285829L);
/* 249 */     d = GG(d, a, b, c, x[2], 9L, 4243563512L);
/* 250 */     c = GG(c, d, a, b, x[7], 14L, 1735328473L);
/* 251 */     b = GG(b, c, d, a, x[12], 20L, 2368359562L);
/*     */
/*     */
/* 254 */     a = HH(a, b, c, d, x[5], 4L, 4294588738L);
/* 255 */     d = HH(d, a, b, c, x[8], 11L, 2272392833L);
/* 256 */     c = HH(c, d, a, b, x[11], 16L, 1839030562L);
/* 257 */     b = HH(b, c, d, a, x[14], 23L, 4259657740L);
/* 258 */     a = HH(a, b, c, d, x[1], 4L, 2763975236L);
/* 259 */     d = HH(d, a, b, c, x[4], 11L, 1272893353L);
/* 260 */     c = HH(c, d, a, b, x[7], 16L, 4139469664L);
/* 261 */     b = HH(b, c, d, a, x[10], 23L, 3200236656L);
/* 262 */     a = HH(a, b, c, d, x[13], 4L, 681279174L);
/* 263 */     d = HH(d, a, b, c, x[0], 11L, 3936430074L);
/* 264 */     c = HH(c, d, a, b, x[3], 16L, 3572445317L);
/* 265 */     b = HH(b, c, d, a, x[6], 23L, 76029189L);
/* 266 */     a = HH(a, b, c, d, x[9], 4L, 3654602809L);
/* 267 */     d = HH(d, a, b, c, x[12], 11L, 3873151461L);
/* 268 */     c = HH(c, d, a, b, x[15], 16L, 530742520L);
/* 269 */     b = HH(b, c, d, a, x[2], 23L, 3299628645L);
/*     */
/*     */
/* 272 */     a = II(a, b, c, d, x[0], 6L, 4096336452L);
/* 273 */     d = II(d, a, b, c, x[7], 10L, 1126891415L);
/* 274 */     c = II(c, d, a, b, x[14], 15L, 2878612391L);
/* 275 */     b = II(b, c, d, a, x[5], 21L, 4237533241L);
/* 276 */     a = II(a, b, c, d, x[12], 6L, 1700485571L);
/* 277 */     d = II(d, a, b, c, x[3], 10L, 2399980690L);
/* 278 */     c = II(c, d, a, b, x[10], 15L, 4293915773L);
/* 279 */     b = II(b, c, d, a, x[1], 21L, 2240044497L);
/* 280 */     a = II(a, b, c, d, x[8], 6L, 1873313359L);
/* 281 */     d = II(d, a, b, c, x[15], 10L, 4264355552L);
/* 282 */     c = II(c, d, a, b, x[6], 15L, 2734768916L);
/* 283 */     b = II(b, c, d, a, x[13], 21L, 1309151649L);
/* 284 */     a = II(a, b, c, d, x[4], 6L, 4149444226L);
/* 285 */     d = II(d, a, b, c, x[11], 10L, 3174756917L);
/* 286 */     c = II(c, d, a, b, x[2], 15L, 718787259L);
/* 287 */     b = II(b, c, d, a, x[9], 21L, 3951481745L);
/*     */
/* 289 */     state[0] += a;
/* 290 */     state[1] += b;
/* 291 */     state[2] += c;
/* 292 */     state[3] += d;
/*     */   }
/*     */
/*     */
/*     */
/*     */
/*     */
/*     */
/*     */   private static void Encode(byte[] output, long[] input, int len)
/*     */   {
/* 302 */     int i = 0; for (int j = 0; j < len; j += 4) {
/* 303 */       output[j] = ((byte)(int)(input[i] & 0xFF));
/* 304 */       output[(j + 1)] = ((byte)(int)(input[i] >>> 8 & 0xFF));
/* 305 */       output[(j + 2)] = ((byte)(int)(input[i] >>> 16 & 0xFF));
/* 306 */       output[(j + 3)] = ((byte)(int)(input[i] >>> 24 & 0xFF));i++;
/*     */     }
/*     */   }
/*     */
/*     */
/*     */
/*     */
/*     */
/*     */
/*     */
/*     */
/*     */
/*     */   private static void Decode(long[] output, byte[] input, int len)
/*     */   {
/* 317 */     int i = 0; for (int j = 0; j < len; j += 4) {
/* 318 */       output[i] =
/* 319 */         (b2iu(input[j]) | b2iu(input[(j + 1)]) << 8 | b2iu(input[(j + 2)]) << 16 | b2iu(input[(j + 3)]) << 24);i++;
/*     */     }
/*     */   }
/*     */
/*     */
/*     */
/*     */
/*     */
/*     */   public static long b2iu(byte b)
/*     */   {
/* 328 */     return b < 0 ? b & 0xFF : b;
/*     */   }
/*     */
/*     */
/*     */
/*     */
/*     */   public static String byteHEX(byte ib)
/*     */   {
/* 336 */     char[] Digit = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A',
/* 337 */       'B', 'C', 'D', 'E', 'F' };
/* 338 */     char[] ob = new char[2];
/* 339 */     ob[0] = Digit[(ib >>> 4 & 0xF)];
/* 340 */     ob[1] = Digit[(ib & 0xF)];
/* 341 */     String s = new String(ob);
/* 342 */     return s;
/*     */   }
/*     */
/*     */   public static String encode(String inbuf) {
/* 346 */     md5Init();
/* 347 */     md5Update(inbuf.getBytes(), inbuf.length());
/* 348 */     md5Final();
/* 349 */     digestHexStr = "";
/* 350 */     for (int i = 0; i < 16; i++) {
/* 351 */       digestHexStr += byteHEX(digest[i]);
/*     */     }
/* 353 */     return digestHexStr;
/*     */   }
/*     */
/*     */
/*     */
/*     */
/*     */   public static String getMD5ofStr(String inbuf)
/*     */   {
/* 361 */     md5Init();
/* 362 */     md5Update(inbuf.getBytes(), inbuf.length());
/* 363 */     md5Final();
/* 364 */     digestHexStr = "";
/* 365 */     for (int i = 0; i < 16; i++) {
/* 366 */       digestHexStr += byteHEX(digest[i]);
/*     */     }
/* 368 */     return digestHexStr;
/*     */   }
/*     */ }


