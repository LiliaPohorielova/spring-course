package ua.com.pogorelova.config;

import org.springframework.web.filter.HiddenHttpMethodFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;

// JAVA КЛАСС ВМЕСТО ФАЙЛА web.xml
// ЭТО ДЛЯ TOMCAT
public class MySpringMvcDispatcherServletInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

    @Override
    protected Class<?>[] getRootConfigClasses() {
        return null; // не используем этот метод
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[] {SpringConfig.class}; // Настройка DispatcherServlet, указываем где искать конфигурацию Спринга
    }

    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"}; // Указываем url, который будет перехватывать DispatcherServlet, в нашем случае любой запрос ("/")
    }

    @Override
    public void onStartup(ServletContext aServletContext) throws ServletException {
        super.onStartup(aServletContext);
        registerHiddenFieldFilter(aServletContext);
    }

    // Добавляем фильтр, который будет перехватывать запросы и искать скрытый атрибут _method
    // В зависимости от этого перенаправлять на PathMapping, PutMapping, DeleteMapping и тд
    private void registerHiddenFieldFilter(ServletContext aContext) {
        aContext.addFilter("hiddenHttpMethodFilter",
                new HiddenHttpMethodFilter()).addMappingForUrlPatterns(null ,true, "/*");
    }
}
