package orgamanager.view;

import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JSeparator;
import javax.swing.JToolBar;

import orgamanager.config.OmConfig;


public class NeuerAnwendungsbereichPanel extends JPanel {

	private JPanel neuerAnwendungsbereichPanel;
	private JButton neuerAnwendungsfallButton_1;
	private JButton neuerAnwendungsfallButton_2;
	private JButton neuerAnwendungsfallButton_3;
	private JButton backButton;
	OmConfig config = new OmConfig();
	
	public NeuerAnwendungsbereichPanel() {
		// TODO Auto-generated constructor stub
	

			config = new OmConfig();
			this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
			neuerAnwendungsbereichPanel = new JPanel(); // FlowLayout
			this.setBorder(BorderFactory.createTitledBorder(config.getMessage("neuerAnwendugsbereichPanelTitleText")));  
			this.setPreferredSize(config.getMainPanelDimension());
			neuerAnwendungsfallButton_1 = new JButton(config.getMessage("neuerAnwendugsbereichPanelCreateButton1"));
			neuerAnwendungsfallButton_2 = new JButton(config.getMessage("neuerAnwendugsbereichPanelCreateButton2"));
			neuerAnwendungsfallButton_3 = new JButton(config.getMessage("neuerAnwendugsbereichPanelCreateButton3"));
			backButton = new JButton(config.getMessage("backButtonText"));
			neuerAnwendungsbereichPanel.add(neuerAnwendungsfallButton_1);
			
			neuerAnwendungsbereichPanel.add(neuerAnwendungsfallButton_2);
			
			neuerAnwendungsbereichPanel.add(neuerAnwendungsfallButton_3);
			this.add(neuerAnwendungsbereichPanel);		
			//this.add(Box.createRigidArea(new Dimension(5,5)));
			
			this.add(backButton);
		}

		public JButton getBackButton(){

			return this.backButton;
		}


		public JButton getCreateNeuerAnwendungsbereichButton(int buttonNr) {
			if (buttonNr == 1) {
				return this.neuerAnwendungsfallButton_1;
			}
			if (buttonNr == 2) {
				return this.neuerAnwendungsfallButton_2;
			}
			if (buttonNr == 3) {
				return this.neuerAnwendungsfallButton_3;
			}
			
			return null;
		}
	

}



	

	
	





	
	
		
	
	
	

