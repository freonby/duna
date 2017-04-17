package by.dunaenergo.web.pdf;

import java.util.ArrayList;
import java.util.List;

public class FizCustomer {
	private long id;
	private String name;
	private String shortName;
	private String city;
	private String street;
	private String email;
	private String phone;
	private String passportSn;
	private String passportNumber;
	private String passportDate;
	private String passportRovd;
	private String passportPrivateNumber;
	private String comment;
	private List<Dogovor> listDogs = new ArrayList<Dogovor>();

	public FizCustomer() {

	}

	public long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getStreet() {
		return street;
	}

	public String getEmail() {
		return email;
	}

	public String getPhone() {
		return phone;
	}

	public String getPassportSn() {
		return passportSn;
	}

	public String getPassportNumber() {
		return passportNumber;
	}

	public String getPassportDate() {
		return passportDate;
	}

	public String getPassportRovd() {
		return passportRovd;
	}

	public String getPassportPrivateNumber() {
		return passportPrivateNumber;
	}

	public String getComment() {
		return comment;
	}

	public List<Dogovor> getListDogs() {
		return listDogs;
	}

	public void setId(long id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getShortName() {
		return shortName;
	}

	public void setShortName(String shortName) {
		this.shortName = shortName;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public void setPassportSn(String passportSn) {
		this.passportSn = passportSn;
	}

	public void setPassportNumber(String passportNumber) {
		this.passportNumber = passportNumber;
	}

	public void setPassportDate(String passportDate) {
		this.passportDate = passportDate;
	}

	public void setPassportRovd(String passportRovd) {
		this.passportRovd = passportRovd;
	}

	public void setPassportPrivateNumber(String passportPrivateNumber) {
		this.passportPrivateNumber = passportPrivateNumber;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public void setListDogs(List<Dogovor> listDogs) {
		this.listDogs = listDogs;
	}

}
