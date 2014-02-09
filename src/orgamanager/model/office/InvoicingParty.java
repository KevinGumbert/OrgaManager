package orgamanager.model.office;

import java.util.ArrayList;
import java.util.List;

import orgamanager.config.OmConfig;

public class InvoicingParty {
	private OmConfig config;
	private String firstName;
	private String lastName;
	private String street;
	private String streetNumber;
	private String postalCode;
	private String city;
	private String job;
	private List<String> jobOptions; // principle: interface segregation principle (java api) 
	private String phone;
	private String email;
	private String url;
	private String bankName;
	private String bankAccountNumber;
	private String bankCodeNumber;
	private String bankBic;
	private String bankIban;
	private String taxNumber;

	public InvoicingParty() {
		config = new OmConfig();
		firstName = config.getFirstName();
		lastName = config.getLastName();
		street = config.getStreet();
		streetNumber = config.getStreetNumber();
		postalCode = config.getPostalCode();
		city = config.getCity();
		job = config.getJob();
		jobOptions = config.getJobOptions();
		phone = config.getPhone();
		email = config.getEmail();
		url = config.getUrl();
		bankName = config.getBankName();
		bankAccountNumber = config.getBankAccountNumber();
		bankCodeNumber = config.getBankCodeNumber();
		bankBic = config.getBankBic();
		bankIban = config.getBankIban();
		taxNumber = config.getTaxNumber();
	}

	public OmConfig getConfig() {
		return config;
	}

	public void setConfig(OmConfig config) {
		this.config = config;
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

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}

	public List<String> getJobOptions() {
		return jobOptions;
	}

	public void setJobOptions(List<String> jobOptions) {
		this.jobOptions = jobOptions;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	public String getBankAccountNumber() {
		return bankAccountNumber;
	}

	public void setBankAccountNumber(String bankAccountNumber) {
		this.bankAccountNumber = bankAccountNumber;
	}

	public String getBankCodeNumber() {
		return bankCodeNumber;
	}

	public void setBankCodeNumber(String bankCodeNumber) {
		this.bankCodeNumber = bankCodeNumber;
	}

	public String getBankBic() {
		return bankBic;
	}

	public void setBankBic(String bankBic) {
		this.bankBic = bankBic;
	}

	public String getBankIban() {
		return bankIban;
	}

	public void setBankIban(String bankIban) {
		this.bankIban = bankIban;
	}

	public String getTaxNumber() {
		return taxNumber;
	}

	public void setTaxNumber(String taxNumber) {
		this.taxNumber = taxNumber;
	}
}
