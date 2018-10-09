
package modle;

import java.util.Arrays;
import java.util.Collections;

/**
 *
 * @author elshaar
 */
public class Rack {
    
    private final Character[] characters;
    private final byte[] indexes;
    private Character character;
    private char encodedCharacter;
    private byte indexOfCharacter;
     private final char none =  (char)(Double.NaN);
    
    public Rack(){
        characters = new Character[26];
        indexes = new byte[26];
        fill();
        encodedCharacter = none;
        character = none;
        indexOfCharacter = (byte)none;
    }
    
    /**
     * set rack to spin to this characters. 
     * @param character
     */
    public void setCharacter(char character){
        character = Character.toLowerCase(character);
        this.character = character;
        indexOfCharacter = indexes[character-'a'];
    }
    
    /**
     * returns the character before the encryption of decryption. 
     * @return 
     */
    public char getCharacter(){
        return character;
    }
    
    /**
     * return the index of letter in the characters array.
     * @param character
     * @return 
     */
    public byte getIndexOfCharacter(char character){
        if(!Character.isLowerCase(character)) return (byte)none;
        return indexes[character-'a'];
    }
    
    /**
     * return the index of character.
     * @return 
     */
    public byte getIndexOfCharacter(){
        return indexOfCharacter;
    }
    
    /**
     * encode the letter by spin rack to specific row(indexOfCharacter), to get the encoded character.
     * @param indexOfCharacter
     * @return 
     */
    public char getCharacter(byte indexOfCharacter){
        if(indexOfCharacter < 0||indexOfCharacter>25) return none;
        return characters[indexOfCharacter];
    }
    
    /**
     * spin the rack by value.
     * @param value
     * @return 
     */
    public char spin(byte value){
        value = (byte) (indexOfCharacter+value);
        value = mod(value, (byte)26);
        //if(value==indexOfPlanCharacter) return none; /*it is spin return to the same chararcter*/
        encodedCharacter = characters[value];
        return encodedCharacter;
    }
    
    
    
    /**
     * print array content vertically.
     */
    public void printV(){
        for (int i = 0; i < 26; i++) System.out.println(String.format("%2d", i)+" "+characters[i]);
    }
    /**
     * print array content horizontalize.
     */
    public void printH(){
        for (int i = 0; i < 26; i++) System.out.print(String.format("%3d", i));
        System.out.println("");
        for (int i = 0; i < 26; i++) System.out.print(String.format("%3s", characters[i]));
        System.out.println("");
    }
    
    ///...private...\\\
    /**
     * characters array: fill with lower case characters.
     * shuffle the characters indexes randomly.
     * indexes array: fill with the indexes of each characters in characters array.
     */
    private void fill(){
        for (int i = 0; i < characters.length; i++) characters[i] = (char)('a'+i);
        Collections.shuffle(Arrays.asList(characters));
        for (byte i = 0; i < 26; i++) indexes[(byte)(characters[i]-'a')] = i;
    }
    
    private byte mod(byte x, byte y){
        x = (byte) (x%y);
        if(x>-1) return x;
        else return (byte) (x+y);
    }
  
    
    
}
