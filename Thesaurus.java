package proj5;


import java.util.Random;

/** THESAURUS CLASS
 * Data structure that holds words and their associated synonyms. You can look up a word and retrieve a synonym for it.
 *
 * @author Jordan An
 * @version 6/5/2020
 */
public class Thesaurus {
    private BST<String, GenericBag<String>> container;
    private LineReader lR;
    /**
     * Default constructor. Creates an empty thesaurus.
     */
    public Thesaurus(){
        container = new BST<>();
        lR = null;
    }


    /**
     * Builds a thesaurus from a text file. Each line of the text file is a comma-separated list of synonymous words. The first word in each line should be the thesaurus entry. The remaining words on that line are the list of synonyms for the entry.
     * @param file path to comma-delimited text file
     */
    public Thesaurus(String file){
        final int INIT_CAPA = 10;
        lR = new LineReader(file, ",");
        container = new BST<>();
        String[] line = lR.getNextLine();
        GenericBag<String> synonym;
        while (line != null) {
            if (container.find(line[0]) == null){
                synonym = new GenericBag<String>(INIT_CAPA);
                container.insert(line[0], synonym);
                contructorHelper(synonym, line);
            }
            else{
                synonym = container.find(line[0]);
                contructorHelper(synonym, line);
            }
            line = lR.getNextLine();
        }
    }

    private void contructorHelper(GenericBag<String> synonym, String[]line){
        String toAdd;
        for (int i = 1; i < line.length; i++){
            toAdd = line[i];
            toAdd = onlyAlphabet(toAdd);
            toAdd.toLowerCase();
            synonym.add(toAdd);
        }
    }
    /**
     * inserts entry and synonyms into thesaurus. If entry does not exist, it creates one. If it does exist, it adds the given synonyms to the entry's synonym list
     * @param entry keyword to be added
     * @param syns array of synonyms for keyword entry
     */
    public void insert(String entry, String[] syns){

        GenericBag<String> synonym;
        if (container.find(entry) == null){
            synonym = new GenericBag<>(10);
            container.insert(entry, synonym);
            insertHelper(synonym, syns);
        }
        else{
            synonym = container.find(entry);
            insertHelper(synonym, syns);
        }
    }

    /**
     * Insert Helper method, taking synonym from array unto a linked list
     * @param synonym The linked list of synonym
     * @param syns The array of synonym
     */
    private void insertHelper(GenericBag<String> synonym, String[] syns){
        for (String toAdd : syns){
            synonym.add(toAdd);
        }
    }
    /**
     * Removes entry (and its associated synonym list) from this thesaurus. If entry does not exist, do nothing.
     * @param entry word to remove
     */
    public void delete(String entry){
        if(container.find(entry) != null){
            container.remove(entry);
        }
    }


    /**
     * Gets a random synonym for the given keyword. If keyword does not exist, return the empty string.
     * @param keyword word to find a synonym for
     * @return a random synonym from the synonym list of that word, or empty string if keyword doesn't exist.
     */
    public String getSynonymFor(String keyword){
        if (container.find(keyword) != null){
            GenericBag<String> synonym = container.find(keyword);
            return synonym.grabRandom();
        }
        else{
            return "";
        }
    }


    /**
     * Get rid of non alphabetic charater in a string
     * @param s the string
     * @return the string with only alphabetic characters
     */
    private String onlyAlphabet(String s){
        return s.replaceAll("[^A-Za-z ]", "");
    }



    /**
     * Return this thesaurus as a printable string. Each keyword and synonym list should be on its own line. The format of each line is: <keyword> - {<syn1>, <syn2>, ..., <synN>}
     * For example,
     * happy - {glad, content, joyful}
     * jump - {leap, bound}
     *
     * The thesaurus keywords will be in alphabetical order. The order of the synonym list words is arbitrary.
     */
    public String toString(){
        return container.toString();
    }
}
