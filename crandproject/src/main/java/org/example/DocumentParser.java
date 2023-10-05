package org.example;
/*
@ This class deines the strucure for index document
Author :Mingwei Shi
 */
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class DocumentParser {



    public String getMyfilePath() {
        return myfilePath;
    }

    public void setMyfilePath(String myfilePath) {
        this.myfilePath = myfilePath;
    }

    private String myfilePath;

    public List<CranfildStructure> getGlobal_myCrandFile() {
        return global_myCrandFile;
    }

    public void setGlobal_myCrandFile(List<CranfildStructure> global_myCrandFile) {
        this.global_myCrandFile = global_myCrandFile;
    }

    private List<CranfildStructure>global_myCrandFile;


    public DocumentParser( String myfilePath)
    {
        this.myfilePath = myfilePath;
        List<CranfildStructure>global_myCrandFile =new ArrayList<>();
    }

    public void parser_and_store() throws IOException {

        List<String> allLines = Files.readAllLines(Paths.get(this.myfilePath));

        String whileSpaceEndOfSegment = "";
        int sizeofS = allLines.size();
        //  System.out.println(sizeofS);
        int indexC = 0;

        // Read all lines from the corpus
        List<String> lines = Files.readAllLines(Paths.get(this.myfilePath));

        // Initialise list of documents
        //ArrayList<Document> documents = new ArrayList<Document>();

        // Each document in the corpus has an index number, an author, a department (?) and an abstract
        // We need to iterate over the lines in the corpus correctly in order to generate our documents
        // Document currentDocument = null;
        String currentField = "";

        // A handful of documents have .A/.B/.W lines contained within the abstract field
        // These lines should be included in the abstract field rather than being treated as field separators
        boolean parsingAbstract = false;

        Path filePath = Paths.get(this.myfilePath);
        int counterForId = 0;
        /*
        String tempCurrentTitle = "";
        String tempCurrentAuthor = "";
        String tempCurrentBibliography ="";
        String tempCurrentDescription ="";
*/
        // Data structure for Cranfiled
        List<CranfildStructure>myCrandFiledStrucre = new ArrayList<>();

        while (indexC < sizeofS) {
            String currentStr = allLines.get(indexC);
/*
 if (currentStr.startsWith(".I")){
                System.out.println(counterForId);
                counterForId++;
                indexC++;
            }
 */
            //CranfildStructure tempCrandFiled = new CranfildStructure();
            String tempCurrentTitle = "";
            String tempCurrentAuthor = "";
            String tempCurrentBibliography ="";
            String tempCurrentDescription ="";
            if (currentStr.startsWith(".I")) {
                counterForId++;
                //   System.out.println(counterForId);
                if(counterForId ==282)
                {
                    int a= 3;
                }

                indexC++;

            }

            currentStr = allLines.get(indexC);
            if (currentStr.startsWith(".T")) {
                // first line of description
                indexC++;
                String contentTitle = "";
                // String nextLine =
                String prefixLine = "";
                Boolean controlForStr = false;
                do {
                    currentStr = allLines.get(indexC);//for stoping
                    contentTitle = contentTitle + " " + currentStr;

                    if(!currentStr.startsWith(".A"))
                    {
                        indexC++;
                    }
                    // indexC++;
                    // for later verification
                    currentStr = allLines.get(indexC);
                    prefixLine = currentStr.substring(0, 2);

                    controlForStr = (prefixLine.equals(".A")||currentStr.equals(""));


                } while (!controlForStr);

                if(contentTitle.equals(".A"))
                {
                    String blank = "";
                    //   System.out.println(blank);
                    tempCurrentTitle = blank;

                }
                else{
                    //   System.out.println(contentTitle);
                    tempCurrentTitle = contentTitle;
                }

                //  System.out.println(contentTitle);

                //indexC-=1;
            }
            currentStr = allLines.get(indexC);
            //System.out.println(indexC);

            if (currentStr.startsWith(".A")) {
                // first line of description
                indexC++;
                String contentAuthor= "";
                // String nextLine =
                String prefixLine = "";
                Boolean controlForStr = false;
                do {
                    currentStr = allLines.get(indexC);//for stoping
                    contentAuthor = contentAuthor  + currentStr;
                    if(!currentStr.startsWith(".B"))
                    {
                        indexC++;
                    }

                    // for later verification
                    currentStr = allLines.get(indexC);
                    prefixLine = currentStr.substring(0, 2);

                    controlForStr = (prefixLine.equals(".B")||currentStr.equals(""));


                } while (!controlForStr);

                if(contentAuthor.equals(".B"))
                {
                    String blank = "";
                    //  System.out.println(blank);
                    //  tempCurrentTitle = blank;
                    tempCurrentAuthor = blank;

                }
                else{
                    // System.out.println(contentAuthor);
                    tempCurrentAuthor = contentAuthor;

                }
                //  System.out.println(contentAuthor);

                //indexC-=1;
            }


            currentStr = allLines.get(indexC);
            //   System.out.println(indexC);

            if (currentStr.startsWith(".B")) {
                // first line of description
                indexC++;
                String contentB = "";
                // String nextLine =
                String prefixLine = "";
                Boolean controlForStr = false;
                do {
                    // buG COMES FROM
                    currentStr = allLines.get(indexC);//for stoping
                    contentB = contentB + currentStr;
                    // judge another line
                    if(!currentStr.startsWith(".W"))
                    {
                        indexC++;
                    }

                    // for later verification
                    currentStr = allLines.get(indexC);
                    prefixLine = currentStr.substring(0, 2);

                    controlForStr = (prefixLine.equals(".W")||currentStr.equals(""));


                } while (!controlForStr);

                if(contentB.equals(".W"))
                {
                    String blank = "";
                    //  System.out.println(blank);
                    tempCurrentBibliography = blank;

                }
                else{
                    // System.out.println(contentB);
                    tempCurrentBibliography = contentB;
                }

                //System.out.println( contentB);


            }

            currentStr = allLines.get(indexC);
            if (currentStr.startsWith(".W")) {
                // first line of description
                indexC++;
                String contentW = "";
                // String nextLine =
                String prefixLine = "";
                Boolean controlForStr = false;
                currentStr = allLines.get(indexC);
                if(currentStr.equals("")||currentStr.startsWith(".I"))
                {

                }
                else{

                    if(counterForId ==1400)
                    {

                        do{
                            currentStr = allLines.get(indexC);//for stoping
                            // NEED TO be sorted out
                            contentW = contentW  + currentStr;
                            if(indexC ==39410)
                            {
                                controlForStr =true;
                            }
                            else{
                                indexC++;
                                // for later verification
                                currentStr = allLines.get(indexC);
                                prefixLine = currentStr.substring(0, 2);

                                controlForStr = (prefixLine.equals(".I") || currentStr.equals(""));

                            }


                        } while (!controlForStr);
                        indexC++;
                    }
                    else{

                        do {
                            currentStr = allLines.get(indexC);//for stoping
                            // NEED TO be sorted out
                            contentW = contentW  + currentStr;
                            indexC++;
                            // for later verification
                            currentStr = allLines.get(indexC);
                            prefixLine = currentStr.substring(0, 2);

                            controlForStr = (prefixLine.equals(".I") || currentStr.equals(""));


                        } while (!controlForStr);
                    }


                }

                if(contentW.equals(".I"))
                {
                    String blank = "";
                    // System.out.println(blank);
                    tempCurrentDescription = blank;

                }
                else{
                    // System.out.println(contentW);
                    tempCurrentDescription = contentW;
                }
                //  System.out.println( contentB);

            }

            CranfildStructure tempCrandFiled = new CranfildStructure();
            String tempId =String.valueOf(counterForId);
            tempCrandFiled.setId(tempId);
            tempCrandFiled.setTitle(tempCurrentTitle.trim());
            tempCrandFiled.setAuthor(tempCurrentAuthor.trim());
            tempCrandFiled.setBibliography(tempCurrentBibliography.trim());
            tempCrandFiled.setDescription(tempCurrentDescription.trim());


            myCrandFiledStrucre.add(tempCrandFiled);

        }

//Copy
        global_myCrandFile = new ArrayList<CranfildStructure>(myCrandFiledStrucre);
    }


}
