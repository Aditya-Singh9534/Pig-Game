package com.aurionpro.pig;
import java.util.*;

public class PigDiceGame {
    public int totalScore;
    public int currentTurnScore;
    DiceRoller dice = new DiceRoller();

   
    public int getTotalScore() {
        return totalScore;
    }

    public int getCurrentTurnScore() {
        return currentTurnScore;
    }

    
    public void setTotalScore(int totalScore) {
        this.totalScore = totalScore;
    }

    public void setCurrentTurnScore(int currentTurnScore) {
        this.currentTurnScore = currentTurnScore;
    }


    public void startGame() {
    	totalScore=0;
        currentTurnScore=0;
        int turnsPlayed = 0;
        System.out.println("Let's Play the Pig Dice Game!\n");

        while (getTotalScore() < 20) {
            turnsPlayed++;
            System.out.println("TURN " + turnsPlayed);

            while (true) {
            	Scanner sc = new Scanner(System.in);
                System.out.print("Roll the dice or hold? (r/h): ");
                String choice = sc.next();

                if (choice.equalsIgnoreCase("r")) {
                    int diceRoll = dice.rollDice();
                    System.out.println("You rolled a " + diceRoll);

                    if (diceRoll == 1) {
                        System.out.println("Turn over. No points earned.\n");
                        setCurrentTurnScore(0);
                        break;
                    } else {
                        setCurrentTurnScore(getCurrentTurnScore() + diceRoll);
                    }
                } else if (choice.equalsIgnoreCase("h")) {
                    setTotalScore(getTotalScore() + getCurrentTurnScore());
                    System.out.println("Points earned this turn: " + getCurrentTurnScore());
                    System.out.println("Total points: " + getTotalScore() + "\n");
                    setCurrentTurnScore(0);
                    break;
                } else {
                    System.out.println("Invalid choice. Please enter 'r' or 'h'.");
                }
            }
        }

        System.out.println("You finished the game in " + turnsPlayed + " turns!\nGame over!");
    }

}
