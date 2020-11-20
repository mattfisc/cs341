
public class TubaGroup implements Observer{
	
	/**
	 * update function sends a StateChange object message to observer
	 * @param m StateChange message with string param
	 */
	@Override
	public void update(StateChange m) {
		System.out.println("Notification to Tubas: " + m.getMessageContent());
	}

}
