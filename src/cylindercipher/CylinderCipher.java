
package cylindercipher;

import java.util.Scanner;
import modle.*;


/**
 *
 * @author elshaar
 */
public class CylinderCipher {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //.
        System.out.print("number of racks: ");
        final byte numberOfRacks = scanner.nextByte();
        System.out.print("spin: ");
        final byte spin = scanner.nextByte();
        //.
        Cylinder cylinder = new Cylinder(numberOfRacks);
        cylinder.print();
        //.
        scanner = new Scanner(System.in);
        //.
        System.out.println("\nEncryption:- ");
        Encoder encoder = new Encoder(cylinder);
        System.out.print("Enter plan text: ");
        String planText = scanner.nextLine();
        System.out.println("cipher text: "+encoder.encrypt(planText, spin));
        //.
        System.out.println("\nDecryption:- ");
        Decoder decoder = new Decoder(cylinder);
        System.out.print("Enter cipher text: ");
        String cipherText = scanner.nextLine();
        System.out.println("plan text: "+decoder.decode(cipherText, spin));
    }
}
