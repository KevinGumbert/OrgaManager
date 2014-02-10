package orgamanager;

import orgamanager.controller.OmController;
import orgamanager.model.OmModel;
import orgamanager.view.OmView;

/**
 * Main is the entry point of this application, you can read the core documentation here as well.
 */
public class Main {
	
	/**
	 * Method creates model, view and controller and launches graphical user interface.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		OmModel model = new OmModel();
		OmView view = new OmView();
		OmController controller = new OmController(model, view);
		controller.prepareForView();
		// neuer Code 
	}
}
