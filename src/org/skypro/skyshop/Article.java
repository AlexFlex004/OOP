package org.skypro.skyshop;

import javax.swing.*;

import static java.awt.SystemColor.text;
import static jdk.javadoc.internal.doclets.formats.html.markup.HtmlStyle.title;

public final class Article implements Searchable {
    private String artclName;
    private String artclText;
    private final String[] tags;

    public Article (String artclName, String artclText, String tags) {
        this.artclName = artclName;
        this.artclText = artclText;
        this.tags = tags != null ? new String[]{tags} : new String[0];
    }

    /// GETTERS ///
    public String getArtclName() {
        return artclName;
    }

    @Override
    public String getSearchTerm() {
        return artclName + " " + artclName;
    }

    public String getArtclText() {
        return artclText;
    }


    @Override
    public String toString() {
        return artclName + "\n" + artclText + tags;
    }


    @Override
    public String getContentType() {
        return "ARTICLE";
    }

    @Override
    public String getName() {
        return artclName;
    }

    @Override
    public String[] getTags() {
        return tags;
    }

}
