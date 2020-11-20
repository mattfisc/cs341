import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author Matthew Fischer
 *
 */
public class MusicConductor implements Subject{

	private List<Observer> observers = new ArrayList<>();
	
	/**
	 * attach function attaches an observer to the subject by adding observer to an array
	 * @param o Observer 
	 */
	@Override
	public void attach(Observer o) {
		observers.add(o);
	}

	/**
	 * detach function detaches an observer from the subject
	 * @param o Observer 
	 */
	@Override
	public void detach(Observer o) {
		observers.remove(o);
		
	}

	/**
	 * notifyUpdate function changes the message in a StateChange object with a string as a param
	 * @param m StateChange message object with a new string as a param
	 */
	@Override
	public void notifyUpdate(StateChange sc) {
		for(Observer o: observers) {
			o.update(sc);
		}
	}

}
