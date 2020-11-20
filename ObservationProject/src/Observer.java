
public interface Observer {

	/**
	 * update function sends a StateChange object message to observer
	 * @param sc StateChange message with string param
	 */
	public void update(StateChange sc);
}
