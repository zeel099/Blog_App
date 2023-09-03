package com.blog.controllers;


import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import javax.servlet.http.HttpServletResponse;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.blog.config.AppConstants;
import com.blog.entity.Post;
import com.blog.payloads.ApiResponse;
import com.blog.payloads.CategoryDto;
import com.blog.payloads.PostDto;
import com.blog.payloads.PostResponse;
import com.blog.services.FileService;
import com.blog.services.PostService;

@RestController
@RequestMapping("/api/")
public class PostController{
	@Autowired(required=false)
	private PostService postService;
	
	@Autowired
	private FileService fileService;
	
	@Value("${project.image}")
	private String path;
	
	@PostMapping("/user/{userId}/category/{categoryId}/posts")
	public ResponseEntity<PostDto>createPost(@RequestBody PostDto postDto,@PathVariable Integer userId,@PathVariable Integer categoryId){				
		PostDto createPost = this.postService.createPost(postDto, userId, categoryId);
		return new ResponseEntity<PostDto>(createPost,HttpStatus.CREATED);
	}
	
	@GetMapping("/user/{userId}/posts")
	public ResponseEntity<List<PostDto>> getPostsByUser(@PathVariable Integer userId){
		
		List<PostDto>posts = this.postService.getPostsByUser(userId);
		return new ResponseEntity<List<PostDto>>(posts,HttpStatus.OK);
	}
	
	@GetMapping("/category/{categoryId}/posts")
	public ResponseEntity<List<PostDto>> getPostsByCategory(@PathVariable Integer categoryId){
		
		List<PostDto>posts = this.postService.getPostsByUser(categoryId);
		return new ResponseEntity<List<PostDto>>(posts,HttpStatus.OK);
	}
	
	@GetMapping("/posts/{postId}")
	public ResponseEntity<PostDto> getPost(@PathVariable Integer postId){
		PostDto postDto = this.postService.getPostById(postId);
		return new ResponseEntity<PostDto>(postDto,HttpStatus.OK);
	}
	
	@GetMapping("/posts")
	public ResponseEntity<PostResponse>getAllPost(
			@RequestParam(value = "pageNumber",defaultValue =AppConstants.PAGE_NUMBER,required=false)Integer pageNumber,
			@RequestParam(value = "pageSie",defaultValue=AppConstants.PAGE_SIZE,required=false)Integer pageSize,
			@RequestParam(value= "sortBy",defaultValue=AppConstants.SORT_BY,required=false)String sortBy,
			@RequestParam(value= "sortDir",defaultValue=AppConstants.SOORT_DIR,required=false)String sortDir,
			@RequestParam(value= "imaNamege",defaultValue=AppConstants.IMAGE_NAME,required=false)String imageName
			){
		
			PostResponse postResponse = this.postService.getAllPost(pageNumber,pageSize,sortBy,sortDir,imageName);
			return new ResponseEntity<PostResponse>(postResponse ,HttpStatus.OK);
	}
	
	@DeleteMapping("/posts/{postId}")
	public ApiResponse deletePost(@PathVariable Integer postId) {
		this.postService.deletePost(postId);
		return new ApiResponse("post is succesfully deleted !!",true);
	}
	
	@PutMapping("/posts/{postId}")
	public ResponseEntity<PostDto> updatePost(@RequestBody PostDto postDto,@PathVariable Integer postId) {
		PostDto updatePost = this.postService.updatePost(postDto,postId);
		return new ResponseEntity<PostDto>(updatePost,HttpStatus.OK);
	}
	
	//search 
	@GetMapping("/posts/search/{keywords}")
	public ResponseEntity<List<PostDto>>searchPostByTitle(
		@PathVariable("keywords")String keywords
	){
		List<PostDto>result = this.postService.searchPosts(keywords);
		return new ResponseEntity<List<PostDto>>(result,HttpStatus.OK);
	}
	
	//post image upload
	
	@PostMapping("/post/image/upload/{postId}")
	public ResponseEntity<PostDto>uploadPostImage(
			@RequestParam("image")MultipartFile image,
			@PathVariable Integer postId) throws IOException{
		
		PostDto postDto = this.postService.getPostById( postId);
		String fileName = this.fileService.uploadImage(path, image);
		
		postDto.setImageName(fileName);
		PostDto updatePost = this.postService.updatePost(postDto, postId);
		
		return new ResponseEntity<PostDto>(updatePost,HttpStatus.OK);
	}
	
	//method to serve files
	@GetMapping(value = "post/image/{imageName}",produces = MediaType.IMAGE_JPEG_VALUE)
	public void downloadImage(
		@PathVariable("imageName") String imageName,
		HttpServletResponse response) throws IOException{
			InputStream resource = this.fileService.getResource(path,imageName);
			response.setContentType(MediaType.IMAGE_JPEG_VALUE);
			StreamUtils.copy(resource,response.getOutputStream());
	}
	
}



