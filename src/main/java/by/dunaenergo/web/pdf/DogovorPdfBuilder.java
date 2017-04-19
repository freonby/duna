package by.dunaenergo.web.pdf;

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

import by.dunaenergo.web.pdf.MoneyToStr.Currency;
import by.dunaenergo.web.pdf.MoneyToStr.Language;
import by.dunaenergo.web.pdf.MoneyToStr.Pennies;

public class DogovorPdfBuilder extends AbstractITextPdfView {

	private Font titleFont;
	private Font headFont;
	private Font vendorTitleFont;
	private Font vendorFont;
	private Font textFont;
	private BaseFont arial;
	private BaseFont arialbd;

	@Override
	protected void buildPdfDocument(Map<String, Object> model, Document doc, PdfWriter writer, HttpServletRequest request, HttpServletResponse response) throws Exception {
		// get data model which is passed by the Spring container
		// receive item count

		FizCustomer customer = (FizCustomer) model.get("customer");
		String objectStreet = (String) model.get("objectStreet");
		String objectCity = (String) model.get("objectCity");
		String typeObject = (String) model.get("typeObject");
		Item item = new Item("Разработка проектной документации по объекту «" + typeObject + " " + customer.getShortName() + ", " + objectCity + ", " + objectStreet + "»", "ед.", 40.41d, 1);
		String path = (String) model.get("path");
		Image logo = Image.getInstance(path + "/resources/img/logo/logo.png");
		logo.setWidthPercentage(30f);
		logo.setAlignment(Element.ALIGN_LEFT);
		BaseColor tableColor = BaseColor.GRAY;
		float ind = 20f;
		int txtAlign = Element.ALIGN_JUSTIFIED;
		int titleAlign = Element.ALIGN_CENTER;
		String date = DateParser.convertDateTo(customer.getDogovorDate());
		arial = BaseFont.createFont("arial.ttf", "cp1251", BaseFont.EMBEDDED);
		arialbd = BaseFont.createFont("arialbd.ttf", "cp1251", BaseFont.EMBEDDED);
		titleFont = new Font(arial, 12);
		headFont = new Font(arial, 8);
		textFont = new Font(arial, 9);
		vendorTitleFont = new Font(arialbd, 10);
		vendorFont = new Font(arialbd, 8);

		// set header
		Paragraph title = new Paragraph("ДОГОВОР №" + customer.getDogovorNumber(), titleFont);
		Paragraph dogDate = new Paragraph("г.Минск   " + date, vendorTitleFont);
		title.setAlignment(Element.ALIGN_LEFT);
		title.setSpacingAfter(5);
		PdfPTable headerTable = new PdfPTable(2);
		headerTable.setWidthPercentage(100);
		headerTable.setSpacingAfter(5);
		headerTable.setSpacingBefore(2);
		PdfPCell cell = createCell("", 1, 1, PdfPCell.NO_BORDER, Element.ALIGN_LEFT, Element.ALIGN_BOTTOM, headFont, tableColor);
		PdfPCell cell2 = createCell("", 1, 1, PdfPCell.NO_BORDER, Element.ALIGN_LEFT, Element.ALIGN_BOTTOM, headFont, tableColor);
		cell.setPaddingBottom(20f);
		cell.setBorderColor(BaseColor.GRAY);
		cell.setBorderWidth(4f);
		cell2.setPaddingBottom(10f);
		cell2.setBorderColor(BaseColor.GRAY);
		cell2.setBorderWidth(4f);
		cell.setPadding(8);
		cell.addElement(logo);
		cell2.addElement(title);
		cell2.addElement(dogDate);
		headerTable.addCell(cell);
		headerTable.addCell(cell2);
		doc.add(headerTable);

		Paragraph headParagraph = new Paragraph(
				"Гр." + customer.getName() + ", именуемый(ая) в дальнейшем «Заказчик», зарегистрированный(ая) по адресу: " + customer.getCity() + ", " + customer.getStreet() + "; паспорт: "
						+ customer.getPassportSn() + " " + customer.getPassportNumber() + ", выдан " + customer.getPassportDate() + " " + customer.getPassportRovd() + "; личный номер: "
						+ customer.getPassportPrivateNumber()
						+ ", с одной стороны, и Общество с ограниченной ответственностью «ДЮНАэнерго» (ООО «ДЮНАэнерго»), именуемое в дальнейшем «Исполнитель», в лице директора Сульжица А.И., действующего на основании Устава, с другой стороны, вместе именуемые «Стороны», заключили настоящий договор о нижеследующем:",
				textFont);
		headParagraph.setAlignment(txtAlign);
		headParagraph.setFirstLineIndent(ind);
		doc.add(headParagraph);

		Paragraph predmetDogTitle = new Paragraph("1. Предмет договора", vendorTitleFont);
		predmetDogTitle.setAlignment(titleAlign);
		doc.add(predmetDogTitle);

		Paragraph p1_1 = new Paragraph("1.1. Исполнитель обязуется по заданию Заказчика выполнить работу по разработке проектной документации по объекту «" + typeObject + " " + customer.getShortName()
				+ ", " + objectCity + ", " + objectStreet + "» и согласовать с заинтересованными, а Заказчик обязуется своевременно принять и оплатить результат выполненных работ.", textFont);
		p1_1.setAlignment(txtAlign);
		p1_1.setFirstLineIndent(ind);
		doc.add(p1_1);
		Paragraph p1_2 = new Paragraph("1.2. Срок выполнения работ – 25 календарных дней", textFont);
		p1_2.setAlignment(txtAlign);
		p1_2.setFirstLineIndent(ind);
		doc.add(p1_2);
		Paragraph p1_3 = new Paragraph("1.3. Местонахождение объекта – " + objectCity + ", " + objectStreet, textFont);
		p1_3.setAlignment(txtAlign);
		p1_3.setFirstLineIndent(ind);
		doc.add(p1_3);
		Paragraph stoimostDogTitle = new Paragraph("2. Стоимость работ и порядок расчетов", vendorTitleFont);
		stoimostDogTitle.setAlignment(titleAlign);
		doc.add(stoimostDogTitle);

		Paragraph p2_1 = new Paragraph(
				"2.1. Стоимость работ по настоящему договору в соответствии с расчетом цены на разработку проектной документации (Приложение 1 к договору) и с Протоколом согласования договорной (контрактной) цены (Приложение 2) составляет "
						+ item.formattedDouble(item.summasNds()) + " (" + new MoneyToStr(Currency.RUR, Language.RUS, Pennies.TEXT).convert(item.summasNds()) + "), в том числе НДС (20%) "
						+ item.formattedDouble(item.nds()) + " (" + new MoneyToStr(Currency.RUR, Language.RUS, Pennies.TEXT).convert(item.nds()) + ").",
				textFont);
		p2_1.setAlignment(txtAlign);
		p2_1.setFirstLineIndent(ind);
		Paragraph p2_2 = new Paragraph("2.2. Стоимость работ может изменяться в процессе действия настоящего договора в следующих случаях:", textFont);
		p2_2.setAlignment(txtAlign);
		p2_2.setFirstLineIndent(ind);
		Paragraph p2_2_1 = new Paragraph("2.2.1. при изменении законодательства о налогообложении и сборах;", textFont);
		p2_2_1.setAlignment(txtAlign);
		p2_2_1.setFirstLineIndent(ind);
		Paragraph p2_2_2 = new Paragraph("2.2.2. при необходимости выполнения дополнительных объемов работ, не предусмотренных договором.", textFont);
		p2_2_2.setAlignment(txtAlign);
		p2_2_2.setFirstLineIndent(ind);
		Paragraph p2_3 = new Paragraph("2.3 Во всех случаях изменение договорной цены оформляется дополнительным соглашением к договору и подписывается обеими сторонами.", textFont);
		p2_3.setAlignment(txtAlign);
		p2_3.setFirstLineIndent(ind);
		Paragraph p2_4 = new Paragraph(
				"2.4. Заказчик производит окончательный расчет за выполненные работы на основании актов сдачи-приемки выполненных работ (этапов), в течение 5 (пяти) календарных дней со дня подписания акта сдачи-приемки выполненных работ (этапов).",
				textFont);
		p2_4.setAlignment(txtAlign);
		p2_4.setFirstLineIndent(ind);
		Paragraph p2_5 = new Paragraph("2.5. Источник финансирования – собственные средства Заказчика.", textFont);
		p2_5.setAlignment(txtAlign);
		p2_5.setFirstLineIndent(ind);
		doc.add(p2_1);
		doc.add(p2_2);
		doc.add(p2_2_1);
		doc.add(p2_2_2);
		doc.add(p2_3);
		doc.add(p2_4);
		doc.add(p2_5);
		Paragraph porjadokDogTitle = new Paragraph("3. Порядок сдачи-приемки работ", vendorTitleFont);
		porjadokDogTitle.setAlignment(titleAlign);
		doc.add(porjadokDogTitle);
		Paragraph p3_1 = new Paragraph(
				"3.1. При завершении работы Исполнитель представляет Заказчику акт сдачи-приемки выполненных работ. Заказчик обязан подписать акт сдачи-приемки выполненных работ в течение 5 (пяти) рабочих дней со дня передачи ему акта Исполнителем либо в этот же срок направить Исполнителю мотивированный отказ от приемки работ. При неполучении Исполнителем в указанный в настоящем пункте срок подписанного акта сдачи-приемки выполненных работ либо мотивированного отказа от приемки работ работы считаются принятыми Заказчиком и подлежат оплате в течение 5 (пяти) календарных дней со дня получения акта Заказчиком.",
				textFont);
		p3_1.setAlignment(txtAlign);
		p3_1.setFirstLineIndent(ind);
		Paragraph p3_2 = new Paragraph(
				"3.2. В случае прекращения работ по инициативе Заказчика, Заказчик обязуется оплатить Исполнителю фактически понесенные им затраты по выполнению, но не свыше стоимости работ, указанной в настоящем договоре.",
				textFont);
		p3_2.setAlignment(txtAlign);
		p3_2.setFirstLineIndent(ind);
		Paragraph p3_3 = new Paragraph(
				"3.3. При наличии мотивированного отказа сторонами составляется двухсторонний акт с перечнем необходимых доработок и сроками их выполнения. Доработки проводятся за счет Исполнителя. После устранения недостатков работа подлежит сдаче-приемке в соответствии с условиями пунктов 3.1-3.2 настоящего договора.",
				textFont);
		p3_3.setAlignment(txtAlign);
		p3_3.setFirstLineIndent(ind);
		Paragraph p3_4 = new Paragraph("3.4. Заказчик обязуется принять и оплатить досрочно выполненные Исполнителем работы.", textFont);
		p3_4.setAlignment(txtAlign);
		p3_4.setFirstLineIndent(ind);
		doc.add(p3_1);
		doc.add(p3_2);
		doc.add(p3_3);
		doc.add(p3_4);
		Paragraph otvetstenDogTitle = new Paragraph("4. Ответственность сторон", vendorTitleFont);
		otvetstenDogTitle.setAlignment(titleAlign);
		doc.add(otvetstenDogTitle);
		Paragraph p4_1 = new Paragraph(
				"4.1. За невыполнение или ненадлежащее выполнение обязательств по настоящему договору Исполнитель и Заказчик несут имущественную ответственность в соответствии с законодательством Республики Беларусь.",
				textFont);
		p4_1.setAlignment(txtAlign);
		p4_1.setFirstLineIndent(ind);
		Paragraph p4_2 = new Paragraph(
				"4.2. Заказчик несет ответственность за невыполнение или ненадлежащее выполнение обязательств, предусмотренных договором, и уплачивает неустойку (пеню) Исполнителю за:", textFont);
		p4_2.setAlignment(txtAlign);
		p4_2.setFirstLineIndent(ind);
		Paragraph p4_2a = new Paragraph(
				"- необоснованное уклонение от приемки выполненных работ и оформления документов, подтверждающих их выполнение, - в размере 0,2 % стоимости непринятых работ за каждый день просрочки, но не более стоимости этих работ.",
				textFont);
		p4_2a.setAlignment(txtAlign);
		p4_2a.setFirstLineIndent(ind);
		Paragraph p4_2b = new Paragraph(
				"- нарушение сроков оплаты выполненных и принятых в установленном порядке работ - в размере 0,2 % не перечисленной суммы за каждый день просрочки платежа, но не более размера этой суммы.",
				textFont);
		p4_2b.setAlignment(txtAlign);
		p4_2b.setFirstLineIndent(ind);
		Paragraph p4_3 = new Paragraph(
				"4.3. Исполнитель несет ответственность за невыполнение или ненадлежащее выполнение работ и уплачивает неустойку (пеню) Заказчику за несоблюдение сроков выполнения работ - в размере 0,2 % процента стоимости невыполненных работ, их видов (этапов) за каждый день просрочки, но не более 20 % их стоимости.",
				textFont);
		p4_3.setAlignment(txtAlign);
		p4_3.setFirstLineIndent(ind);
		Paragraph p4_4 = new Paragraph(
				"4.4. Стороны устанавливают досудебный (претензионный) порядок разрешения споров. Срок рассмотрения претензии – 15 (пятнадцать) календарных дней с даты получения претензии стороной.",
				textFont);
		p4_4.setAlignment(txtAlign);
		p4_4.setFirstLineIndent(ind);
		doc.add(p4_1);
		doc.add(p4_2);
		doc.add(p4_2a);
		doc.add(p4_2b);
		doc.add(p4_3);
		addNewPage(doc);
		Paragraph garantDogTitle = new Paragraph("5. Гарантийные обязательства", vendorTitleFont);
		garantDogTitle.setAlignment(titleAlign);
		doc.add(garantDogTitle);

		Paragraph p5_1 = new Paragraph(
				"5.1. Гарантийный срок на выполненные Исполнителем работы составляет 2 (два) года. Исчисление гарантийного срока на выполненные Исполнителем работы начинается с дня подписания сторонами акта сдачи-приемки работ по договору. Течение гарантийного срока продлевается на время устранения дефектов, на протяжении которого объект не мог эксплуатироваться вследствие недостатков, за которые отвечает Исполнитель.",
				textFont);
		p5_1.setAlignment(txtAlign);
		p5_1.setFirstLineIndent(ind);
		Paragraph p5_2 = new Paragraph(
				"5.2. Дефекты, выявленные в выполненных работах в период гарантийного срока, устраняются за счет Исполнителя. Для участия в составлении акта, согласования сроков и порядка устранения дефекта приглашается представитель Исполнителя, который должен прибыть на объект не позднее 5 дней со дня письменного уведомления Заказчиком. В случае неявки в установленный срок, акт составляется Заказчиком в одностороннем порядке и направляется Исполнителю для устранения дефектов.",
				textFont);
		p5_2.setAlignment(txtAlign);
		p5_2.setFirstLineIndent(ind);
		Paragraph p5_3 = new Paragraph(
				"5.3. Исполнитель не несет ответственности за дефекты, произошедшие вследствие нормативного износа, неправильной эксплуатации, ненадлежащего ремонта или повреждения третьими лицами.",
				textFont);
		p5_3.setAlignment(txtAlign);
		p5_3.setFirstLineIndent(ind);
		doc.add(p5_1);
		doc.add(p5_2);
		doc.add(p5_3);
		Paragraph termDogTitle = new Paragraph("6. Срок действия договора", vendorTitleFont);
		termDogTitle.setAlignment(titleAlign);
		doc.add(termDogTitle);
		Paragraph p6_1 = new Paragraph("6.1. Договор вступает в силу со дня его подписания и действует до полного выполнения сторонами предусмотренных в нем обязательств.", textFont);
		p6_1.setAlignment(txtAlign);
		p6_1.setFirstLineIndent(ind);
		Paragraph p6_2 = new Paragraph(
				"6.2. Внесение в договор изменений и/или дополнений возможно только по взаимному согласию Сторон с оформлением дополнительного соглашения, если иное не предусмотрено условиями настоящего договора. Срок рассмотрения Стороной предложения о внесении изменений и/или дополнений в договор составляет 10 (десять) календарных дней с даты получения соответствующего предложения от другой Стороны.",
				textFont);
		p6_2.setAlignment(txtAlign);
		p6_2.setFirstLineIndent(ind);
		Paragraph p6_3 = new Paragraph(
				"6.3. Договор может быть расторгнут по соглашению сторон, а также по основаниям, предусмотренным законодательством. Срок рассмотрения Стороной предложения о расторжении договора составляет 20 (двадцать) календарных дней с даты получения соответствующего предложения от другой Стороны.",
				textFont);
		p6_3.setAlignment(txtAlign);
		p6_3.setFirstLineIndent(ind);
		Paragraph p6_4 = new Paragraph(
				"6.4. Стороны признают юридическую силу договора, дополнительных соглашений, приложений к ним, переданных посредством факсимильной связи, до обмена оригиналами названных документов. Досылка оригиналов осуществляется в течение 10 календарных дней от даты получения названных документом по факсимильной связи.",
				textFont);
		p6_4.setAlignment(txtAlign);
		p6_4.setFirstLineIndent(ind);
		Paragraph p6_5 = new Paragraph("6.5. Приложения к настоящему договору являются его неотъемлемой частью.", textFont);
		p6_5.setAlignment(txtAlign);
		p6_5.setFirstLineIndent(ind);
		Paragraph p6_6 = new Paragraph("6.6. Настоящий договор составлен и подписан в двух экземплярах, имеющих равную юридическую силу, по одному экземпляру для каждой из сторон.", textFont);
		p6_6.setAlignment(txtAlign);
		p6_6.setFirstLineIndent(ind);
		doc.add(p6_1);
		doc.add(p6_2);
		doc.add(p6_3);
		doc.add(p6_4);
		doc.add(p6_5);
		doc.add(p6_6);
		Paragraph prilDogTitle = new Paragraph("7. Приложения", vendorTitleFont);
		prilDogTitle.setAlignment(titleAlign);
		doc.add(prilDogTitle);
		Paragraph p7_1 = new Paragraph("Приложение № 1. Расчет цены на разработку проектной документации.", textFont);
		p7_1.setAlignment(txtAlign);
		p7_1.setFirstLineIndent(ind);
		Paragraph p7_2 = new Paragraph("Приложение № 2. Протокол согласования договорной (контрактной) цены.", textFont);
		p7_2.setAlignment(txtAlign);
		p7_2.setFirstLineIndent(ind);
		doc.add(p7_1);
		doc.add(p7_2);
		Paragraph adressDogTitle = new Paragraph("8. Юридические адреса и реквизиты сторон", vendorTitleFont);
		adressDogTitle.setAlignment(titleAlign);
		doc.add(adressDogTitle);
		Paragraph footerDogTitle = new Paragraph("ЗАКАЗЧИК:", titleFont);
		footerDogTitle.setAlignment(Element.ALIGN_LEFT);
		doc.add(footerDogTitle);
		Paragraph p8_1 = new Paragraph(
				"Гр." + customer.getName() + ", зарегистрированный(ая) по адресу: " + customer.getCity() + ", " + customer.getStreet() + "; паспорт: " + customer.getPassportSn() + " "
						+ customer.getPassportNumber() + ", выдан " + customer.getPassportDate() + " " + customer.getPassportRovd() + "; личный номер: " + customer.getPassportPrivateNumber(),
				textFont);
		p8_1.setAlignment(txtAlign);

		doc.add(p8_1);
		Paragraph footerDogTitle1 = new Paragraph("ИСПОЛНИТЕЛЬ:", titleFont);
		footerDogTitle1.setAlignment(Element.ALIGN_LEFT);
		doc.add(footerDogTitle1);
		Paragraph p8_2 = new Paragraph("ООО «ДЮНАэнерго» 220029, г. Минск, пр. Машерова, 17, к.725", textFont);
		p8_2.setAlignment(txtAlign);

		Paragraph p8_3 = new Paragraph("тел./факс +375 (17) 286 34 08 , +375 (29) 753 82 83, e-mail: na_an@tut.by, сайт: www.dunaenergo.by", textFont);
		p8_3.setAlignment(txtAlign);

		Paragraph p8_4 = new Paragraph("УНП 192485462 ОКПО 382368345000 р/с 3012037816018", textFont);
		p8_4.setAlignment(txtAlign);

		Paragraph p8_5 = new Paragraph("в ЦБУ 111 ОАО «Приорбанк», код 153001749 Адрес банка: 220123, г. Минск, пр. Машерова, 40", textFont);
		p8_5.setAlignment(txtAlign);

		doc.add(p8_2);
		doc.add(p8_3);
		doc.add(p8_4);
		doc.add(p8_5);

		PdfPTable footerTable = new PdfPTable(2);
		footerTable.setWidthPercentage(100);
		footerTable.setSpacingAfter(5);
		footerTable.setSpacingBefore(15);
		PdfPCell cell3 = createCell("", 1, 1, PdfPCell.NO_BORDER, Element.ALIGN_LEFT, Element.ALIGN_TOP, headFont, tableColor);
		PdfPCell cell4 = createCell("", 1, 1, PdfPCell.NO_BORDER, Element.ALIGN_LEFT, Element.ALIGN_TOP, headFont, tableColor);
		cell3.setPaddingBottom(20f);
		cell3.setBorderWidth(4f);
		cell4.setPaddingBottom(20f);
		cell4.setBorderWidth(4f);

		cell3.addElement(footerDogTitle);
		Paragraph p8_12 = new Paragraph("Гр." + customer.getName(), textFont);
		Paragraph p8_6 = new Paragraph("_____________________  " + customer.getShortName(), textFont);
		p8_6.setSpacingBefore(40);
		Paragraph p8_7 = new Paragraph(date, textFont);
		p8_7.setSpacingBefore(10);

		cell3.addElement(p8_12);
		cell3.addElement(p8_6);
		cell3.addElement(p8_7);

		cell4.addElement(footerDogTitle1);
		Paragraph p8_8 = new Paragraph("Директор ООО «ДЮНАэнерго»", textFont);
		Paragraph p8_9 = new Paragraph("_____________________  А.И.Сульжиц", textFont);
		p8_9.setSpacingBefore(40);
		Paragraph p8_10 = new Paragraph(date + "        м.п.", textFont);
		p8_10.setSpacingBefore(10);

		cell4.addElement(p8_8);
		cell4.addElement(p8_9);
		cell4.addElement(p8_10);

		footerTable.addCell(cell3);
		footerTable.addCell(cell4);
		doc.add(footerTable);
		addNewPage(doc);
		Paragraph pril2Title = new Paragraph("Приложение 2", vendorFont);
		Paragraph pril2Title1 = new Paragraph("к договору №" + customer.getDogovorNumber(), textFont);
		Paragraph pril2Title3 = new Paragraph("от " + date, textFont);
		PdfPTable pril2Table = new PdfPTable(4);
		pril2Table.setWidthPercentage(100);
		pril2Table.setSpacingAfter(50);
		PdfPCell cellp1 = createCell("", 1, 1, PdfPCell.NO_BORDER, Element.ALIGN_LEFT, Element.ALIGN_TOP, headFont, tableColor);
		PdfPCell cellp2 = createCell("", 1, 1, PdfPCell.NO_BORDER, Element.ALIGN_LEFT, Element.ALIGN_TOP, headFont, tableColor);
		PdfPCell cellp3 = createCell("", 1, 1, PdfPCell.NO_BORDER, Element.ALIGN_LEFT, Element.ALIGN_TOP, headFont, tableColor);
		PdfPCell cellp4 = createCell("", 1, 1, PdfPCell.NO_BORDER, Element.ALIGN_LEFT, Element.ALIGN_TOP, headFont, tableColor);
		cellp4.addElement(pril2Title);
		cellp4.addElement(pril2Title1);
		cellp4.addElement(pril2Title3);
		pril2Table.addCell(cellp1);
		pril2Table.addCell(cellp2);
		pril2Table.addCell(cellp3);
		pril2Table.addCell(cellp4);
		doc.add(pril2Table);
		Paragraph protokolDogTitle = new Paragraph("ПРОТОКОЛ", vendorTitleFont);
		protokolDogTitle.setAlignment(titleAlign);
		doc.add(protokolDogTitle);
		Paragraph protokolp1 = new Paragraph("согласования договорной (контрактной) цены", textFont);
		protokolp1.setAlignment(titleAlign);
		Paragraph protokolp2 = new Paragraph("к договору № " + customer.getDogovorNumber() + " от " + date, textFont);
		protokolp2.setAlignment(titleAlign);
		Paragraph protokolp3 = new Paragraph("Разработка проектной документации по объекту", vendorFont);
		protokolp3.setAlignment(titleAlign);
		Paragraph protokolp4 = new Paragraph("«" + typeObject + " " + customer.getShortName() + ", " + objectCity + ", " + objectStreet + "»", vendorFont);
		protokolp4.setAlignment(titleAlign);
		protokolp4.setSpacingAfter(20);
		doc.add(protokolp1);
		doc.add(protokolp2);
		doc.add(protokolp3);
		doc.add(protokolp4);
		Paragraph protokolText1 = new Paragraph("Мы, нижеподписавшиеся, от лица Заказчика – Гр." + customer.getName() + ", зарегистрированный(ая) по адресу: " + customer.getCity() + ", "
				+ customer.getStreet() + "; паспорт: " + customer.getPassportSn() + " " + customer.getPassportNumber() + ", выдан " + customer.getPassportDate() + " " + customer.getPassportRovd()
				+ "; личный номер: " + customer.getPassportPrivateNumber()
				+ ", и от лица Исполнителя – Общества с ограниченной ответственностью «ДЮНАэнерго» - директор Сульжиц Андрей Иванович удостоверяем, что сторонами достигнуто соглашение о величине договорной (контрактной) цены на выполнение работ по договору № "
				+ customer.getDogovorNumber() + " от " + date + " в сумме " + item.formattedDouble(item.summasNds()) + " ("
				+ new MoneyToStr(Currency.RUR, Language.RUS, Pennies.TEXT).convert(item.summasNds()) + "), в том числе НДС (20%) " + item.formattedDouble(item.nds()) + " ("
				+ new MoneyToStr(Currency.RUR, Language.RUS, Pennies.TEXT).convert(item.nds()) + ").", textFont);

		protokolText1.setAlignment(txtAlign);
		protokolText1.setFirstLineIndent(ind);
		Paragraph protokolText2 = new Paragraph("Настоящий протокол является основанием для проведения взаимных расчетов и платежей между Заказчиком и Исполнителем.", textFont);
		protokolText2.setAlignment(txtAlign);
		protokolText2.setFirstLineIndent(ind);
		doc.add(protokolText1);
		doc.add(protokolText2);
		doc.add(footerTable);

		// set invoice table
		PdfPTable invoiceTable = new PdfPTable(9);
		invoiceTable.setWidthPercentage(100);
		float[] columnWidths = { 10, 50, 10, 10, 15, 20, 10, 15, 20 };
		invoiceTable.setWidths(columnWidths);
		invoiceTable.setSpacingBefore(20);
		invoiceTable.setSpacingAfter(20);
		addNewPage(doc);
		PdfPTable headerInvoice = new PdfPTable(1);
		headerInvoice.setWidthPercentage(100);
		headerInvoice.setSpacingAfter(20);
		headerInvoice.setSpacingBefore(5);
		// String headText = "Внимание!Товар отпускается по факту прихода денег
		// на р/c Поставщика, при наличии доверенности и паспорта. В
		// доверенности должны быть указаны УНП и ОКПО Плательщика.";
		// Paragraph head = new Paragraph(headText, headFont);
		Paragraph vendorTitle = new Paragraph("ПОЛУЧАТЕЛЬ:\n", vendorTitleFont);
		vendorTitle.setSpacingBefore(20);
		Paragraph vName = new Paragraph("ООО «ДЮНАэнерго»", vendorTitleFont);
		Paragraph vAddress = new Paragraph("Адрес: " + "220029, г. Минск, пр. Машерова, 17, к.725", vendorFont);
		Paragraph vPhone = new Paragraph("Тел.: " + "+375 (17) 286 34 08", vendorFont);
		Paragraph vUnp = new Paragraph("УНП 192485462 ОКПО 382368345000", vendorFont);
		Paragraph vBank = new Paragraph("Банк: " + "ЦБУ 111 ОАО «Приорбанк»" + " " + "Адрес банка: 220123, г. Минск, пр. Машерова, 40", vendorFont);
		Paragraph vBankAccount = new Paragraph("Р/c: " + "3012037816018", vendorFont);
		Paragraph vBankCode = new Paragraph("Код банка: " + "153001749", vendorFont);
		PdfPCell cellTitle = new PdfPCell(new Phrase("ООО «ДЮНАэнерго»", vendorFont));

		cellTitle.setPadding(8);
		cellTitle.addElement(vName);
		cellTitle.addElement(vAddress);
		cellTitle.addElement(vPhone);
		cellTitle.addElement(vUnp);
		cellTitle.addElement(vBank);
		cellTitle.addElement(vBankAccount);
		cellTitle.addElement(vBankCode);
		headerInvoice.addCell(cellTitle);
		// doc.add(head);
		doc.add(vendorTitle);
		doc.add(headerInvoice);

		// set title invoice and number
		Paragraph titleInv = new Paragraph("СЧЕТ-ФАКТУРА №" + customer.getDogovorNumber() + " от " + date, titleFont);
		titleInv.setAlignment(Element.ALIGN_CENTER);
		titleInv.setSpacingAfter(5);
		doc.add(titleInv);
		doc.add(protokolp2);

		addCustomer(doc, customer, headFont);
		// invoice table head
		addHeadTable(invoiceTable, Element.ALIGN_CENTER, Element.ALIGN_CENTER, tableColor);

		// add item to invoice table
		addItem(invoiceTable, item, Element.ALIGN_RIGHT, Element.ALIGN_RIGHT, tableColor);
		// add table footer
		addFooterTable(invoiceTable, item.formattedDouble(item.summa()), item.formattedDouble(item.nds()), item.formattedDouble(item.summasNds()), Element.ALIGN_RIGHT, Element.ALIGN_RIGHT,
				tableColor);
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

		Paragraph podp = new Paragraph("Счет выдал   _________________________   Директор ООО «ДЮНАэнерго» А.И.Сульжиц", vendorFont);
		podp.setSpacingBefore(30);
		doc.add(podp);
		Paragraph mp = new Paragraph("м.п.", vendorFont);
		mp.setSpacingBefore(20);
		mp.setIndentationLeft(20);
		doc.add(mp);
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

	public PdfPTable addItem(PdfPTable invoiceTable, Item item, int hAlignment, int vAlignment, BaseColor color) {
		invoiceTable.addCell(createCell("1", 1, 1, PdfPCell.BOX, Element.ALIGN_CENTER, vAlignment, headFont, color));
		invoiceTable.addCell(createCell(item.getItemName(), 1, 1, PdfPCell.BOX, Element.ALIGN_LEFT, vAlignment, headFont, color));
		invoiceTable.addCell(createCell(item.getIzm(), 1, 1, PdfPCell.BOX, Element.ALIGN_CENTER, vAlignment, headFont, color));
		invoiceTable.addCell(createCell(Long.toString(item.getItemCount()), 1, 1, PdfPCell.BOX, Element.ALIGN_CENTER, vAlignment, headFont, color));
		invoiceTable.addCell(createCell(item.formattedDouble(item.getPriceDouble()), 1, 1, PdfPCell.BOX, hAlignment, vAlignment, headFont, color));
		invoiceTable.addCell(createCell(item.formattedDouble(item.summa()), 1, 1, PdfPCell.BOX, hAlignment, vAlignment, headFont, color));
		invoiceTable.addCell(createCell("20", 1, 1, PdfPCell.BOX, hAlignment, vAlignment, headFont, color));
		invoiceTable.addCell(createCell(item.formattedDouble(item.nds()), 1, 1, PdfPCell.BOX, hAlignment, vAlignment, headFont, color));
		invoiceTable.addCell(createCell(item.formattedDouble(item.summasNds()), 1, 1, PdfPCell.BOX, hAlignment, vAlignment, headFont, color));
		return invoiceTable;
	}

	public PdfPTable addFooterTable(PdfPTable invoiceTable, String summa, String nds, String summasNds, int hAlignment, int vAlignment, BaseColor color) {
		invoiceTable.addCell(createCell("Итого", 5, 1, PdfPCell.NO_BORDER, Element.ALIGN_CENTER, vAlignment, vendorFont, color));
		invoiceTable.addCell(createCell(summa, 1, 1, PdfPCell.BOX, hAlignment, vAlignment, vendorFont, color));
		invoiceTable.addCell(createCell(nds, 2, 1, PdfPCell.BOX, hAlignment, vAlignment, vendorFont, color));
		invoiceTable.addCell(createCell(summasNds, 1, 1, PdfPCell.BOX, hAlignment, vAlignment, vendorFont, color));
		return invoiceTable;
	}

	public PdfPTable addHeadTable(PdfPTable invoiceTable, int hAlignment, int vAlignment, BaseColor color) {
		invoiceTable.addCell(createCell("№", 1, 1, PdfPCell.BOX, hAlignment, vAlignment, headFont, color));
		invoiceTable.addCell(createCell("Наименование товара(услуги,работы)", 1, 1, PdfPCell.BOX, hAlignment, vAlignment, headFont, color));
		invoiceTable.addCell(createCell("Ед.изм.", 1, 1, PdfPCell.BOX, hAlignment, vAlignment, headFont, color));
		invoiceTable.addCell(createCell("Кол-во", 1, 1, PdfPCell.BOX, hAlignment, vAlignment, headFont, color));
		invoiceTable.addCell(createCell("Цена", 1, 1, PdfPCell.BOX, hAlignment, vAlignment, headFont, color));
		invoiceTable.addCell(createCell("Сумма", 1, 1, PdfPCell.BOX, hAlignment, vAlignment, headFont, color));
		invoiceTable.addCell(createCell("Ставка НДС %", 1, 1, PdfPCell.BOX, hAlignment, vAlignment, headFont, color));
		invoiceTable.addCell(createCell("НДС", 1, 1, PdfPCell.BOX, hAlignment, vAlignment, headFont, color));
		invoiceTable.addCell(createCell("Сумма с НДС", 1, 1, PdfPCell.BOX, hAlignment, vAlignment, headFont, color));
		return invoiceTable;
	}

	public void addNewPage(Document doc) {
		Paragraph emptySpace = new Paragraph(" ", textFont);
		while (!doc.newPage()) {
			try {
				doc.add(emptySpace);
			} catch (DocumentException e) {

				e.printStackTrace();
			}
		}

	}

	public Document addCustomer(Document doc, FizCustomer customer, Font font) {

		Paragraph customerTitle = new Paragraph("ПЛАТЕЛЬЩИК: " + customer.getName() + "\n", vendorTitleFont);
		Paragraph cAddress = new Paragraph("Адрес регистрации: " + customer.getCity() + ", " + customer.getStreet(), font);
		Paragraph cPassport = new Paragraph("Паспорт: " + customer.getPassportSn() + " " + customer.getPassportNumber(), font);
		Paragraph cVyd = new Paragraph("Выдан: " + customer.getPassportDate() + " " + customer.getPassportRovd(), font);
		Paragraph cPrivateNumb = new Paragraph("Личный номер: " + customer.getPassportPrivateNumber(), font);

		try {
			doc.add(customerTitle);
			doc.add(cAddress);
			doc.add(cPassport);
			doc.add(cVyd);
			doc.add(cPrivateNumb);

		} catch (DocumentException e) {

			e.printStackTrace();
		}

		return doc;
	}

}