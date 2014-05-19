package orgamanager.model.publications;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

import javax.swing.JOptionPane;

import orgamanager.config.OmConfig;
import orgamanager.utilities.OmPublicationConstant;
import orgamanager.utilities.OmUtilities;

public class PublicationsList {
	public OmConfig config;
	public ArrayList<Publication> publications;
	public ArrayList<PublicationParent> parents;
	
	public PublicationsList(String path) throws FileNotFoundException{
		config = new OmConfig(); // TODO boy scout rule: think about dependancy injection
		publications = new ArrayList<Publication>();
		parents = new ArrayList<PublicationParent>();
		parseBibtexFile(path);
	}
	
	public List<Publication> getCitations(){
		return this.publications;
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
		int lineCounter = 0;
		while (in.hasNextLine()){
			String line = in.nextLine(); // each line of bibtex file
			int curLine = lineCounter++;
			if (line.contains("Closed-loop control of patient handling robots")){
				System.out.println("Read " + curLine + ": " + line);
			}
			if (line.equals("") || line.equals(" ") || (line.substring(0,1)).equals("%")){ // leere Zeile, Patentschrift, Latex-Kommentar
				continue;
			}
			if (line.contains("@article")){ // start of entry
        		activeEntry = true;
        		entry = "";
        		entry += line + "\n";
        		continue;
			} else if (line.contains("@book")){ 
        		activeEntry = true;
        		entry = "";
        		entry += line + "\n";
        		continue;
			} else if (line.contains("@incollection")){ 
        		activeEntry = true;
        		entry = "";
        		entry += line + "\n";
        		continue;
			} else if (line.contains("@inproceedings")){ 
        		activeEntry = true;
        		entry = "";
        		entry += line + "\n";
        		continue;
			} else if (line.contains("@misc")){ 
				activeEntry = true;
        		entry = "";
        		entry += line + "\n";
        		continue;
			} else if (line.contains("@patent")){ 
				activeEntry = true;
        		entry = "";
        		entry += line + "\n";
        		continue;
			} else if (line.contains("@proceedings")){ 
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
			if (item.contains("@book")){
				PublicationParent book = new PublicationParent(item);
				parents.add(book);
			}
			if (item.contains("@proceedings")){
				PublicationParent proceeding = new PublicationParent(item);
				parents.add(proceeding);
			}
		}
		System.out.println("PublicationsParents created ..." + parents.size());
		for (String item : entries){
			if (item.contains("@article")){
				Publication article = new Publication(item, parents);
				publications.add(article);
			} else if (item.contains("@book")){
				boolean createBookPublication = shouldBePublished(item, OmPublicationConstant.BOOK, this.config);
				if (createBookPublication){
					Publication book = new Publication(item, parents);
					publications.add(book);
				}
			} else if (item.contains("@incollection")){
				Publication incollection = new Publication(item, parents);
				publications.add(incollection);
			} else if (item.contains("@inproceedings")){
				Publication citation = new Publication(item, parents);
				publications.add(citation);
			} else if (item.contains("@misc")){
				boolean createMiscPublication = shouldBePublished(item, OmPublicationConstant.MISC, this.config);
				if (createMiscPublication){
					Publication citation = new Publication(item);
					publications.add(citation);
				}
			} else {
				//System.out.println("WARNING - unknown entry in citation-strings-list.");
			}
		}
		System.out.println("Publications created ... " + publications.size());
	}
	
	private boolean shouldBePublished(String item, OmPublicationConstant type, OmConfig config) {
		List<OmPublicationConstant> typesToShow = config.getPublicationsTypesToShow();
		boolean typeMatch = false;
		for (OmPublicationConstant typeToCompare : typesToShow) { // check type
			if (type == typeToCompare) {
				typeMatch = true;
				break;
			}
		}
		if (!typeMatch) {
			return false; // no publishable type, quit
		}
		boolean stopPublishKeyMatch = false; // check for keywords like Faps-TT which stops publishing
		List<String> stopPubWords = config.getPublicationsBookConstraints();
		for (String key : stopPubWords){
			if (item.contains(key)){
				stopPublishKeyMatch = true;
				break;
			}
		}
		if (stopPublishKeyMatch){
			return false; // no publishable item, quit
		}
		if (type == OmPublicationConstant.BOOK){ // special case book as publication
			boolean authorMatch = false;
			List<String> authors = config.getPublicationsBookAuthorsToShow();
			for (String author : authors){
				StringTokenizer st = new StringTokenizer(author, " ");
				String firstName = st.nextToken();
				String lastName = st.nextToken();
				if (item.contains(lastName)){
					authorMatch = true;
					break;
				}
			}
			if (!authorMatch){
				return false; // no special author like Franke, Feldmann, quit
			}
		}
		return true;
	}
	
	public void saveAsCsv(String path){
		String fileName = path;
		String content = "";
		for (Publication citation : this.publications){
			content += citation.getCsvString();
		}
		OmUtilities utils = new OmUtilities();
		utils.printStringToFile(content, fileName);
	}
}
