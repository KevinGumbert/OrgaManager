package orgamanager;

import orgamanager.controller.OmController;
import orgamanager.model.OmModel;
import orgamanager.view.OmView;

public class Main {

	public static void main(String[] args) {
		// SwingMVC, see macs.hw.ac.uk/guidebook/?name=Using%20The%20GUI&page=1
        OmModel model = new OmModel();
        OmView view = new OmView();
        OmController controller = new OmController(model, view);
	}

}
