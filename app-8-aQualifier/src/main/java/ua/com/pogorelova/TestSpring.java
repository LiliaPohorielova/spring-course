package ua.com.pogorelova;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestSpring {

    public static void main(String[] args) {
        // Указываем путь к файлу конфигурации (applicationContext.xml) и получаем ApplicationContext
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
                "applicationContext.xml"
        );

        // Аннотация @Autowired автоматически внедряет зависимость (может стоять на поле, сеттере, конструкторе)
        // Аннотация @Qualifier указывает id того бина, который нужно внедрить, если несколько бинов подходят в одно поле, сеттер, конструктор

        MusicPlayer musicPlayer = context.getBean("musicPlayer", MusicPlayer.class);
        musicPlayer.playMusic();

        // НО! ПРОБЛЕМА: всё равно указываем всё вручную
        
        context.close();
    }
}
