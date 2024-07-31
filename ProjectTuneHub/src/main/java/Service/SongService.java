package Service;

import java.util.List;

import com.kodnest.tune.entity.Playlist;
import com.kodnest.tune.entity.Song;

public interface SongService {
  public void addSong(Song song);

public String addSong(String song);

  

public boolean songExists(String genre);

public List<Song> fetchAllSongs();

public void addplaylist(Playlist playlist);

public void updateSong(Song s);



}
