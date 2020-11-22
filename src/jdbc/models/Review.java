package jdbc.models;

public class Review {
  private Integer id;
  private Integer songId;
  private String comment;

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

  public String getComment() {
    return comment;
  }

  public void setComment(String comment) {
    this.comment = comment;
  }

  public Review() {    }
  public Review(Integer id, Integer song_id, String comment) {
    this.id = id;
    this.songId = song_id;
    this.comment = comment;
  }
  public String toString() {
    return id + ", " + songId + ", " + comment;
  }
}
