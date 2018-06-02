package com.example.demo.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.demo.Domain.Post;
import com.example.demo.Service.AuthorService;
import com.example.demo.Service.PostService;

@Controller
@RequestMapping("/admin")

public class AdminPostController {
	
	private PostService postService;
	private AuthorService authorService;

	
	@Autowired
	public AdminPostController(PostService postService, AuthorService authorService) {
		this.postService = postService;
		this.authorService = authorService;
		
	}
	
	@RequestMapping("/posts/create")
	public String loadAuthors( Model model ) {
		model.addAttribute("post", new Post());
		model.addAttribute("authors", authorService.list());
		return "admin/post/postForm";
		
	}
		
	@RequestMapping("/list")
	public String list(Model model) {
		model.addAttribute("posts", postService.list());
		return "admin/post/list";
	}
	
	@RequestMapping("/posts/{id}")
	public String view(@PathVariable Long id, Model model) {
		model.addAttribute("post", postService.get(id));
		return "admin/post/viewPost";
	}
	
	@RequestMapping(value = "/post/save", method = RequestMethod.POST)
	public String savePost( @Valid Post post, BindingResult bindingResult, Model model ) {
		
		if(bindingResult.hasErrors()) {
			
		}else {
			
			Post savedPost = postService.save(post);
			return "redirect:/posts/" + savedPost.getId();			
		}
		
		return null;
		
	}
	

}
