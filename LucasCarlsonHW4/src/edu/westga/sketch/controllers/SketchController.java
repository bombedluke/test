package edu.westga.sketch.controllers;

import edu.westga.sketch.model.Turtle;
import edu.westga.sketch.utils.Statistics;

/**
 * Uses turtle objects to draw on the screen.
 * 
 * @author CS 1301
 * @version Spring 2017
 */
public class SketchController {
	private Turtle bigTurtle;
	private Turtle mediumTurtle;
	private Turtle littleTurtle;
	

	/**
	 * Creates and initializes a new SketchController object.
	 * 
	 * @precondition none
	 * @postcondition none
	 * 
	 */
	public SketchController() {
		this.bigTurtle = new Turtle(30);
		this.mediumTurtle = new Turtle(20);
		this.littleTurtle = new Turtle(10);
	

		this.bigTurtle.increaseTurtleSizeBy10();

		this.littleTurtle.decreaseTurtleSizeBy10();
		this.littleTurtle.decreaseTurtleSizeBy10();
		
		this.mediumTurtle.decreaseTurtleSizeBy10();
	}

	/**
	 * Draws a figure on the screen using turtles.
	 * 
	 * @precondition none
	 * @postcondition none
	 */
	public void draw() {
		this.moveBigTurtleToPositionForFirstRectangle();
		this.moveLittleTurtleToPositionForFirstRectangle();

		this.drawRectangleWithBigTurtle();
		this.drawRectangleWithLittleTurtle();

		this.moveBigTurtleToPositionForSecondRectangle();
		this.moveLittleTurtleToPositionForSecondRectangle();

		this.drawRectangleWithBigTurtle();
		this.drawRectangleWithLittleTurtle();
		
		this.mediumTurtleStartingPosition();
	
		this.drawBigFrameWithMediumTurtle();
		
		this.mediumTurtle.turnRight90();
		this.mediumTurtle.raiseTail();
		
	}

	private void drawBigFrameWithMediumTurtle() {
		this.stepForward(mediumTurtle, 19);
		this.mediumTurtle.turnRight90();
		this.stepForward(mediumTurtle, 19);
		this.mediumTurtle.turnRight90();
		this.stepForward(mediumTurtle, 19);
		this.mediumTurtle.turnRight90();
		this.stepForward(mediumTurtle, 19);
	}

	private void mediumTurtleStartingPosition() {
		this.mediumTurtle.stepForward();
		this.mediumTurtle.turnRight90();
		this.mediumTurtle.stepForward();
		this.mediumTurtle.turnLeft90();
		this.mediumTurtle.lowerTail();
	}

	private void stepForward(Turtle aTurtle, int steps) {
		for (int i = 0; i < steps; i++) {
			aTurtle.stepForward();
		}

	}

	private void moveLittleTurtleToPositionForSecondRectangle() {
		this.littleTurtle.turnRight90();
		this.stepForward(this.littleTurtle, 12);
		this.littleTurtle.turnLeft90();
	}

	private void drawRectangleWithLittleTurtle() {
		this.littleTurtle.lowerTail();

		this.stepForward(this.littleTurtle, 22);
		this.littleTurtle.turnRight90();

		this.stepForward(this.littleTurtle, 10);
		this.littleTurtle.turnRight90();

		this.stepForward(this.littleTurtle, 22);
		this.littleTurtle.turnRight90();

		this.stepForward(this.littleTurtle, 10);
		this.littleTurtle.turnRight90();

		this.littleTurtle.raiseTail();
	}

	private void moveBigTurtleToPositionForSecondRectangle() {
		this.bigTurtle.turnRight90();
		this.stepForward(this.bigTurtle, 6);
		this.bigTurtle.turnLeft90();
	}

	private void drawRectangleWithBigTurtle() {
		this.bigTurtle.lowerTail();

		this.stepForward(this.bigTurtle, 12);
		this.bigTurtle.turnRight90();

		this.stepForward(this.bigTurtle, 6);
		this.bigTurtle.turnRight90();

		this.stepForward(this.bigTurtle, 12);
		this.bigTurtle.turnRight90();

		this.stepForward(this.bigTurtle, 6);
		this.bigTurtle.turnRight90();

		this.bigTurtle.raiseTail();
	}

	private void moveBigTurtleToPositionForFirstRectangle() {
		this.bigTurtle.stepForward();
		this.bigTurtle.turnRight90();
		this.bigTurtle.stepForward();
		this.bigTurtle.turnLeft90();
	}

	private void moveLittleTurtleToPositionForFirstRectangle() {
		this.stepForward(this.littleTurtle, 3);
		this.littleTurtle.turnRight90();
		this.stepForward(this.littleTurtle, 3);
		this.littleTurtle.turnLeft90();
	}

	/**
	 * Displays summary stats about the turtles used to draw.
	 * 
	 * @precondition none
	 * @postcondition none
	 */
	public void displaySummaryStats() {
		Statistics stats = new Statistics();
		
		System.out.println("Turtle stats: ");
		System.out.println();
		
		this.displayTurtleStepStatistics(stats);

		this.displayTurtleAgeStatistics(stats);
	}

	private void displayTurtleAgeStatistics(Statistics stats) {
		int ageOfBigTurtle = this.bigTurtle.getTurtleAge();
		int ageOfMediumTurtle = this.mediumTurtle.getTurtleAge();
		int ageOfLittleTurtle = this.littleTurtle.getTurtleAge();
		System.out.println();
		System.out.println("Age of Turtles:");
		System.out.println("Big Turtle: " + ageOfBigTurtle);
		System.out.println("Medium Turtle: " + ageOfMediumTurtle);
		System.out.println("Little Turtle: " + ageOfLittleTurtle);
		
		double averageAge = stats.computeAverage(ageOfBigTurtle, ageOfMediumTurtle, ageOfLittleTurtle);
		System.out.println();
		System.out.println("Average age of all turtles: " + averageAge);
	}

	private void displayTurtleStepStatistics(Statistics stats) {
		System.out.println("Steps taken by:");

		int stepsByBigTurtle = this.bigTurtle.getStepsForward();
		int stepsByLittleTurtle = this.littleTurtle.getStepsForward();
		int stepsByMediumTurtle = this.mediumTurtle.getStepsForward();

		System.out.println("Big turtle: " + stepsByBigTurtle);
		System.out.println("Medium Turtle: " + stepsByMediumTurtle);
		System.out.println("Little turtle: " + stepsByLittleTurtle);
		
		System.out.println();
		if ((stepsByBigTurtle > stepsByMediumTurtle) && (stepsByBigTurtle > stepsByLittleTurtle))  {
			System.out.println("The big turtle took the most steps.");
		}
		else if ((stepsByMediumTurtle > stepsByBigTurtle) && (stepsByMediumTurtle > stepsByLittleTurtle)) {
			System.out.println("The medium turtle took the most steps.");
			
		}
		else {
			System.out.println("The little turtle took the most steps.");
		}
		double average = stats.computeAverage(stepsByBigTurtle, stepsByMediumTurtle, stepsByLittleTurtle);
		System.out.println();
		System.out.println("Average steps taken by all turtles:" + average);
	}

}