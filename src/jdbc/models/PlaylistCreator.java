package jdbc.models;

public class PlaylistCreator {
  private Integer id;
  private String username;
  public Integer getId() {
    return id;
  }
  public void setId(Integer id) {
    this.id = id;
  }
  public String getUsername() {
    return username;
  }
  public void setUsername(String username) {
    this.username = username;
  }
  public PlaylistCreator() {    }
  public PlaylistCreator(Integer id, String username) {
    this.id = id;
    this.username = username;
  }
  public String toString() {
    return id + ", " + username;
  }
}


