package orgamanager.config;

import java.util.ArrayList;
import java.util.List;

public class OfficeConfig {

	private String commandPdfViewer;
	private String commandPdfLatex;
	private String firstName; // principle: information hiding
	private String lastName;
	private String street;
	private String streetNumber;
	private String postalCode;
	private String city;
	private String phone;
	private String email;
	private String url;
	private String bankName;
	private String bankAccountNumber;
	private String bankCodeNumber;
	private String bankBic;
	private String bankIban;
	private String taxNumber;
	private String job;
	private List<String> jobOptions;
	
	public OfficeConfig(){
		commandPdfViewer = "evince";
		commandPdfLatex = "pdflatex";
		firstName = "XXXXXX";
		lastName = "XXXXX";
		street = "XXXXXXXXXXX";
		streetNumber = "XX"; 
		postalCode = "XXXXX";
		city = "XXXXXXXXXX";
		phone = "XXXXXXXXXXX";
		email = "XXXXXXXXXXXXXX"; 
		url = "XXXXXXXXXXXXXXX";
		bankName = "XXXXXXXXX";
		bankAccountNumber = "XXX XXX XX";
		bankCodeNumber = "XXX XXX XX";
		bankBic = "XXXX XX XX XXX";
		bankIban = "XXXXXXXXXXXXXXXXXXXX";
		taxNumber = "XXXXXXXXXXXX";
		job = "XXXXXXXXXXXXXX";
		jobOptions = new ArrayList<String>();
		jobOptions.add("XXXXXXXXXXXXXXXXX"); // TODO maybe use enums
		jobOptions.add("YYYYYYYYYYYYYYYYY");
		jobOptions.add("ZZZZZZZZZZZZZZZZZ");
	}
	
	public String getCommandPdfViewer() {
		return commandPdfViewer;
	}

	public void setCommandPdfViewer(String commandPdfViewer) {
		this.commandPdfViewer = commandPdfViewer;
	}

	public String getCommandPdfLatex() {
		return commandPdfLatex;
	}

	public void setCommandPdfLatex(String commandPdfLatex) {
		this.commandPdfLatex = commandPdfLatex;
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
	
}
