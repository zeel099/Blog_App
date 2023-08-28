package com.esop.Esop_management.security;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
//import org.springframework.stereotype.Component;
//import org.springframework.web.filter.OncePerRequestFilter;

import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.MalformedJwtException;
//@Component
public class JwtAuthenticationFilter {

//	@Autowired
//	private UserDetailsService userDetailsService;
//
//	@Autowired
//	private JwtTokenHelper jwtTokenHelper;
//
//	@Override
//	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
//			throws ServletException, IOException {
//		// TODO Auto-generated method stub
//		//1. get token from request
//		String requestToken = request.getHeader("Authorization");
//		Bearer 23433ut
//		System.out.println(requestToken);
//
//		String username =null;
//		String token = null;
//
//		if(requestToken!=null && requestToken.startsWith("Basic")) {
//
//			token = requestToken.substring(7);
//
//			try {
//				username = this.jwtTokenHelper.getUsernameFromToken(token);
//			}catch(IllegalArgumentException e) {
//				System.out.println("Unable to get jwt token");
//			}catch(ExpiredJwtException e) {
//				System.out.println("Jwt token has expired");
//			}catch(MalformedJwtException e) {
//				System.out.println("Invalid Jwt");
//			}
//
//
//		}else {
//			System.out.println("Jwt token does not begin with bearer");
//		}
//
//		//once we get the token now validate
//
//		if(username!=null && SecurityContextHolder.getContext().getAuthentication()==null) {
//
//			UserDetails userDetails = this.userDetailsService.loadUserByUsername(username);
//			if(this.jwtTokenHelper.validationToken(token, userDetails)) {
//				//authentication
//
//				UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(userDetails,null,userDetails.getAuthorities());
//				usernamePasswordAuthenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
//
//
//				SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
//			}else {
//				System.out.println("Invalid jwt token");
//			}
//
//
//
//		}else {
//			System.out.println("username is null OR context details is not null");
//		}
//
//		filterChain.doFilter(request, response);
//	}
//

}
