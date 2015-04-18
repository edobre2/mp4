package mp4;

interface Subject {
	public void AddObserver(IObserver observer);
	public void RemoveObserver(IObserver observer);
	public void NotifyObservers();
}
