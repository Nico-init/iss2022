package it.unibo.radarSystem22_4.appl.SonarObservable;

import it.unibo.radarSystem22.domain.interfaces.IDistance;

public interface IObservableDistance extends IDistance {
	public void setDistance(IDistance distance);
	public void register(IObserver observer);
	public void unregister(IObserver observer);
	public void notifyObserver();
		     
}
