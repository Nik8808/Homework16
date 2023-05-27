package ru.netology.javaqa;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class GameTest {
    @Test
    public void firstPlayerWins() {
        Player vita = new Player(1, "Витя", 10);
        Player kata = new Player(1, "Катя", 5);
        Game game = new Game();

        game.register(vita);
        game.register(kata);
        int actual = game.round("Витя", "Катя");
        int expected = 1;

        Assertions.assertEquals(expected, actual);
    }
    @Test
    public void secondPlayerWins() {
        Player vita = new Player(1, "Витя", 5);
        Player kata = new Player(1, "Катя", 6);
        Game game = new Game();

        game.register(vita);
        game.register(kata);
        int actual = game.round("Витя", "Катя");
        int expected = 2;

        Assertions.assertEquals(expected, actual);
    }
    @Test
    public void noOneWon() {
        Player vita = new Player(1, "Витя", 5);
        Player kata = new Player(1, "Катя", 5);
        Game game = new Game();

        game.register(vita);
        game.register(kata);
        int actual = game.round("Витя", "Катя");
        int expected = 0;

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void noFirstPlayer() {
        Player vita = new Player(1, "Витя", 5);
        Player kata = new Player(1, "Катя", 10);
        Game game = new Game();

        game.register(vita);
        game.register(kata);

        Assertions.assertThrows(NotRegisteredException.class,() -> game.round("Витя", "Толя"));
    }

    @Test
    public void noSecondPlayer() {
        Player vita = new Player(1, "Витя", 5);
        Player kata = new Player(1, "Катя", 10);
        Game game = new Game();

        game.register(vita);
        game.register(kata);

        Assertions.assertThrows(NotRegisteredException.class,() -> game.round("Вова", "Катя"));
    }
    @Test
    public void thereIsNoPlayer() {
        Player vita = new Player(1, "Витя", 5);
        Player kata = new Player(1, "Катя", 10);
        Game game = new Game();

        game.register(vita);
        game.register(kata);

        Assertions.assertThrows(NotRegisteredException.class,() -> game.round("Вова", "Катя"));
    }
}
