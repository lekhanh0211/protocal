package com.shop.dao;

import java.util.List;

public interface BillDetail {

	boolean insert(BillDetail bld);

	boolean edit(BillDetail bld);

	boolean delete(int id);

	BillDetail getById(int id);

	List<BillDetail> getAll();
}
