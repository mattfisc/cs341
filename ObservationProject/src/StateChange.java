/**
 * 
 * @author Matthew Fischer
 * 
 */
public class StateChange {

	private String messageContent;
	
	/**
	 * Constructor function
	 * @param m String store text in private attribute
	 */
	public StateChange(String m) {
		this.messageContent = m;
	}
	
	/**
	 * getMessageContent function to return string message content 
	 * @return messageContent private string message
	 */
	public String getMessageContent() {
		return messageContent;
	}
}
