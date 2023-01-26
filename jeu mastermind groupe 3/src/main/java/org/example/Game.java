package org.example;
import java.util.Scanner;

/**asmaa et edwin**/
public class Game {
    private static final int MAX_TURNS = 12;
    private static final String[] COLORS = {"yellow", "blue", "red", "green", "white", "black"};
    private static final int NUM_PEGS = 4;
    private int turns;
    private String[] secretCode;
    private int[] score;
    private boolean isCodebreaker;
    private boolean gameOver;

    public Game(boolean isCodebreaker) {
        this.isCodebreaker = isCodebreaker;
        this.score = new int[]{0, 0};
    }


    public void play() {
        if (isCodebreaker) {
            codebreakerTurn();
        } else {
            codemakerTurn();
        }
    }

    void codemakerTurn() {
        Scanner input = new Scanner(System.in);
        System.out.println("Entrez le code secret svp (choose from: " + String.join(", ", COLORS) + "): ");

        secretCode = new String[NUM_PEGS];
        for (int i = 0; i < NUM_PEGS; i++) {
            secretCode[i] = input.next();
        }

        System.out.println("The secret code has been set. The codebreaker will now try to guess it.");
    }

    boolean codebreakerTurn() {
        Scanner input = new Scanner(System.in);
        String[] guess = new String[NUM_PEGS];
        int blackPegs = 0;
        int whitePegs = 0;

        System.out.println("Enter your guess (choose from: " + String.join(", ", COLORS) + "): ");
        for (int i = 0; i < NUM_PEGS; i++) {
            guess[i] = input.next();
        }

        for (int i = 0; i < NUM_PEGS; i++) {
            if (guess[i].equals(secretCode[i])) {
                blackPegs++;
            } else {
                for (int j = 0; j < NUM_PEGS; j++) {
                    if (guess[i].equals(secretCode[j])) {
                        whitePegs++;
                        break;
                    }
                }
            }
        }
        System.out.println("Black pegs: " + blackPegs + ", White pegs: " + whitePegs);
        if (blackPegs == NUM_PEGS) {
            System.out.println("Congratulations, you've cracked the code!");
            score[0]++;
            gameOver = true;
        } else if (turns == MAX_TURNS) {
            System.out.println("Sorry, you've run out of turns. The secret code was: " + String.join(" ", secretCode));
            score[1]++;
            gameOver = true;
        }
        return false;
    }
}