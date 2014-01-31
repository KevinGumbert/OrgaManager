package orgamanager.model.citation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.StringTokenizer;

import orgamanager.utilities.OmCitationConstant;
import orgamanager.utilities.OmUtilities;

public class Citation {
	private OmCitationConstant citationType;
	private boolean valid; // flag for validation
	private Proceeding parent; // proceeding for inproceeding, null if journal article
	private ArrayList<Proceeding> proceedings; 
	private String isbn;
	
	// data used from bibtex-web-api
	private String authors; 
	private String reference; // = citation, note
	private String year;
	
	public Citation(String entry){
		this.parent = null;
		this.valid = true;
		this.isbn = "";
		this.year = "";
		this.proceedings = null;
		parseBibtexString(entry);
		validate();
	}
	
	public Citation(String entry, ArrayList<Proceeding> proceedings){
		this.parent = null;
		this.valid = true;
		this.isbn = "";
		this.year = "";
		this.proceedings = new ArrayList<Proceeding>(proceedings);
		parseBibtexString(entry);
		validate();
	}
	
	public String getCsvString(){
		String csv = "";
		String type = ""; 				// db web
		String author = this.authors; 	// db web
		String publisher = "";			// db web
		String title = "";				// db web
		String year = this.year;		// db web
		String isbn = "";				// db web
		String doi = "";				// db web
		String note = this.reference;	// db web
		String location = "";			// db web
		String approval = "";			// db web
		String date = "";				// db web
		csv += type; 
		csv += "$";
		csv += author; 
		csv += "$";
		csv += publisher;
		csv += "$";
		csv += title;
		csv += "$";
		csv += year;
		csv += "$";
		csv += isbn;
		csv += "$";
		csv += doi;
		csv += "$";
		csv += note;
		csv += "$";
		csv += location;
		csv += "$";
		csv += approval;
		csv += "$";
		csv += date;
		csv += "\n";
		return csv;
	}
	
	public String getReference(){
		return this.reference;
	}
	
	public boolean getIsValid(){
		return this.valid;
	}
	
