package it.unibo.radarSystem22_4.appl.SonarObservable;

import it.unibo.radarSystem22.domain.interfaces.IDistance;

public interface IObserver {
	public void update(IDistance distance);
}
