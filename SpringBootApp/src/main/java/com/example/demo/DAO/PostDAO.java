package com.example.demo.DAO;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.Domain.Post;
import java.lang.Long;


public interface PostDAO extends CrudRepository<Post, Long>{
	
	Post findFirstByOrderByPostedOnDesc();
	
	List<Post> findAllByOrderByPostedOnDesc();

	List<Post> findAllByAuthorIdOrderByPostedOnDesc(Long id);
	
	List<Post> findAllById(List<Long> ids);

}
