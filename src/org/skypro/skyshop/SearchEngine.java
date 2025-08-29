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

    // Поиск по строке
    public Searchable[] search(String query) {
        Searchable[] results = new Searchable[5];
        int count = 0;

        // Разбиваем строку поиска на слова
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

                // Если слово не найдено ни в тексте, ни в тегах — объект не подходит
                if (!(inText || inTags)) {
                    matches = false;
                    break;
                }
            }

            if (matches) {
                results[count++] = items[i];
                if (count == 5) break; // ограничиваем максимум 5 результатами
            }


        }

        return results;
    }
    }
