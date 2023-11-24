package dao;

import model.Match;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class MatchDAO extends DAO {
    public MatchDAO() {
        super();
        conectar();
    }

    public void finalize() {
        close();
    }

    public static int insert(Match user) {
        int id = 0;
        try {
            String sql = "INSERT INTO correspondencias (idusuario1, idusuario2, match) VALUES (?, ?, ?)";
            PreparedStatement st = conexao.prepareStatement(sql);
            st.setInt(1, user.getIdusuario1());
            st.setInt(2, user.getIdusuario2());
            st.setInt(3, user.getMatch());
            st.executeUpdate();
            st.close();
            Statement st2 = conexao.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            String sql2 = "SELECT id FROM correspondencias WHERE idusuario1=" + user.getIdusuario2() + " and idusuario2 = " + user.getIdusuario1() + " and match=1";
            ResultSet rs = st2.executeQuery(sql2);
            if (rs.first()) {
               id = rs.getInt("id"); 
            }
        } catch (SQLException u) {
            throw new RuntimeException(u);
        }
        return id;
    }
    
    
    
}
