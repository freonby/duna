package by.dunaenergo.web.pdf;

import java.util.Calendar;
import java.util.Formatter;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import by.dunaenergo.web.pdf.MoneyToStr.Currency;
import by.dunaenergo.web.pdf.MoneyToStr.Language;
import by.dunaenergo.web.pdf.MoneyToStr.Pennies;

public class InvoicePDFBuilder extends AbstractITextPdfView {
	private String headText;
	private Font titleFont;
	private Font headFont;
	private Font vendorTitleFont;
	private Font vendorFont;
	private BaseFont arial;
	private BaseFont arialbd;
	private Calendar calendar;

	@Override
	protected void buildPdfDocument(Map<String, Object> model, Document doc, PdfWriter writer, HttpServletRequest request, HttpServletResponse response) throws Exception {
		// get data model which is passed by the Spring container
		// receive item count
		FizCustomer offer = (FizCustomer) model.get("customer");

		Object object = (Object) model.get("item");
		Item item = null;
		// if (object instanceof ShowCase) {
		// ShowCase showcase = (ShowCase) object;
		// // receive item
		// item = new Item(showcase.getCommercialName() + " " +
		// showcase.getInvoiceName(), "шт", showcase.doublePrice(), count);
		// }
		// if (object instanceof Conditioner) {
		// Conditioner cond = (Conditioner) object;
		// // receive item
		// item = new Item("Сплит-система " + cond.getModelIndoor() + ", тип ("
		// + cond.getType() + ")", "шт", cond.doublePrice(), count);
		// }
		// if (object instanceof Refrigerant) {
		// Refrigerant rfg = (Refrigerant) object;
		// // receive item
		// item = new Item("Хладагент " + rfg.getName() + " (баллон " +
		// rfg.getWeight() + " кг)", "шт", rfg.doublePrice(), count);
		// }
		// Customer customer = (Customer) model.get("cust");
		FizCustomer customer = new FizCustomer();
		headText = "Внимание!Товар отпускается по факту прихода денег на р/c Поставщика, при наличии доверенности и паспорта. В доверенности должны быть указаны УНП и ОКПО Плательщика.";
		// set fonts
		arial = BaseFont.createFont("arial.ttf", "cp1251", BaseFont.EMBEDDED);
		arialbd = BaseFont.createFont("arialbd.ttf", "cp1251", BaseFont.EMBEDDED);
		titleFont = new Font(arial, 16);
		headFont = new Font(arial, 8);
		vendorTitleFont = new Font(arialbd, 10);
		vendorFont = new Font(arialbd, 8);
		calendar = Calendar.getInstance();
		// set header
		PdfPTable headerTable = new PdfPTable(1);
		headerTable.setWidthPercentage(100);
		headerTable.setSpacingAfter(20);
		headerTable.setSpacingBefore(5);
		PdfPCell cell;
		Paragraph head = new Paragraph(headText, headFont);
		Paragraph vendorTitle = new Paragraph("ПОСТАВЩИК:\n", vendorTitleFont);
		vendorTitle.setSpacingBefore(20);
		Paragraph vName = new Paragraph("ИП Войтас С.П.", vendorTitleFont);
		Paragraph vAddress = new Paragraph("Адрес: " + "220021 г.Минск, ул.Огарева,1", vendorFont);
		Paragraph vPhone = new Paragraph("Тел.: " + "(029)778-08-34", vendorFont);
		Paragraph vUnp = new Paragraph("УНП " + "691389574", vendorFont);
		Paragraph vBank = new Paragraph("Банк: " + "ЗАО \"МТБанк\"" + " " + "г.Минск, пр.Партизанский,6а", vendorFont);
		Paragraph vBankAccount = new Paragraph("Р/c: " + "3013117020010", vendorFont);
		Paragraph vBankCode = new Paragraph("Код банка: " + "117", vendorFont);
		cell = new PdfPCell(new Phrase("ИП Войтас С.П.", vendorFont));
		cell.setPadding(8);
		cell.addElement(vName);
		cell.addElement(vAddress);
		cell.addElement(vPhone);
		cell.addElement(vUnp);
		cell.addElement(vBank);
		cell.addElement(vBankAccount);
		cell.addElement(vBankCode);
		headerTable.addCell(cell);
		doc.add(head);
		doc.add(vendorTitle);
		doc.add(headerTable);
		// set title invoice and number
		@SuppressWarnings("resource")
		Formatter f = new Formatter();
		Paragraph title = new Paragraph("СЧЕТ-ФАКТУРА №" + "212" + " от " + f.format("%td.%tm.%ty", calendar, calendar, calendar).toString(), titleFont);
		title.setAlignment(Element.ALIGN_CENTER);
		title.setSpacingAfter(20);
		doc.add(title);
		addCustomer(doc, customer, headFont);
		// set invoice table
		PdfPTable invoiceTable = new PdfPTable(9);
		invoiceTable.setWidthPercentage(100);
		float[] columnWidths = { 10, 50, 10, 10, 15, 20, 10, 15, 20 };
		invoiceTable.setWidths(columnWidths);
		invoiceTable.setSpacingBefore(20);
		invoiceTable.setSpacingAfter(20);

		// invoice table head
		addHeadTable(invoiceTable, Element.ALIGN_CENTER, Element.ALIGN_CENTER);

		// add item to invoice table
		addItem(invoiceTable, item, Element.ALIGN_RIGHT, Element.ALIGN_RIGHT);
		// add table footer
		addFooterTable(invoiceTable, item.formattedDouble(item.summa()), item.formattedDouble(item.nds()), item.formattedDouble(item.summasNds()), Element.ALIGN_RIGHT, Element.ALIGN_RIGHT);
		doc.add(invoiceTable);

		Paragraph nm = new Paragraph("Наименований:" + "1", headFont);
		nm.setSpacingBefore(10);
		doc.add(nm);
		Paragraph vsego = new Paragraph("Всего: " + new MoneyToStr(Currency.RUR, Language.RUS, Pennies.TEXT).convert(item.summasNds()), headFont);
		Paragraph nds = new Paragraph("В том числе НДС: " + new MoneyToStr(Currency.RUR, Language.RUS, Pennies.TEXT).convert(item.nds()), headFont);
		vsego.setSpacingBefore(10);
		nds.setSpacingBefore(5);
		doc.add(vsego);
		doc.add(nds);

		Paragraph podp = new Paragraph("Счет выдал   _________________________   Индивидуальный предприниматель Войтас С.П.", vendorFont);
		podp.setSpacingBefore(30);
		doc.add(podp);
		Paragraph mp = new Paragraph("м.п.", vendorFont);
		mp.setSpacingBefore(20);
		mp.setIndentationLeft(20);
		doc.add(mp);

	}

