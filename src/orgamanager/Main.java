package orgamanager;

import java.awt.Frame;

import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;

import orgamanager.controller.OmController;
import orgamanager.model.OmModel;
import orgamanager.utilities.OmSplashScreen;
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
		showSplashScreen();
		//setNimbusLookAndFeel();
		setMetalLookAndFeel();
		OmModel model = new OmModel();
		OmView view = new OmView();
		OmController controller = new OmController(model, view);
		controller.prepareForView();
	}
	
	public static void setNimbusLookAndFeel(){
		// set Look and Feel to Nimbus
		try {
		    for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
		        if ("Nimbus".equals(info.getName())) {
		            UIManager.setLookAndFeel(info.getClassName());
		            break;
		        }
		    }
		} catch (Exception e) {
		    // If Nimbus is not available, you can set the GUI to another look and feel.
		}
	}
	
	public static void setMetalLookAndFeel(){
		// set Look and Feel to Nimbus
		try {
		    for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
		        if ("Metal".equals(info.getName())) {
		            UIManager.setLookAndFeel(info.getClassName());
		            break;
		        }
		    }
		} catch (Exception e) {
		    // If Metal is not available, you can set the GUI to another look and feel.
		}
	}
	
	public static void showSplashScreen(){
		// SplashScreen
		Frame frame = new Frame();
		new OmSplashScreen(frame);
	}
}
