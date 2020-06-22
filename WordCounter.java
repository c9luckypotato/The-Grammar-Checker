package proj5;

/**
 * WORDCOUNTER CLASS
 * Class for computing word frequencies from a text file
 *
 * @author Jordan An
 * @version 6/5/2020
 */

public class WordCounter {

    private LineReader lR;
    private BST<String, Integer> frequency;
    /**
     * Default constructor
     */
    public WordCounter(){
        lR = null;
        frequency = new BST<String, Integer>();
    }

    /**
     * returns the frequency of the given word
     * @param word string to get the frequency of
     * @returnthe number of times word appears in the input file
     */
    public int getFrequency(String word){
        if(frequency.find(word) == null){
            return 0;
        }
        else {
            return frequency.find(word);
        }
    }

    /**
     * Computes frequency of each word in given file
     * @param file path to file, such as "src/input.txt"
     */
    public void findFrequencies(String file){
        lR = new LineReader(file, " ");
        String[] line = lR.getNextLine();

        while (line != null) {
            for (String word : line) {
                word = onlyAlphabet(word);
                word = word.toLowerCase();

                int counter = 0;
                if (frequency.find(word) == null) {
                    counter++;
                    frequency.insert(word, counter);
                }
                else{
                    counter = frequency.find(word);
                    counter++;
                    frequency.setDataAtKey(word, counter);
                }
            }
            line = lR.getNextLine();
        }
    }


    /**
     * Get rid of non alphabetic charater in a string
     * @param s the string
     * @return the string with only alphabetic characters
     */
    private String onlyAlphabet(String s){
        return s.replaceAll("[^A-Za-z]", "");
    }


    /**
     * returns words and their frequencies as a printable String. Each word/frequency pair should be on a separate line, and the format of each line should be <word>: <frequency>
     * For example,
     * are: 3
     * bacon: 2
     *
     * Words should be in alphabetical order.
     */
    public String toString(){
        return frequency.toString();
    }
}
