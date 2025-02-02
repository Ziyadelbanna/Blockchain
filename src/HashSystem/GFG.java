package HashSystem;

import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
/*
Citation:-
---------
----------------------- Copyright from Ziyad Elbanna: this is a template used from GeekstoGeeks.org online, all rights reserved for G4G -------------------------
 */
// Java program to calculate SHA hash value

 public class GFG {
     public static byte[] getSHA(byte[] input) throws NoSuchAlgorithmException {
         // Static getInstance method is called with hashing SHA
         MessageDigest md = MessageDigest.getInstance("SHA-256");

         // digest() method called
         // to calculate message digest of an input
         // and return array of byte
         return md.digest(input);
     }

     public static String toHexString(byte[] hash) {
         // Convert byte array into signum representation
         BigInteger number = new BigInteger(1, hash);

         // Convert message digest into hex value
         StringBuilder hexString = new StringBuilder(number.toString(16));

         // Pad with leading zeros
         while (hexString.length() < 32) {
             hexString.insert(0, '0');
         }

         return hexString.toString();
     }


     // Driver code
     public static void main(String args[]) {
         System.out.println("HashCode Generated by SHA-256 for:");

         String s1 = "GeeksForGeeks";
         //System.out.println("\n" + s1 + " : " + toHexString(getSHA(s1)));

         String s2 = "hello world";
         //System.out.println("\n" + s2 + " : " + toHexString(getSHA(s2)));
     }
 }
