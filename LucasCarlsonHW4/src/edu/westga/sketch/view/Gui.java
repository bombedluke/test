package edu.westga.sketch.view;

import edu.westga.sketch.controllers.ApplicationDriver;
import edu.westga.sketch.controllers.SketchController;
import edu.westga.sketch.model.Turtle;

import java.lang.reflect.Field;

import acm.program.*;

/**
 * The GUI for the application.
 * 
 * @author CS 1301
 * @version Spring 2017
 * 
 */
public class Gui extends GraphicsProgram {

	public static final int APPLICATION_WIDTH = ApplicationDriver.WINDOW_SIZE;
	public static final int APPLICATION_HEIGHT = ApplicationDriver.WINDOW_SIZE;
	private static final long serialVersionUID = 1L;

	private SketchController sketchPad;

	/**
	 * Constructs and initializes the GUI.
	 * 
	 * @precondition none
	 * @postcondition none
	 */
	public Gui() {
		this.sketchPad = new SketchController();
	}

	/**
	 * Initializes the application.
	 * 
	 * @precondition none
	 * @postcondition none
	 */
	public void init() {
		this.resize(APPLICATION_WIDTH, APPLICATION_HEIGHT);

		Field[] fields = this.sketchPad.getClass().getDeclaredFields();

		for (Field currField : fields) {
			try {
				currField.setAccessible(true);

				if (currField.get(this.sketchPad) instanceof Turtle) {
					Turtle turtle = (Turtle) currField.get(this.sketchPad);
					super.add(turtle);
				}

				currField.setAccessible(false);
			} catch (IllegalArgumentException | IllegalAccessException e) {
				e.printStackTrace();
			}
		}

	}

	/**
	 * Part of the execution cycle for the application.
	 * 
	 * @precondition none
	 * @postcondition none
	 */
	public void run() {
		this.sketchPad.draw();
		this.sketchPad.displaySummaryStats();
	}

}
