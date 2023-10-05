package org.example;
/*
@ This class deines the strucure for index document
Author :Mingwei Shi
 */
import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.document.StringField;
import org.apache.lucene.document.TextField;
import org.apache.lucene.index.DirectoryReader;
import org.apache.lucene.index.IndexReader;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.queryparser.classic.MultiFieldQueryParser;
import org.apache.lucene.queryparser.classic.ParseException;
import org.apache.lucene.queryparser.classic.QueryParser;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.search.TopDocs;
// 1
import org.apache.lucene.search.similarities.BM25Similarity;
// 2
import org.apache.lucene.search.similarities.ClassicSimilarity;
//3
import org.apache.lucene.search.similarities.LMDirichletSimilarity;
// 4
import org.apache.lucene.search.similarities.LMJelinekMercerSimilarity;
//5
import org.apache.lucene.search.similarities.BooleanSimilarity;
//6
import org.apache.lucene.search.similarities.MultiSimilarity;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;
import org.apache.lucene.store.MMapDirectory;
import org.example.MyIndexer;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.DecimalFormat;
import java.util.*;
import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.Option;

/*

Optimise:

1 Synomonous dictory/Corpus
2  Using cryptgraph algorithm to encode the document ID
For example: Elias_delta decoding
3 Add the concurrency
 */

/*
@ This class deines the strucure for index document
Author :Mingwei Shi
 */

/*

    The analyzer selected: Standard and customised analyzer that could process large stop words

    2 option

    Query parser field selected 6 combination

    6 option

    Simiarity matching :

    // 1
    import org.apache.lucene.search.similarities.BM25Similarity;
    // 2
    import org.apache.lucene.search.similarities.ClassicSimilarity;
    //3
    import org.apache.lucene.search.similarities.LMDirichletSimilarity;
    // 4
    import org.apache.lucene.search.similarities.LMJelinekMercerSimilarity;

    4 Option


The total experiemnt: 2 * 6 * 4 = 48 experim,emt

 */
public class Main {
    // Global variable
    public static final String CRAND_1400_ADDRESS = "./ExternalFile/cran.all.1400";

    public static final String CRAND_QRY_ADDRESS = "./ExternalFile/cran.qry";
    public static  final String LARGE_STOPWORD_ADDRESS_173STOPWORDS = "SelfDefienStopWord/173Stopwords.txt";
    public static  final String LARGE_STOPWORD_ADDRESS_495STOPWORDS = "SelfDefienStopWord/495Stopwords.txt";
    public static final  String DIRTORY_ADDRESS = "./dir";
    private static final int NUMBER_DOCUMENT_QUERY = 50;
    private static String MYOUTPUT_FILE_DIRECTORY = "./output";

