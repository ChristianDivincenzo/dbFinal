package jdbc.models;

public class SongInPlaylist {
  private Integer id;
  private Integer songId;
  private Integer playlistId;

  public Integer getId() {
    return id;
  }
  public void setId(Integer id) {
    this.id = id;
  }

  public Integer getSongId() {
    return songId;
  }
  public void setSongId(Integer songId) {
    this.songId = songId;
  }

  public Integer getPlaylistId() {
    return playlistId;
  }
  public void setPlaylistId(Integer playlistId) {
    this.playlistId = playlistId;
  }

  public SongInPlaylist() {    }
  public SongInPlaylist(Integer id, Integer songId, Integer playlistId) {
    this.id = id;
    this.songId = songId;
    this.playlistId = playlistId;
  }
  public String toString() {
    return id + ", " + songId + ", " + playlistId;
  }

}
