package org.muqit.carrentalsystem.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.muqit.carrentalsystem.configuration.CRSBeanConfig;
import org.muqit.carrentalsystem.constants.CRSConstants;
import org.muqit.carrentalsystem.frameworkspecifics.SpringHandler;
import org.muqit.carrentalsystem.model.BookingHistory;
import org.muqit.carrentalsystem.service.CRSServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class BookingHandler 
{

	SpringHandler springHandler = null;
	ApplicationContext context = null;
	
	private boolean isSessionActive(HttpServletRequest request)
	{
		boolean isActive = false;
		HttpSession session = request.getSession(false);
		if(session != null && session.getAttribute("user") != null)
		{
			isActive = true;
		}
		return isActive;
	}
	
	private void setNecessaryObjects()
	{
		springHandler = SpringHandler.getInstance();
	    context = springHandler.getContext(CRSBeanConfig.class);
	}
	
	@RequestMapping(value = "/bookingHistory/{action}", method = RequestMethod.POST)
	public ModelAndView customerActionHandle(@PathVariable String action, @Valid @ModelAttribute("bookingHistory") BookingHistory bookingHistory, BindingResult result, HttpServletRequest request)
	{
		ModelAndView mv = new ModelAndView();
		if(!isSessionActive(request))
		{
			mv.setViewName("Login");
			return mv;
		}
		
		mv.setViewName("BookingHistory");
		bookingHistory.setIsSubmitted(0);
		
		if(result.hasErrors()) 
		{
			request.setAttribute("message", CRSConstants.messageInvalidData);
		}
		else 
		{
			setNecessaryObjects();
			CRSServiceImpl service = context.getBean(CRSServiceImpl.class);
			service.setNecessaryObjects();
			
			if(action.equals("add"))
			{
				service.add(bookingHistory, request);
			}
		}
		return mv;
	}
	
	//@RequestMapping(value = "/customer/all", method = RequestMethod.GET)
	public ModelAndView getAllCustomers(HttpServletRequest request)
	{
		ModelAndView mv = new ModelAndView();
		if(!isSessionActive(request))
		{
			mv.setViewName("Login");
			return mv;
		}
		mv.setViewName("AllCustomers");

		setNecessaryObjects();
		CRSServiceImpl service = context.getBean(CRSServiceImpl.class);
		service.setNecessaryObjects();
		
		service.getAllCustomers(request);
		return mv;
	}
	
// commit
}
