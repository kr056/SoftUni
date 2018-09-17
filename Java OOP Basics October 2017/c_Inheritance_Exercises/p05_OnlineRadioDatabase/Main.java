package c_Inheritance_Exercises.p05_OnlineRadioDatabase;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int numberOfSongs = Integer.valueOf(bf.readLine());

        Playlist playlist = new Playlist();

        for (int i = 0; i < numberOfSongs; i++) {
            try {
                String[] songProps = bf.readLine().split("[;]");
                String artistName = songProps[0];
                String songTitle = songProps[1];
                String[] songLength = songProps[2].split("[:]");

                int songMinutes = Integer.valueOf(songLength[0]);
                int songSeconds = Integer.valueOf(songLength[1]);
                int songLengthInSeconds = songMinutes * 60 + songSeconds;

                Song song = new Song(artistName, songTitle, songLengthInSeconds, songMinutes, songSeconds);

                playlist.addSong(song);

                System.out.println("Song added.");

            } catch (NumberFormatException e) {
                System.out.println("Invalid song length.");
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        System.out.println("Songs added: " + playlist.getPlaylistSize());
        System.out.println(playlist.printPlaylistLength());
    }
}