package com.autocomplete.dao;

import java.util.List;
import java.util.stream.Collectors;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.autocomplete.model.Alphabet;
import com.autocomplete.model.Word;

/**
 * Created by arvindkasale on 2/22/17.
 */
@Repository
public class WordDaoImpl implements WordDao {

	@Autowired
	private SessionFactory sessionFactory;

	public void save(List<String> list) {
		int count = 0;
		Session session = sessionFactory.getCurrentSession();
		for(String str : list) {

			count++;
			if(count > 120078) {
				Word word = new Word(str);
				Alphabet alphabet = new Alphabet(str);
				word.setAlphabet(alphabet);
				session.save(alphabet);
				session.save(word);
				System.out.println("SAving string :" + count + ": " + str);
				if (count % 20 == 0) { //20, same as the JDBC batch size
					//flush a batch of inserts and release memory:
					session.flush();
					session.clear();
				}
			}
		}
	}

	@Override
	public List<String> search(String search) {
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Word.class);
		criteria.createAlias("alphabet","alphabet");
		List<Word> words = criteria.add(Restrictions.like("name", search+"%")).list();
		return words.stream().map(word -> word.getName()).collect(Collectors.toList());
	}
}
