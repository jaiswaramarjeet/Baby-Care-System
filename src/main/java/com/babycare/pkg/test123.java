package com.babycare.pkg;
import java.io.IOException;


import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.babycare.admin.add_product;
import com.babycare.admin.add_productDao;
import com.babycare.admin.admin;
import com.babycare.admin.admindao;
import com.babycare.admin.admininsertname;
import com.babycare.admin.insert_name_dao;
import com.babycare.babysitter.babysitter;
import com.babycare.babysitter.babysitterdao;
import com.babycare.doctor.doctor;
import com.babycare.doctor.doctordao;
import com.babycare.feedback.review;
import com.babycare.feedback.reviewdao;


@Controller

public class test123 {
	
	
    
/*-------------------------------registration dao class object-------------------------------------*/  
	@Autowired
	regdao d;  
   


/*--------------------------------name dao class object-------------------------------------------*/
	@Autowired
	namedao name; 

	/*--------------------------------aboutus-------------------------------------------*/
	
	@RequestMapping ("about")
	public String about()
	{
		return "aboutus";
	}
	
	/*--------------------------------babycaretips-------------------------------------------*/
	
	@RequestMapping ("babycare")
	public String babycare()
	{
		return "babycaretips";
	}
	/*-------------------------------Vaccination-------------------------------------------*/

	
	@RequestMapping ("vacci")
	public String vacci()
	{
		return "vaccination";
	} 
/*---------------------------------------------------registration------------------------------------*/
    @RequestMapping ("registration")
    public String login(@ModelAttribute("l")registration l)
    {
        return "registrationpage";
    }
    @RequestMapping ("logincheck")
    public String login2(@ModelAttribute("l")registration l)
    {
        d.adduser(l);
        return "userpage";
    }
  /*---------------------------------------------login-------------------------------------------*/
	@Autowired
	logindao da;
    @RequestMapping ("loginuser")
    public String login3(@ModelAttribute("k")login k)
    {
 
        return "loginpage";
    }
    @RequestMapping ("viewprofile")
    public String login4(@ModelAttribute("k")login k,Model m,HttpServletRequest res)
    {
    	
    	List r=da.Checklogin(k);
    	    	
    	if(!r.isEmpty())
    	{
    		HttpSession http=res.getSession();
    	
    		login lo=(login)r.listIterator().next();
    		
        	
    		http.setAttribute("email",res.getParameter("email"));
    		http.setAttribute("password",res.getParameter("password"));
    		return "profile";
    		
    	}
    	else
    	{
    		return "incorrect";
    	}
    	
    }
    	
   
    @RequestMapping ("profile")
    public String profile()
    {
    	return "profile";
    }
    
 /*-----------------------------------------------------------logout-------------------------------------------------------*/
    
    @RequestMapping ("/logout")
    public String logout(login k,HttpServletRequest res)
    {
    
    	
    	HttpSession http=res.getSession();
    	/*http.setAttribute("email",null);
    	http.setAttribute("password",null);*/

    	http.invalidate();
    
    	return "loginpage";
    }
    
    
 /*-----------------------------------------------------checkprofile---------------------------------------------------------*/
    
   @RequestMapping ("checkprofile")
    public String listuserdata(@ModelAttribute("l")login l,Model m,HttpServletRequest res) throws IOException
    {
   
	List<login> lo=da.Checkprofile(res);
	
	
		m.addAttribute("lo",lo);
		return "user_Details";
	
    }
    

 /*------------------------------------------Admin Login------------------------------------------------*/
    
    @Autowired
	
    admindao adm;
	
