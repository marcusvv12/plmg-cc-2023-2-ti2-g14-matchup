package app;

import static spark.Spark.*;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.StringReader;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;
import spark.Request;
import spark.Response;
import spark.Session;
import service.AppUserService;

import model.AppUsers;


public class Aplicacao {

    private static final ObjectMapper objectMapper = new ObjectMapper();
   
    private static AppUserService appUserService = new AppUserService();
    
    private static String userEmail = null;
    
    static boolean isLoggedIn(Request request) {
        Session session = request.session(false);
        return (session != null && session.attribute("email") != null);
    }

    public static void main(String[] args) {
        port(5050);
        
        objectMapper.registerModule(new JavaTimeModule());
        staticFiles.externalLocation("src/main/resources");
        
        get("/check-session", (request, response) -> {
        	userEmail = request.session().attribute("email");
        	//System.out.println("Email: " + userEmail);
            if (!isLoggedIn(request)) {
                response.status(401);
            }
            return "";
        });

        post("/appuser/match", (request, response) -> {
            try {
                String requestBody = request.body();
                // System.out.println("Received JSON data: " + requestBody);
                JsonNode json = objectMapper.readTree(requestBody);

                int id = json.get("id").asInt();
                int userid = json.get("userid").asInt();
                int match = json.get("match").asInt();        
                int retorno  = appUserService.insertMatch(id,userid, match);
                System.out.println(retorno);
                if(retorno>0) {
                	response.status(200);
                } else 
                {  	
                	response.status(201);
                }

                return "AppUser inserted successfully!";
            } catch (JsonParseException e) {
                response.status(400);
                return "Invalid JSON format: " + e.getMessage();
            } catch (NumberFormatException e) {
                response.status(400);
                return "Invalid number format: " + e.getMessage();
            } catch (Exception e) {
            	System.out.println(e);
                response.status(400);
                return "Error: " + e.getMessage();
            }
        });

        
        
        post("/appuser/insert", (request, response) -> {
            try {
                String requestBody = request.body();
                // System.out.println("Received JSON data: " + requestBody);
                JsonNode json = objectMapper.readTree(requestBody);

                String nome = json.get("nome").asText();
                String email = json.get("email").asText();
                String password = json.get("password").asText();        
                String telefone = json.get("telefone").asText();
                String biografia = json.get("biografia").asText();
                String plataformas = json.get("plataformas").asText();
                String jogos = json.get("jogos").asText();
                String genero = json.get("genero").asText();
                String datanasc = json.get("datanasc").asText();

                appUserService.insertAppUser(nome,email, password, telefone,biografia,plataformas,jogos,genero,datanasc);

                response.status(201);
                return "AppUser inserted successfully!";
            } catch (JsonParseException e) {
                response.status(401);
                return "Invalid JSON format: " + e.getMessage();
            } catch (NumberFormatException e) {
                response.status(402);
                return "Invalid number format: " + e.getMessage();
            } catch (Exception e) {
            	System.out.println(e);
                response.status(403);
                return "Error: " + e.getMessage();
            }
        });
        
        post("/login", (request, response) -> {
            try {
                String requestBody = request.body();
                // System.out.println("Received JSON data: " + requestBody);
                JsonNode json = objectMapper.readTree(requestBody);

                String email = json.get("email").asText();
                String password = json.get("password").asText();
                String userid = appUserService.loginAppUser(email, password);
                if(userid!="") 
                {   response.status(Integer.parseInt(userid));
 		            return userid;
	        	} else 
                {
                	response.status(0);
                	return "";
                }
            } catch (Exception e) {
             	System.out.println(e);
                 response.status(400);
                 return "Error: " + e.getMessage();
             }
        });
        

        
        post("/appuser/update", (request, response) -> {
            String email = request.queryParams("email");
            String newEmail = request.queryParams("new-email");
            String newPassword = request.queryParams("new-password");
            int newidade = Integer.parseInt(request.queryParams("new-idade"));

            appUserService.updateAppUser(email, newEmail, newPassword, newidade);
            response.status(200);
            return "AppUser updated successfully!";
        });
        
        post("/logout", (request, response) -> {
            Session session = request.session(false);
            if (session != null) {
                session.invalidate(); // Destroy the session
            }
            response.status(200);
            return "Logged out successfully";
        });

        
        get("/get-user-data", (request, response) -> {
            String email = userEmail;
            String password = appUserService.getAppUser(email).getPassword();

            // Create a JSON object with the data
            JsonObject userData = new JsonObject();
            userData.addProperty("email", email);
            userData.addProperty("password", password);

            response.type("application/json");
            return userData.toString();
        });

        post("/getuser", (request, response) -> {
        	try {
        		String requestBody = request.body();
                JsonNode json = objectMapper.readTree(requestBody);
                String id = json.get("id").asText();
                String userid = json.get("userid").asText();
                
	         	AppUsers user = appUserService.getUserId(Integer.parseInt(id), Integer.parseInt(userid) );
	        	if(user!=null) {
		            // Create a JSON object with the data
		            JsonObject userData = new JsonObject();
		            userData.addProperty("nome", user.getNome());
		            userData.addProperty("jogos", user.getJogos());
		            userData.addProperty("plataformas", user.getPlataformas());
		            userData.addProperty("biografia", user.getBiografia());
		            userData.addProperty("id", user.getId());
		            userData.addProperty("datanasc", user.getDatanasc());
		
		            response.type("application/json");
		            response.status(200);
		            response.body(userData.toString());
		            return userData;
	        	} else {
	        		response.status(400);
	        		return "{}";
	        	}
        	 } catch (Exception e) {
             	System.out.println(e);
                 response.status(400);
                 return "Error: " + e.getMessage();
             }
        });

        
        
        
        
        post("/appuser/list", (request, response) -> {
            try {
            	
                String requestBody = request.body();
                // System.out.println("Received JSON data: " + requestBody);
                JsonNode json = objectMapper.readTree(requestBody);

                
                int userid = json.get("userid").asInt();
                List<AppUsers> appUserList = appUserService.getAllAppUsers(userid);
                
                StringBuilder html = new StringBuilder();
                for (AppUsers appUser : appUserList) {
                    html.append("<div class=\"rectangle\">");
                    html.append("<img class=\"image\" src=\"img/usuario.jpg\" alt=\"Imagem no Centro\">");
                    html.append("<h1>"+ appUser.getNome() + "</h1>");
                    html.append("<h2><ion-icon name=\"logo-whatsapp\"></ion-icon> <a href=\"https://wa.me/55"+ appUser.getTelefone()+"\">Clique aqui para conversar!</a></h2>");
                    html.append("</div>");
                }

                return html.toString();
            } catch (JsonParseException e) {
                response.status(400);
                return "Invalid JSON format: " + e.getMessage();
            } catch (NumberFormatException e) {
                response.status(400);
                return "Invalid number format: " + e.getMessage();
            } catch (Exception e) {
            	System.out.println(e);
                response.status(400);
                return "Error: " + e.getMessage();
            }
        });
        

       
        
        




        
       


    }
}