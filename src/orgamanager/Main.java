package orgamanager;

import orgamanager.controller.OmController;
import orgamanager.model.OmModel;
import orgamanager.view.OmView;

public class Main {

        public static void main(String[] args) {
        OmModel model = new OmModel();
        OmView view = new OmView();
        OmController controller = new OmController(model, view);
        controller.prepareForView();
        }

}
