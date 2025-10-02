package org.skypro.skyshop;

public interface Searchable {

    String getSearchTerm();


    String getContentType();






    default String getStringRepresentation() {
        return getSearchTerm() + " — " + getContentType();
    }
}

