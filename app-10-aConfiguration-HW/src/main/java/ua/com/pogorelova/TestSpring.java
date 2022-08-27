package ua.com.pogorelova;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ua.com.pogorelova.config.SpringConfig;
import ua.com.pogorelova.genres.ClassicalMusic;

public class TestSpring {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(
                SpringConfig.class
        );

        MusicPlayer musicPlayer = context.getBean("musicPlayer", MusicPlayer.class);

        System.out.println(musicPlayer.playMusic());

        context.close();
    }
}
