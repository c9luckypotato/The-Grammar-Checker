package proj5;


/**
 * GRAMMARCHECKER CLASS
 * Uses a thesaurus and word frequencies to replace overused words in a text document with random synonyms.
 *
 * @author Jordan An
 * @version 6/5/2020
 */
public class GrammarChecker {

    private Thesaurus thesaurus;
    private WordCounter wC;
    private LineReader lR;
    private int limit;
    /**
     * Non-default constructor. Builds a thesaurus out of the given comma-separated file and sets the threshold for overused words
     * @param thesaurusFile path to comma-separated file used to build a thesaurus
     * @param threshold a word is considered "overused" if it appears more than (but not equal to) this many times in a text document
     */
    public GrammarChecker(String thesaurusFile, int threshold){
        thesaurus = new Thesaurus(thesaurusFile);
        limit = threshold;
        wC = new WordCounter();
        lR = null;
    }


    /**
     * Given a text file, replaces overused words with synonyms. Finished text is printed to the console.
     * @param textfile file with original text
     */
    public void improveGrammar(String textfile){
        lR = new LineReader(textfile, " ");
        wC.findFrequencies(textfile);
        String[] line = lR.getNextLine();

        while (line != null){
            for (String word : line){
                String stripWord = onlyAlphabet(word);
                stripWord = stripWord.toLowerCase();
                if (wC.getFrequency(stripWord) > limit) {
                    if (thesaurus.getSynonymFor(stripWord) == "") {
                        System.out.print(word + " ");
                    }
                    else {
                        String synonym = thesaurus.getSynonymFor(stripWord);
                        synonym = correctFormat(word, synonym);
                        System.out.print(synonym + " ");
                    }
                }
                else{
                    System.out.print(word + " ");
                }
            }
            System.out.println();
            line = lR.getNextLine();
        }

    }


    /**
     * Return the synonym in the correct format with punctuation
     * @param word the original word
     * @param newWord the synonym
     * @return the synonym after being formatted
     */
    private String correctFormat(String word, String newWord){
        String ans = "";

        int i =0;
        Character c = word.charAt(i);
        if (c.isLetter(c) && c.isUpperCase(c)){
            ans += newWord.substring(0,1).toUpperCase() + newWord.substring(1);
        }
        else if (c.isLetter(c)){
            ans += newWord;
        }

        // beginning punctuation
        while (!c.isLetter(c)){
            ans += c;
            i++;
            c = word.charAt(i);

            if (c.isUpperCase(c)){
                ans += newWord.substring(0,1).toUpperCase() + newWord.substring(1);
            }
        }

        //ending punctuation
        i = word.length() - 1;
        c = word.charAt(i);
        String endingPunc = "";
        while(!c.isLetter(c)){
            endingPunc += c;
            i--;
            c = word.charAt(i);
        }

        //reverse the ending punctuation we collected
        for (int j = endingPunc.length() - 1; j >= 0; j--){
            c = endingPunc.charAt(j);
            ans += c;
        }

        return ans;
    }


    /**
     * Get rid of non alphabetic charater in a string
     * @param s the string
     * @return the string with only alphabetic characters
     */
    private String onlyAlphabet(String s){
        return s.replaceAll("[^A-Za-z]", "");
    }


}
