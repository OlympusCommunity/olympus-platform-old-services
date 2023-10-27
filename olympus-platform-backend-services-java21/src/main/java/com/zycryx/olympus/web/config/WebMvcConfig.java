package com.zycryx.olympus.web.config;

import com.zycryx.olympus.util.constants.ValidationConstant;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
            registry.addMapping("/**")
                    .allowedHeaders("*")
                    .allowedMethods("*")
                    .allowedOriginPatterns("*")
                    .allowCredentials(true)
                    .maxAge(ValidationConstant.MAX_AGE_SECS);
    }

}
