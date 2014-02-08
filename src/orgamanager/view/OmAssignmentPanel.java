package orgamanager.view;

import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;

import orgamanager.config.OmConfig;

public class OmAssignmentPanel extends JPanel {

	private JPanel assignmentPanel;
	private JButton createAssignmentButton;
	private JButton backButton;
	private OmConfig config;

	public OmAssignmentPanel() {
		config = new OmConfig();
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		assignmentPanel = new JPanel(); // FlowLayout
		this.setBorder(BorderFactory.createTitledBorder(config.getMessage("assignmentPanelTitleText")));
		this.setPreferredSize(config.getMainPanelDimension());
		createAssignmentButton = new JButton(config.getMessage("assignmentsPanelCreateButton"));
		backButton = new JButton(config.getMessage("backButtonText"));
		assignmentPanel.add(createAssignmentButton);
		this.add(assignmentPanel);
		this.add(Box.createRigidArea(new Dimension(10,10)));
		this.add(backButton);
	}
	
	public JButton getBackButton(){
		return this.backButton;
	}
	
	public JButton getCreateAssignmentButton(){
		return this.createAssignmentButton;
	}
}
