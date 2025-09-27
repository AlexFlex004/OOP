package org.skypro.skyshop;

import java.util.*;

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
    public Set<Searchable> search(String query) {
        // Компаратор: сначала по длине имени (убывание), затем по алфавиту
        Comparator<Searchable> comparator = Comparator
                .comparingInt((Searchable s) -> s.getSearchTerm().length()).reversed()
                .thenComparing(Searchable::getSearchTerm);

        Set<Searchable> results = new TreeSet<>(comparator);

        String[] words = query.toLowerCase().split("\\s+");

        for (Searchable item : items) {
            String term = item.getSearchTerm().toLowerCase();
            String[] tags = item.getTags();

            boolean matches = true;

            for (String word : words) {
                boolean inText = term.contains(word);

                boolean inTags = false;
                for (String tag : tags) {
                    if (tag.toLowerCase().contains(word)) {
                        inTags = true;
                        break;
                    }
                }

                if (!(inText || inTags)) {
                    matches = false;
                    break;
                }
            }

            if (matches) {
                results.add(item);
            }
        }

        return results;
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