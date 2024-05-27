import java.sql.*;
import java.util.*;

public class HashMarkov implements MarkovInterface {

    protected String[] myWords;     // Training text split into array of words 
    protected Random myRandom;      // Random number generator
    protected int myOrder;          // Length of WordGrams used
    protected static String END_OF_TEXT = "*** ERROR ***"; 

    protected HashMap<WordGram, ArrayList<String>> myMap;

    public HashMarkov(){
        this(3);
        myMap = new HashMap<WordGram, ArrayList<String>>(); 
    }

    public HashMarkov(int order){
        myOrder = order;
        myRandom = new Random();
        myMap = new HashMap<WordGram, ArrayList<String>>();
    }

    @Override
    public void setTraining(String text) {
        // TODO Auto-generated method stub
        myWords = text.split("\\s+");
        myMap.clear();

        int max = myWords.length - myOrder;
        for(int i = 0; i <= max; i++){
            WordGram wg = new WordGram(myWords, i, myOrder);
            
            if(! myMap.containsKey(wg)){
                myMap.put(wg, new ArrayList<String>());
            }

            if(i < max){
                myMap.get(wg).add(myWords[i + myOrder]);
            }
        }
       // throw new UnsupportedOperationException("Unimplemented method 'setTraining'");
    }

    @Override
    public List<String> getFollows(WordGram wgram) {
        // TODO Auto-generated method stub
        List <String> follows = new ArrayList<>();

        if(!myMap.containsKey(wgram)){ 
            throw new UnsupportedOperationException("Unimplemented method 'getFollows'");
        }
        return myMap.get(wgram);
    }

    private String getNextWord(WordGram wgram) {
        List<String> follows = getFollows(wgram);

        if (follows.size() == 0) {
            return "";
        }

        else {
            int randomIndex = myRandom.nextInt(follows.size());
            return follows.get(randomIndex);
        }
    }
    @Override
    public String getRandomText(int length) {
        // TODO Auto-generated method stub
       // throw new UnsupportedOperationException("Unimplemented method 'getRandomText'");
       ArrayList<String> randomWords = new ArrayList<>(length);

       int index = myRandom.nextInt(myWords.length - myOrder + 1);

       WordGram wg = new WordGram(myWords,index,myOrder);

       randomWords.add(wg.toString());

       for(int i=0; i < length-myOrder; i++) {
           String nextWord = getNextWord(wg);
           if (nextWord.equals("")) {
               break;
           }
           randomWords.add(nextWord);
           wg = wg.shiftAdd(nextWord);
       }
       return String.join(" ", randomWords);
    }

    @Override
    public int getOrder() {
        // TODO Auto-generated method stub
        return myOrder;
        // throw new UnsupportedOperationException("Unimplemented method 'getOrder'");
    }

    @Override
    public void setSeed(long seed) {
        // TODO Auto-generated method stub
        myRandom.setSeed(seed);
        //throw new UnsupportedOperationException("Unimplemented method 'setSeed'");
    }
    
}