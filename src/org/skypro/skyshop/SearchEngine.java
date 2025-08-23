package org.skypro.skyshop;

public class SearchEngine {

    private final Searchable[] items;
    private int size;

    public SearchEngine(int capacity) {
        this.items = new Searchable[capacity];
        this.size = 0;
    }


    public void add(Searchable item) {
        if (size < items.length) {
            items[size++] = item;
        } else {
            System.out.println("Массив переполнен, добавить нельзя.");
        }
    }

    ///ПОИСК///
    public Searchable[] search(String query) {
        Searchable[] results = new Searchable[5];
        int count = 0;

        for (int i = 0; i < size; i++) {
            if (items[i].getSearchTerm().toLowerCase().contains(query.toLowerCase())) {
                results[count++] = items[i];
                if (count == 5) break;
            }
        }
        return results;
    }
}
