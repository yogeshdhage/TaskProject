package Utility;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class Store {

	Map<String, List<String>> playlistPerUser;
    private int initialCapacity;

    public Store(int initialCapacity) {
        this.initialCapacity = initialCapacity;
        this.playlistPerUser = new HashMap<>();
    }

    public void recentlyPlayedSong(String user, String song) {
        List<String> userPlaylist = playlistPerUser.getOrDefault(user, new ArrayList<String>());
       
        userPlaylist.remove(song);
        userPlaylist.add(song);
        playlistPerUser.put(user, userPlaylist);
    }

    public List<String> getRecentlyPlayedSongs(String user) {
    	List<String> EmptyList=Collections.emptyList();
        List<String> userPlaylist = playlistPerUser.getOrDefault(user, EmptyList);

        if (userPlaylist.size() <= initialCapacity) {
            return userPlaylist;
        }
        return userPlaylist.subList(userPlaylist.size() - initialCapacity, userPlaylist.size());
    }
}
