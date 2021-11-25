package com.ji.chapter9;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Comparator;

import org.junit.jupiter.api.Test;

public class Point {
	private final int x; 
	private final int y;
	
	public final static Comparator<Point> compareByXAndThenY = Comparator.comparing(Point::getX).thenComparing(Point::getY);
	
	public Point(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}
	
	public Point moveRightBy(int x) {
		return new Point(this.x + x, this.y);
	}

	@Test
	public void testMoveRight() {
		Point p1 = new Point(5, 5);
		Point p2 = p1.moveRightBy(10);
		assertEquals(15, p2.getX());
		assertEquals(5, p2.getY());
	}
	
	@Test
	public void testComparingTwoPoints() {
		Point p1 = new Point(10, 15);
		Point p2 = new Point(10, 20);
		int result = Point.compareByXAndThenY.compare(p1, p2);
		assertTrue(result<0);
	}
	
}


