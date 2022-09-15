package com.shop.controller.user;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.shop.dto.CartDto;
import com.shop.entities.Bill;
import com.shop.service.impl.BillDetailServiceImpl;
import com.shop.service.impl.BillServiceImpl;

@Controller

public class CheckOutController {
	@Autowired
	private BillServiceImpl billServiceImpl;
	@Autowired
	private BillDetailServiceImpl billDetailServiceImpl;

	@InitBinder
	public void initBinder(WebDataBinder data) {
		SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
		data.registerCustomEditor(Date.class, new CustomDateEditor(sf, true));
	}

	@RequestMapping(value = "/checkout")
	public String CheckOut(Model model, HttpSession session) {
		Bill bill = new Bill();
		model.addAttribute("bill", bill);
		return "fontend/checkout";
	}

	@RequestMapping(value = "/checkout", method = RequestMethod.POST)

	public String CheckOrder(Model model, @ModelAttribute("bill") Bill bill, HttpSession session) {

		boolean bl = billServiceImpl.insert(bill);
		model.addAttribute("bill", bill);
//		HashMap<Long, CartDto> bill = (HashMap<Long, CartDto>) session.getAttribute("loginInfo");
//		billDetailServiceImpl.insert(bill);
		return "fontend/checkout";
	}

}
