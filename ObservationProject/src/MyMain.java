/**
 * 
 * @author Matthew Fischer
 * Application Launcher
 */
public class MyMain {

	/**
	 * main function launches application
	 * @param args String array
	 */
	public static void main(String[] args) {

		// ADD OBSERVERS
		TromboneGroup tromb = new TromboneGroup();
		TubaGroup tuba = new TubaGroup();
		TrumpetGroup trumpet = new TrumpetGroup();
		
		// ADD SUBJECT
		MusicConductor conductor = new MusicConductor();
		
		// ATTACH OBSERVERS
		conductor.attach(tromb);
		conductor.attach(tuba);
		
		
		// TEST NOTIFICATION
		conductor.notifyUpdate(new StateChange("Cresendo"));
		
		// DETACH AND ATTACH
		conductor.detach(tromb);
		conductor.attach(trumpet);
		
		// TEST NOTIFICATION
		conductor.notifyUpdate(new StateChange("Descendo"));
	}

}
