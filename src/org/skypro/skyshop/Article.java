package org.skypro.skyshop;

public class Article implements Searchable {
    private String artclName;
    private String artclText;

    public Article (String artclName, String artclText) {
        this.artclName = artclName;
        this.artclText = artclText;
    }

    /// GETTERS ///
    public String getArtclName() {
        return artclName;
    }

    public String getArtclText() {
        return artclText;
    }



    @Override
    public String toString() {
        return artclName + "\n" + artclText;
    }

    @Override
    public String getSearchTerm() {
        return toString();
    }

    @Override
    public String getContentType() {
        return "ARTICLE";
    }

    @Override
    public String getName() {
        return artclName;
    }

}
