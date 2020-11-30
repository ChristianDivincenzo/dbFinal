package jdbc.daos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import jdbc.models.PlaylistCreator;
import jdbc.models.PlaylistListener;

public class DaoConfig {

  static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
  static final String HOST = "localhost:3306";
  static final String SCHEMA = "playlist";
  static final String CONFIG = "serverTimezone=UTC";
  static final String DB_URL
      = "jdbc:mysql://" + HOST + "/" + SCHEMA + "?" + CONFIG;

  static final String USER = "dbDesign";
  static final String PASS = "dbDesign";

  static Connection connection = null;
  static PreparedStatement statement = null;
  Integer status = -1;

  public static Connection getConnection() {
    try {
      Class.forName(JDBC_DRIVER);
      connection = DriverManager
          .getConnection(DB_URL, USER, PASS);
    } catch (ClassNotFoundException | SQLException e) {
      e.printStackTrace();
    }
    return connection;
  }

 public static void closeConnection() {
    try {
      if(connection != null) {
        connection.close();
        connection = null;
      }
      if(statement != null) {
        statement.close();
        statement = null;
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }
  
  // --------------------------------------------------------------------------------
  // Playlist creator classes
  // --------------------------------------------------------------------------------


  static final String FIND_ALL_PLAYLISTCREATORS
      = "SELECT * FROM playlist_creator";

  public List<PlaylistCreator> findAllCreators() {
    List<PlaylistCreator> creators = new ArrayList<PlaylistCreator>();
    connection = getConnection();
    try {
      statement = connection
          .prepareStatement(FIND_ALL_PLAYLISTCREATORS);
      ResultSet resultSet = statement.executeQuery();
      while (resultSet.next()) {
        Integer id = resultSet.getInt("id");
        String creatorUsername = resultSet.getString("username");
        PlaylistCreator listCreator = new PlaylistCreator(id, creatorUsername);
        creators.add(listCreator);
      }
    } catch (SQLException e) {
      e.printStackTrace();
    } finally {
      closeConnection();
    }
    return creators;
  }

  static final String UPDATE_PLAYLISTCREATOR =
      "UPDATE playlist_creator SET username=? WHERE id=?";

  public Integer updateCreator(Integer creatorId, PlaylistCreator creator) {
    connection = getConnection();
    try {
      statement = connection.prepareStatement(UPDATE_PLAYLISTCREATOR);
      statement.setString(1, creator.getUsername());
      statement.setInt(2, creator.getId());
      status = statement.executeUpdate();
    } catch (SQLException e) {
      e.printStackTrace();
    } finally {
      closeConnection();
    }
    return status;
  }

  static final String FIND_CREATOR_BY_ID =
      "SELECT * FROM playlist_creator WHERE id=?";
  public PlaylistCreator findCreatorById(Integer creatorId) {
    connection = getConnection();
    try {
      statement = connection.prepareStatement(FIND_CREATOR_BY_ID);
      statement.setInt(1, creatorId);
      ResultSet resultSet = statement.executeQuery();
      if (resultSet.next()) {
        String username = resultSet.getString("username");
        PlaylistCreator creator = new PlaylistCreator(creatorId, username);
        return creator;
      }
    } catch (SQLException e) {
      e.printStackTrace();
    } finally {
      closeConnection();
    }
    return null;
  }

  static final String CREATE_PLAYLISTCREATOR
      = "INSERT INTO playlist_creator VALUES (?,?)";
  public Integer createPlaylistCreator(PlaylistCreator creator) {
    status = -1;
    connection = getConnection();
    try {
      statement = connection
          .prepareStatement(CREATE_PLAYLISTCREATOR);
      statement.setInt(1, creator.getId());
      statement.setString(2, creator.getUsername());
      status = statement.executeUpdate();
    } catch (SQLException e) {
      e.printStackTrace();
    } finally {
      closeConnection();
    }
    return status;
  }


  static final String DELETE_CREATOR =
      "DELETE FROM playlist_creator WHERE id=?";
  public void deleteCreator(Integer creatorId) {
    String sql = "delete from playlist_creator where id=?";
    try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
        PreparedStatement stmt = conn.prepareStatement(sql)) {

      stmt.setInt(1, creatorId);
      stmt.executeUpdate();
      System.out.println("Record deleted successfully");
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  // --------------------------------------------------------------------------------
  // Playlist listener classes
  // --------------------------------------------------------------------------------


  static final String FIND_ALL_PLAYLISTLISTENERS
      = "SELECT * FROM playlist_listener";

  public List<PlaylistListener> findAllListeners() {
    List<PlaylistListener> listeners = new ArrayList<PlaylistListener>();
    connection = getConnection();
    try {
      statement = connection
          .prepareStatement(FIND_ALL_PLAYLISTLISTENERS);
      ResultSet resultSet = statement.executeQuery();
      while (resultSet.next()) {
        Integer id = resultSet.getInt("id");
        String listenerUsername = resultSet.getString("username");
        PlaylistListener listListener = new PlaylistListener(id, listenerUsername);
        listeners.add(listListener);
      }
    } catch (SQLException e) {
      e.printStackTrace();
    } finally {
      closeConnection();
    }
    return listeners;
  }

  static final String UPDATE_PLAYLISTLISTENER=
      "UPDATE playlist_listener SET username=? WHERE id=?";

  public Integer updateListener(Integer listenerId, PlaylistCreator listener) {
    connection = getConnection();
    try {
      statement = connection.prepareStatement(UPDATE_PLAYLISTLISTENER);
      statement.setString(1, listener.getUsername());
      statement.setInt(2, listener.getId());
      status = statement.executeUpdate();
    } catch (SQLException e) {
      e.printStackTrace();
    } finally {
      closeConnection();
    }
    return status;
  }

  static final String FIND_LISTENER_BY_ID =
      "SELECT * FROM playlist_listener WHERE id=?";
  public PlaylistListener findListenerById(Integer listenerId) {
    connection = getConnection();
    try {
      statement = connection.prepareStatement(FIND_LISTENER_BY_ID);
      statement.setInt(1, listenerId);
      ResultSet resultSet = statement.executeQuery();
      if (resultSet.next()) {
        String username = resultSet.getString("username");
        PlaylistListener listener = new PlaylistListener(listenerId, username);
        return listener;
      }
    } catch (SQLException e) {
      e.printStackTrace();
    } finally {
      closeConnection();
    }
    return null;
  }

  static final String CREATE_PLAYLISTLISTENER
      = "INSERT INTO playlist_listener VALUES (?,?)";
  public Integer createPlaylistListener(PlaylistListener listener) {
    status = -1;
    connection = getConnection();
    try {
      statement = connection
          .prepareStatement(CREATE_PLAYLISTLISTENER);
      statement.setInt(1, listener.getId());
      statement.setString(2, listener.getUsername());
      status = statement.executeUpdate();
    } catch (SQLException e) {
      e.printStackTrace();
   } finally {
      closeConnection();
    }
    return status;
  }


  static final String DELETE_LISTENER=
      "DELETE FROM playlist_creator WHERE id=?";
  public void deleteListener(Integer listenerId) {
    String sql = "delete from playlist_listener where id=?";
    try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
        PreparedStatement stmt = conn.prepareStatement(sql)) {

      stmt.setInt(1, listenerId);
      stmt.executeUpdate();
      System.out.println("Record deleted successfully");
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }








  public static void main(String[] args) {
    DaoConfig dao = new DaoConfig();
    List<PlaylistCreator> creators = dao.findAllCreators();
    for (PlaylistCreator c : creators) {
      System.out.println(c);
    }

    PlaylistCreator creator = new PlaylistCreator(22, "Flames");
    Integer status = dao.updateCreator(22, creator);

    creators = dao.findAllCreators();
    for (PlaylistCreator c : creators) {
      System.out.println(c);
    }

      creator = dao.findCreatorById(578);
      System.out.println(creator);

      creator = new PlaylistCreator(710, "tobedeleted");
      Integer stat = dao.createPlaylistCreator(creator);
      System.out.println(stat);

      creator = dao.findCreatorById(410);
      System.out.println(creator);

      dao.deleteCreator(710);
    }

}



