package orgamanager.utilities;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JWindow;
import javax.swing.SwingUtilities;

public class OmSplashScreen extends JWindow {

	public OmSplashScreen(Frame f) {
		// from http://www.javaworld.com/javaworld/javatips/jw-javatip104.html
		super(f);
		int waitTime = 4000;
		// Datei ablegen in
		String pathToPng = "orgamanager/files/omsplash.jpg";
		URL urlimage = ClassLoader.getSystemResource(pathToPng);
		JLabel l = new JLabel(new ImageIcon(urlimage));
		getContentPane().add(l, BorderLayout.CENTER);
		pack();
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		Dimension labelSize = l.getPreferredSize();
		setLocation(screenSize.width / 2 - (labelSize.width / 2),
				screenSize.height / 2 - (labelSize.height / 2));
		addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e){
				setVisible(false);
				dispose();
			}
		});
		final int pause = waitTime;
		final Runnable closerRunner = new Runnable() {
			public void run(){
				setVisible(false);
				dispose();
			}
		};
		Runnable waitRunner = new Runnable() {
			public void run(){
				try {
					Thread.sleep(pause);
					SwingUtilities.invokeAndWait(closerRunner);
				} catch (Exception e) {
					e.printStackTrace();
					// can catch InvocationTargetException
					// can catch InterruptedException
				}
			}
		};
		setVisible(true);
		Thread splashThread = new Thread(waitRunner, "SplashThread");
		splashThread.start();
	}
	
}
