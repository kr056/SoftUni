package c_Inheritance_Exercises.p05_OnlineRadioDatabase;

class Song {
    private String artistName;
    private String songName;
    private int songMinutes;
    private int songSeconds;
    private int songLength;

    Song(String artistName, String songName, int songLength, int songMinutes, int songSeconds) {
        this.setArtistName(artistName);
        this.setSongName(songName);
        this.setSongLength(songLength);
        this.setSongMinutes(songMinutes);
        this.setSongSeconds(songSeconds);
    }

    private void setSongLength(int songLength) {
        this.songLength = songLength;
    }

    private void setArtistName(String artistName) {
        if (artistName.trim().length() < 3 || artistName.trim().length() > 20) {
            throw new IllegalArgumentException("Artist name should be between 3 and 20 symbols.");
        }
        this.artistName = artistName;
    }

    private void setSongName(String songName) {
        if (songName.trim().length() < 3 || songName.trim().length() > 30) {
            throw new IllegalArgumentException("Song name should be between 3 and 30 symbols.");
        }
        this.songName = songName;
    }

    private void setSongMinutes(int songMinutes) {
        if (songMinutes < 0 || songMinutes > 14) {
            throw new IllegalArgumentException("Song minutes should be between 0 and 14.");
        }
        this.songMinutes = songMinutes;
    }

    private void setSongSeconds(int songSeconds) {
        if (songSeconds < 0 || songSeconds > 59) {
            throw new IllegalArgumentException("Song seconds should be between 0 and 59.");
        }
        this.songSeconds = songSeconds;
    }

    public int getSongLength() {
        return songLength;
    }
}
