package by.dunaenergo.web;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import by.dunaenergo.web.pdf.Customer;

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
		mav.addObject("customer", new Customer());
		mav.addObject("mainStyle", "active");
		mav.addObject("contactStyle", "");
		return mav;
	}

	/**
	 * Handle request to download a PDF document
	 */

	@RequestMapping(value = "/dogovor", method = RequestMethod.POST)
	public ModelAndView dogovorPdf(@ModelAttribute("customer") Customer customer) {
		ModelAndView mav = new ModelAndView();
		String path = servletContext.getRealPath("/");
		mav.addObject("customer", customer);
		mav.addObject("path", path);
		mav.setViewName("dogovorView");
		return mav;

	}

	@RequestMapping(value = "/invoice", method = RequestMethod.POST)
	public ModelAndView invoicePdf(@ModelAttribute("customer") Customer customer) {
		ModelAndView mav = new ModelAndView();
		String path = servletContext.getRealPath("/");
		mav.addObject("customer", customer);
		mav.addObject("path", path);
		mav.setViewName("invoiceView");
		return mav;

	}

}
