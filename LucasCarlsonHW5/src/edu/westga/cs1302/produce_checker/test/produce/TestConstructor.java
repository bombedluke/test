package edu.westga.cs1302.produce_checker.test.produce;

import static org.junit.Assert.*;

import java.time.LocalDate;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import edu.westga.cs1302.produce_checker.model.Produce;

public class TestConstructor {
	
	@Rule public ExpectedException exception = ExpectedException.none();

	@Test
	public void testValidInput() {
		Produce result = new Produce(4, 5, LocalDate.now());
		
		assertEquals("Checking idCode", 4, result.getIdCode());
		assertEquals("Checking cost", 5, result.getCost());
		assertEquals("Checking expiration date", LocalDate.now(), result.getExpirationDate());	
	}
	
	@Test
	public void testIdCodeEqualToZero(){
		this.exception.expect(IllegalArgumentException.class);
		new Produce(0, 4, LocalDate.now());
	}
	
	@Test
	public void testIdCodeLessThanZero(){
		this.exception.expect(IllegalArgumentException.class);
		new Produce(-2, 4, LocalDate.now());
	}
	
	@Test
	public void testCostEqualToZero(){
		this.exception.expect(IllegalArgumentException.class);
		new Produce(3, 0, LocalDate.now());
	}
	
	@Test
	public void testCostLessThanZero(){
		this.exception.expect(IllegalArgumentException.class);
		new Produce(3,-3 , LocalDate.now());
	}
	@Test
	public void testExpirationDateNull(){
		this.exception.expect(IllegalArgumentException.class);
		new Produce(4, 4, null);
	}
	
}
