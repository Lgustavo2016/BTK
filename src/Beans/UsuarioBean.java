package Beans;

import java.sql.Date;

public class UsuarioBean {

    //METODO PARA CADASTRAR USUARIO....
    private int ID;
    private String login;
    private String senha;
    private String nome;
    private Date data;

    public UsuarioBean() {

    }

    public UsuarioBean(String login, String senha, String nome) {

        this.login = login;
        this.senha = senha;
        this.nome = nome;
    }


    // SET
    public void setNOME(String nome) {

        this.nome = nome;

    }

    public void setLOGIN(String login) {

        this.login = login;

    }

    public void setSENHA(String senha) {
        this.senha = senha;

    }

    // GET
    public String getNOME() {

        return nome;

    }

    public String getLOGIN() {

        return login;

    }

    public String getSENHA() {

        return senha;

    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

}
