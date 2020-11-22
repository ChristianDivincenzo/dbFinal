package jdbc.models;

public class Song {
  private Integer id;
  private String title;
  private String artist;
  private String releaseDate;
  private String albumTitle;
  private Integer runtime;

  public Integer getId() {
    return id;
  }
  public void setId(Integer id) {
    this.id = id;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getArtist() {
    return artist;
  }

  public void setArtist(String artist) {
    this.artist = artist;
  }

  public String getReleaseDate() {
    return releaseDate;
  }

  public void setReleaseDate(String releaseDate) {
    this.releaseDate = releaseDate;
  }

  public String getAlbumTitle() {
    return albumTitle;
  }

  public void setAlbumTitle(String albumTitle) {
    this.albumTitle = albumTitle;
  }

  public Integer getRuntime() {
    return runtime;
  }
  public void setRuntime(Integer runtime) {
    this.runtime = runtime;
  }

  public Song() {    }
  public Song(Integer id, String title, String artist,
      String releaseDate, String albumTitle, Integer runtime) {
    this.id = id;
    this.title = title;
    this.artist = artist;
    this.releaseDate = releaseDate;
    this.albumTitle = albumTitle;
    this.runtime = runtime;
  }
  public String toString() {
    return id + ", " + title + ", " + artist + ", " + releaseDate
        + ", " + albumTitle + ", " + runtime;
  }



}