	private void parseBibtexString(String entry){
		char leftDelimiter = '{';
		char rightDelimiter = '}';
		OmUtilities utils = new OmUtilities();
		String cleanedEntry = utils.replaceBibtexChars(entry);
		HashMap<String, String> citationAttributes = new HashMap<String, String>();
		Scanner in = new Scanner(cleanedEntry);
		while (in.hasNextLine()){
			String line = in.nextLine(); // each line of bibtex string
			if (line.contains("@inproceedings")){ // start of entry
				citationAttributes.put("type", "inproceeding");
        		continue;
        	} else if (line.equals("} ") || line.equals("}")){ // end of entry 
        		validate();
        		continue;
			} else { // no start or end
				int firstSpace = line.substring(1).indexOf(' ');
				String firstWord = line.substring(1, (firstSpace + 1));
				if (firstWord.equals("abstract")) {
					citationAttributes.put("abstract", ""); // abstract is not relevant here
				} else if (firstWord.equals("author")) {
					String authorString = utils.pickChildString(line, leftDelimiter, rightDelimiter);
					citationAttributes.put("author", authorString);
				} else if (firstWord.equals("title")) {
					String titleString = utils.pickChildString(line, leftDelimiter, rightDelimiter);
					citationAttributes.put("title", titleString);
				} else if (firstWord.equals("keywords")) {
					String keywordString = utils.pickChildString(line, leftDelimiter, rightDelimiter);
					citationAttributes.put("keywords", keywordString);
				} else if (firstWord.equals("pages")) {
					String pagesString = utils.pickChildString(line, leftDelimiter, rightDelimiter);
					citationAttributes.put("pages", pagesString);
				} else if (firstWord.equals("publisher")) {
					String publisherString = utils.pickChildString(line, leftDelimiter, rightDelimiter);
					citationAttributes.put("publisher", publisherString);
				} else if (firstWord.equals("isbn")) {
					String isbnString = utils.pickChildString(line, leftDelimiter, rightDelimiter);
					citationAttributes.put("isbn", isbnString);
				} else if (firstWord.equals("editor")) {
					String editorString = utils.pickChildString(line, leftDelimiter, rightDelimiter);
					citationAttributes.put("editor", editorString);
				} else if (firstWord.equals("booktitle")) {
					String booktitleString = utils.pickChildString(line, leftDelimiter, rightDelimiter);
					citationAttributes.put("booktitle", booktitleString);
				} else if (firstWord.equals("year")) {
					String yearString = utils.pickChildString(line, leftDelimiter, rightDelimiter);
					citationAttributes.put("year", yearString);
				} else if (firstWord.equals("address")) {
					String addressString = utils.pickChildString(line, leftDelimiter, rightDelimiter);
					citationAttributes.put("address", addressString);
				} else {
					// throw(new
					// RuntimeException("Unrecognized citation attribute!"));
					System.out.println("ACHTUNG: unerkanntes Wort - " + firstWord);
				}
				continue;
			}
		}
		in.close();
		// set attributes to object
		if (citationAttributes.get("type").equals("inproceeding")){
			this.citationType = OmCitationConstant.INPROCEEDING;
		} else {
			System.out.println("WARNING - unknown OmCitationConstant!");
		}
		createAuthor(citationAttributes.get("author"));
		String author = this.authors;
		String title = "";
		String editor = "";
		String booktitle = "";
		String location = "";
		String publisher = "";
		String year = "";
		String pages = "";
		String isbn = ""; // used for proceeding search
		// overwrite
		if (citationAttributes.get("title") != null && !citationAttributes.get("title").equals("")){
			title = citationAttributes.get("title");
		}
		if (citationAttributes.get("editor") != null && !citationAttributes.get("editor").equals("")){
			editor = citationAttributes.get("editor");
		}
		if (citationAttributes.get("booktitle") != null && !citationAttributes.get("booktitle").equals("")){
			booktitle = citationAttributes.get("booktitle");
		}
		if (citationAttributes.get("address") != null && !citationAttributes.get("address").equals("")){
			location = citationAttributes.get("address");
		}
		if (citationAttributes.get("publisher") != null && !citationAttributes.get("publisher").equals("")){
			publisher = citationAttributes.get("publisher");
		}
		if (citationAttributes.get("year") != null && !citationAttributes.get("year").equals("")){
			year = citationAttributes.get("year");
		}
		if (citationAttributes.get("pages") != null && !citationAttributes.get("pages").equals("")){
			pages = citationAttributes.get("pages");
		}
		if (citationAttributes.get("isbn") != null && !citationAttributes.get("isbn").equals("")){
			isbn = citationAttributes.get("isbn");
		}
		// unused attributes: abstract, keywords, ...
		this.year = year;
		this.isbn = isbn;
		if (proceedings != null){
			connectToParent();
		}
		createReferences(author, title, editor, booktitle, location, publisher, year, pages);
	}
	
	private void connectToParent(){
		// look for corresponding isbn
		System.out.println("Citation ... try connect to parent!");
		String key = this.isbn;
		for (Proceeding proceeding : proceedings){
			String procKey = proceeding.getIsbn();
			if (procKey.equals(key)){
				System.out.println("MATCH!");
				this.parent = proceeding;
			}
		}
	}
	
