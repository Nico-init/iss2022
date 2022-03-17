package it.unibo.radarSystem22.domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import it.unibo.radarSystem22.domain.mock.SonarMockMy;

public class TestSonarMy {

	@Before
	public void up() {
		System.out.println("start");
	}

	@After
	public void down() {
		System.out.println("finish");
	}
	
	@Test
	public void testSonarMock() throws InterruptedException {
		
		SonarMockMy sonar = new SonarMockMy();
		
		assertFalse(sonar.isActive());
		
		sonar.activate();
		long startTime = System.currentTimeMillis();
		assertTrue(sonar.isActive());
		
		assertEquals(sonar.getDistance().getVal(), 90);
		
		int sleep = 10000;
		while((System.currentTimeMillis() - startTime) < sleep) {}
		
		System.out.println(sonar.getDistance().getVal());
		assertEquals(sonar.getDistance().getVal(), 50);
		
		/*
		sleep = 90000;
		while((System.currentTimeMillis() - startTime) < sleep) {}
		
		System.out.println(sonar.getDistance().getVal());
		assertEquals(sonar.getDistance().getVal(), 1);
		*/
		
		sonar.deactivate();
		assertFalse(sonar.isActive());
	}
	
}
