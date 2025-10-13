package org.skypro.skyshop;

import java.util.*;
import java.util.stream.Collectors;

public class SearchEngine {

    //Set
    private final Set<Searchable> items;

    public SearchEngine() {
        this.items = new HashSet<>();
    }

    //НОВЫЙ
    public void add(Searchable item) {
        items.add(item);
    }

    //ПОИСК
    private static final Comparator<Searchable> COMPARATOR = Comparator
            .comparingInt((Searchable s) -> s.getSearchTerm().length()).reversed()
            .thenComparing(Searchable::getSearchTerm);

    public Set<Searchable> search(String query) {
        String[] words = query.toLowerCase().split("\\s+");

        return items.stream()
                .filter(item -> Arrays.stream(words).allMatch(word -> {
                    String term = item.getSearchTerm().toLowerCase();

                    boolean inText = term.contains(word);
                    boolean inTags = (item instanceof Taggable)
                            && Arrays.stream(((Taggable) item).getTags())
                            .anyMatch(tag -> tag.toLowerCase().contains(word));

                    return inText || inTags;
                }))
                .collect(Collectors.toCollection(() -> new TreeSet<>(COMPARATOR)));
    }

    // Новый метод: поиск самого подходящего объекта
    public Searchable findBestMatch(String query) throws BestResultNotFound {
        if (query == null || query.isEmpty()) {
            throw new BestResultNotFound(query);
        }

        Searchable bestMatch = null;
        int maxCount = 0;

        for (Searchable item : items) {
            int count = countOccurrences(item.getSearchTerm().toLowerCase(), query.toLowerCase());

            if (count > maxCount) {
                maxCount = count;
                bestMatch = item;
            }
        }

        if (bestMatch == null) {
            throw new BestResultNotFound(query);
        }

        return bestMatch;
    }

    // Подсчёт вхождений подстроки
    private int countOccurrences(String text, String sub) {
        int count = 0;
        int index = 0;
        while ((index = text.indexOf(sub, index)) != -1) {
            count++;
            index += sub.length();
        }
        return count;


    }
}