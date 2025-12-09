package com.jobPortal.Bridgeify.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.nio.file.Path;
import java.nio.file.Paths;

@Configuration
public class MvcConfig implements WebMvcConfigurer {
    private static final String UPLOADS_DIR="photos";

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        exposedDirectory(UPLOADS_DIR,registry);
    }

    private void exposedDirectory(String uploadsDir, ResourceHandlerRegistry registry) {
        Path path= Paths.get(uploadsDir);
        registry.addResourceHandler("/"+uploadsDir+"/**").addResourceLocations("file:"+path.toAbsolutePath()+"/");
    }
}
