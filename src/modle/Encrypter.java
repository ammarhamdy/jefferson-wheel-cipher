
package modle;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author elshaar
 */
public class Encrypter {
    
    private final Cylinder cylinder;
    private String planText;

    
    public Encrypter(Cylinder cylinder){
        this.cylinder = cylinder;
    }
    
    public String getPlanText(){
        return planText;
    }
    
    public byte getNumberOfRacks(){
        return cylinder.getNumberOfRacks();
    }
    
    public String encrypt(String planText, byte spin){
        if(planText == null || "".equals(planText)) return null;
        this.planText = planText;
        //char cipherCharacter;
        Rack racks[] = cylinder.getRacks();
        byte index;
        byte iterator = 0;
        String cipherText = "";
        for (int i = 0; i < planText.length(); i++) 
            if(Character.isLowerCase(planText.charAt(i))) {
                index = (byte) (iterator%cylinder.getNumberOfRacks());
                racks[index].setPlanCharacter(planText.charAt(i));
                cipherText += racks[index].spin(spin);
                iterator++;
            }
        return cipherText; 
    }
    
    public char encrypt(char character, byte rackIndex, byte spin){
        cylinder.getRacks()[rackIndex].setPlanCharacter(character);
        return cylinder.getRacks()[rackIndex].spin(spin);
    }
        
    
    /**
     * return string ready to encrypt.
     * return the after remover any character expected lower case. 
     * @param chunk
     * @return 
     */
    public String filter(String chunk){
        final StringBuilder filteredChunk = new StringBuilder();
        for (int i = 0; i < chunk.length(); i++) if(Character.isLowerCase(chunk.charAt(i))) filteredChunk.append(chunk.charAt(i));
        return filteredChunk.toString();
    }
    
    /**
     * splits text to chunks each chunk in specific size(chunkSize).
     * chunk is the only characters lower case in text.
     * chunkSize must be at least one can not be zero or less.  
     * @param text
     * @param chunkSize
     * @return 
     */
    public List filter(String text, byte chunkSize){
        if (chunkSize<1) return null;
        List<String> list= new ArrayList<>();
        String filteredChunk = "";
        // loop: chunk.
        for (int i = 0; i < text.length(); i++) {
            if(Character.isLowerCase(text.charAt(i))) 
                filteredChunk += text.charAt(i);
            else continue;
            if(filteredChunk.length()%chunkSize==0){
                list.add(filteredChunk);
                filteredChunk="";
            }
        }
        if(filteredChunk.length()>0) list.add(filteredChunk);
        return list;
    }
    
    
}
