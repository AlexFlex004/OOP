package org.skypro.skyshop;

public interface Searchable {

    String getSearchTerm();


    String getContentType();


    int getPrice();

    int getFinalPrice();

    String[] getTags();


    default String getStringRepresentation() {
        return getSearchTerm() + " — " + getContentType();
    }
}

