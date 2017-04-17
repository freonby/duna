package by.dunaenergo.web.pdf;

import java.util.Date;

public class Dogovor {
	private long id;
	private String dogovorName;
	private String dogovorNumber;
	private Date date;
	private Item item;
	private FizCustomer fizCustomer;

	public Dogovor() {

	}

	public long getId() {
		return id;
	}

	public String getDogovorName() {
		return dogovorName;
	}

	public String getDogovorNumber() {
		return dogovorNumber;
	}

	public Date getDate() {
		return date;
	}

	public Item getItem() {
		return item;
	}

	public FizCustomer getFizCustomer() {
		return fizCustomer;
	}

	public void setId(long id) {
		this.id = id;
	}

	public void setDogovorName(String dogovorName) {
		this.dogovorName = dogovorName;
	}

	public void setDogovorNumber(String dogovorNumber) {
		this.dogovorNumber = dogovorNumber;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public void setItem(Item item) {
		this.item = item;
	}

	public void setFizCustomer(FizCustomer fizCustomer) {
		this.fizCustomer = fizCustomer;
	}

}