    @RequestMapping ("admin")
    public String admin1(@ModelAttribute("a")admin a)
    {
 
        return "adminform";
    }
    @RequestMapping ("adminlogin")
    public String admin2(@ModelAttribute("a")admin a,Model m,HttpServletRequest request)
    {
    	
    	List r=adm.Checkladmin(a);
    	
    	    	
    	if(!r.isEmpty())
    	{
    		HttpSession http=request.getSession();
    		
    	
    		admin ad=(admin)r.listIterator().next();
    		
        	
    		http.setAttribute("username",ad.getUser());
    		http.setAttribute("password",ad.getPass());
    		return "adminprofile";
    		
    	}
    	else
    	{
    		return "i_correct";
    	}
    	
    }
    	
   
    @RequestMapping ("adminprofile")
    public String adminprofile()
    {
    	return "adminprofile";
    }
    

/*-------------------------------------Admin Logout-------------------------------------------------*/
	
	@RequestMapping ("/adminlogout")
	public String adminlogout(@ModelAttribute("a")admin a,HttpServletRequest res)
	{
	
		
		HttpSession http=res.getSession();
		http.setAttribute("username",null);
		http.setAttribute("password",null);
	
		http.invalidate();
	
		return "adminform";
	}
	
	
/*----------------------------------Add Name-------------------------------------------------------*/
	@Autowired
	insert_name_dao inser;
	@RequestMapping ("admin_inser_name")
	    public String addname1(@ModelAttribute("admin")admininsertname admin)
	    {
		
		
	        return "admin_add_name";
	    }
	    @RequestMapping ("Show_name")
	    public String addname2(@ModelAttribute("admin")admininsertname admin)
	    {
	    	System.out.println("abc");
	    	
	        inser.addname(admin);
	       // System.out.println("abc");
	        return "adminprofile";
	    }

	    
/*--------------------------------------Admin Check Baby Name List-----------------------------------*/
	    @RequestMapping ("all_baby_name_list")
	    public ModelAndView baby_name_list1(@ModelAttribute("aa")admininsertname aa,ModelAndView model)
	    {
	    	List<admininsertname> lo=inser.Checknamelist(aa);
	   	    model.addObject("lo",lo);
	   	    model.setViewName("check_baby_name_list");
	   	    return model;
	    	//return "check_baby_name_list";
	    }
	    
/*----------------------------------Admin delete baby_name----------------------------------------------*/
	    
	    @RequestMapping("deleteName")
	    public String deleteName(@ModelAttribute("aa")admininsertname aa,HttpServletRequest request) 
	    {
	        String  nAme=request.getParameter("name");
	        inser.delete_Name(nAme);
	        return "adminprofile";
	    }
	      
	      
/*--------------------------------------Admin Check User Details-------------------------------------*/
	   
	    @RequestMapping ("user_details")
	    public ModelAndView listlogin2(@ModelAttribute("l")login l,ModelAndView model) throws IOException
	    {
	    
	    List<login> lo=da.Checkalluserdetails(l);
	    model.addObject("lo",lo);
	    model.setViewName("userdetails");
	    return model;
	    }
/*--------------------------------------admin delete user details------------------------------------------*/
	    @RequestMapping("deleteData")
	    public String deleteData(HttpServletRequest request) 
	    {
	        String  eMail=request.getParameter("email");
	        da.delete_Row(eMail);
	        return "adminprofile";
	    }
	  
	    
/*------------------------------------user check baby name list-------------------------------------------------*/
	      
			@RequestMapping ("namechack")
			public String userCheckName(@ModelAttribute("ad")admininsertname ad)
			{
			
			
			    return "namepage";
			}
			
			@RequestMapping ("user_check_name_list")
		    public ModelAndView userCheckName2(@ModelAttribute("ad")admininsertname ad,ModelAndView model) throws IOException
		    {
		    
		    List<admininsertname> lo=inser.Checknamelist2(ad);
		    model.addObject("lo",lo);
		    model.setViewName("userCheckBabyNameList");
		    return model;
		    }
			
			
			  @RequestMapping ("userProfiles")
			    public String adminprofile2()
			    {
			    	return "profile";
			    }
			    
/*---------------------------------Admin add product------------------------------------------------*/
			@Autowired
			add_productDao product;
			
			@RequestMapping (value="add_Product")
					    
