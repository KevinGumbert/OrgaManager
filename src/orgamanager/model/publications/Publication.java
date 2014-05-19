package orgamanager.model.publications;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.StringTokenizer;

import orgamanager.config.OmConfig;
import orgamanager.utilities.OmPublicationConstant;
import orgamanager.utilities.OmUtilities;

/**
 * Class represents a publication.
 * 
 * Publication items will be shown on website.
 */
public class Publication {
	
	private OmPublicationConstant publicationType;
	private boolean valid; 
	private PublicationParent parent; 	/** book for incollection, proceeding for inproceeding, null for article or book */ 
	private ArrayList<PublicationParent> possibleParents; 
	private String isbn; 				// important for connectToParent()
	private String booktitle; 			// important for connectToParent()
	private String authors; 			// used in web-api
	private String reference; 			// used in web-api; citation, note
	private String year;				// used in web-api
	
	public Publication(String entry){
		this.parent = null;
		this.valid = true;
		this.isbn = "";
		this.booktitle = "";
		this.year = "";
		this.possibleParents = null;
		parseBibtexString(entry);
		validate();
	}
	
	public Publication(String entry, ArrayList<PublicationParent> proceedings){
		this.parent = null;
		this.valid = true;
		this.isbn = "";
		this.booktitle = "";
		this.year = "";
		this.possibleParents = new ArrayList<PublicationParent>(proceedings);
		parseBibtexString(entry);
		validate();
	}
	
	public Publication(){ // just for unit tests
	}
	
