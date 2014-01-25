package orgamanager.view;

import java.awt.Dimension;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class OmWelcomePanel extends JPanel {

        private JLabel headerLabel;
        private JButton logout;
        
        public OmWelcomePanel(){
                this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
                headerLabel = new JLabel("Cockpit");
                headerLabel.setPreferredSize(new Dimension(600, 50));
                logout = new JButton("Ausloggen");
                this.add(headerLabel);
                this.add(logout);
        }

        public JLabel getHeaderLabel(){
                return headerLabel;
        }

        public void setHeaderLabel(JLabel headerLabel){
                this.headerLabel = headerLabel;
        }

        public JButton getLogout(){
                return logout;
        }

        public void setLogout(JButton logout){
                this.logout = logout;
        }
}
