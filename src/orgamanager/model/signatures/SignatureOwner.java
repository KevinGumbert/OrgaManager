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
}
