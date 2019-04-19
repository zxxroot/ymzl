/*     */ package com.rongdu.cashloan.core.common.util;
/*     */ 
/*     */ import java.awt.Color;
/*     */ import java.awt.Font;
/*     */ import java.awt.Graphics2D;
/*     */ import java.awt.image.BufferedImage;
/*     */ import java.io.FileOutputStream;
/*     */ import java.io.IOException;
/*     */ import java.io.OutputStream;
/*     */ import java.util.Random;
/*     */ import javax.imageio.ImageIO;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class ValidateCode
/*     */ {
/*  20 */   private int width = 160;
/*     */   
/*  22 */   private int height = 40;
/*     */   
/*  24 */   private int codeCount = 4;
/*     */   
/*  26 */   private int lineCount = 150;
/*     */   
/*  28 */   private String code = null;
/*     */   
/*  30 */   private BufferedImage buffImg = null;
/*     */   
/*     */ 
/*  33 */   private char[] codeSequence = { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 
/*  34 */     'k', 'l', 'm', 'n', 'p', 'q', 'e', 's', 't', 'u', 'v', 'w', 
/*  35 */     'x', 'y', 'z', '1', '2', '3', '4', '5', '6', '7', '8', '9' };
/*     */   
/*     */ 
/*     */ 
/*     */   public ValidateCode()
/*     */   {
/*  41 */     createCode();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public ValidateCode(int width, int height)
/*     */   {
/*  49 */     this.width = width;
/*  50 */     this.height = height;
/*  51 */     createCode();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public ValidateCode(int width, int height, int codeCount, int lineCount)
/*     */   {
/*  61 */     this.width = width;
/*  62 */     this.height = height;
/*  63 */     this.codeCount = codeCount;
/*  64 */     this.lineCount = lineCount;
/*  65 */     createCode();
/*     */   }
/*     */   
/*     */   public void createCode() {
/*  69 */     int x = 0;int fontHeight = 0;int codeY = 0;
/*  70 */     int red = 0;int green = 0;int blue = 0;
/*     */     
/*  72 */     x = this.width / (this.codeCount + 2);
/*  73 */     fontHeight = this.height - 13;
/*  74 */     codeY = this.height - 4;
/*     */     
/*     */ 
/*  77 */     this.buffImg = new BufferedImage(this.width, this.height, 1);
/*  78 */     Graphics2D g = this.buffImg.createGraphics();
/*     */     
/*  80 */     Random random = new Random();
/*     */     
/*  82 */     g.setColor(Color.WHITE);
/*  83 */     g.fillRect(0, 0, this.width, this.height);
/*     */     
/*  85 */     Font font = new Font("Fixedsys", 0, fontHeight);
/*     */     
/*  87 */     g.setFont(font);
/*     */     
/*  89 */     for (int i = 0; i < this.lineCount; i++)
/*     */     {
/*  91 */       int xs = random.nextInt(this.width);
/*  92 */       int ys = random.nextInt(this.height);
/*  93 */       int xe = xs + random.nextInt(this.width / 8);
/*  94 */       int ye = ys + random.nextInt(this.height / 8);
/*     */       
/*     */ 
/*  97 */       red = random.nextInt(255);
/*  98 */       green = random.nextInt(255);
/*  99 */       blue = random.nextInt(255);
/* 100 */       g.setColor(new Color(red, green, blue));
/* 101 */       g.drawLine(xs, ys, xe, ye);
/*     */     }
/*     */     
/*     */ 
/* 105 */     StringBuffer randomCode = new StringBuffer();
/*     */     
/* 107 */     for (int i = 0; i < this.codeCount; i++) {
/* 108 */       String strRand = String.valueOf(this.codeSequence[random.nextInt(this.codeSequence.length)]);
/*     */       
/* 110 */       red = random.nextInt(255);
/* 111 */       green = random.nextInt(255);
/* 112 */       blue = random.nextInt(255);
/* 113 */       g.setColor(new Color(red, green, blue));
/* 114 */       g.drawString(strRand, (i + 1) * x, codeY);
/*     */       
/* 116 */       randomCode.append(strRand);
/*     */     }
/*     */     
/* 119 */     this.code = randomCode.toString();
/*     */   }
/*     */   
/*     */   public void write(String path) throws IOException {
/* 123 */     OutputStream sos = new FileOutputStream(path);
/* 124 */     write(sos);
/*     */   }
/*     */   
/*     */   public void write(OutputStream sos) throws IOException {
/* 128 */     ImageIO.write(this.buffImg, "png", sos);
/* 129 */     sos.close();
/*     */   }
/*     */   
/*     */   public BufferedImage getBuffImg() {
/* 133 */     return this.buffImg;
/*     */   }
/*     */   
/*     */   public String getCode() {
/* 137 */     return this.code;
/*     */   }
/*     */ }
