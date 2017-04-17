package by.dunaenergo.web.pdf;

import java.util.Date;

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
	private String dogovorNumber;
	private String dogovorName;
	private Item item;
	private Date dogovorDate;
	private String comment;

	public FizCustomer() {

	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getShortName() {
		return shortName;
	}

	public void setShortName(String shortName) {
		this.shortName = shortName;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getPassportSn() {
		return passportSn;
	}

	public void setPassportSn(String passportSn) {
		this.passportSn = passportSn;
	}

	public String getPassportNumber() {
		return passportNumber;
	}

	public void setPassportNumber(String passportNumber) {
		this.passportNumber = passportNumber;
	}

	public String getPassportDate() {
		return passportDate;
	}

	public void setPassportDate(String passportDate) {
		this.passportDate = passportDate;
	}

	public String getPassportRovd() {
		return passportRovd;
	}

	public void setPassportRovd(String passportRovd) {
		this.passportRovd = passportRovd;
	}

	public String getPassportPrivateNumber() {
		return passportPrivateNumber;
	}

	public void setPassportPrivateNumber(String passportPrivateNumber) {
		this.passportPrivateNumber = passportPrivateNumber;
	}

	public String getDogovorNumber() {
		return dogovorNumber;
	}

	public void setDogovorNumber(String dogovorNumber) {
		this.dogovorNumber = dogovorNumber;
	}

	public String getDogovorName() {
		return dogovorName;
	}

	public Date getDogovorDate() {
		return dogovorDate;
	}

	public void setDogovorDate(Date dogovorDate) {
		this.dogovorDate = dogovorDate;
	}

	public void setDogovorName(String dogovorName) {
		this.dogovorName = dogovorName;
	}

	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

}
