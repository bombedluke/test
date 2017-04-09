package edu.westga.cs1302.produce_checker.test.produce_checker;

import static org.junit.Assert.*;

import java.time.LocalDate;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import edu.westga.cs1302.produce_checker.model.Produce;
import edu.westga.cs1302.produce_checker.model.ProduceChecker;

public class TestFirstProduceIsNewest {
	
	@Rule public ExpectedException exception = ExpectedException.none();

	@Test
	public void testProduce1IsNull() {
		this.exception.expect(IllegalArgumentException.class);
		Produce produce1 = null;
		Produce produce2 = new Produce(1, 1, LocalDate.of(2017, 12, 9));
		Produce produce3 = new Produce(1, 1, LocalDate.of(2017, 5, 12));
		ProduceChecker aProduce = new ProduceChecker();
		aProduce.getFreshestProduce(produce1, produce2, produce3);
	}
	@Test
	public void testProduce2IsNull() {
		this.exception.expect(IllegalArgumentException.class);
		Produce produce1 = new Produce(1, 1, LocalDate.of(2017, 12, 9));
		Produce produce2 = null;
		Produce produce3 = new Produce(1, 1, LocalDate.of(2017, 5, 12));
		ProduceChecker aProduce = new ProduceChecker();
		aProduce.getFreshestProduce(produce1, produce2, produce3);
	}
	@Test
	public void testProduce3IsNull() {
		this.exception.expect(IllegalArgumentException.class);
		Produce produce1 = new Produce(1, 1, LocalDate.of(2017, 12, 9));
		Produce produce2 = new Produce(1, 1, LocalDate.of(2017, 5, 12));
		Produce produce3 = null;
		ProduceChecker aProduce = new ProduceChecker();
		aProduce.getFreshestProduce(produce1, produce2, produce3);
	}
	@Test
	public void testProduce1IsNewest() {
		Produce produce1 = new Produce(1, 1, LocalDate.of(2017, 12, 9));
		Produce produce2 = new Produce(1, 1, LocalDate.of(2014, 5, 12));
		Produce produce3 = new Produce(1, 1, LocalDate.of(2016, 3, 12));
		ProduceChecker aProduce = new ProduceChecker();
		assertEquals("Produce1 is freshest", produce1, aProduce.getFreshestProduce(produce1, produce2, produce3));
	}
	@Test
	public void testProduce1IsNewestButSameAsProduce2() {
		Produce produce1 = new Produce(1, 1, LocalDate.of(2017, 12, 9));
		Produce produce2 = new Produce(1, 1, LocalDate.of(2017, 12, 9));
		Produce produce3 = new Produce(1, 1, LocalDate.of(2016, 3, 12));
		ProduceChecker aProduce = new ProduceChecker();
		assertEquals("Produce1 is freshest", produce1, aProduce.getFreshestProduce(produce1, produce2, produce3));
	}
	@Test
	public void testProduce1IsNewestButSameAsProduce2And3() {
		Produce produce1 = new Produce(1, 1, LocalDate.of(2017, 5, 12));
		Produce produce2 = new Produce(1, 1, LocalDate.of(2017, 5, 12));
		Produce produce3 = new Produce(1, 1, LocalDate.of(2017, 5, 12));
		ProduceChecker aProduce = new ProduceChecker();
		assertEquals("Produce1 is freshest", produce1, aProduce.getFreshestProduce(produce1, produce2, produce3));
	}
	@Test
	public void testProduce2IsNewest() {
		Produce produce1 = new Produce(1, 1, LocalDate.of(2014, 12, 9));
		Produce produce2 = new Produce(1, 1, LocalDate.of(2017, 5, 12));
		Produce produce3 = new Produce(1, 1, LocalDate.of(2016, 3, 12));
		ProduceChecker aProduce = new ProduceChecker();
		assertEquals("Produce2 is freshest", produce2, aProduce.getFreshestProduce(produce2, produce3, produce1));
	}
	@Test
	public void testProduce2IsNewestButSameAsProduce3() {
		Produce produce1 = new Produce(1, 1, LocalDate.of(2014, 12, 9));
		Produce produce2 = new Produce(1, 1, LocalDate.of(2017, 5, 12));
		Produce produce3 = new Produce(1, 1, LocalDate.of(2017, 5, 12));
		ProduceChecker aProduce = new ProduceChecker();
		assertEquals("Produce2 is freshest", produce2, aProduce.getFreshestProduce(produce2, produce3, produce1));
	}
	@Test
	public void testProduce3IsNewest() {
		Produce produce1 = new Produce(1, 1, LocalDate.of(2016, 12, 9));
		Produce produce2 = new Produce(1, 1, LocalDate.of(2014, 5, 12));
		Produce produce3 = new Produce(1, 1, LocalDate.of(2017, 3, 12));
		ProduceChecker aProduce = new ProduceChecker();
		assertEquals("Produce3 is freshest", produce3, aProduce.getFreshestProduce(produce3, produce2, produce1));
	}



}
