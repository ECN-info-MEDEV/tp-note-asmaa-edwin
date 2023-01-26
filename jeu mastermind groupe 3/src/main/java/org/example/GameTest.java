package org.example;

import org.junit.Test;
import static org.junit.Assert.*;

public class GameTest {
    @Test
    public void testCodemakerTurn() {
        Game game = new Game(false);
        game.codemakerTurn();
        // Vérifiez que le code secret a bien été défini
        assertNotNull(game.secretCode);
        // Vérifiez que le code secret contient 4 éléments
        assertEquals(4, game.secretCode.length);
    }
    
    @Test
    public void testCodebreakerTurn() {
        Game game = new Game(true);
        game.codemakerTurn();
        game.codebreakerTurn();
        // Vérifiez que le score du Codebreaker est correctement incrémenté lorsqu'il a deviné le code secret
        assertEquals(1, game.score[0]);
        // Vérifiez que la partie est terminée lorsqu'il a deviné le code secret
        assertTrue(game.gameOver);
    }
    
    @Test
    public void testPlay() {
        Game game = new Game(true);
        game.play();
        // Vérifiez que la méthode codebreakerTurn() est appelée lorsque le joueur est le Codebreaker
        assertEquals(1, game.score[0]);
        game = new Game(false);
        game.play();
        // Vérifiez que la méthode codemakerTurn() est appelée lorsque le joueur est le CodeMaker
        assertNotNull(game.secretCode);
    }
}
