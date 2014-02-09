package orgamanager.model.office;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class InvoiceRecipient {
	
	// JPA with EclipseLink
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)  
	private Long id;
	private String firstName;
	private String lastName;
	private String mnemonic;
	private String company;
	private String street;
	private String streetNumber;
	private String city;
	private String postalCode;
	
	public InvoiceRecipient(){
		firstName = "Max"; 
		lastName = "Mustermann";
		mnemonic = "mamustermann";
		company = "Musterfirma GmbH";
		street = "Musterweg";
		streetNumber = "2";
		city = "Musterstadt";
		postalCode = "12345";
	}
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getMnemonic() {
		return mnemonic;
	}

	public void setMnemonic(String mnemonic) {
		this.mnemonic = mnemonic;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getStreetNumber() {
		return streetNumber;
	}

	public void setStreetNumber(String streetNumber) {
		this.streetNumber = streetNumber;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}
	
	@Override
	public String toString() {
		return "InvoiceRecipient [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ";]";
	}
	
}
