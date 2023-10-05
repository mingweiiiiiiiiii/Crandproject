package org.example;
/*
@ This class deines the strucure for index document
Author :Mingwei Shi
 */
import org.apache.lucene.analysis.*;
import org.apache.lucene.analysis.en.EnglishPossessiveFilter;
import org.apache.lucene.analysis.en.PorterStemFilter;
import org.apache.lucene.analysis.standard.StandardTokenizer;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Stopremoval_495CustomisedAnalyzer extends Analyzer {

    public static  final String LARGE_STOPWORD_ADDRESS_495STOPWORDS = "SelfDefienStopWord/495Stopwords.txt";




    @Override
    protected Analyzer.TokenStreamComponents createComponents(String fieldName) {
// The only abustrcut type could be extended by user
        ArrayList<String> myStopWordList = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(LARGE_STOPWORD_ADDRESS_495STOPWORDS))) {
            String line;

            // Read each line from the text file and add it to the ArrayList
            while ((line = reader.readLine()) != null) {
                myStopWordList.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


        StandardTokenizer mytokenizer = new StandardTokenizer();
        TokenStream stream = null;
        // Since lunence only process lowercase
        stream = new LowerCaseFilter(mytokenizer);
        //  Remove the possessive such as they've
        stream = new EnglishPossessiveFilter(stream);
        // Remove the stop word based on my list
        stream = new StopFilter(stream, new CharArraySet(myStopWordList, true));
        // Double fileter again
        stream = new PorterStemFilter(stream);
        // return
        return new Analyzer.TokenStreamComponents(mytokenizer, stream);

    }
}
