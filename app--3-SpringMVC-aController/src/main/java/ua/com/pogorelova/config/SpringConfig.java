package ua.com.pogorelova.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.thymeleaf.spring5.SpringTemplateEngine;
import org.thymeleaf.spring5.templateresolver.SpringResourceTemplateResolver;
import org.thymeleaf.spring5.view.ThymeleafViewResolver;

// JAVA КЛАСС ВМЕСТО ФАЙЛА applicationContextMVC.xml
// ЭТО ДЛЯ СПРИНГА

@Configuration // Аннотацией @Configuration помечаем конфигурационный класс (который будет вместо web.xml)
@ComponentScan("ua.com.pogorelova") // Аннотацией @ComponentScan говорим, где будут находиться наши компоненты - будущие бины
@EnableWebMvc // Аннотацией @EnableWebMvc говорим, что будет использоваться модель MVC вместо ....
public class SpringConfig implements WebMvcConfigurer {

    private final ApplicationContext applicationContext;

    // "Магия"
    @Autowired
    public SpringConfig(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }

    @Bean // Бин, который отвечает за то, где будут наши представления (.html)
    public SpringResourceTemplateResolver templateResolver() {
        SpringResourceTemplateResolver templateResolver = new SpringResourceTemplateResolver();
        templateResolver.setApplicationContext(applicationContext);
        templateResolver.setPrefix("/WEB-INF/views/"); // добавлять к каждому файлу контроллера папку (чтобы не писать)
        templateResolver.setSuffix(".html"); // добавляем расширение (чтобы в контроллере указывать только название hello_world)
        return templateResolver;
    }

    @Bean // Добавляем templateResolver в templateEngine
    public SpringTemplateEngine templateEngine() {
        SpringTemplateEngine templateEngine = new SpringTemplateEngine();
        templateEngine.setTemplateResolver(templateResolver());
        templateEngine.setEnableSpringELCompiler(true);
        return templateEngine;
    }

    @Override // Говорим, что будем использовать Thymeleaf вместо стандартного инструмента
    public void configureViewResolvers(ViewResolverRegistry registry) {
        ThymeleafViewResolver resolver = new ThymeleafViewResolver();
        resolver.setTemplateEngine(templateEngine());
        registry.viewResolver(resolver);
    }
}
