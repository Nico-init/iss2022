package it.unibo.radarSystem22.domain.mock;

import it.unibo.radarSystem22.domain.interfaces.ILed;

public class LedMock implements ILed {
	private boolean state;

	public LedMock() {
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
