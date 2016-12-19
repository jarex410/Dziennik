package com.diary.init;

import org.springframework.context.annotation.*;
import org.springframework.core.env.Environment;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import javax.annotation.Resource;

@Configuration
@EnableTransactionManagement
@EnableWebMvc
@PropertySource("classpath:application.properties")
@ComponentScan(basePackages = {"com.diary"}, excludeFilters = {@ComponentScan.Filter(type = FilterType.ANNOTATION,
        value = Configuration.class)})
@Import({SecurityConfig.class})
public class WebApplicationConfig extends WebMvcConfigurerAdapter {

    @Resource
    private Environment env;

    /**
     * Set location where to look for resources e.g. scripts, images, css files.
     *
     * @param registry
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/**").addResourceLocations("/resources/");
    }

}
