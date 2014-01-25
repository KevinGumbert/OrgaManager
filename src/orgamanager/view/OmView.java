package orgamanager.view;

import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class OmView {

	private JPanel mainPanel;

	public OmView() {
		createAndShowGUI();
	}

	public JPanel getMainPanel() {
		return mainPanel;
	}

	public void setMainPanel(JPanel mainPanel) {
		this.mainPanel = mainPanel;
	}

	private JPanel createContentPane() {
		mainPanel = new JPanel(); // FlowLayout
		this.mainPanel.setPreferredSize(new Dimension(605, 405));
		return mainPanel;
	}

	private void createAndShowGUI() {
		JFrame.setDefaultLookAndFeelDecorated(true);
		JFrame frame = new JFrame("OrgaManager");
		frame.setContentPane(createContentPane());
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
	}
}
