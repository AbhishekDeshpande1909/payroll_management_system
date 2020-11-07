package com.cdac.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cdac.dao.HrDao;
import com.cdac.dto.Hr;

@Service
public class HrServiceImple implements HrService {

	@Autowired
	private HrDao hrDao;
	
	@Override
	public void addHr(Hr hr) {
		hrDao.insertHr(hr);

	}

	@Override
	public boolean findHr(Hr hr) {
		return hrDao.checkHr(hr);
	}

}
