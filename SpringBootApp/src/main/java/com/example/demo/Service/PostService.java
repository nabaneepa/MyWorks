package com.example.demo.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.DAO.PostDAO;
import com.example.demo.Domain.Post;

@Service
public class PostService {
	
	private PostDAO postDAO;
	
	@Autowired
	public PostService(PostDAO postDAO) {
		this.postDAO = postDAO;
		
	}
	
	public List<Post> list() {
		return postDAO.findAllByOrderByPostedOnDesc();
	}
	

	public Post get(Long id) {
		List<Long> ids = new ArrayList<Long>();
		ids.add(id);
		List<Post> posts =  postDAO.findAllById(ids);
		System.out.println(posts.get(0).toString());
		return posts.get(0);
	}
	
	public Post save(Post post) {
		return postDAO.save(post);
	
	}
}
