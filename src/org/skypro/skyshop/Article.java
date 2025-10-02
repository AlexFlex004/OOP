package org.skypro.skyshop;

import java.util.Objects;

public class Article implements Searchable, Taggable {
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

    @Override
    public String getContentType() {
        return "Статья";
    }
}
