package orgamanager.model.signatures;

import java.util.ArrayList;

public class SignatureOwner {
	
	String firstname;
	String lastname;
	String email;
	String fax;
	String tel;
	String city;
	String street;
	String title;
	String id;

	ArrayList<Signature> signatures;

	public SignatureOwner(String firstname, String lastname, String email,
			String fax, String tel, String city, String street, String title,
			String id) {

		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
		this.fax = fax;
		this.tel = tel;
		this.city = city;
		this.street = street;
		this.title = title;
		this.id = id;
	}
	
	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFax() {
		return fax;
	}

	public void setFax(String fax) {
		this.fax = fax;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public ArrayList<Signature> getSignatures() {
		return signatures;
	}

	public void setSignatures(ArrayList<Signature> signatures) {
		this.signatures = signatures;
	}

}