		    public String product(@ModelAttribute("add")add_product add)
		    {
		        return "insertProduct";
		    }
		    @RequestMapping (value="add_Products")
		    public String product2(@ModelAttribute("add")add_product add)
		    {
		    
		        product.addProduct(add);
		        
		        return "productPage";
		    }
	
		    
/*----------------------------------------Edit Baby Name---------------------------------------------------------*/
		    
			@RequestMapping ("edit_name")
	
			
		    public String edit_name_list1(@ModelAttribute("ain")admininsertname ain,HttpServletRequest res)
		    {
				HttpSession http=res.getSession();
				http.setAttribute("name",res.getParameter("name"));
		    	return "editNameForm";
		    }
			@RequestMapping ("edit_Name")
		    public String edit_name_list12(@ModelAttribute("ain")admininsertname ain,HttpServletRequest res)
		    {
		    	//System.out.println("abc");
				HttpSession http=res.getSession();
				http.getAttribute("name");
				String bgender=res.getParameter("gender");
				String breligion=res.getParameter("religion");
				String bname=res.getParameter("name");
				String bmeaning=res.getParameter("meaning");
				ain.setGender(bgender);
				ain.setReligion(breligion);
				ain.setName(bname);
				ain.setMeaning(bmeaning);
		        inser.editBabyName(ain);
		       
		        return "adminprofile";
		    }

			
/*---------------------------------------check product list-----------------------------------------------*/
		
			   @RequestMapping ("check_Product")
			    public ModelAndView listProduct(@ModelAttribute("add")add_product add,ModelAndView model) throws IOException
			    {
			    
			    List<add_product> lo=product.Checkproductlistlist(add);
			    model.addObject("lo",lo);
			    model.setViewName("checkProduct");
			    return model;
			    }
/*-------------------------------------user check product list----------------------------------------------------------------*/
			   @RequestMapping ("user_check_Product")
			    public ModelAndView userlistProduct(@ModelAttribute("add")add_product add,ModelAndView model) throws IOException
			    {
			    
			    List<add_product> lo=product.Checkproductlistlist(add);
			    model.addObject("lo",lo);
			    model.setViewName("userCheck_product");
			    return model;
			    }
			
/*----------------------------------------delete product-----------------------------------------------------------------*/
			   @RequestMapping("deleteproduct")
			    public String deleteproduct(HttpServletRequest request) 
			    {
			        String  id=request.getParameter("pid");
			        product.delete_product(id);
			        return "adminprofile";
			    }
			   
			   
/*------------------------------------------------feedback----------------------------------------------------------------------*/
			   
				
			   @Autowired
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
				}

				
/*-------------------------------------------admin check feedback list-------------------------------------------------------*/				
			  
				 @RequestMapping ("feedbackList")
				    public ModelAndView feedbacklist(@ModelAttribute("r")review r,ModelAndView model) throws IOException
				    {
				    
				    List<review> lo=rev.feedvackList(r);
				    model.addObject("lo",lo);
				    model.setViewName("checkFeedbackList");
				    return model;
				    }
				 
/*-----------------------------------------------------Add Doctor----------------------------------------------------------------*/
				 
				 
					
				   	@Autowired
				   	doctordao doc;
					@RequestMapping ("doctor")
					public  String review1(@ModelAttribute("d")doctor d,HttpServletRequest req)
					{
						
						
						return "addDoctor";
					}
					@RequestMapping ("dOctor")
					public  String review2(@ModelAttribute("d")doctor d,HttpServletRequest req)
					{
						
						doc.addDoctor(d);
						
						return "add_doctor";
					}

/*-------------------------------------------admin check doctor list-------------------------------------------------------*/				
					  
				@RequestMapping ("doctorList")
			    public ModelAndView doctor(@ModelAttribute("d")doctor d,ModelAndView model) throws IOException
			    {
					    
				    List<doctor> lo=doc.checkDoctor(d);
				    model.addObject("lo",lo);
				    model.setViewName("checkDoctor");
				    return model;
			    }
					 
