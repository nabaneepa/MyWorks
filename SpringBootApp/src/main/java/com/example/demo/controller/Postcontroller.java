package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.Service.AuthorService;
import com.example.demo.Service.PostService;

@Controller
@RequestMapping("/posts")
public class Postcontroller {

	private PostService postService;
	
	@Autowired
	public Postcontroller(PostService postService) {
		this.postService = postService;		
	}
	
	
	@RequestMapping("/list")
	public String list(Model model) {
		model.addAttribute("posts", postService.list());
		return "user/post/list";
	}
	
	@RequestMapping("/{id}")
	public String view(@PathVariable Long id, Model model) {
		model.addAttribute("post", postService.get(id));
		return "user/post/viewPost";
	}
	
}
