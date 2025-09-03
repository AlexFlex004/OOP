package org.skypro.skyshop;

public class BestResultNotFound extends Exception {
    public BestResultNotFound(String search) {
        super("Не найден результат для поискового запроса: \"" + search + "\"");
    }
}
