
/**
 * 
 * @author Matthew Fischer
 * interface Subject
 */
public interface Subject {

	/**
	 * attach function attaches an observer to the subject by adding observer to an array
	 * @param o Observer 
	 */
	public void attach(Observer o);
	
	/**
	 * detach function detaches an observer from the subject
	 * @param o Observer 
	 */
	public void detach(Observer o);
	
	/**
	 * notifyUpdate function changes the message in a StateChange object with a string as a param
	 * @param m StateChange message object with a new string as a param
	 */
	public void notifyUpdate(StateChange m);
	
}
