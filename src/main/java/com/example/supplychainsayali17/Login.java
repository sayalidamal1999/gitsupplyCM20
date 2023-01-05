package com.example.supplychainsayali17;

import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.sql.ResultSet;

public class Login {

   private byte[] getSHA(String input){
      try{
          MessageDigest messageDigest=MessageDigest.getInstance("SHA-256");
          return messageDigest.digest(input.getBytes(StandardCharsets.UTF_8));
      }catch(Exception e){
          e.printStackTrace();
      }
      return null;
    }

    private String getEncryptedPassword(String password){
        try{
            BigInteger number=new BigInteger(1,getSHA(password));
            StringBuilder hexString=new StringBuilder(number.toString(16));
            return hexString.toString();
        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }




    public boolean costumerLogin(String email,String password){
        String query=String.format("SELECT*FROM costumer WHERE email='%s' AND password= '%s'",email,password);
        try{
            DatabaseConnection dbCon=new DatabaseConnection();
            ResultSet rs= dbCon.getQueryTable(query);
            if(rs!=null && rs.next()){
                return true;
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }

 //   public static void main(String[] args) {
 //      Login login = new Login();
 //       System.out.println(login.costumerLogin("sayali@gmail.com","sayali@123"));
 //   }

   //public static void main(String[] args) {
   //    Login login=new Login();
   //   System.out.println(login.getEncryptedPassword("sayali@123"));
   //}
}
