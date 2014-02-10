package orgamanager.model.office;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import orgamanager.utilities.OmSex;

@Entity
@Table(name = "InvoiceRecipient")
public class InvoiceRecipient {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)  
	@Column(name = "id")
	private Long id;
	@Column(name = "firstName")
	private String firstName;
	@Column(name = "lastName")
	private String lastName;
	@Column(name = "mnemonic")
	private String mnemonic;
	@Column(name = "company")
	private String company;
	@Column(name = "street")
	private String street;
	@Column(name = "streetNumber")
	private String streetNumber;
	@Column(name = "city")
	private String city;
	@Column(name = "postalCode")
	private String postalCode;
	@Column(name = "sex")
	private OmSex sex;
	
	public InvoiceRecipient(){
		firstName = "Anton"; 
		lastName = "Aal";
		mnemonic = "antaal";
		company = "Musterfirma GmbH";
		street = "Musterweg";
		streetNumber = "2";
		city = "Musterstadt";
		postalCode = "12345";
		sex = OmSex.MALE;
	}
	
	public InvoiceRecipient(String firstName, String lastName, String mnemonic, String company, String street, String streetNumber, String city, String postalCode, OmSex sex){
		this.firstName = firstName;
		this.lastName = lastName;
		this.mnemonic = mnemonic;
		this.company = company;
		this.street = street;
		this.streetNumber = streetNumber;
		this.city = city;
		this.postalCode = postalCode;
		this.sex = sex;
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
	
	public OmSex getSex() {
		return sex;
	}

	public void setSex(OmSex sex) {
		this.sex = sex;
	}
	
	@Override
	public String toString() {
		return "InvoiceRecipient [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ";]";
	}
	
}
