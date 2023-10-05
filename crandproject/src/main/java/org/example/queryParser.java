package org.example;
/*
@ This class deines the strucure for index document
Author :Mingwei Shi
 */
import org.apache.lucene.search.Query;
import org.apache.lucene.queryparser.classic.QueryParser;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class queryParser {



    public HashMap<String, String> getGlobalContent() {
        return globalContent;
    }

    public void setGlobalContent(HashMap<String, String> globalContent) {
        this.globalContent = globalContent;
    }

    private HashMap<String,String>globalContent;


    public List<String> getQueryIdList() {
        return queryIdList;
    }

    private List<String>queryIdList;

    public String getMyfilePath() {
        return myfilePath;
    }



    public void setMyfilePath(String myfilePath) {
        this.myfilePath = myfilePath;
    }


    private String myfilePath;

    public queryParser(String myfilePath)
    {
        this.myfilePath = myfilePath;

        globalContent = new HashMap<>();
        queryIdList = new ArrayList<>();
    }

    public void parser_and_store() throws IOException
    {




        //  System.out.println(sizeofS);
        int indexC = 0;


        List<String> allLines = Files.readAllLines(Paths.get(this.myfilePath));
        int sizeofS = allLines.size();

        String currentField = "";

        boolean parsingAbstract = false;

        Path filePath = Paths.get(this.myfilePath);
        int counterForId = 0;

        //List<Pair<String,String> >myCrandFiledStrucre = new ArrayList<>();


        while (indexC < sizeofS) {
            String currentStr = allLines.get(indexC);

            String tempQueryID = null;
            //CranfildStructure tempCrandFiled = new CranfildStructure();
            String tempCurrentTitle = "";
            String tempCurrentAuthor = "";
            String tempCurrentBibliography ="";
            String tempCurrentDescription ="";
            if (currentStr.startsWith(".I")) {
                counterForId++;
                //   System.out.println(counterForId);

                // Start from 3
                indexC++;
                tempQueryID = currentStr.substring(3,currentStr.length());
                if(tempQueryID.equals("86"))
                {
                    int a = 2;
                }
              //  System.out.println(tempQueryID);

            }

           // currentStr = allLines.get(indexC);

            currentStr = allLines.get(indexC);
            if (currentStr.startsWith(".W")) {
                // first line of description
                indexC++;
                String contentW = "";
                // String nextLine =
                String prefixLine = "";
                Boolean controlForStr = false;
                currentStr = allLines.get(indexC);

                do {
                    currentStr = allLines.get(indexC);//for stoping
                    // NEED TO be sorted out
                    contentW = contentW  +" " +currentStr;
                    indexC++;
                    // for later verification
                    if(indexC == 918)
                    {
                        controlForStr = true;
                        indexC =1000;
                    }
                    else{
                        currentStr = allLines.get(indexC);
                        prefixLine = currentStr.substring(0, 2);

                        controlForStr = (prefixLine.equals(".I") || currentStr.equals(""));
                    }



                } while (!controlForStr);

                tempCurrentDescription = contentW;

            }

            /*
            System.out.println("TeSTING");

            System.out.println("Id   : " + counterForId);
            System.out.println("Ttile   : " + tempCurrentTitle);
            System.out.println("Author   : " + tempCurrentAuthor);

            System.out.println("Bibi   : " + tempCurrentBibliography);

            System.out.println("Absutr:    : " + tempCurrentDescription);
            System.out.println("One turn finished ---------------------");
*/




       //     System.out.println("ssssss");
            String trimString = tempCurrentDescription.trim();

            String mutipletString = trimString.replaceAll("\\?", "");
            String resultString = mutipletString.replaceAll("\\s+", " ");
/*


.I 086
.W
what is the available information pertaining to boundary layers on very
slender bodies of revolution in continuum flow (the ?transverse
curvature  effect) .
.I 087
.W
what is the available information pertaining to the effect of slight
rarefaction on boundary layer flows (the ?slip? effect) .
.I 093
.W

I need to remove the ? inside the sentence ;otherwise it throw error when using Lucence.

 */
            globalContent.put(tempQueryID,resultString);
            String findD = globalContent.get(tempQueryID);
            queryIdList.add(tempQueryID);
          //  System.out.println(findD);




           // myCrandFiledStrucre.add(tempCrandFiled);

        }
       // global_myCrandFile =new ArrayList<CrandQueryStructure>(myCrandFiledStrucre);

    }
}
