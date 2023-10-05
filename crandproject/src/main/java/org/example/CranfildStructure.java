
package org.example;

/*
@ This class deines the strucure for index document
Author :Mingwei Shi
 */
public class CranfildStructure {



    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getBibliography() {
        return bibliography;
    }

    public String getDescription() {
        return description;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setBibliography(String bibliography) {
        this.bibliography = bibliography;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    private String id;
    private String title;

    private String author;

    private String bibliography;

    private  String description;
}
