package com.babycare.pkg;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.babycare.feedback.review;
import com.babycare.feedback.reviewdao;

@Controller
public class reviewController {
	
	/*@Autowired
	reviewdao rev;
	@RequestMapping ("rEview")
	public  String review1(@ModelAttribute("r")review r,HttpServletRequest req)
	{
		String email=req.getParameter("email");
		
		return "reviewForm";
	}
	@RequestMapping ("Review")
	public  String review2(@ModelAttribute("r")review r,HttpServletRequest req)
	{
		String email=req.getParameter("email");
		rev.review(r,req);
		
		return "profile";
	}*/

}
