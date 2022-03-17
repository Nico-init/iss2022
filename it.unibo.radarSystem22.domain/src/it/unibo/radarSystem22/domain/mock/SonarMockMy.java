package it.unibo.radarSystem22.domain.mock;

import it.unibo.radarSystem22.domain.Distance;
import it.unibo.radarSystem22.domain.interfaces.IDistance;
import it.unibo.radarSystem22.domain.interfaces.ISonar;

public class SonarMockMy implements ISonar {
	private boolean state;
	private long startTime;
	private int[] vetStates;
	private int DIM = 90;
	private int TIME_SLICE = 250;

	public SonarMockMy() {
		state = false;
		startTime =0;
		vetStates = new int[DIM];
	}

	@Override
	public void activate() {
		startTime = System.currentTimeMillis();
		
		int cont = DIM;
		for (int i = 0; i < DIM; i++) {
			vetStates[i] = cont--;
			System.out.println(vetStates[i]);
		}
		
		state = true;
	}

	@Override
	public void deactivate() {
		state = false;
	}

	@Override
	public IDistance getDistance() {
		if (!state) return null;
		
		long currTime = System.currentTimeMillis();
		int pos = (int) ((currTime - startTime) / TIME_SLICE);
		
		if(pos >=90) pos = 89; 
		
		return new Distance(vetStates[pos]);

	}

	@Override
	public boolean isActive() {
		return state;
	}

}
