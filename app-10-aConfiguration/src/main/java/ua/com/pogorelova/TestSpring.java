package ua.com.pogorelova;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestSpring {

    public static void main(String[] args) {
        // ClassPathXmlApplicationContext c xml (config.xml или appcontext.xml) = AnnotationConfigApplicationContext (класс SpringConfig.class)
        // Аннотация @Configuration (указывает конфигурационный класс) = config.xml или appcontext.xml
        // Аннотация @ComponentScan = <component-scan base-package="ua.com.pogorelova"/> в xml
        // Аннотация @PropertySource = <property-placeholder location="classpath:musicPlayer.properties"/> в xml
        // Аннотация @Bean = <bean/> в xml
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(
                SpringConfig.class
        );

        MusicPlayer musicPlayer = context.getBean("musicPlayer", MusicPlayer.class);

        System.out.println(musicPlayer.getName());
        System.out.println(musicPlayer.getVolume());

        ClassicalMusic classicalMusic1 = context.getBean("classicalMusic", ClassicalMusic.class);
        ClassicalMusic classicalMusic2 = context.getBean("classicalMusic", ClassicalMusic.class);

        System.out.println(classicalMusic1 == classicalMusic2);

        context.close();
    }
}
