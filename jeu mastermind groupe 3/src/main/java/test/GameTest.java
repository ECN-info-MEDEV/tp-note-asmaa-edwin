package org.example;

import org.junit.Test;
import static org.junit.Assert.*;

public class GameTest {
    @Test
    public void testCodemakerTurn() {
        Game game = new Game(false);
        game.codemakerTurn();
        // Vérifiez que le code secret a bien été défini
        assertNotNull(game.getSecretCode());
        // Vérifiez que le code secret contient 4 éléments
        assertEquals(4, game.getSecretCode().length);
    }
    
    @Test
    public void testCodebreakerTurn() {
        Game game = new Game(true);
        game.codemakerTurn();
        game.codebreakerTurn();
        // Vérifiez que le score du Codebreaker est correctement incrémenté lorsqu'il a deviné le code secret
        assertEquals(1, game.getScore());
        // Vérifiez que la partie est terminée lorsqu'il a deviné le code secret
        assertTrue(game.isGameOver());
    }
    
    @Test
    public void testPlay() {
        Game game = new Game(true);
        game.play();
        // Vérifiez que la méthode codebreakerTurn() est appelée lorsque le joueur est le Codebreaker
        assertEquals(1, game.getScore());
        game = new Game(false);
        game.play();
        // Vérifiez que la méthode codemakerTurn() est appelée lorsque le joueur est le CodeMaker
        assertNotNull(game.getSecretCode());
    }
    @Test
    public void testPlay_Codebreaker() {
        game.play();
        // Vérifier que la méthode codebreakerTurn() a été appelée
    }
    
    @Test
    public void testPlay_CodeMaker() {
        game = new Game(false);
        game.play();
        // Vérifier que la méthode codemakerTurn() a été appelée
    }

    @Test
    public void testCodebreakerTurn_success() {
        // Configurer l'état de la partie pour simuler une réussite
        boolean result = game.codebreakerTurn();
        Assert.assertTrue(result);
    }
    
}
