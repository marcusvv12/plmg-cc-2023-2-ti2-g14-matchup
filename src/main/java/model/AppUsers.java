package model;

public class AppUsers {
    private int id;
    private String nome;
    private String email;
    private String password;
    private String telefone;
    private String biografia;
    private String plataformas;
    private String jogos;
    private String genero;
    private String datanasc;
    
    

    public AppUsers() {
        this.id = 0;
        this.nome = "";
        this.email = "";
        this.password = "";
        this.telefone = "";
        this.biografia = "";
        this.plataformas = "";
        this.jogos = "";
        this.genero = "";
        this.datanasc = "";
    }

    public AppUsers(int id, String nome, String email, String password, String telefone, String biografia, String plataformas, String jogos, String genero, String datanasc) {
        setId(id);
        setNome(nome);
        setEmail(email);
        setPassword(password);
        setTelefone(telefone);
        setBiografia(biografia);
        setPlataformas(plataformas);
        setJogos(jogos);
        setGenero(genero);
        setDatanasc(datanasc);
        
        
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }
    
    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }


    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getTelefone() {
        return telefone;
    }
    
    public void setBiografia(String biografia) {
        this.biografia = biografia;
    }

    public String getBiografia() {
        return biografia;
    }
    
    public void setPlataformas(String plataformas) {
        this.plataformas = plataformas;
    }

    public String getPlataformas() {
        return plataformas;
    }
    
    public void setJogos(String jogos) {
        this.jogos = jogos;
    }

    public String getJogos() {
        return jogos;
    }
    
    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getGenero() {
        return genero;
    }
    
    public void setDatanasc(String datanasc) {
        this.datanasc = datanasc;
    }

    public String getDatanasc() {
        return datanasc;
    }

    @Override
    public String toString() {
        return "User ID: " + id + ", Email: " + email ;
    }
}
