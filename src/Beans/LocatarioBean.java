package Beans;

public class LocatarioBean {

    private String nome;
    private String serie;
    private String periodo;
    private String tipo;
    private String email;
    private String tel;
    private String cel;
    private int ID;

    public LocatarioBean(String nome, String serie) {
        this.nome = nome;
        this.serie = serie;
    }

    public LocatarioBean() {
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSerie() {
        return serie;
    }

    public void setSerie(String serie) {
        this.serie = serie;
    }

   
    public String getPeriodo() {
        return periodo;
    }


    public void setPeriodo(String periodo) {
        this.periodo = periodo;
    }

    public String getTipo() {
        return tipo;
    }

  
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

  
    public int getID() {
        return ID;
    }

   
    public void setID(int ID) {
        this.ID = ID;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getCel() {
        return cel;
    }

    public void setCel(String cel) {
        this.cel = cel;
    }

}