	public String getCsvString() {
		String csv = "";
		String type = ""; 				// db web
		String author = this.authors; 	// db web
		String publisher = ""; 			// db web
		String title = ""; 				// db web
		String year = this.year; 		// db web
		String isbn = ""; 				// db web
		String doi = ""; 				// db web
		String note = this.reference; 	// db web
		String location = ""; 			// db web
		String approval = ""; 			// db web
		String date = ""; 				// db web
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
		char leftDelimiter 	= '{';
		char rightDelimiter = '}';
		OmUtilities utils 	= new OmUtilities();
		String cleanedEntry = utils.replaceBibtexChars(entry);
		HashMap<String, String> citationAttributes = new HashMap<String, String>();
		Scanner in = new Scanner(cleanedEntry);
		while (in.hasNextLine()){
			String line = in.nextLine(); 
			if (line.contains("@patent")){ 
				citationAttributes.put("type", "patent");// not relevant
				continue;
			} else if (line.contains("@article")){ 				// start of article entry
				citationAttributes.put("type", "article");
        		continue;// each line of bibtex string
			} else if (line.contains("@book")){ 			// start of book entry
				citationAttributes.put("type", "book"); 	// attributes: author, year, title, address, series;
        		continue;
			} else if (line.contains("@inproceedings")){ 	// start of entry
				citationAttributes.put("type", "inproceeding");
        		continue;
			} else if (line.contains("@incollection")){ 			// start of book entry
				citationAttributes.put("type", "incollection"); 	// attributes: author, year, title, address, series;
        		continue;
			} else if (line.contains("@misc")){ 			// start of misc entry
				citationAttributes.put("type", "misc"); 	// attributes: author, year, title, address, series;
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
				} else if (firstWord.equals("series")) { // misc type;
					String seriesString = utils.pickChildString(line, leftDelimiter, rightDelimiter);
					citationAttributes.put("series", seriesString);
				} else if (firstWord.equals("volume")) { // article type;
					String volumeString = utils.pickChildString(line, leftDelimiter, rightDelimiter);
					citationAttributes.put("volume", volumeString);
				} else if (firstWord.equals("number")) { // article type;
					String numberString = utils.pickChildString(line, leftDelimiter, rightDelimiter);
					citationAttributes.put("number", numberString);
				} else if (firstWord.equals("journal")) { // article type;
					String journalString = utils.pickChildString(line, leftDelimiter, rightDelimiter);
					citationAttributes.put("journal", journalString);
				} else if (firstWord.equals("issn")) { // article type;
					String issnString = utils.pickChildString(line, leftDelimiter, rightDelimiter);
					citationAttributes.put("issn", issnString);
				} else { // abstract often has more than one line
					//System.out.println("WARNING: Publication.parseBibtexString(), unknown word - " + firstWord);
				}
				continue;
			}
		}
		in.close();
		// set attributes to object
		if (citationAttributes.get("type").equals("article")){
			this.publicationType = OmPublicationConstant.ARTICLE;
		} else if (citationAttributes.get("type").equals("book")){
			this.publicationType = OmPublicationConstant.BOOK;
		} else if (citationAttributes.get("type").equals("incollection")){
			this.publicationType = OmPublicationConstant.INCOLLECTION;
		} else if (citationAttributes.get("type").equals("inproceeding")){
			this.publicationType = OmPublicationConstant.INPROCEEDING;
		} else if (citationAttributes.get("type").equals("misc")){
			this.publicationType = OmPublicationConstant.MISC;
		} else {
			System.out.println("WARNING - unknown OmCitationConstant!");
		}
		String author = "";
		if (citationAttributes.get("author") != null){ // books do not have authors just editors
			this.authors = createAuthor(citationAttributes.get("author"));
			author = this.authors;
		}
		String title = "";
		String editor = "";
		String booktitle = ""; 	// used for proceeding search
		String location = "";
		String publisher = "";
		String year = ""; 		// used for proceeding search
		String pages = "";
		String series = ""; 	// used by misc-type
		String isbn = ""; 		// used for proceeding search
		String journal = "";
		String number = "";
		String volume = "";
		String issn = "";
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
		if (citationAttributes.get("series") != null && !citationAttributes.get("series").equals("")){
			series = citationAttributes.get("series");
		}
		if (citationAttributes.get("isbn") != null && !citationAttributes.get("isbn").equals("")){
			isbn = citationAttributes.get("isbn");
		}
		if (citationAttributes.get("journal") != null && !citationAttributes.get("journal").equals("")){
			journal = citationAttributes.get("journal");
		}
		if (citationAttributes.get("number") != null && !citationAttributes.get("number").equals("")){
			number = citationAttributes.get("number");
		}
		if (citationAttributes.get("volume") != null && !citationAttributes.get("volume").equals("")){
			volume = citationAttributes.get("volume");
		}
		if (citationAttributes.get("issn") != null && !citationAttributes.get("issn").equals("")){
			issn = citationAttributes.get("issn");
		}
		// unused attributes: abstract, keywords, ...
		createYear(year); // sets the object attribute for web api, keeps the long version for typed reference
		this.isbn = isbn;
		this.booktitle = booktitle;
		if (possibleParents != null){
			connectToParent();
		}
		createReferences(author, title, editor, booktitle, location, publisher, year, pages, series, volume, number, journal, issn);
		String dstr = "Publication created: " + author + " " +  title + ", " + year + ", " + this.publicationType + "; ";
		if (this.parent != null){
			dstr += "+";
		} else {
			dstr += "-";
		}
		//System.out.println(dstr);
	}
	
	private void connectToParent(){ // TODO unit test see problem boenig
		// look for corresponding isbn
		//System.out.println("Citation ... try connect to parent!");
		String isbn = this.isbn;
		String booktitle = this.booktitle;
		String year = this.year; // object attribute will be formatted like '2012'
		for (PublicationParent parent : possibleParents){
			String procIsbn = parent.getIsbn();
			String procBooktitle = parent.getTitle();
			String procYear = parent.getYear();
			if (isbn.equals(procIsbn) && !isbn.equals("")){
				//System.out.println("MATCH! (isbn)");
				this.parent = parent;
				break;
			} else if (booktitle.equals(procBooktitle)){ // booktitle is ok, go for year
				if (year.equals(procYear)){
					//System.out.println("MATCH! (title + year)");
					this.parent = parent;
					break;
				}
			} else if (procBooktitle.contains(booktitle)  && !booktitle.equals("")){
				if (year.equals(procYear)){
					//System.out.println("MATCH! (part of title + year)");
					this.parent = parent;
					break;
				}
			}
		}
	}
	
	private void createReferences(String author, String title, String editor, String booktitle, String location, String publisher, String year, String pages, String series, String volume, String number, String journal, String issn){
		String ref = "";
		String authors = "";
		if (author.equals("") && publicationType == OmPublicationConstant.BOOK){ // empty author string means it is a book as a publication // TODO Unittest
			author = new String(editor);
			this.authors = createEditor(editor);
		}
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
	    if (ref.length() > 1){ // there are items without author ...
	    	ref = ref.substring(0, ref.length() - 2);
	    }
	    // editor suffix 
	    if (this.publicationType == OmPublicationConstant.BOOK){
	    	ref += " (Hrsg.)";
	    }
	    ref += ": ";
	    // add title
	    ref += title;
	    ref += ". ";
	    if (this.publicationType == OmPublicationConstant.BOOK){
	    	 ref += createLocation(location);
			 ref += ": ";
			 ref += publisher;
			 ref += ", ";
			 ref += year;
	    }
		if (this.publicationType == OmPublicationConstant.INPROCEEDING || this.publicationType == OmPublicationConstant.INCOLLECTION){ 
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
		    String parentLocation = createLocation(location);
		    if (!parentLocation.equals("")){
		    	ref += parentLocation;
			    ref += ": ";
		    }
		    if (!publisher.equals("")){
		    	ref += publisher;
			    ref += ", ";
		    }
		    ref += year;
		    if (volume != null && !volume.equals("")){
		    	ref += " ";
		    	ref += "(";
		    	ref += volume;
		    	ref += ")";
		    }
		    if (pages != null && !pages.equals("")){
		    	ref += ", ";
		    	ref += "S. ";
		    	ref += pages;
		    }
		} else if (this.publicationType == OmPublicationConstant.MISC){
			// add in 
			ref += "In: ";
			ref += series;
			ref += ". ";
			ref += location;
			ref += ", ";
			ref += year;
			// misc: series
		} else if (this.publicationType == OmPublicationConstant.ARTICLE){
			// add in 
			ref += "In: ";
			ref += journal;
			ref += " ";
			ref += volume;
			ref += " (";
			ref += year;
			ref += ")";
			ref += ", Nr. ";
			ref += number;
			ref += ", S. ";
			ref += pages;
			// misc: series
		} else {
			// 
		}
		this.reference = ref;
	}
	
	private String createLocation(String locationString){
		String str = "";
		ArrayList<String> locations = new ArrayList<String>();
		StringTokenizer st = new StringTokenizer(locationString, " ");
	    while (st.hasMoreTokens()) {
	        String tok = st.nextToken();
	        if (tok.equals("and")){ 
	        	continue; 
	        } else { // one name to include
	        	locations.add(tok);
	        	continue;
	        }
	    }
	    for (int i = 0; i < locations.size(); i++){
	    	if (i == locations.size() - 1){
	    		str += locations.get(i);
	    	} else {
	    		str += locations.get(i);
	    		str += "; ";
	    	}
	    }
	    return str;
	}
	
	private void createYear(String year){
		String formatted = "";
		if (year.length() > 4){
			int length = year.length(); // take just the last four letters;
			formatted = year.substring((length - 4), length);
			this.year = formatted;
		} else {
			this.year = year;
		}
	}
	
	private String createAuthor(String authorStringPara){
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
	    String authorsString = "";
	    for (int i = 0; i < authors.size(); i++){
	    	if (i == authors.size()){
	    		authorsString += authors.get(i);
	    	} else {
	    		authorsString += authors.get(i);
	    		authorsString += "; ";
	    	}
	    }
	    return authorsString;
	}
	
	public String createEditorWithBrackets(String editor){
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
					// check for authors notation, i.e. lastname, firstname(s)
					if (tok.charAt(tok.length() - 1) == ','){
						String editorToAddString = "";
						String lastName = tok.substring(0, (tok.length() - 1));
						if (st.hasMoreTokens()){
							String firstName = st.nextToken();
							editorToAddString += firstName;
							if (st.hasMoreTokens()){
								String tokenAfterFirstName = st.nextToken();
								if (!tokenAfterFirstName.equals("") && !tokenAfterFirstName.equals("and")){
									editorToAddString += " ";
									editorToAddString += tokenAfterFirstName;
								}
							}
						}
						editorToAddString += " ";
						editorToAddString += lastName;
						editors.add(editorToAddString);// add name
					} else {
						editors.add(tok); // add Single Word Item
					}
					
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
	
	public String createEditorDefault(String editor){
		String str = "";
		ArrayList<String> editorList = new ArrayList<String>();
		String[] fullNamesArray = editor.split("and");
		for (String fullName : fullNamesArray){
			String[] tokens = fullName.split(", ");
			String editorFullName = "";
			if (tokens.length < 2){
				editorFullName = fullName; // only one token like IEEE
				editorList.add(editorFullName);
				break;
			}
			// Leerzeichen vorne und hinten abschneiden
			String firstName = tokens[0];
			String lastName = tokens[1];
			String firstNameCleanedStart = "";
			String firstNameCleanedEnd = "";
			if (firstName.charAt(0) == ' '){
				firstNameCleanedStart = firstName.substring(1);
			} else {
				firstNameCleanedStart = firstName;
			}
			if (firstNameCleanedStart.charAt((firstNameCleanedStart.length() - 1)) == ' '){
				firstNameCleanedEnd = firstNameCleanedStart.substring(0, firstNameCleanedStart.length() - 2);
			} else {
				firstNameCleanedEnd = firstNameCleanedStart;
			}
			String lastNameCleanedStart = "";
			String lastNameCleanedEnd = "";
			if (lastName.charAt(0) == ' '){
				lastNameCleanedStart = lastName.substring(1);
			} else {
				lastNameCleanedStart = lastName;
			}
			if (lastNameCleanedStart.charAt((lastNameCleanedStart.length() - 1)) == ' '){
				lastNameCleanedEnd = lastNameCleanedStart.substring(0, lastNameCleanedStart.length() - 1);
			} else {
				lastNameCleanedEnd = lastNameCleanedStart;
			}
			editorFullName = lastNameCleanedEnd + " " + firstNameCleanedEnd;
			editorList.add(editorFullName);
		}
		for (int i = 0; i < editorList.size(); i++){
	    	if (i == (editorList.size() - 1)){
	    		str += editorList.get(i);
	    	} else {
	    		str += editorList.get(i);
	    		str += "; ";
	    	}
	    }
		return str;
	}
	
	public String createEditor(String editor){
		String str = "";
		if (editor.contains("{")){ // hasBrackets
			str = createEditorWithBrackets(editor);
		} else {
			str = createEditorDefault(editor);
		}
		return str;
		// combine double names without brackets
		//String[] words = editor.split("and");
		//System.out.println("BP");
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
