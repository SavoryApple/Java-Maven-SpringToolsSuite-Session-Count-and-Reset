package com.seannavery.counter;

import javax.servlet.http.HttpSession;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;
// New import needed!
import org.springframework.ui.Model;
@Controller
public class HomeController {
    @RequestMapping("/")
    public String index(HttpSession session, Model model) {
    	Integer currentCount = (Integer) session.getAttribute("count");
		model.addAttribute("countToShow", currentCount);
        return "index.jsp";
    }
    
    @RequestMapping("/counter")
	public String counter(HttpSession session, Model model) {
		
    	// If the count is not already in session
		if (session.getAttribute("count") == null) {
		// Use setAttribute to initialize the count in session
			session.setAttribute("count", 0);	
		}
		else {
		// increment the count by 1 using getAttribute and setAttribute
			Integer currentCount = (Integer) session.getAttribute("count");
			currentCount++;
			session.setAttribute("count", currentCount);
			model.addAttribute("countToShow", currentCount);
		}
		Integer currentCount = (Integer) session.getAttribute("count");
		model.addAttribute("countToShow", currentCount);
		return "counter.jsp";
	}
    
    @RequestMapping("/counter2")
	public String counter2(HttpSession session, Model model) {
		
    	// If the count is not already in session
		if (session.getAttribute("count") == null) {
		// Use setAttribute to initialize the count in session
			session.setAttribute("count", 0);	
		}
		else {
		// increment the count by 1 using getAttribute and setAttribute
			Integer currentCount = (Integer) session.getAttribute("count");
			currentCount += 2;
			session.setAttribute("count", currentCount);
			model.addAttribute("countToShow", currentCount);
		}
		Integer currentCount = (Integer) session.getAttribute("count");
		model.addAttribute("countToShow", currentCount);
		return "counter.jsp";
	}
    
    @RequestMapping("/reset")
   	public String reset(HttpSession session, Model model) {
   			Integer currentCount = (Integer) session.getAttribute("count");
   			currentCount = 0;
   			session.setAttribute("count", currentCount);
   			model.addAttribute("countToShow", currentCount);
   			return "counter.jsp";
   		}
   	}