    public static void main(String[] args) throws IOException, ParseException {

        String asciiArt =
                "                                                                                                                                                                                                                     \n" +
                        "                                                                                                                                                                                                                     \n" +
                        "                //   ) )                                     //   / /                             //   ) )                                                 //   / /                                                 \n" +
                        " \\\\  \\\\  \\\\    //         __      ___       __      ___   / //___  ( ) //  ___      ___   /      ((         ___      ___      __      ___     / __        //____      __      ___     ( )   __      ___     // // // \n" +
                        "  >>  >>  >>  //        //  ) ) //   ) ) //   ) ) //   ) / / ___  / / // //___) ) //   ) /         \\\\     //___) ) //   ) ) //  ) ) //   ) ) //   ) )    / ____    //   ) ) //   ) ) / / //   ) ) //___) ) << << <<  \n" +
                        " //  //  //  //        //      //   / / //   / / //   / / //     / / // //       //   / /            ) ) //       //   / / //      //       //   / /    //        //   / / ((___/ / / / //   / / //         \\\\ \\\\ \\\\ \n" +
                        "            ((____/ / //      ((___( ( //   / / ((___/ / //     / / // ((____   ((___/ /      ((___ / / ((____   ((___( ( //      ((____   //   / /    //____/ / //   / /   //__   / / //   / / ((____                ";

        System.out.println(asciiArt);
      //  PrintWriter myWriter = new PrintWriter(MYOUTPUT_FILE, "UTF-8");

        System.out.println("------------Starting parsing the crandfile file------------ ");


        MyIndexer myIndex = new MyIndexer(CRAND_1400_ADDRESS);

        myIndex.parser_and_store();


        List<CranfildStructure> mycurrentCrandList = myIndex.getGlobal_myCrandFile();
        // Creat document
        List<Document> documentList = new ArrayList<>();


        // 2 Create index
        for (int i = 0; i < mycurrentCrandList.size(); i++) {
            // curent separte
            Document tempD = new Document();
            // creat field object
            String tempId = mycurrentCrandList.get(i).getId();
            String tempTitle = mycurrentCrandList.get(i).getTitle();
            String tempAuthor = mycurrentCrandList.get(i).getAuthor();
            String tempBibliography = mycurrentCrandList.get(i).getBibliography();
            String tempDesciption = mycurrentCrandList.get(i).getDescription();

            tempD.add(new StringField("id", tempId, Field.Store.YES));
            tempD.add(new TextField("Tittle", tempTitle, Field.Store.YES));
            tempD.add(new StringField("Author", tempAuthor, Field.Store.YES));
            tempD.add(new StringField("Bibliography", tempBibliography, Field.Store.YES));
            tempD.add(new TextField("Desciption", tempDesciption, Field.Store.YES));


            documentList.add(tempD);
        }

        // Query parser
        queryParser myqueryPaser = new queryParser(CRAND_QRY_ADDRESS);

        myqueryPaser.parser_and_store();
        HashMap<String, String> myQueryDescirption_findedByID = myqueryPaser.getGlobalContent();
        List<String> myQueryIDsequence = myqueryPaser.getQueryIdList();


        System.out.println("------------Starting parsing the query file------------ ");


/*

Configuation
 */
        Analyzer myAnalyzer = null;
        String analyzerTag = null;
        for(int analyzerindex = 0 ;analyzerindex <3;analyzerindex++)
        {
            System.out.println("There are two types of analyzers and we use number to refer them"+"\n"+
                    "0 for Standard analyzer; 1 for Customised analyzer");
            if(analyzerindex == 0)
            {
                myAnalyzer =  new StandardAnalyzer();
                analyzerTag = "a1";
            }
            if(analyzerindex == 1){
                myAnalyzer =  new Stopremoval_173CustomisedAnalyzer();
                analyzerTag = "a2";

            }
            if(analyzerindex == 2){
                myAnalyzer =  new Stopremoval_495CustomisedAnalyzer();
                analyzerTag = "a3";

            }
            System.out.println("Starting indexing ");
            IndexWriterConfig myWriterconfig = new IndexWriterConfig(new StandardAnalyzer());
            myWriterconfig.setSimilarity(new BM25Similarity());
            Path myindexPath = Paths.get(DIRTORY_ADDRESS);
            Directory indexDir = FSDirectory.open(myindexPath);
            // Overwrite seveearl times
            myWriterconfig.setOpenMode(IndexWriterConfig.OpenMode.CREATE);
            IndexWriter indexWriter = new IndexWriter(indexDir, myWriterconfig);

            // add document to the index
            indexWriter.addDocuments(documentList);

            indexWriter.close();
            indexDir.close();
            System.out.println("Finishing indexing ");

            Directory mydircotry = FSDirectory.open(myindexPath);
            DirectoryReader mydirReader = DirectoryReader.open(mydircotry);
            IndexSearcher searcher = new IndexSearcher(mydirReader);
            String simialirtyMatchingAlgorithmTag = null;
            for(int simialirtyMatchingIndex = 0 ;simialirtyMatchingIndex<3;simialirtyMatchingIndex++)
            {
                System.out.println("Staring select simialrity ");
                System.out.println("There are 3 types of simlairty matching and we use number to refer them");


                /*

import org.apache.lucene.search.similarities.LMDirichletSimilarity;
// 4
import org.apache.lucene.search.similarities.LMJelinekMercerSimilarity;
 */
                System.out.println(
                        "0 for Vector space"+"\n"+
                        "1 for BM25 "+"\n"+
                        "2 for LMDirichletSimilarity ");

                // set searcher here

                if(simialirtyMatchingIndex==0)
                {
                    simialirtyMatchingAlgorithmTag = "s1";
                    searcher.setSimilarity(new ClassicSimilarity());
                    System.out.println("Current simialrity  is Vector space");
                }
                if(simialirtyMatchingIndex==1)
                {
                    simialirtyMatchingAlgorithmTag = "s2";
                    searcher.setSimilarity(new BM25Similarity());
                    System.out.println("Current simialrity  is BM25");
                }
                if(simialirtyMatchingIndex==2)
                {
                    simialirtyMatchingAlgorithmTag = "s3";
                    searcher.setSimilarity(new LMDirichletSimilarity());
                    System.out.println("Current simialrity  is LMDirichletSimilarity");
                }

                System.out.println("Finishing select simialrity !");

                  /*
    fEATURE
        Please cross vailaition here
        3 Varaible has impact on research resutls have 9 permusation and we need to deelte the
        dublcoat such as title ,big same as
           1  Title

           3 Abstruct



           7  Title + Abstruct

                       tempD.add(new StringField("id", tempId, Field.Store.YES));
            tempD.add(new StringField("Tittle", tempTitle, Field.Store.YES));
            tempD.add(new StringField("Author", tempAuthor, Field.Store.YES));
            tempD.add(new TextField("Bibliography", tempBibliography, Field.Store.YES));
            tempD.add(new TextField("Desciption", tempDesciption, Field.Store.YES));
         */
                String constant_title = "Tittle";
                String constant_bibi = "Bibliography";
                String constant_descir = "Desciption";
                float weightForTittle = 0.2f;

                float weightForDescr =1.1f;
                System.out.println("There are 3 types of feature combination and we use number to refer them");
                String featureTag = null;
                System.out.println("1. Title");
                System.out.println("2. Abstract");
                System.out.println("3. Title + Abstract ");
                System.out.println("Here is the weight for each feature");

                System.out.println("Title for 0.2f");
                System.out.println("Desciption for =1.1f");
                String [] Feature1_CONSTANT_TITLE_FEATURE = new String []{constant_title};
               // String [] Feature2_CONSTANT_BIBI_FEATURE =new String []{constant_bibi};
                String [] Feature2_CONSTANT_BIBI_FEATURE =new String [] {constant_descir};
             //   String []Feature4_CONSTANT_TITLE_BIBI_FEATURE =new String []{constant_title,constant_bibi};
                String []Feature3_CONSTANT_TITLE_DESC_FEATURE =new String []{constant_title,constant_descir};
               // String []Feature6_CONSTANT_BIBI_DESCI_FEATURE =new String []{constant_bibi,constant_descir};
               // String []Feature7_CONSTANT_ALL_THREE_FEATURE =new String []{constant_title,constant_bibi,constant_descir};

                System.out.println("Starting select feature");
                QueryParser parser_single_mutiple = null;
                for(int featureIndex  = 0 ;featureIndex<3;featureIndex++)
                {
                    switch (featureIndex){
                        case 0:
                            parser_single_mutiple = new QueryParser(constant_title, myAnalyzer);
                            parser_single_mutiple.setAllowLeadingWildcard(true);
                            featureTag = "f1";
                            System.out.println("We select  title only");
                            break;
                        case 1:
                            parser_single_mutiple = new QueryParser(constant_descir, myAnalyzer);
                            parser_single_mutiple.setAllowLeadingWildcard(true);
                            featureTag = "f2";
                            System.out.println("We select  descript only");
                            break;

                        case 2:
                            Map<String, Float> bootssetting3 = new HashMap<>();
                            bootssetting3.put(constant_title,weightForTittle);
                            bootssetting3.put(constant_descir,weightForDescr);
                            parser_single_mutiple = new MultiFieldQueryParser(Feature3_CONSTANT_TITLE_DESC_FEATURE, myAnalyzer,bootssetting3);

                            parser_single_mutiple.setAllowLeadingWildcard(true);
                            featureTag = "f3";
                            System.out.println("We select  all two title descirption_ combination");

                        default:
                            System.out.println("Invalid selection");
                            break;
                    }

                    System.out.println("Finishing   feature selection");


                    String hyphenS = "-";
                    String saveFileAddress = MYOUTPUT_FILE_DIRECTORY+analyzerTag+hyphenS+simialirtyMatchingAlgorithmTag+hyphenS+featureTag+".txt";
                    FileWriter fileWriter = new FileWriter(saveFileAddress);
                    int curentQueryNumber = 1;
                    for (int i = 0; i < myQueryIDsequence.size(); i++) {
                        String tempId = myQueryIDsequence.get(i);
                        String querytempDescription = myQueryDescirption_findedByID.get(tempId);
                        Query qry = parser_single_mutiple.parse(querytempDescription);

                        ScoreDoc[] mydocHit = searcher.search(qry, NUMBER_DOCUMENT_QUERY).scoreDocs;

                        for (ScoreDoc cuurenthit : mydocHit) {
                            Document doc = searcher.doc(cuurenthit.doc);
                            String zeroTage =  " 0 ";
                            String EXPTag = " RANDOM";
                            // String outputString = String.format("%03d", curentQueryNumber) + zeroTage + doc.get("id") + zeroTage
                            //        + cuurenthit.score + EXPTag;
                            String formatOutput = String.format(
                                    "%3d 0 %s 0 %f RANDOM",curentQueryNumber,doc.get("id"),cuurenthit.score);

                            System.out.println(formatOutput);
                            fileWriter.write(formatOutput + System.lineSeparator());



                        }
                        curentQueryNumber++;

                    }

                    fileWriter.close();
                    //mydirReader.close();
                     //mydircotry.close();
                }


            }

        }
       // mydirReader.close();
        //mydircotry.close();
        /*
        Path indexPath = Paths.get(DIRTORY_ADDRESS);


        IndexWriterConfig myWriterconfig = new IndexWriterConfig(new StandardAnalyzer());
        myWriterconfig.setSimilarity(new BM25Similarity());

        Directory indexDir = FSDirectory.open(indexPath);
        myWriterconfig.setOpenMode(IndexWriterConfig.OpenMode.CREATE);
        IndexWriter indexWriter = new IndexWriter(indexDir, myWriterconfig);

        // add document to the index
        indexWriter.addDocuments(documentList);

        indexWriter.close();
        indexDir.close();

        Directory mydircotry = FSDirectory.open(indexPath);
        DirectoryReader mydirReader = DirectoryReader.open(mydircotry);
        IndexSearcher searcher = new IndexSearcher(mydirReader);
        searcher.setSimilarity(new BM25Similarity());


        MultiFieldQueryParser queryParser = new MultiFieldQueryParser(new String[] {  "Tittle",  "Bibliography", "Desciption" },new StandardAnalyzer());


        queryParser.setAllowLeadingWildcard(true);

        FileWriter fileWriter = new FileWriter("output/resultssss.txt");
        int curentQueryNumber = 1;

         */
        /*
        for (int i = 0; i < myQueryIDsequence.size(); i++) {
            String tempId = myQueryIDsequence.get(i);
            String querytempDescription = myQueryDescirption_findedByID.get(tempId);
            Query qry = queryParser.parse(querytempDescription);

            ScoreDoc[] topHits = searcher.search(qry, 10).scoreDocs;

            for (ScoreDoc hit : topHits) {
                Document doc = searcher.doc(hit.doc);
                String zeroTage =  " 0 ";
                String outputString = String.format("%03d", curentQueryNumber) + zeroTage + doc.get("id") + zeroTage
                        + hit.score + " RANDOM";
                System.out.println(outputString);
                fileWriter.write(outputString + System.lineSeparator());



            }
            curentQueryNumber++;

        }

        fileWriter.close();
            mydirReader.close();
           mydircotry.close();

         */
    }

}