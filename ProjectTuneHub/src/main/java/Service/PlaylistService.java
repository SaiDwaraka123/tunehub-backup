package Service;

import java.util.List;

import com.kodnest.tune.entity.Playlist;

public interface PlaylistService {

	 public void addplaylist(Playlist playlist);

	List<Playlist> fetchAllSongs();

  public List<Playlist> fetchAllPlaylists();

	//List<Playlist> fetchAllPlaylist();

}
