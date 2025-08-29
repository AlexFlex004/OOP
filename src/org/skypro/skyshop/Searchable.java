package org.skypro.skyshop;

import javax.swing.*;

public interface Searchable {
    String getSearchTerm();
    String getContentType();
    String getName();
    String[] getTags();

    default String getStringRepresentation() {
        return getName() + " — " + getContentType();
    }



}
