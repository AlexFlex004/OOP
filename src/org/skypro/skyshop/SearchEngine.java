package org.skypro.skyshop;

public class SearchEngine {

    private final Searchable[] items;
    private int size;

    public SearchEngine(int capacity) {
        this.items = new Searchable[capacity];
        this.size = 0;
    }

    // Добавление нового объекта
    public void add(Searchable item) {
        if (size < items.length) {
            items[size++] = item;
        } else {
            System.out.println("Массив переполнен, добавить нельзя!");
        }
    }

    // Поиск всех подходящих (до 5 результатов)
    public Searchable[] search(String query) {
        Searchable[] results = new Searchable[5];
        int count = 0;

        String[] words = query.toLowerCase().split("\\s+");

        for (int i = 0; i < size; i++) {
            String term = items[i].getSearchTerm().toLowerCase();
            String[] tags = items[i].getTags();

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
                results[count++] = items[i];
                if (count == 5) break;
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

        for (int i = 0; i < size; i++) {
            Searchable item = items[i];
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
