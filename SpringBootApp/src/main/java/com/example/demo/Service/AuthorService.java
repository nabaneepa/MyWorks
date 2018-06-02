package com.example.demo.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.DAO.AuthorDAO;
import com.example.demo.Domain.Author;

@Service
public class AuthorService {
	
private AuthorDAO authorDAO;
	
	@Autowired
	public AuthorService(AuthorDAO authorDAO) {
		super();
		this.authorDAO = authorDAO;
	}

	public List<Author> list() {
		return authorDAO.findAllByOrderByLastNameAscFirstNameAsc();
	}
	
}
