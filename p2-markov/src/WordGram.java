import java.util.*;

/**
 * A WordGram object represents an immutable
 * sequence of words.
 * For use in Compsci 201, Duke University, Fall 2022
 * Add yourself as an author when you make edits
 * @author Brandon Fain
 * @author Owen Astrachan, revised Fall 2023
 */

public class WordGram {
    private String[] myWords;   // Stores WordGram words
    private String myToString;  // Stores space separated words as one string
    private int myHash;         // Stores hash value of WordGram

   
    /**
     * Constructor should generate a WordGram with size words
     * beginning at the start index value of source array.
     * Each element of source array should be a single word.
     * @param source Source array, each element should be a single word
     * @param start Index of first word for WordGram object
     * @param size Number of elements in WordGram object
     */
    public WordGram(String[] source, int start, int size) {
        // TODO correctly implement constructor
        myToString = null;
        myHash = 0;
        myWords = new String[size];
   
        for(int i=0; i < size; i++) {
            myWords[i] = source[start+i];
        }
    }

    /**
     * Returns number of words in this WordGram
     * @return order of wordgram, number of words
     */
    public int length() {
        // TODO correctly implement length
        return myWords.length;
    }


    /**
     * Returns true if o is also a wordgram with the
     * same words, otherwise returns false
    */
    @Override
    public boolean equals(Object o) {
        if (! (o instanceof WordGram) || o == null){
            return false;
        }
        WordGram other = (WordGram) o;
        // TODO complete correct implementation of equals (above is correct)
        if(! (this.length() == other.length())){
            return false;
        }
        for (int i=0; i<  this.length(); i++){
            if(!this.myWords[i].equals(other.myWords[i]))
            {
                return false;
            }
        }
        return true;
    }

    /**
     * Returns a hashCode for WordGram object equal to
     * the hashCode of the space separated words stored in
     * the WordGram.
     */
    @Override
    public int hashCode() {
        // TODO correctly implement hashCode
        if(myHash == 0){
            myHash = this.toString().hashCode();
        }
        return myHash;
    }


    /**
     * Return a new WordGram of the same length as this WordGram
     * consisting of words 1 through length-1 of this WordGram
     * followed by last. Does NOT mutate this WordGram.
     * @param last added as last string of returned WordGram
     * Should be a single word
     * @return new WordGram
     */
    public WordGram shiftAdd(String last) {
        // TODO correctly implement shiftAdd
        WordGram wg = new WordGram(myWords, 0, length());
        int i;
        for(i=0; i < myWords.length - 1; i++){
            wg.myWords[i] = wg.myWords[i+1];
        }
        wg.myWords[i] = last;
        return wg;
    }


    /**
     * Returns space separated words stored in the WordGram
     * as a single String.
     */
    @Override
    public String toString() {
        // TODO correctly implement toString
        if(myToString == null){
            myToString = String.join(" ", myWords);
        }
        return myToString;
    }
}