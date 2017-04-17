package by.dunaenergo.web.pdf;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.NumberFormat;
import java.util.Locale;

public class Item {
	private String itemName;
	private String izm;
	private Double priceDouble;
	private long itemCount;
	private Locale locale;
	private NumberFormat nf;

	public Item(String itemName, String izm, double price, long itemCount) {
		super();
		this.itemName = itemName;
		this.izm = izm;
		this.priceDouble = price;
		this.itemCount = itemCount;
		this.locale = new Locale("RU");
		this.nf = NumberFormat.getInstance(locale);

	}

	public String formattedDouble(Double d) {
		return nf.format(d);
	}

	public Double summa() {
		Double summa = new BigDecimal(priceDouble * itemCount).setScale(2, RoundingMode.HALF_UP).doubleValue();
		return summa;

	}

	public Double nds() {
		Double nds = new BigDecimal(summa() * 20 / 100).setScale(2, RoundingMode.HALF_UP).doubleValue();
		return nds;

	}

	public Double summasNds() {
		Double summasNds = new BigDecimal(summa() + nds()).setScale(2, RoundingMode.HALF_UP).doubleValue();
		return summasNds;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public String getIzm() {
		return izm;
	}

	public void setIzm(String izm) {
		this.izm = izm;
	}

	public long getItemCount() {
		return itemCount;
	}

	public void setItemCount(long itemCount) {
		this.itemCount = itemCount;
	}

	public Double getPriceDouble() {
		return priceDouble;
	}

	public void setPriceDouble(Double priceDouble) {
		this.priceDouble = priceDouble;
	}

}
