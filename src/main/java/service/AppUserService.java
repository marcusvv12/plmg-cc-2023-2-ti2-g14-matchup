package service;

import dao.AppUserDAO;
import dao.MatchDAO;
import model.AppUsers;
import model.Match;
import java.util.List;
import javax.servlet.http.HttpSession;

import model.AppUsers;
import java.util.List;
import javax.servlet.http.HttpSession;

public class AppUserService {
    private AppUserDAO appUserDAO;

    public AppUserService() {
        this.appUserDAO = new AppUserDAO();
    }

    public boolean insertAppUser(String nome, String email, String password, String telefone, String biografia, String plataformas, String jogos, String genero, String datanasc) {
        AppUsers appUser = new AppUsers(0,nome, email, password, telefone,biografia,plataformas,jogos,genero,datanasc);
        return appUserDAO.insert(appUser);
    }
    
    public int insertMatch(int idusuario1, int idusuario2, int match) {
        Match appmatch = new Match(0,idusuario1, idusuario2, match);
        return MatchDAO.insert(appmatch);
    }
    
    public String loginAppUser(String email,  String password) {
        
        return appUserDAO.loginValidar(email, password);
    }

    public AppUsers getUserId(int id, int userid) {
    	return appUserDAO.getUser(id,userid);
    }
    
    public AppUsers getAppUser(String email) {
        return appUserDAO.get(email);
    }

    public List<AppUsers> getAllAppUsers(int userid) {
        return appUserDAO.getAll(userid);
    }

    public boolean updateAppUser(String email, String newEmail, String newPassword, int newidade) {
        AppUsers appUser = appUserDAO.get(email);
        if (appUser != null) {
            appUser.setEmail(newEmail);
            appUser.setPassword(newPassword);
            
            return appUserDAO.update(appUser);
        }
        return false;
    }

    public boolean deleteAppUser(int id) {
        return appUserDAO.delete(id);
    }
    
    public boolean authenticateUser(String email, String password, HttpSession session) {
        AppUsers user = appUserDAO.get(email);

        if (user != null && user.getPassword().equals(password)) {
            // User authenticated, store the user in the session
            session.setAttribute("user", user);
            return true;
        } else {
            return false;
        }
    }
    
    public AppUsers getUserByEmail(String email) {
        AppUsers user = appUserDAO.get(email);
        return user;
    }

    public void logoutUser(HttpSession session) {
        // Invalidate the session to log the user out
        session.invalidate();
    }

    public boolean isUserLoggedIn(HttpSession session) {
        // Check if a user is logged in by inspecting the session
        return session.getAttribute("user") != null;
    }
}
