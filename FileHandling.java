package filehandling;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class FileHandling {
	ArrayList<Song> songsAL = new ArrayList<Song>();

	public static void main(String[] args) throws IOException {
		new FileHandling().go();
	}
	
	public void go() throws IOException {
		getSongs();
	}
	
	void getSongs() throws IOException {
		try {
			File file = new File("songs.txt");
			BufferedReader br = new BufferedReader(new FileReader(file));
			String line = null;
			while((line = br.readLine()) != null) {
				addSongs(line);
			}
			for (Song s : songsAL) {
				System.out.println(s);
			}
			br.close();
		} catch (Exception e) {
			System.out.println("Exception Thrown" + e);
		}
		
		FileOutputStream fout = new FileOutputStream("songnames.txt");
		ObjectOutputStream oos = new ObjectOutputStream(fout);
		for (Song s: songsAL) {
			oos.writeObject(s.songName);
		}
		oos.close();
	} 
	
	void addSongs(String line){
		String[] nextSong = line.split("/");
		Song newSong = new Song(nextSong[0], nextSong[1], nextSong[2],nextSong[3]);
		songsAL.add(newSong);
		
	}
	
	class Song {

		private String songName;
		private String artistName;
		private String songRating;
		private String songSinger;
		@Override
		public String toString() {
			return "Song [songName=" + songName + ", artistName=" + artistName + ", songRating=" + songRating
					+ ", songSinger=" + songSinger + "]";
		}
		public Song(String songName, String artistName, String songRating, String songSinger) {
			super();
			this.songName = songName;
			this.artistName = artistName;
			this.songRating = songRating;
			this.songSinger = songSinger;
		}
		public String getSongName() {
			return songName;
		}
		public void setSongName(String songName) {
			this.songName = songName;
		}
		public String getArtistName() {
			return artistName;
		}
		public void setArtistName(String artistName) {
			this.artistName = artistName;
		}
		public String getSongRating() {
			return songRating;
		}
		public void setSongRating(String songRating) {
			this.songRating = songRating;
		}
		public String getSongSinger() {
			return songSinger;
		}
		public void setSongSinger(String songSinger) {
			this.songSinger = songSinger;
		}
			
	}
}
