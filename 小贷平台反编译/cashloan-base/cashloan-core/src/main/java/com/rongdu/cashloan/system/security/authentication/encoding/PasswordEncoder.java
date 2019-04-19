/*    */ package com.rongdu.cashloan.system.security.authentication.encoding;
/*    */ 
/*    */
import com.rongdu.cashloan.core.common.util.crypto.Crypto;
import org.springframework.dao.DataAccessException;
import org.springframework.security.authentication.dao.SaltSource;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

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
/*    */ public class PasswordEncoder
/*    */
        /*    */ {
/*    */   private Crypto crypto;
/*    */   private SaltSource saltSource;
/*    */   
/*    */   private Object getSalt()
/*    */   {
/* 23 */     UserDetails user = null;
/* 24 */     if ((SecurityContextHolder.getContext() != null) && 
/* 25 */       (SecurityContextHolder.getContext().getAuthentication() != null) && 
/* 26 */       (SecurityContextHolder.getContext().getAuthentication().getPrincipal() != null)) {
/* 27 */       user = (UserDetails)SecurityContextHolder.getContext().getAuthentication()
/* 28 */         .getPrincipal();
/*    */     }
/*    */     
/* 31 */     return this.saltSource.getSalt(user);
/*    */   }
/*    */   
/*    */   public void setCrypto(Crypto crypto) {
/* 35 */     this.crypto = crypto;
/*    */   }
/*    */   
/*    */   public void setSaltSource(SaltSource saltSource) {
/* 39 */     this.saltSource = saltSource;
/*    */   }
/*    */   
/*    */   public String encodePassword(String rawPass) throws DataAccessException
/*    */   {
/* 44 */     return encodePassword(rawPass, getSalt());
/*    */   }
/*    */   
/*    */   public String encodePassword(String rawPass, Object salt) throws DataAccessException
/*    */   {
/* 49 */     if (salt == null) {
/* 50 */       salt = getSalt();
/*    */     }
/* 52 */     String saltedPass = mergePasswordAndSalt(rawPass, salt, false);
/* 53 */     return this.crypto.encrypt(saltedPass);
/*    */   }

    private String mergePasswordAndSalt(String rawPass, Object salt, boolean b) {
    return "";
    }

    /*    */
/*    */   public boolean isPasswordValid(String encPass, String rawPass) throws DataAccessException
/*    */   {
/* 58 */     return isPasswordValid(encPass, rawPass, getSalt());
/*    */   }
/*    */   
/*    */   public boolean isPasswordValid(String encPass, String rawPass, Object salt)
/*    */     throws DataAccessException
/*    */   {
/* 64 */     if (salt == null) {
/* 65 */       salt = getSalt();
/*    */     }
/* 67 */     String pass1 = encPass;
/* 68 */     String pass2 = encodePassword(rawPass, salt);
/*    */     
/* 70 */     return pass1.equals(pass2);
/*    */   }
/*    */ }