package by.dunaenergo.web.pdf;

import java.util.Calendar;
import java.util.Formatter;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

public class DogovorPdfBuilder extends AbstractITextPdfView {

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
		Customer offer = (Customer) model.get("customer");

		String path = (String) model.get("path");
		Image logo = Image.getInstance(path + "/resources/img/logo/logo.png");
		logo.setWidthPercentage(40f);
		BaseColor tableColor = BaseColor.GRAY;

		arial = BaseFont.createFont("arial.ttf", "cp1251", BaseFont.EMBEDDED);
		arialbd = BaseFont.createFont("arialbd.ttf", "cp1251", BaseFont.EMBEDDED);
		titleFont = new Font(arial, 16);
		headFont = new Font(arial, 8);
		vendorTitleFont = new Font(arialbd, 10);
		vendorFont = new Font(arialbd, 8);
		calendar = Calendar.getInstance();
		// set header
		PdfPTable headerTable = new PdfPTable(2);
		headerTable.setWidthPercentage(100);
		headerTable.setSpacingAfter(20);
		headerTable.setSpacingBefore(5);

		Paragraph vName = new Paragraph("ИП Войтас С.П.", vendorTitleFont);
		Paragraph vPhone = new Paragraph("Тел.: " + "(029)778-08-34", vendorFont);
		Paragraph vEmail = new Paragraph("E-mail.: " + "freonby@gmail.com", vendorFont);
		Paragraph vUnp = new Paragraph("УНП " + "691389574", vendorFont);
		Paragraph p1 = new Paragraph("- холодильное оборудование", headFont);
		Paragraph p2 = new Paragraph("- торговое оборудование", headFont);
		Paragraph p3 = new Paragraph("- кондиционеры", headFont);
		Paragraph p4 = new Paragraph("- проектирование инженерных систем", headFont);
		Paragraph p5 = new Paragraph("- инженерные услуги", headFont);

		PdfPCell cell = createCell("", 1, 1, PdfPCell.BOTTOM, Element.ALIGN_LEFT, Element.ALIGN_BOTTOM, headFont, tableColor);
		PdfPCell cell2 = createCell("", 1, 1, PdfPCell.BOTTOM, Element.ALIGN_LEFT, Element.ALIGN_BOTTOM, headFont, tableColor);
		cell.setPaddingBottom(20f);
		cell.setBorderColor(BaseColor.GRAY);
		cell.setBorderWidth(4f);
		cell2.setPaddingBottom(10f);
		cell2.setBorderColor(BaseColor.GRAY);
		cell2.setBorderWidth(4f);
		cell.setPadding(8);
		cell.addElement(logo);
		cell.addElement(vName);
		cell.addElement(vPhone);
		cell.addElement(vEmail);
		cell.addElement(vUnp);
		cell2.addElement(p1);
		cell2.addElement(p2);
		cell2.addElement(p3);
		cell2.addElement(p4);
		cell2.addElement(p5);

		headerTable.addCell(cell);
		headerTable.addCell(cell2);

		doc.add(headerTable);
		// set title invoice and number
		@SuppressWarnings("resource")
		Formatter f = new Formatter();
		Paragraph title = new Paragraph("КОММЕРЧЕСКОЕ ПРЕДЛОЖЕНИЕ №" + "212" + " от " + f.format("%td.%tm.%ty", calendar, calendar, calendar).toString(), titleFont);
		title.setAlignment(Element.ALIGN_CENTER);
		title.setSpacingAfter(20);
		doc.add(title);
		addOffer(doc, offer, headFont);

		Paragraph podp = new Paragraph("С уважением,  ИП Войтас С.П.", vendorFont);
		Paragraph delivery = new Paragraph("Доставка товара: по Минску, по Беларуси. Стоимость доставки оговаривается дополнительно.", headFont);
		Paragraph term = new Paragraph("Срок поставки: по договоренности", headFont);
		Paragraph pay = new Paragraph("Порядок оплаты: предоплата. Возможна беспроцентная отсрочка платежа 30 дней (кредитная линия банка)", headFont);
		doc.add(delivery);
		doc.add(term);
		doc.add(pay);

		podp.setSpacingBefore(30);
		doc.add(podp);
	}

	public PdfPCell createCell(String content, int colspan, int rowspan, int border, int hAlignment, int vAlignment, Font font, BaseColor color) {
		PdfPCell cell = new PdfPCell(new Phrase(content, font));
		cell.setPaddingBottom(4);
		cell.setColspan(colspan);
		cell.setRowspan(rowspan);
		cell.setBorder(border);
		cell.setHorizontalAlignment(hAlignment);
		cell.setVerticalAlignment(vAlignment);
		cell.setBorderColor(color);
		return cell;
	}

	public Document addOffer(Document doc, Customer cust, Font font) {
		Paragraph customerTitle = new Paragraph("КОМУ: " + cust.getCompanyName() + "\n", vendorTitleFont);
		Paragraph cAddress = new Paragraph("Конт.лицо: " + cust.getContactPerson(), font);
		Paragraph cPhone = new Paragraph("Тел.: " + cust.getPhone(), font);
		Paragraph cUnp = new Paragraph("email: " + cust.getEmail(), font);
		try {
			doc.add(customerTitle);
			doc.add(cAddress);
			doc.add(cPhone);
			doc.add(cUnp);

		} catch (DocumentException e) {

			e.printStackTrace();
		}

		return doc;
	}

}