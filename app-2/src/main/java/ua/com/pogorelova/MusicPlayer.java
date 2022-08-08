package ua.com.pogorelova;

public class MusicPlayer {
    private Music music; // ОБЪЕКТ ИНТЕРФЕЙСА
    // играть музыку любого жанра

    public MusicPlayer(Music music) {//Принцип Inversion of Control
        this.music = music;
    }

    public void playMusic() {
        System.out.println("Playing " + "\"" + music.getSong() + "\"");
    }
}
