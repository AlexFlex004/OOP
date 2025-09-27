package org.skypro.skyshop;

import javax.swing.*;

import java.util.Objects;

import static java.awt.SystemColor.text;
import static jdk.javadoc.internal.doclets.formats.html.markup.HtmlStyle.title;

public abstract class Article implements Searchable {
    private final String title;
    private final String[] tags;

    public Article(String title, String[] tags) {
        this.title = title;
        this.tags = tags;
    }

    @Override
    public String getSearchTerm() {
        return title;
    }

    @Override
    public String[] getTags() {
        return tags;
    }

    // equals и hashCode только по названию
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Article)) return false;
        Article article = (Article) o;
        return Objects.equals(title, article.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title);
    }
}