/*----------------------------------------delete doctor-----------------------------------------------------------------*/
					 			  
				 @RequestMapping("deleteDoctor")
			    public String deletedoctor(HttpServletRequest request) 
			    {
			        String  name=request.getParameter("fullname");
			        doc.delete_product(name);
			        return "adminprofile";
			    }
				 
/*------------------------------------------user search doctor-------------------------------------------------------*/
				 @RequestMapping ("doctorSearch")
				public String serchDoctor(@ModelAttribute("d")doctor d)
				{
					
					
				    return "doctor_search";
				}
					
				 @RequestMapping ("doctor_search")
			    public String searchDoctor2(@ModelAttribute("d")doctor d,Model m,HttpServletRequest res) throws IOException
			    {
				    			
					List<doctor> lo=doc.searchDoctor(d);
					if(!lo.isEmpty())
					{
					m.addAttribute("lo",lo);
				    return "userCheckDoctorList";
					}
					else
					{
						return "notFound";
					}
				    
			    }
					
 /*-----------------------------------------------------Add Babysitter----------------------------------------------------------------*/
				 
				 
					
				   	@Autowired
				   	babysitterdao bsd;
					@RequestMapping ("babySitter")
					public  String review1(@ModelAttribute("b")babysitter b,HttpServletRequest req)
					{
						
						
						return "addBabysitter";
					}
					@RequestMapping ("baby_sitter")
					public  String review2(@ModelAttribute("b")babysitter b,HttpServletRequest req)
					{
						
						bsd.addBabysitter(b);
						
						return "add_doctor";
					}

/*-------------------------------------------admin check babysitter list-------------------------------------------------------*/				
					  
				@RequestMapping ("babysitterList")
			    public ModelAndView check_Baby(@ModelAttribute("b")babysitter b,ModelAndView model) throws IOException
			    {
					    
				    List<babysitter> lo=bsd.checkBabysitter(b);
				    model.addObject("lo",lo);
				    model.setViewName("checkBabysitter");
				    return model;
			    }
					 
/*----------------------------------------delete product-----------------------------------------------------------------*/
					 			  
			 @RequestMapping("deleteBabysitter")
			    public String deleteBabysitter(HttpServletRequest request) 
			    {
			        String  aadhar=request.getParameter("aadhar");
			        bsd.delete_babysitter(aadhar);
			        return "adminprofile";
			    }
				 
/*--------------------------------------------------user search doctor-------------------------------------------------------*/
				 @RequestMapping ("BabyaitterSearch")
				public String serchDoctor(@ModelAttribute("b")babysitter b)
				{
					
					
				    return "babysitter_search";
				}
					
				 @RequestMapping ("babysitter_search")
			    public String searchDoctor2(@ModelAttribute("b")babysitter b,Model m,HttpServletRequest res) throws IOException
			    {
				    			
					List<babysitter> lo=bsd.searchBabysitter(b);
					if(!lo.isEmpty())
					{
					m.addAttribute("lo",lo);
				    return "userCheckBabysitterList";
					}
					else
					{
						return "not_found";
					}
				    
			    }
					
/*------------------------------------------edit password----------------------------------------------------------------------------------*/
				 								    
				/*	@RequestMapping ("cange_pass")
			
					
				    public String changePassword(@ModelAttribute("k")login k,HttpServletRequest res)
				    {
						HttpSession http=res.getSession();
						http.setAttribute("email",res.getParameter("email"));
				    	return "changePassword";
				    }
					@RequestMapping ("change_Pass")
				    public String changePassword2(@ModelAttribute("k")login k,HttpServletRequest res)
				    {
				    	//System.out.println("abc");
						HttpSession http=res.getSession();
						http.getAttribute("email");
						String email=res.getParameter("email");
						String password=res.getParameter("password");
						k.setEmail(email);
						k.setPass(password);
						
				        da.changePassword(k);
				       
				        return "abc";
				    }*/

}