	private void createReferences(String author, String title, String editor, String booktitle, String location, String publisher, String year, String pages){
		// ggf. TODO der Tagungsuntertitel wird nicht genannt!
		String ref = "";
		String authors = "";
		authors = new String(author);
		StringTokenizer st = new StringTokenizer(authors, " ");
	    while (st.hasMoreTokens()) {
	        String tok = st.nextToken();
	        if (tok.charAt(tok.length()-1) == ','){
	        	String lastName = tok.substring(0, (tok.length() - 1));
	        	String firstName = st.nextToken();
	        	ref += lastName;
	        	ref += ", ";
	        	ref += firstName.substring(0,1);
	        	ref += ".";
	        	ref += "; ";
	        	continue; 
	        }
	    }
	    // exclude last semikolon and space
	    ref = ref.substring(0, ref.length() - 2);
	    ref += ": ";
	    // add title
	    ref += title;
	    ref += ". ";
	    // add in 
	    ref += "In: ";
	    if (editor != null && !editor.equals("")){
	    	String editorFinal = createEditor(editor);
	    	ref += editorFinal;
	    	ref += " (Hrsg.)";
	    	ref += ": ";
	    }
	    if (this.parent != null && this.parent.getTitle() != null && !this.parent.getTitle().equals("")){
	    	ref += this.parent.getTitle();
	    } else {
	    	ref += booktitle;
	    }
	    ref += ". ";
	    ref += location;
	    ref += ": ";
	    ref += publisher;
	    ref += ", ";
	    ref += year;
	    if (pages != null && !pages.equals("")){
	    	ref += ", ";
	    	ref += "S. ";
	    	ref += pages;
	    }
	    this.reference = ref;
	}
	
	private void createAuthor(String authorStringPara){
		ArrayList<String> authors = new ArrayList<String>();
		String authorString = new String(authorStringPara);
		StringTokenizer st = new StringTokenizer(authorString, " ");
	    while (st.hasMoreTokens()) {
	        String tok = st.nextToken();
	        if (tok.equals("and")){ continue; }
	        if (tok.charAt(tok.length()-1) == ','){
	        	// lastName, firstName will follow
	        	String lastName = tok.substring(0, (tok.length() - 1));
	        	String firstName = st.nextToken();
	        	authors.add(lastName + ", " + firstName);
	        	continue;
	        }
	    }
	    this.authors = "";
	    for (int i = 0; i < authors.size(); i++){
	    	if (i == authors.size()){
	    		this.authors += authors.get(i);
	    	} else {
	    		this.authors += authors.get(i);
	    		this.authors += "; ";
	    	}
	    }
	}
	
	private String createEditor(String editor){
		String str = "";
		ArrayList<String> editors = new ArrayList<String>();
		StringTokenizer st = new StringTokenizer(editor, " ");
	    boolean isMultipleWordItem = false;
	    String multipleWordEditor = "";
		while (st.hasMoreTokens()) {
			String tok = st.nextToken();
			if (isMultipleWordItem){
				if (tok.charAt(tok.length() - 1) == '}'){ // end of multiple word editor
        			multipleWordEditor += tok;
    	        } else { // 
    	        	multipleWordEditor += tok;
    	        	multipleWordEditor += " ";
    	        	continue; // do not finalise - rerun
    	        }
				String multipleWordEditorFinal = multipleWordEditor.substring(1, (multipleWordEditor.length() - 1));
	        	editors.add(multipleWordEditorFinal);
	        	isMultipleWordItem = false;
			} else { // SingleWordItem
				if (tok.equals("and")){ 
					continue; 
				}
				if (tok.charAt(0) == '{'){  // start of multiple word editor
					isMultipleWordItem = true;
		        	multipleWordEditor += tok;
		        	multipleWordEditor += " ";
				} else {
					editors.add(tok); // add Single Word Item
				}
			}
	    }
	    for (int i = 0; i < editors.size(); i++){
	    	if (i == (editors.size() - 1)){
	    		str += editors.get(i);
	    	} else {
	    		str += editors.get(i);
	    		str += "; ";
	    	}
	    }
		return str;
	}
	
	private void validate(){
		// TODO
	}
	
	
	// data from bibtex
//	private String key; 
//	private String type; 
//	private String summary; // abstract is java key word
//	private String author;
//	private String title;
//	private String keywords;
//	private String pages;
//	private String publisher;
//	private String isbn;
//	private String editor;
//	private String booktitle;
//	private String year;
//	private String address;
	
	// data for db
//	private String type; 		// db web
//	private String author; 		// db web
//	private String publisher;	// db web
//	private String title; 		// db web
//	private String year; 		// db web
//	private String isbn; 		// db web
//	private String doi; 		// db web
//	private String note; 		// db web
//	private String location; 	// db web
//	private String approval; 	// db web
//	private String date; 		// db web
}
