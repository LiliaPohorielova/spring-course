package ua.com.pogorelova;

import java.util.ArrayList;
import java.util.List;

public class MusicPlayer {
    private List<Music> musicList = new ArrayList<>();
    private Music music;
    private String name;
    private int volume;

    public void setMusicList(List<Music> musicList) {
        for (var i: musicList) {
            this.musicList.add(i);
        }
    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public MusicPlayer() {}

    public MusicPlayer(Music music) {//Принцип Inversion of Control
        this.music = music;
    }

    public void setMusic(Music music) {
        this.music = music;
    }

    public void playMusic() {
        System.out.println("Playing " + "\"" + music.getSong() + "\"");
    }

    public void playMusicList() {
        for (var i: musicList) {
            System.out.println("Playing " + "\"" + i.getSong() + "\"");
        }
    }
}
