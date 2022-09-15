package com.shop.service;

import java.util.List;

import com.shop.entities.Bill;

public interface BillService {
	boolean insert(Bill bill);

	boolean edit(Bill bill);

	boolean delete(int id);

	Bill getById(int id);

	List<Bill> getAll();
}
