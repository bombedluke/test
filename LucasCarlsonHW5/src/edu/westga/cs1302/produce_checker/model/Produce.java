package edu.westga.cs1302.produce_checker.model;

import java.time.LocalDate;

/** Stores information for a single Produce item.
 * 
 * @author CS 1301
 * @version Spring 2017
 */
public class Produce {
	public LocalDate expirationDate;
	public int cost;
	public int idCode;
	
	/** Creates a new Produce with the specified id code, cost, and expiration date.
	 * 
	 * @precondition idCode > 0 &&
	 * 				 cost > 0 &&
	 * 				 expirationDate != null
	 * @postcondition getExpirationDate() == expirationDate &&
	 * 				  getCost() == cost &&
	 * 				  getIdCode() == idCode
	 * 
	 * @param idCode
	 * @param cost
	 * @param expirationDate
	 */
	public Produce(int idCode, int cost, LocalDate expirationDate) {
		if(idCode <=0){
			throw new IllegalArgumentException("idCode was not positive.");
		}
		if(cost <= 0){
			throw new IllegalArgumentException("Cost was not positive.");
		}
		if(expirationDate == null){
			throw new IllegalArgumentException("ExpirationDate cannot be null.");
		}
		
		this.idCode = idCode;
		this.cost = cost;
		this.expirationDate = expirationDate;
	}
	
	/** Returns the expiration date for the Produce
	 * 
	 * @precondition none
	 * @postcondition none
	 * 
	 * @return the expiration date for the Produce
	 */
	public LocalDate getExpirationDate() {
		return this.expirationDate;
	}

	
	/** Returns the id code for the Produce
	 * 
	 * @precondition none
	 * @postcondition none
	 * 
	 * @return the id code for the Produce
	 */
	public int getIdCode() {
		return this.idCode;
	}

	
	/** Returns the cost for the Produce
	 * 
	 * @precondition none
	 * @postcondition none
	 * 
	 * @return the cost for the Produce
	 */
	public int getCost() {
		return this.cost;
	}
}
