package orgamanager;

import java.awt.Frame;
import java.util.Scanner;

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
		// NOTE: use ant to build the tool - folder OrgaManager 'ant';
		// run by cd in dist and call java -jar orga-manager.jar (Swing-UI);
		// run with param java -jar orga-manager.jar -tui for terminal UI, i.e. for ssh access on the raspberry pi;
		String params = "";
		boolean isTui = false;
		for(int i=0; i<args.length; i++){
			if(args[i].equals("-tui")){isTui = true;}
        }
		if (isTui){ 
			showTextUserInterface();
		} else {
			showSplashScreen(); // TODO JPEG seems corrupted
			//setNimbusLookAndFeel();
			setMetalLookAndFeel();
			OmModel model = new OmModel();
			OmView view = new OmView();
			OmController controller = new OmController(model, view);
			controller.prepareForView();
		}
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
	
	public static void showTextUserInterface(){
		System.out.println("=====================================================\n");
		System.out.println("*** OrgaManager ***\n");
		System.out.println("Anwendungsfaelle:");
		System.out.println("0 - Beenden");
		System.out.println("1 - UseCase1");
		boolean quit = false;
		while (!quit){
			   Scanner scanner = new Scanner(System.in);
			   System.out.print("Eingabe: ");
			   String eingabe = scanner.nextLine();
			   if (eingabe.equals("0")){
				   quit = true;
			   } else if (eingabe.equals("1")){
				   System.out.println("UseCase1");
			   } else {}
		}
		System.out.println("=== OrgaManager - ENDE ===\n");
	}
}
