package com.shop.controller.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.shop.entities.Comment;
import com.shop.entities.Product;
import com.shop.service.impl.CategoryServiceImpl;
import com.shop.service.impl.CommentServiceImpl;
import com.shop.service.impl.ProductServiceImpl;

@Controller
public class ShopController {
	@Autowired
	ProductServiceImpl productServiceImpl = new ProductServiceImpl();
	@Autowired
	CategoryServiceImpl categoryServiceImpl = new CategoryServiceImpl();
	@Autowired
	CommentServiceImpl commentServiceImpl = new CommentServiceImpl();

	@RequestMapping(value = { "/shop" })
	public String Shop(Model model) {
		model.addAttribute("category", categoryServiceImpl.getAll());
		model.addAttribute("product", productServiceImpl.getAll());
		return "fontend/shop";
	}

	@RequestMapping(value = "/shop/{cat_id}")
	public String ShopByCat(Model model, @PathVariable int cat_id) {
		model.addAttribute("category", categoryServiceImpl.getAll());
		model.addAttribute("probycate", productServiceImpl.getProductById(cat_id));
		return "fontend/category";
	}

	@RequestMapping(value = "/shop-detail/{id}")
	public String ShopById(Model model, @PathVariable int id) {
		// model.addAttribute("category", categoryServiceImpl.getCateByProduct(id));
		Product byId = productServiceImpl.getById(id);
		model.addAttribute("probyid", byId);
		int catId = byId.getCat_id();
		model.addAttribute("probycatid", productServiceImpl.getProductById(catId));
		model.addAttribute("commentbyid", commentServiceImpl.getCommentById(id));
		return "fontend/product-detail";
	}

	@RequestMapping(value = "/addComment", method = RequestMethod.POST)
	public String AddComment(Model model, @ModelAttribute("cmt") Comment cmt) {
		boolean bl = commentServiceImpl.insert(cmt);
		if (bl) {
			model.addAttribute("success", "Gửi bình luận thành công!!!");
		} else {
			model.addAttribute("error", "Gửi bình luận thất bại!!!");
		}
		return "fontend/product-detail";
	}

}
