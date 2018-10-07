/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;


import java.util.List;
import modle.Cylinder;
import modle.Encrypter;

/**
 *
 * @author elshaar
 */ 
public class TestEncrypt {
    public static void main(String[] args) {
        
        Cylinder cylinder = new Cylinder((byte)7);
        testEncrypt(cylinder);
        
    }

    static void testEncrypt(Cylinder cylinder){
        String planText = "ammar hamdy";
        cylinder.print();
        Encrypter encrypt = new Encrypter(cylinder);
        String  cipherText = encrypt.encrypt(planText, (byte)3);
        System.out.println(planText+"\n"+cipherText);
    }
    
    static void testFilter(Cylinder cylinder){
        Encrypter encrypt = new Encrypter(cylinder);
        //.
        String c = encrypt.filter("ammar hamdy");
        System.out.println(c+"  "+c.length());
        c = encrypt.filter("  am m arY 5+- ?>< ANha AJCU vmdy  .");
        System.out.println(c+"  "+c.length());
        List list = encrypt.filter("name age am m arY 5+- ?>< ANha AJCU mdy. elshaar", (byte)5);
        System.out.println(list);
    }
    

}
