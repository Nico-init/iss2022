package it.unibo.radarSystem22.domain.mock;

import it.unibo.radarSystem22.domain.interfaces.ILed;

public class LedMockMy implements ILed {
	private boolean state;

	public LedMockMy() {
		state = false;
	}
	
	@Override
	public void turnOn() {
		state = true;
	}

	@Override
	public void turnOff() {
		state = false;
	}

	@Override
	public boolean getState() {
		return state;
	}

}
