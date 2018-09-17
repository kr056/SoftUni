package c_Inheritance_Exercises.p05_OnlineRadioDatabase;

import java.util.ArrayList;

public class Playlist {
    private ArrayList<Song> songs;
    private int totalLengthOfPlaylistInSeconds;

    public Playlist() {
        this.songs = new ArrayList<>();
    }

    public void addSong(Song song) {
        this.songs.add(song);
        this.totalLengthOfPlaylistInSeconds += song.getSongLength();
    }

    public String printPlaylistLength() {
        int hours = totalLengthOfPlaylistInSeconds / 3600;
        int minutes = (totalLengthOfPlaylistInSeconds % 3600) / 60;
        int seconds = totalLengthOfPlaylistInSeconds % 60;

        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Playlist length: %dh %dm %ds%n", hours, minutes, seconds));

        return sb.toString();

    }

    public int getPlaylistSize() {
        return this.songs.size();
    }

}
