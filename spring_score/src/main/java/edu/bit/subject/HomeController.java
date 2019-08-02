package edu.bit.subject;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/score")
	public String score(Score score) {
			
		return "subject/score";
	}
	
	@RequestMapping(value = "/scoreResult")
	public String scoreResult(HttpServletRequest httpServletRequest, Score score, Model model) {
		
		String names = httpServletRequest.getParameter("namea");
		String kor = httpServletRequest.getParameter("kua");
		String eng = httpServletRequest.getParameter("ena");
		String math = httpServletRequest.getParameter("maa");
		String sci = httpServletRequest.getParameter("sca");
		
		System.out.println(names);
		
		int ku =  Integer.parseInt(kor);
		int en =  Integer.parseInt(eng);
		int ma =  Integer.parseInt(math);
		int sc =  Integer.parseInt(sci);
		
		int total = score.totalScore(ku,en,ma,sc);
		int avg = score.avgScore(total);

		System.out.println(total);
		System.out.println(avg);
		
		model.addAttribute("name",names);
		model.addAttribute("totalsum",total);
		model.addAttribute("avgscore",avg);
		model.addAttribute("ku",ku);
		model.addAttribute("en",en);
		model.addAttribute("ma",ma);
		model.addAttribute("sc",sc);
		
		return "subject/scoreResult";
	}
	
}
