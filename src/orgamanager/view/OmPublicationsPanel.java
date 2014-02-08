package orgamanager.view;

import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;

import orgamanager.config.OmConfig;

public class OmPublicationsPanel extends JPanel {
	
	private JPanel publicationsPanel;
	private JButton createPublicationsButton;
	private JButton backButton;
	private OmConfig config;

	public OmPublicationsPanel() {
		config = new OmConfig();
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		publicationsPanel = new JPanel(); // FlowLayout
		this.setBorder(BorderFactory.createTitledBorder(config.getMessage("publicationsPanelTitleText")));
		this.setPreferredSize(config.getMainPanelDimension());
		createPublicationsButton = new JButton(config.getMessage("publicationsPanelCreateButton"));
		backButton = new JButton(config.getMessage("backButtonText"));
		publicationsPanel.add(createPublicationsButton);
		this.add(publicationsPanel);
		this.add(Box.createRigidArea(new Dimension(10,10)));
		this.add(backButton);
	}
	
	public JButton getBackButton(){
		return this.backButton;
	}
	
	public JButton getCreatePublicationsButton(){
		return this.createPublicationsButton;
	}
	
}

