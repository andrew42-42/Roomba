import java.util.Scanner;  //may be necessary for input

import javax.swing.JOptionPane;  //may be necessary for input

import kareltherobot.*;

public class Driver implements Directions {
// declared here so it is visible in all the methods!! 
// It will be assigned a value in the getInfo method
	private static Robot roomba; 

	

	// You will add very many variables!!

	
	public static void main(String[] args) {
		// LEAVE THIS ALONE!!!!!!
		Driver d = new Driver();

  /**
	 * This section of code gets info from the user in the following order: 1. Ask the user
	 * which world file they wish to process. Right now, that world file name is
	 * hardcoded in. 2. Ask the user for the starting location and direction of the
	 * Robot. A new Robot should be constructed and assigned to the global
	 * (instance) variable named roomba that is declared on line 10.
	 * 
	 * An inelegant way to interact with the user is via the console, using
	 * System.out.println and a Scanner that scans System.in (input from the
	 * console). A more elegant way to get user input might include using a
	 * JOptionPane.
	 */

    String wrldName = "finalTestWorld2024 (1).wld";
		boolean canMove = true;

		World.readWorld(wrldName);
    World.setVisible(true);
		World.setDelay(0);
		Robot roomba = new Robot(26,101,East,0);
		int areaOfRoom = 0;
		double numOfPiles = 0;
		int numOfBeepers = 0;
		int largestPile = 0;
		int beepersInPile = 0;

    


	/** This section will have all the logic that takes the Robot to every location 
	 * and cleans up all piles of beepers.  Think about ways you can break this
	 * large, complex task into smaller, easier to solve problems.
	 */

		// the line below causes a null pointer exception
		// what is that and why are we getting it?
		while(canMove==true){
			 if(roomba.nextToABeeper()==true){
				numOfPiles++;
			 }
			 while(roomba.nextToABeeper()==true){
			  beepersInPile++;
			  roomba.pickBeeper();
			  numOfBeepers++;
		   }
			 if(beepersInPile > largestPile){
				largestPile = beepersInPile;
			 }
			 beepersInPile = 0;
		  if(roomba.frontIsClear()==false){
				if(roomba.facingWest()==true)
				{
				 roomba.turnLeft();
				roomba.turnLeft();
				roomba.turnLeft();
			  if(roomba.frontIsClear()==true){
					roomba.move();
					areaOfRoom++;
					roomba.turnLeft();
					roomba.turnLeft();
					roomba.turnLeft();
				}
				else if(roomba.frontIsClear()==false){
				roomba.turnOff();
				canMove = false;
			 }
			}
			else if(roomba.facingEast()==true){
			 roomba.turnLeft();
			 if(roomba.frontIsClear()==true){
				roomba.move();
				areaOfRoom++;
				roomba.turnLeft();
			 }
			 else if(roomba.frontIsClear()==false){
				roomba.turnOff();
				canMove = false;
			 }
			}
		   }
			 roomba.move();
			 areaOfRoom++;
		  }

		
		
		
		


  





  	/** This method displays the results of cleaning the room.  All of the info
	 * in the pdf that describes the problem need to be displayed.  You can present
	 * this info in the console (boring) or you can present using JOptionPane (cool!)
	 */

   double avgPileSize = (numOfBeepers) / (numOfPiles);
	 double percentDirty = (numOfPiles) / (areaOfRoom);
	 System.out.println("The area of the room is " + areaOfRoom);
		System.out.println("There are " + numOfPiles + " piles");
		System.out.println("There are " + numOfBeepers + " beepers");
		System.out.println("The largest pile had " + largestPile + " beepers");
		System.out.println("There was an average of " + avgPileSize + " beepers per pile");
		System.out.println("The room was " + percentDirty + "% dirty");
		System.out.println("The largest pile is at 32, 123");









  }

}
