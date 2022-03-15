package it.unibo.radarSystem22.domain;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import it.unibo.radarSystem22.domain.mock.LedMockMy;

public class TestLed {

	@Before
	public void up() {
		System.out.println("up");
	}

	@After
	public void down() {
		System.out.println("down");
	}

	@Test
	public void testLedMockOn() {
		System.out.println("testLedMockOn");
		LedMockMy led = new LedMockMy();

		assertTrue(!led.getState());

		led.turnOn();
		assertTrue(led.getState());
	}

	@Test
	public void testLedMockOff() {
		System.out.println("testLedMockOff");
		LedMockMy led = new LedMockMy();

		assertTrue(!led.getState());

		led.turnOff();
		assertTrue(!led.getState());
	}

}
