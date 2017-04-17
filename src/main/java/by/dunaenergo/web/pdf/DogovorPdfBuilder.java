package by.dunaenergo.web.pdf;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
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
	private Font textFont;
	private BaseFont arial;
	private BaseFont arialbd;

	@Override
	protected void buildPdfDocument(Map<String, Object> model, Document doc, PdfWriter writer, HttpServletRequest request, HttpServletResponse response) throws Exception {
		// get data model which is passed by the Spring container
		// receive item count
		FizCustomer customer = (FizCustomer) model.get("customer");
		String path = (String) model.get("path");
		Image logo = Image.getInstance(path + "/resources/img/logo/logo.png");
		logo.setWidthPercentage(30f);
		logo.setAlignment(Element.ALIGN_LEFT);
		BaseColor tableColor = BaseColor.GRAY;
		float ind = 20f;
		int txtAlign = Element.ALIGN_JUSTIFIED;
		int titleAlign = Element.ALIGN_CENTER;
		arial = BaseFont.createFont("arial.ttf", "cp1251", BaseFont.EMBEDDED);
		arialbd = BaseFont.createFont("arialbd.ttf", "cp1251", BaseFont.EMBEDDED);
		titleFont = new Font(arial, 12);
		headFont = new Font(arial, 8);
		textFont = new Font(arial, 9);
		vendorTitleFont = new Font(arialbd, 10);
		vendorFont = new Font(arialbd, 8);

		// set header
		Paragraph title = new Paragraph("ДОГОВОР №" + customer.getDogovorNumber(), titleFont);
		Paragraph dogDate = new Paragraph("г.Минск   " + DateParser.convertDateTo(customer.getDogovorDate()), vendorTitleFont);
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
				"Гр. Ананьева Лариса Иосифовна, именуемая в дальнейшем «Заказчик», зарегистрированная по адресу: Минский р-н, н.п. Боровляны, ул. Детская, 1; паспорт: серия МС 2861894, выдан 25.08.2016 Минским РУВД Минской обл.; личный номер: 4020565В063РВ2, с одной стороны, и Общество с ограниченной ответственностью «ДЮНАэнерго» (ООО «ДЮНАэнерго»), именуемое в дальнейшем «Исполнитель», в лице директора Сульжица А.И., действующего на основании Устава, с другой стороны, вместе именуемые «Стороны», заключили настоящий договор о нижеследующем:",
				textFont);
		headParagraph.setAlignment(txtAlign);
		headParagraph.setFirstLineIndent(ind);
		doc.add(headParagraph);

		Paragraph predmetDogTitle = new Paragraph("1. Предмет договора", vendorTitleFont);
		predmetDogTitle.setAlignment(titleAlign);
		doc.add(predmetDogTitle);

		Paragraph p1_1 = new Paragraph(
				"1.1. Исполнитель обязуется по заданию Заказчика выполнить работу по разработке проектной документации по объекту «Устройство трехфазного ввода в жилой дом Ананьевой Л.И., н.п. Боровляны, ул. Фрунзенская д.15А» и согласовать с заинтересованными, а Заказчик обязуется своевременно принять и оплатить результат выполненных работ.",
				textFont);
		p1_1.setAlignment(txtAlign);
		p1_1.setFirstLineIndent(ind);
		doc.add(p1_1);
		Paragraph p1_2 = new Paragraph("1.2. Срок выполнения работ – январь 2017 г", textFont);
		p1_2.setAlignment(txtAlign);
		p1_2.setFirstLineIndent(ind);
		doc.add(p1_2);
		Paragraph p1_3 = new Paragraph("1.3. Местонахождение объекта – Минский р-н, н.п. Боровляны, ул. Фрунзенская, д.15А.", textFont);
		p1_3.setAlignment(txtAlign);
		p1_3.setFirstLineIndent(ind);
		doc.add(p1_3);
		Paragraph stoimostDogTitle = new Paragraph("2. Стоимость работ и порядок расчетов", vendorTitleFont);
		stoimostDogTitle.setAlignment(titleAlign);
		doc.add(stoimostDogTitle);

		Paragraph p2_1 = new Paragraph(
				"2.1. Стоимость работ по настоящему договору в соответствии с расчетом цены на разработку проектной документации (Приложение 1 к договору) и с Протоколом согласования договорной (контрактной) цены (Приложение 2) составляет 48,49 рублей (сорок восемь рублей сорок девять копеек), в том числе НДС (20%) 8,08 рублей (восемь рублей восемь копеек).",
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
		doc.add(p4_4);

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

}