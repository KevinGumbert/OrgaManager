package orgamanager.config;

import java.util.ArrayList;
import java.util.List;

import orgamanager.utilities.OmPublicationConstant;

public class PublicationsConfig {

	private List<OmPublicationConstant> publicationsTypesToShow; // principle: use interfaces instead of classes
	private List<String> publicationsBookAuthorsToShow;
	private List<String> publicationsBookConstraints; /** keywords to prevent publication */

	public PublicationsConfig() { // TODO boy scout rule: think about dependancy injection
		publicationsTypesToShow = new ArrayList<OmPublicationConstant>();
		publicationsTypesToShow.add(OmPublicationConstant.ARTICLE);
		publicationsTypesToShow.add(OmPublicationConstant.BOOK);
		publicationsTypesToShow.add(OmPublicationConstant.INCOLLECTION);
		publicationsTypesToShow.add(OmPublicationConstant.INPROCEEDING);
		publicationsBookAuthorsToShow = new ArrayList<String>();
		publicationsBookAuthorsToShow.add("Jörg Franke");
		publicationsBookAuthorsToShow.add("Klaus Feldmann");
		publicationsBookConstraints = new ArrayList<String>();
		publicationsBookConstraints.add("Faps-TT");
	}

	public List<OmPublicationConstant> getPublicationsTypesToShow() { 
		return publicationsTypesToShow;
	}

	public void setPublicationsTypesToShow(List<OmPublicationConstant> publicationsTypesToShow) {
		this.publicationsTypesToShow = publicationsTypesToShow;
	}

	public List<String> getPublicationsBookAuthorsToShow() {
		return publicationsBookAuthorsToShow;
	}

	public void setPublicationsBookAuthorsToShow(List<String> publicationsBookAuthorsToShow) {
		this.publicationsBookAuthorsToShow = publicationsBookAuthorsToShow;
	}

	public List<String> getPublicationsBookConstraints() {
		return publicationsBookConstraints;
	}

	public void setPublicationsBookConstraints(List<String> publicationsBookConstraints) {
		this.publicationsBookConstraints = publicationsBookConstraints;
	}

}
