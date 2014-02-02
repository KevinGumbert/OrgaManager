package orgamanager.model.publications;

import java.util.HashMap;
import java.util.Scanner;

import orgamanager.utilities.OmPublicationConstant;
import orgamanager.utilities.OmUtilities;

public class PublicationParent {
	
	OmPublicationConstant citationType;
	String isbn;
	String title;
	String year;
	boolean valid;
	
	public PublicationParent(String entry){
		this.valid = true;
		parseBibtexString(entry);
	}
	
	public void parseBibtexString(String entry){
		char leftDelimiter = '{';
		char rightDelimiter = '}';
		OmUtilities utils = new OmUtilities();
		String cleanedEntry = utils.replaceBibtexChars(entry);
		HashMap<String, String> citationAttributes = new HashMap<String, String>();
		Scanner in = new Scanner(cleanedEntry);
		while (in.hasNextLine()){
			String line = in.nextLine(); // each line of bibtex string
			if (line.contains("@proceedings")){ // start of entry
				citationAttributes.put("type", "proceeding");
        		continue;
        	} else if (line.equals("} ") || line.equals("}")){ // end of entry 
        		validate();
        		continue;
			} else { // no start or end
				int firstSpace = line.substring(1).indexOf(' ');
				String firstWord = line.substring(1, (firstSpace + 1));
				if (firstWord.equals("isbn")) {
					String isbnString = utils.pickChildString(line, leftDelimiter, rightDelimiter);
					citationAttributes.put("isbn", isbnString); // abstract is not relevant here
				} else if (firstWord.equals("title")) {
					String titleString = utils.pickChildString(line, leftDelimiter, rightDelimiter);
					citationAttributes.put("title", titleString);
				} else if (firstWord.equals("year")) {
					String yearString = utils.pickChildString(line, leftDelimiter, rightDelimiter);
					citationAttributes.put("year", yearString);
				} else {
					// abstract, address, number, publisher, editor
					System.out.println("ACHTUNG - Proceeding.parseBibtexString(): ungenutztes Wort - " + firstWord);
				}
				continue;
			}
		}
		in.close();
		// set attributes to object
		if (citationAttributes.get("type").equals("proceeding")){
			this.citationType = OmPublicationConstant.PROCEEDING;
		} else {
			System.out.println("WARNING Proceeding - unknown OmCitationConstant!");
		}
		String isbn = "";
		String title = "";
		String year = "";
		// overwrite
		if (citationAttributes.get("title") != null && !citationAttributes.get("title").equals("")){
			title = citationAttributes.get("title");
		}
		if (citationAttributes.get("isbn") != null && !citationAttributes.get("isbn").equals("")){
			isbn = citationAttributes.get("isbn");
		}
		if (citationAttributes.get("year") != null && !citationAttributes.get("year").equals("")){
			year = citationAttributes.get("year");
		}
		this.title = title;
		this.isbn = isbn;
		this.year = year;
	}
	
	public void validate(){
		// TODO
	}
	
	public OmPublicationConstant getCitationType(){
		return citationType;
	}

	public void setCitationType(OmPublicationConstant citationType){
		this.citationType = citationType;
	}

	public String getIsbn(){
		return isbn;
	}

	public void setIsbn(String isbn){
		this.isbn = isbn;
	}

	public String getTitle(){
		return title;
	}
	
	public String getYear(){
		return year;
	}

	public boolean isValid(){
		return valid;
	}
}
