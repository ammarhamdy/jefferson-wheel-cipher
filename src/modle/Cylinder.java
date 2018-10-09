
package modle;

/**
 *
 * @author elshaar
 */
public class Cylinder {
    
    private final byte numberOfRack;
    private final Rack[] racks;

    public Cylinder(){
        this.numberOfRack = 10;
        racks = new Rack[numberOfRack];
        fill();
    }
    
    public Cylinder(byte numberOfRack){
        this.numberOfRack = numberOfRack;
        racks = new Rack[numberOfRack];
        fill();
    }
    
    public Rack getRack(final byte index){
        return racks[index];
    }

    public Rack[] getRacks(){
        return racks;
    }
    
    public byte getNumberOfRacks(){
        return numberOfRack;
    }
    
    /**
     * print racks characters as a table.
     */
    public void print(){
        System.out.println("Cylinder("+this.hashCode()+"):   "+numberOfRack+" racks");
        System.out.print("    ");
        for (int i = 0; i < numberOfRack; i++) System.out.print(i+"  ");
        System.out.println("");
        for (int i = 0; i < 26; i++) {
            System.out.print(String.format("%2d",i)+"  ");
            for (Rack rack : racks) System.out.print(rack.getCharacter((byte)i)+"  ");
            System.out.println("");
        }
    }
    
    ///...private...\\\
    /**
     * fill the racks array with racks. 
     */
    private void fill(){
        for (byte i = 0; i < numberOfRack; i++) racks[i] = new Rack();
    }
    
}
