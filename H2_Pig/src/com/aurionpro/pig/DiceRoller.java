package com.aurionpro.pig;
import java.util.*;
public class DiceRoller {
	
		Random random = new Random();
	    public int numberOfSides=6;

	    public int rollDice() {
	        return random.nextInt(numberOfSides) + 1;
	    }
	

}