	public PdfPCell createCell(String content, int colspan, int rowspan, int border, int hAlignment, int vAlignment, Font font) {
		PdfPCell cell = new PdfPCell(new Phrase(content, font));
		cell.setPaddingBottom(4);
		cell.setColspan(colspan);
		cell.setRowspan(rowspan);
		cell.setBorder(border);
		cell.setHorizontalAlignment(hAlignment);
		cell.setVerticalAlignment(vAlignment);
		return cell;
	}

	public PdfPTable addItem(PdfPTable invoiceTable, Item item, int hAlignment, int vAlignment) {
		invoiceTable.addCell(createCell("1", 1, 1, PdfPCell.BOX, Element.ALIGN_CENTER, vAlignment, headFont));
		invoiceTable.addCell(createCell(item.getItemName(), 1, 1, PdfPCell.BOX, Element.ALIGN_LEFT, vAlignment, headFont));
		invoiceTable.addCell(createCell(item.getIzm(), 1, 1, PdfPCell.BOX, Element.ALIGN_CENTER, vAlignment, headFont));
		invoiceTable.addCell(createCell(Long.toString(item.getItemCount()), 1, 1, PdfPCell.BOX, Element.ALIGN_CENTER, vAlignment, headFont));
		invoiceTable.addCell(createCell(item.formattedDouble(item.getPriceDouble()), 1, 1, PdfPCell.BOX, hAlignment, vAlignment, headFont));
		invoiceTable.addCell(createCell(item.formattedDouble(item.summa()), 1, 1, PdfPCell.BOX, hAlignment, vAlignment, headFont));
		invoiceTable.addCell(createCell("20", 1, 1, PdfPCell.BOX, hAlignment, vAlignment, headFont));
		invoiceTable.addCell(createCell(item.formattedDouble(item.nds()), 1, 1, PdfPCell.BOX, hAlignment, vAlignment, headFont));
		invoiceTable.addCell(createCell(item.formattedDouble(item.summasNds()), 1, 1, PdfPCell.BOX, hAlignment, vAlignment, headFont));
		return invoiceTable;
	}

