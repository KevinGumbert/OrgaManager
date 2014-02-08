package orgamanager.view;

import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import orgamanager.config.OmConfig;

public class OmView {

	private JPanel mainPanel;
	OmConfig config;

	public OmView() {
		config = new OmConfig();
		createAndShowGUI();
	}

	public JPanel getMainPanel() {
		return mainPanel;
	}

	public void setMainPanel(JPanel mainPanel) {
		this.mainPanel.removeAll();
		this.mainPanel.add(mainPanel);
		this.mainPanel.revalidate();
	}

	private JPanel createContentPane() {
		mainPanel = new JPanel(); // FlowLayout
		OmConfig config = new OmConfig();
		this.mainPanel.setPreferredSize(config.getMainPanelDimension());
		return mainPanel;
	}

	private void createAndShowGUI() {
		JFrame.setDefaultLookAndFeelDecorated(true);
		JFrame frame = new JFrame(config.getMessage("mainFrameTitle"));
		frame.setContentPane(createContentPane());
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
	}
}
