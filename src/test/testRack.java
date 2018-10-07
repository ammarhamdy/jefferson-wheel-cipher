
package test;

import java.util.Scanner;
import modle.Rack;

/**
 *
 * @author elshaar
 */
public class testRack {
    
    public static void main(String[] args) {
        Rack rack = new Rack();
        rack.printH();
        testSpin(rack);
    }
    
    static byte testMod(byte x, byte y){
        x = (byte) (x%y);
        if(x>-1) return x;
        else return (byte) (x+y);
    }
    
    static void testSpin(Rack rack){
        Scanner scanner = new Scanner(System.in);
        rack.setPlanCharacter('a');
        System.out.println("\nplan character: "+'a'+"  "+rack.getIndexOfCharacter('a'));
        while(true){
            System.out.print("spin: ");
            byte spin = scanner.nextByte();
            System.out.println(rack.spin(spin));
        }
    }
    
}
