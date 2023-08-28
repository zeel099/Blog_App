package com.esop.Esop_management.config;

import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.reactive.UrlBasedCorsConfigurationSource;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.Arrays;
import java.util.List;

public class CorsFilterConfig implements WebMvcConfigurer{
    @Override
    public void addCorsMappings(CorsRegistry registry) {
//        WebMvcConfigurer.super.addCorsMappings(registry);
        registry.addMapping("/**")
                .allowedOrigins("*")
                .allowedMethods("*")
                .allowedHeaders("*");

    }

    //    public static final List<String> allowedOrigins = Arrays.asList("yourDomainsHere");
//    public UrlBasedCorsConfigurationSource corsFilter() {
//        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
//        CorsConfiguration config = new CorsConfiguration();
//
//        // Set up allowed origins, methods, headers, etc.
//        config.addAllowedOrigin("http://localhost:3000");
//        config.addAllowedMethod("*");
//        //config.addAllowedMethod("POST");
//        config.addAllowedHeader("*");
//        // Add more configuration as needed
//
//        source.registerCorsConfiguration("/**", config);
//
//        //CorsFilter corsFilter = new CorsFilter(source);
//        return source;
   // }
//    @Bean
//    public FilterRegistrationBean<CorsFilter> initCorsFilter() {
        
        // @formatter:off
//        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
//        CorsConfiguration con = new CorsConfiguration();
//        con.setAllowCredentials(true);
//        con.setAllowedHeaders(Arrays.asList("Authorization", "Cache-Control", "Content-Type"));
//        con.addAllowedMethod("*");
//        con.setAllowedOrigins(allowedOrigins);
//        source.registerCorsConfiguration("/company", con);
//        FilterRegistrationBean<CorsFilter> bean = new FilterRegistrationBean<>(new CorsFilter(con));
//        bean.setOrder(Ordered.HIGHEST_PRECEDENCE);
//        return bean;
        // @formatter:on
    //}
}
