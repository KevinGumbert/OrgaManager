package orgamanager.view;

import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;

import orgamanager.config.OmConfig;
import orgamanager.config.WebAttachmentConfig;

public class OmSignaturePanel extends JPanel  {
	
	private JPanel SignaturePanel;
	private JButton SignatureButton;
	private JButton backButton;
	
	private OmConfig config;
	//private WebAttachmentConfig webAttachmentConfig;
	
	public OmSignaturePanel() {

		config = new OmConfig();
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		SignaturePanel = new JPanel(); // FlowLayout
		this.setBorder(BorderFactory.createTitledBorder(config.getMessage("signaturesPanelTitleText")));  
		this.setPreferredSize(config.getMainPanelDimension());
		SignatureButton = new JButton(config.getMessage("signaturesPanelCreateButton")); 	
		backButton = new JButton(config.getMessage("backButtonText"));
		SignaturePanel.add(SignatureButton);
		this.add(SignaturePanel);		
		this.add(Box.createRigidArea(new Dimension(10,10)));
		this.add(backButton);
	}

	public JButton getBackButton(){

		return this.backButton;
	}


	public JButton getCreateSignatureButton() {
		return this.SignatureButton;
	}
}





	
	
		
	
	
	

