package it.unibo.radarSystem22_4.appl.SonarObservable;

import it.unibo.radarSystem22.domain.interfaces.ISonar;

public interface IObservableSonar extends ISonar{
	public void register(IObserver observer);
	public void unregister(IObserver observer);
}
