package dao;

import model.AppUsers;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class AppUserDAO extends DAO {
    public AppUserDAO() {
        super();
        conectar();
    }

    public void finalize() {
        close();
    }

    public boolean insert(AppUsers user) {
        boolean status = false;
        try {
            String sql = "INSERT INTO users (nome, email, senha, telefone, biografia, plataformas, jogos, genero, datanasc) VALUES (?, ?, md5(?), ?, ?, ?, ?, ?, ?::date)";
            PreparedStatement st = conexao.prepareStatement(sql);
            st.setString(1, user.getNome());
            st.setString(2, user.getEmail());
            st.setString(3, user.getPassword());
            st.setString(4, user.getTelefone()); 
            st.setString(5, user.getBiografia()); 
            st.setString(6, user.getPlataformas()); 
            st.setString(7, user.getJogos()); 
            st.setString(8, user.getGenero()); 
            st.setString(9, user.getDatanasc()); 
            st.executeUpdate();
            st.close();
        } catch (SQLException u) {
            throw new RuntimeException(u);
        }
        return status;
    }
    
    

    public String loginValidar(String email, String senha){
    	String id = "";

        try {
            Statement st = conexao.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            String sql = "SELECT id FROM users WHERE email='" + email + "'and senha = md5('" + senha + "')";
            ResultSet rs = st.executeQuery(sql);
            if (rs.first()) {
               id = rs.getString("id"); 
            }
            
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
          	
    	return id; 
    }
    
    public boolean match(AppUsers user) {
        boolean status = false;
        try {
            String sql = "INSERT INTO users (nome, email, senha) VALUES (?, ?, ?)";
            PreparedStatement st = conexao.prepareStatement(sql);
            st.setString(1, user.getNome());
            st.setString(2, user.getEmail());
            st.setString(3, user.getPassword());   
            st.executeUpdate();
            st.close();
        } catch (SQLException u) {
            throw new RuntimeException(u);
        }
        return status;
    }
    
    public AppUsers get(String email) {
        AppUsers user = null;

        try {
            Statement st = conexao.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            String sql = "SELECT * FROM users WHERE email='" + email + "'";
            ResultSet rs = st.executeQuery(sql);
            if (rs.next()) {
               user = new AppUsers(rs.getInt("id"), rs.getString("nome"),rs.getString("email"), rs.getString("senha"), rs.getString("telefone"), rs.getString("biografia"), rs.getString("plataformas"),
            			rs.getString("jogos"), rs.getString("genero"), rs.getString("datanasc"));;
            }
            st.close();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        return user;
    }

    public AppUsers getUser(int id, int userid) {
        AppUsers user = null;

        try {
            Statement st = conexao.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            String sql = "SELECT * FROM users WHERE id>=" + id +" and id <> " + userid + " and id not in (select idusuario1 from correspondencias where idusuario2="+ userid+") limit 1";
            ResultSet rs = st.executeQuery(sql);
            if (rs.next()) {
               user = new AppUsers(rs.getInt("id"), rs.getString("nome"),rs.getString("email"), rs.getString("senha"), rs.getString("telefone"), rs.getString("biografia"), rs.getString("plataformas"),
            			rs.getString("jogos"), rs.getString("genero"), rs.getString("datanasc"));;
            }
            st.close();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        return user;
    }
    
    public List<AppUsers> getAll(int userid) {
        List<AppUsers> userList = new ArrayList<>();

        try {
            String sql = "SELECT * FROM users where id in (select idusuario1 from correspondencias where idusuario2 =" + userid + " and match = 1) and id in (select idusuario2 from correspondencias where idusuario1 =" + userid + " and match = 1)";
            PreparedStatement preparedStatement = conexao.prepareStatement(sql);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                AppUsers user = new AppUsers(rs.getInt("id"), rs.getString("nome"),rs.getString("email"), rs.getString("senha"), rs.getString("telefone"), rs.getString("biografia"), rs.getString("plataformas"),
            			rs.getString("jogos"), rs.getString("genero"), rs.getString("datanasc"));
                userList.add(user);
            }

            rs.close();
            preparedStatement.close();
        } catch (SQLException e) {
            System.err.println("Error executing the query: " + e.getMessage());
        }

        return userList;
    }

    public boolean update(AppUsers user) {
        boolean status = false;
        try {
            String sql = "UPDATE users SET email = ?, senha = ?";
            PreparedStatement st = conexao.prepareStatement(sql);
            st.setString(1,  "'" + user.getEmail() + "'");
            st.setString(2, user.getPassword());
            
            st.setInt(3, user.getId());
            st.executeUpdate();
            st.close();
            status = true;
        } catch (SQLException u) {
            throw new RuntimeException(u);
        }
        return status;
    }
    
    public AppUsers getUserByEmail(String email) {
        AppUsers user = null;
        try {
            String sql = "SELECT * FROM matchup.Users WHERE email=?";
            PreparedStatement st = conexao.prepareStatement(sql);
            st.setString(1, "'" + email + "'");
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
            	user = new AppUsers(rs.getInt("id"), rs.getString("nome"),rs.getString("email"), rs.getString("senha"), rs.getString("telefone"), rs.getString("biografia"), rs.getString("plataformas"),
            			rs.getString("jogos"), rs.getString("genero"), rs.getString("datanasc"));
            }
            st.close();
        } catch (SQLException e) {
            System.err.println("Error retrieving user by email: " + e.getMessage());
        }
        return user;
    }

    public boolean delete(int id) {
        boolean status = false;
        try {
            Statement st = conexao.createStatement();
            st.executeUpdate("DELETE FROM matchup.Users WHERE id = " + id);
            st.close();
            status = true;
        } catch (SQLException u) {
            throw new RuntimeException(u);
        }
        return status;
    }
}
