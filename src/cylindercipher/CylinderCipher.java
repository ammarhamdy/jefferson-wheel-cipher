
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
        byte numberOfRacks = scanner.nextByte();
        //.
        Cylinder cylinder = new Cylinder(numberOfRacks);
        cylinder.print();
        Encrypter encrypter = new Encrypter(cylinder);
        //.
        scanner = new Scanner(System.in);
        System.out.print("Enter plan text: ");
        String planText = scanner.nextLine();
        System.out.print("spin: ");
        byte spin = scanner.nextByte();
        //.
        String cipherText = encrypter.encrypt(planText, spin);
        System.out.println("cipher text: "+cipherText);
    }
}
