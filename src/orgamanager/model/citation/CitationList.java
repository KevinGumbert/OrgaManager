package orgamanager.model.citation;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

import javax.swing.JOptionPane;

import orgamanager.utilities.OmUtilities;

public class CitationList {
	public ArrayList<Citation> citations;
	public ArrayList<Proceeding> proceedings;
	
	public CitationList(String path) throws FileNotFoundException{
		citations = new ArrayList<Citation>();
		proceedings = new ArrayList<Proceeding>();
		parseBibtexFile(path);
	}
	
	public List<Citation> getCitations(){
		return this.citations;
	}
	
	public void parseBibtexFile(String path){
		OmUtilities utils = new OmUtilities();
		String content = "";
		try {
			content = utils.readStringFromFile(path);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String cleanedContent = utils.replaceBibtexChars(content);
		ArrayList<String> entries = new ArrayList<String>();
		Scanner in = new Scanner(cleanedContent);
		boolean activeEntry = false;
		String entry = "";
		while (in.hasNextLine()){
			String line = in.nextLine(); // each line of bibtex file
			if (line.equals("") || line.equals(" ")){ // leere Zeile
				continue;
			}
			if (line.contains("@inproceedings")){ // start of entry
        		activeEntry = true;
        		entry = "";
        		entry += line + "\n";
        		continue;
			} else if (line.contains("@proceedings")){ // start of proceeding
				activeEntry = true;
        		entry = "";
        		entry += line + "\n";
        		continue;
        	} else if (line.equals("} ") || line.equals("}")) {
        		activeEntry = false;
        		entries.add(new String(entry));
        		continue;
        	} else {
        		if (activeEntry){ // line to grab
        			entry += line + "\n";
        		}
        		continue;
        	}
		}
		in.close();
		// create object - make sure that all proceedings are created first.
		for (String item : entries){
			if (item.contains("@proceedings")){
				Proceeding proceeding = new Proceeding(item);
				proceedings.add(proceeding);
			}
		}
		System.out.println("Proceedings created ...");
		for (String item : entries){
			if (item.contains("@inproceedings")){
				Citation citation = new Citation(item, proceedings);
				citations.add(citation);
			}
		}
		System.out.println("Citations created ...");
	}
	
	public void saveAsCsv(String path){
		String fileName = path;
		//String fileName = "Gespeichert_als_CSV-Datei.csv";
		String content = "";
		for (Citation citation : this.citations){
			content += citation.getCsvString();
		}
		OmUtilities utils = new OmUtilities();
		utils.printStringToFile(content, fileName);
	}
}
