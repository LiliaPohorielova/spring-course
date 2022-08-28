package ua.com.pogorelova.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

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
}
