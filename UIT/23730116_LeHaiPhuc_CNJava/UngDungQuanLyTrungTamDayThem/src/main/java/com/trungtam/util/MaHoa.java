package com.trungtam.util;
import java.security.MessageDigest;
// SHA-256
public class MaHoa {
    public static String sha256(String input){
        try{
            MessageDigest md=MessageDigest.getInstance("SHA-256");
            byte[] h=md.digest(input.getBytes("UTF-8"));
            StringBuilder sb=new StringBuilder();
            for(byte b: h) sb.append(String.format("%02x", b));
            return sb.toString();
        }catch(Exception e){ throw new RuntimeException("Loi ma hoa: "+e.getMessage(), e); }
    }
}
