//package com.example.demoview.config;
//
//import com.example.demoview.web.working.TodoList;
//import org.springframework.context.annotation.*;
//import org.springframework.web.context.WebApplicationContext;
//import org.springframework.web.servlet.ViewResolver;
//import org.springframework.web.servlet.config.annotation.EnableWebMvc;
//import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
//import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
//import org.thymeleaf.spring5.SpringTemplateEngine;
//import org.thymeleaf.spring5.view.ThymeleafView;
//import org.thymeleaf.spring5.view.ThymeleafViewResolver;
//import org.thymeleaf.templatemode.TemplateMode;
//import org.thymeleaf.templateresolver.ClassLoaderTemplateResolver;
//
//import java.util.Collections;
//
//@EnableWebMvc
//@Configuration
//public class WebConfig implements WebMvcConfigurer {
//
////    @Override
////    public void addResourceHandlers(final ResourceHandlerRegistry registry) {
////        registry.addResourceHandler("resources/**/*")
////                .addResourceLocations("classpath:resources/");
////    }
////
////    @Bean
////    @Description("Thymeleaf template resolver serving HTML 5")
////    public ClassLoaderTemplateResolver templateResolver() {
////        var templateResolver = new ClassLoaderTemplateResolver();
////        templateResolver.setPrefix("templates/");
////        templateResolver.setCacheable(false);
////        templateResolver.setSuffix(".html");
////        templateResolver.setTemplateMode(TemplateMode.HTML);
////        templateResolver.setCharacterEncoding("UTF-8");
////        return templateResolver;
////    }
////
////    @Bean
////    @Description("Thymeleaf template engine with Spring integration")
////    public SpringTemplateEngine templateEngine() {
////        var templateEngine = new SpringTemplateEngine();
////        templateEngine.setTemplateResolver(templateResolver());
////        templateEngine.setEnableSpringELCompiler(true);
////        return templateEngine;
////    }
////
////    @Bean
////    @Description("Thymeleaf view resolver")
////    public ViewResolver viewResolver() {
////        var viewResolver = new ThymeleafViewResolver();
////        viewResolver.setTemplateEngine(templateEngine());
////        viewResolver.setCharacterEncoding("UTF-8");
////        viewResolver.setOrder(1);
////        viewResolver.setViewNames(new String[] {".html", ".xhtml"});
////        return viewResolver;
////    }
//
//    @Override
//    public void addViewControllers(ViewControllerRegistry registry) {
//        registry.addViewController("/").setViewName("index");
//    }
//
//    @Bean
//    @Scope(
//            value = WebApplicationContext.SCOPE_SESSION,
//            proxyMode = ScopedProxyMode.TARGET_CLASS)
//    public TodoList todos() {
//        return new TodoList();
//    }
//
////    @Bean
////    @Scope("prototype")
////    public ThymeleafView mainView() {
////        ThymeleafView view = new ThymeleafView("footerx"); // templateName = 'footerx'
////        view.setStaticVariables(
////                Collections.singletonMap("footer", "The ACME Fruit Company"));
////        return view;
////    }
//}
