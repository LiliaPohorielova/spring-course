package ua.com.pogorelova;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class MusicPlayer {

    private Music music;

    @Autowired
    // Уточняем какую именно музыку ожидаем получить
    public MusicPlayer(@Qualifier("popMusic") Music music) {
        this.music = music;
    }

    public void playMusic() {
        System.out.println("Playing: " + music.getSong());
    }
}
