package ua.com.pogorelova;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestSpring {
    public static void main(String[] args) {
        // Указываем путь к файлу конфигурации (applicationContext.xml) и получаем ApplicationContext
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
                "applicationContext.xml"
        );

        // ТЕПЕРЬ НАМ ЭТО БОЛЬШЕ НЕ НУЖНО
//      // Достать Bean из ApplicationContext
//      Music music = context.getBean("musicBean", Music.class);
//      // Пока внедряем объект вручную, потом будет Dependency Injection
//      MusicPlayer musicPlayer = new MusicPlayer(music);

        // Spring сам создал musicBean и внедрил его в musicPlayer! КРОСОТА!
        MusicPlayer musicPlayer = context.getBean("musicPlayer", MusicPlayer.class);
        musicPlayer.playMusic();
        context.close();
    }
}
