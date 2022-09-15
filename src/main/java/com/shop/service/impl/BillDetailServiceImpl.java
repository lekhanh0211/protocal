package com.shop.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.shop.dao.BillDetail;
import com.shop.dao.impl.BillDetailDAOImpl;

@Service
public class BillDetailServiceImpl implements BillDetail {
	@Autowired
	private BillDetailDAOImpl billDetailDAOImpl;

	@Override
	public boolean insert(BillDetail bld) {
		// TODO Auto-generated method stub
		return billDetailDAOImpl.insert(bld);
	}

	@Override
	public boolean edit(BillDetail bld) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(int id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public BillDetail getById(int id) {
		// TODO Auto-generated method stub
		return billDetailDAOImpl.getById(id);
	}

	@Override
	public List<BillDetail> getAll() {
		// TODO Auto-generated method stub
		return billDetailDAOImpl.getAll();
	}
}
