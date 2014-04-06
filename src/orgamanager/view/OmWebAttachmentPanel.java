package orgamanager.view;

import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;

import orgamanager.config.OmConfig;
import orgamanager.config.WebAttachmentConfig;

public class OmWebAttachmentPanel extends JPanel {
	private JPanel webAttachmentsPanel;
	private JButton createWebAttachmentButton;
	private JButton backButton;
	
	private OmConfig config;
	private WebAttachmentConfig webAttachmentConfig;

	public OmWebAttachmentPanel() {
		config = new OmConfig();
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		webAttachmentsPanel = new JPanel(); // FlowLayout
		this.setBorder(BorderFactory.createTitledBorder(config.getMessage("webAttachmentPanelTitleText")));  
		this.setPreferredSize(config.getMainPanelDimension());
		createWebAttachmentButton = new JButton(config.getMessage("webAttachmentPanelCreateButton")); 	
		backButton = new JButton(config.getMessage("backButtonText"));
		webAttachmentsPanel.add(createWebAttachmentButton);
		this.add(webAttachmentsPanel);		
		this.add(Box.createRigidArea(new Dimension(10,10)));
		this.add(backButton);
		
	}
	
	public JButton getBackButton(){

		return this.backButton;
	}


	public JButton getCreateWebAttachmentButton() {
		return this.createWebAttachmentButton;
	}

}
