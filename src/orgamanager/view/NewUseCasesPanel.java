package orgamanager.view;

import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;

import orgamanager.config.OmConfig;

public class NewUseCasesPanel extends JPanel {

	private JPanel newUseCasePackagePanel;
	private JButton newUseCaseButton1;
	private JButton newUseCaseButton2;
	private JButton newUseCaseButton3;
	private JButton backButton;
	OmConfig config = new OmConfig();

	public NewUseCasesPanel() {
		config = new OmConfig();
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		this.setBorder(BorderFactory.createTitledBorder(config.getMessage("newUseCasesPanelTitleText")));
		this.setPreferredSize(config.getMainPanelDimension());
		newUseCasePackagePanel = new JPanel(); // FlowLayout
		newUseCaseButton1 = new JButton(config.getMessage("newUseCasesPanelCreateButton1"));
		newUseCaseButton2 = new JButton(config.getMessage("newUseCasesPanelCreateButton2"));
		newUseCaseButton3 = new JButton(config.getMessage("newUseCasesPanelCreateButton3"));
		newUseCasePackagePanel.add(newUseCaseButton1);
		newUseCasePackagePanel.add(newUseCaseButton2);
		newUseCasePackagePanel.add(newUseCaseButton3);
		this.add(Box.createRigidArea(new Dimension(10,10)));
		this.add(newUseCasePackagePanel);
		this.add(Box.createRigidArea(new Dimension(10,10)));
		backButton = new JButton(config.getMessage("backButtonText"));
		this.add(backButton);
	}

	public JButton getBackButton() {
		return this.backButton;
	}

	public JButton getCreateNeuerAnwendungsbereichButton(int buttonNr) {
		if (buttonNr == 1) {
			return this.newUseCaseButton1;
		}
		if (buttonNr == 2) {
			return this.newUseCaseButton2;
		}
		if (buttonNr == 3) {
			return this.newUseCaseButton3;
		}
		return null;
	}

}
