
package modle;

/**
 *
 * @author elshaar
 */
public class Decoder {
    
    private final Cylinder cylinder;
    private String cipherText;
    
    public Decoder(final Cylinder cylinder){
        this.cylinder = cylinder;
    }
    
    public String getCipherText(){
        return cipherText;
    }
    
    /**
     * decrypt the cipher text back to plan text again.
     * @param cipherText
     * @param spin
     * @return plan text
     */
    public String decode(final String cipherText, final byte spin){
        if(cipherText == null || "".equals(cipherText)) return null;
        this.cipherText = cipherText;
        final StringBuilder planText = new StringBuilder("");
        //.
        for (int i = 0; i < cipherText.length(); i++)
            planText .append( decode(cipherText.charAt(i), (byte) (i%cylinder.getNumberOfRacks()), spin));
        return planText.toString();
    }
    
    
    public char decode(final char character, final byte rackIndex, final byte spin){
        cylinder.getRacks()[rackIndex].setCharacter(character);
        return cylinder.getRacks()[rackIndex].spin((byte) (spin*-1));
    }
    
}
