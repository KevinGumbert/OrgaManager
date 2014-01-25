package orgamanager.utilities;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

import javax.swing.JOptionPane;

public class OmUtilities {

	public boolean printStringToFile(String content, String path){
		PrintWriter writer;
		try {
			JOptionPane.showMessageDialog(null, "BP7","Debug", JOptionPane.WARNING_MESSAGE);
			writer = new PrintWriter(path, "UTF-8");
			writer.println(content);
			writer.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			return false;
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
}