	public PdfPTable addFooterTable(PdfPTable invoiceTable, String summa, String nds, String summasNds, int hAlignment, int vAlignment) {
		invoiceTable.addCell(createCell("Итого", 5, 1, PdfPCell.NO_BORDER, Element.ALIGN_CENTER, vAlignment, vendorFont));
		invoiceTable.addCell(createCell(summa, 1, 1, PdfPCell.BOX, hAlignment, vAlignment, vendorFont));
		invoiceTable.addCell(createCell(nds, 2, 1, PdfPCell.BOX, hAlignment, vAlignment, vendorFont));
		invoiceTable.addCell(createCell(summasNds, 1, 1, PdfPCell.BOX, hAlignment, vAlignment, vendorFont));
		return invoiceTable;
	}

	public PdfPTable addHeadTable(PdfPTable invoiceTable, int hAlignment, int vAlignment) {
		invoiceTable.addCell(createCell("№", 1, 1, PdfPCell.BOX, hAlignment, vAlignment, headFont));
		invoiceTable.addCell(createCell("Наименование товара(услуги,работы)", 1, 1, PdfPCell.BOX, hAlignment, vAlignment, headFont));
		invoiceTable.addCell(createCell("Ед.изм.", 1, 1, PdfPCell.BOX, hAlignment, vAlignment, headFont));
		invoiceTable.addCell(createCell("Кол-во", 1, 1, PdfPCell.BOX, hAlignment, vAlignment, headFont));
		invoiceTable.addCell(createCell("Цена", 1, 1, PdfPCell.BOX, hAlignment, vAlignment, headFont));
		invoiceTable.addCell(createCell("Сумма", 1, 1, PdfPCell.BOX, hAlignment, vAlignment, headFont));
		invoiceTable.addCell(createCell("Ставка НДС %", 1, 1, PdfPCell.BOX, hAlignment, vAlignment, headFont));
		invoiceTable.addCell(createCell("НДС", 1, 1, PdfPCell.BOX, hAlignment, vAlignment, headFont));
		invoiceTable.addCell(createCell("Сумма с НДС", 1, 1, PdfPCell.BOX, hAlignment, vAlignment, headFont));
		return invoiceTable;
	}

	public Document addCustomer(Document doc, FizCustomer customer, Font font) {
		Paragraph customerTitle = new Paragraph("ПЛАТЕЛЬЩИК: " + customer.getName() + "\n", vendorTitleFont);
		Paragraph cAddress = new Paragraph("Юр.адрес: " + customer.getCity(), font);
		Paragraph cPhone = new Paragraph("Тел.: " + customer.getPhone(), font);

		try {
			doc.add(customerTitle);
			doc.add(cAddress);
			doc.add(cPhone);

		} catch (DocumentException e) {

			e.printStackTrace();
		}

		return doc;
	}

}