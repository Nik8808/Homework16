package ru.netology.javaqa;

public class NotRegisteredException extends RuntimeException {
    public NotRegisteredException(String playerName) {
        super("Игрока с именем" + playerName + "не найден");
    }
}

