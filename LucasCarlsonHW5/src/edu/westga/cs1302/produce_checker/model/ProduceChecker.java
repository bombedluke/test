package edu.westga.cs1302.produce_checker.model;

import java.time.LocalDate;

/** Defines processes for checking and comparing Produce objects.
 * 
 * @author CS 1301
 * @version Spring 2017
 */
public class ProduceChecker {

	/** Creates a new ProduceChecker.
	 * 
	 * @precondition none
	 * @postcondition none
	 * 
	 */
	public ProduceChecker() { }
	
	/** Find the newest Produce item in a collection.
	 * If there is a tie between 2 or more produce items, 
	 * the first item in the collection is considered the 
	 * newest. produce1 is the first item. produce2 is the
	 * second item. produce3 is the last item.
	 * 
	 * @precondition produce1 != null &&
	 * 				 produce2 != null &&
	 * 				 produce3 != null 
	 * @postcondition none
	 * 
	 * @param produce1 first produce item in the collection
	 * @param produce2 second produce item in the collection
	 * @param produce3 third produce item in the collection
	 * 
	 * @return newest produce item
	 */
	public Produce getFreshestProduce(Produce produce1, Produce produce2, Produce produce3) {
		if(produce1 == null){
			throw new IllegalArgumentException("Produce1 cannot be null.");
		}
		if(produce2 == null){
			throw new IllegalArgumentException("Produce2 cannot be null.");
		}
		if(produce3 == null){
			throw new IllegalArgumentException("Produce3 cannot be null.");
		}
		
		if(this.firstProduceIsNewest(produce1, produce2, produce3)) {
			return produce1;
		}
		else if(this.firstProduceIsNewest(produce2, produce1, produce3)) {
			return produce2;
		}
		else {
			return produce3;
		}
	}
	
	/* Checks if the first produce item is newer or the same age as the other two produce.
	 * 
	 * @precondition produce1 != null &&
	 * 				 produce2 != null &&
	 * 				 produce3 != null 
	 * @postcondition none
	 * 
	 * @return true iff produce1 is the newest or tied for the newest produce in the collection;
	 * 		   false iff produce1 is not the newest or tied for the newest produce in the collection;
	 */
	private boolean firstProduceIsNewest(Produce produce1, Produce produce2, Produce produce3) {
		return !produce1.getExpirationDate().isBefore(produce2.getExpirationDate()) && 
			   !produce1.getExpirationDate().isBefore(produce3.getExpirationDate());
	}
	
	/** Checks if a given produce item has expired.
	 * 
	 * @precondition produce != null
	 * @postcondition none
	 * 
	 * @param produce the produce item to check
	 * @return true iff produce has expired;
	 * 		   false iff produce has not expired;
	 */
	public boolean hasExpired(Produce produce) {
		if(produce == null){
			throw new IllegalArgumentException("Produce cannot be null.");
		}
		
		LocalDate currentDate = LocalDate.now();
		if(produce.getExpirationDate().isBefore(currentDate)) {
			return true;
		}
		return false;
	}
	
}
