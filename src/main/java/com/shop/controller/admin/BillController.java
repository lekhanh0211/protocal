package com.shop.controller.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.shop.entities.Bill;
import com.shop.service.impl.BillServiceImpl;

@Controller
@RequestMapping(value = "/admin")
public class BillController {
	@Autowired
	private BillServiceImpl billServiceImpl;

	@RequestMapping(value = { "", "/bill" })
	public String Bill(Model model) {
		model.addAttribute("bill", billServiceImpl.getAll());
		return "backend/bill";
	}

	@RequestMapping(value = { "", "/bill-detail" })
	public String BillDetail() {

		return "backend/bill-detail";
	}

	@RequestMapping(value = { "", "/deleteBill" })
	public String DeleteBill(@RequestParam("id") Integer id, Model model) {
		boolean bl = billServiceImpl.delete(id);
		if (bl) {
			model.addAttribute("success", "Xóa hóa đơn thành công!!!");
		} else {
			model.addAttribute("error", "Xóa hóa đơn thất  bại!!!");
		}
		List<Bill> listBl = billServiceImpl.getAll();
		model.addAttribute("bill", listBl);
		return "backend/bill";
	}
}
