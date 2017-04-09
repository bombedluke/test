package edu.westga.cs1302.produce_checker.test.produce_checker;

import static org.junit.Assert.*;

import java.time.LocalDate;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import edu.westga.cs1302.produce_checker.model.Produce;
import edu.westga.cs1302.produce_checker.model.ProduceChecker;

public class TestHasExpired {
	
	@Rule public ExpectedException exception = ExpectedException.none();

	@Test
	public void testWhenProduceIsNull() {
		this.exception.expect(IllegalArgumentException.class);
		ProduceChecker produce = new ProduceChecker();
		produce.hasExpired(null);
	}
	@Test
	public void testWhenExpirationDateIsBeforeCurrentDate() {
		Produce result = new Produce(2, 2, LocalDate.of(2016, 12, 13));
		ProduceChecker produce1 = new ProduceChecker();
		assertTrue(produce1.hasExpired(result));
	}
	@Test
	public void testWhenExpirationDateIsCurrentDate() {
		Produce result = new Produce(2, 2, LocalDate.now());
		ProduceChecker produce1 = new ProduceChecker();
		assertFalse(produce1.hasExpired(result));
	}
	@Test
	public void testWhenExpirationDateIsAfterCurrentDate() {
		Produce result = new Produce(2, 2, LocalDate.of(2019, 4, 29));
		ProduceChecker produce1 = new ProduceChecker();
		assertFalse(produce1.hasExpired(result));
	}
	
	

}
