package by.dunaenergo.web;

import java.util.Date;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import by.dunaenergo.web.pdf.FizCustomer;
import by.dunaenergo.web.pdf.Item;

/**
 * Handles requests for the application home page.
 */
@Controller
public class MainController {
	@Autowired
	private ServletContext servletContext;

	@RequestMapping(value = { "/", "mainPage" }, method = RequestMethod.GET)
	public ModelAndView viewMainPage() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("index");
		mav.addObject("customer", new FizCustomer());
		mav.addObject("mainStyle", "active");
		mav.addObject("contactStyle", "");
		return mav;
	}

	/**
	 * Handle request to download a PDF document
	 */

	@RequestMapping(value = "/dogovor", method = RequestMethod.GET)
	public ModelAndView dogovorPdf(@RequestParam String name, @RequestParam String shortName, @RequestParam String city, @RequestParam String street, @RequestParam String phone, @RequestParam String email, @RequestParam String passportSn, @RequestParam String passportNumber,
			@RequestParam String passportDate, @RequestParam String passportRovd, @RequestParam String passportPrivateNumber, @RequestParam String dogovorNumber, @RequestParam String objectCity, @RequestParam String objectStreet, @RequestParam String typeObject) {
		ModelAndView mav = new ModelAndView();
		FizCustomer fiz = new FizCustomer();
		fiz.setName(name);
		fiz.setShortName(shortName);
		fiz.setCity(city);
		fiz.setStreet(street);
		fiz.setPhone(phone);
		fiz.setEmail(email);
		fiz.setPassportSn(passportSn);
		fiz.setPassportNumber(passportNumber);
		fiz.setPassportDate(passportDate);
		fiz.setPassportRovd(passportRovd);
		fiz.setPassportPrivateNumber(passportPrivateNumber);
		String dogovorName = typeObject + " " + shortName + ", " + objectCity + ", " + objectStreet;
		fiz.setDogovorName(dogovorName);
		fiz.setDogovorNumber(dogovorNumber);
		Date today = new Date();
		fiz.setDogovorDate(today);
		Item item = new Item(dogovorName, "ед.", 40.41d, 1);
		fiz.setItem(item);
		String path = servletContext.getRealPath("/");
		mav.addObject("customer", fiz);
		mav.addObject("path", path);
		mav.setViewName("dogovorView");
		return mav;

	}

	@RequestMapping(value = "/invoice", method = RequestMethod.POST)
	public ModelAndView invoicePdf(@ModelAttribute("customer") FizCustomer customer) {
		ModelAndView mav = new ModelAndView();
		String path = servletContext.getRealPath("/");
		mav.addObject("customer", customer);
		mav.addObject("path", path);
		mav.setViewName("invoiceView");
		return mav;

	}

}
