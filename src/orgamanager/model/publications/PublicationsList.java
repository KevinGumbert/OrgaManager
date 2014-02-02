package orgamanager.model.publications;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

import javax.swing.JOptionPane;

import orgamanager.utilities.OmUtilities;

public class PublicationsList {
	public ArrayList<Publication> citations;
	public ArrayList<PublicationParent> proceedings;
	
	public PublicationsList(String path) throws FileNotFoundException{
		citations = new ArrayList<Publication>();
		proceedings = new ArrayList<PublicationParent>();
		parseBibtexFile(path);
	}
	
//	public CitationList(ArrayList<Proceeding> proceedings, ArrayList<Citation> citations) { // important for unit tests
//		citations = new ArrayList<Citation>(citations);
//		proceedings = new ArrayList<Proceeding>(proceedings);
//	}
	
	public List<Publication> getCitations(){
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
			} else if (line.contains("@misc")){ // start of proceeding
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
				PublicationParent proceeding = new PublicationParent(item);
				proceedings.add(proceeding);
			}
		}
		System.out.println("Proceedings created ..." + proceedings.size());
		for (String item : entries){
			if (item.contains("@inproceedings")){
				Publication citation = new Publication(item, proceedings);
				citations.add(citation);
			} else if (item.contains("@misc")){
				Publication citation = new Publication(item);
				citations.add(citation);
			} else {
				System.out.println("WARNING - unknown entry in citation-strings-list.");
			}
		}
		System.out.println("Citations created ... " + citations.size());
	}
	
	public void saveAsCsv(String path){
		String fileName = path;
		//String fileName = "Gespeichert_als_CSV-Datei.csv";
		String content = "";
		for (Publication citation : this.citations){
			content += citation.getCsvString();
		}
		OmUtilities utils = new OmUtilities();
		utils.printStringToFile(content, fileName);
	}
}
