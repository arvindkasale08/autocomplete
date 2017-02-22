package com.autocomplete.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.autocomplete.dao.WordDao;

/**
 * Created by arvindkasale on 2/22/17.
 */
@Service
public class WordServiceImpl implements WordService {

	@Autowired
	private WordDao dao;

	@Override
	@Transactional
	public void save(List<String> list) {
		dao.save(list);
	}

	@Override
	@Transactional
	public List<String> search(String search) {
		return dao.search(search);
	}
}
