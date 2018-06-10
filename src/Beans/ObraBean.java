package Beans;

import java.sql.Date;

public class ObraBean {

    private String Titulo_OBRA;
    private String Editora_OBRA;
    private String Descricao_OBRA;
    private String localizacao;
    private String edicao;
    private String ano;
    private String genero;
    private String autor;
    private Date data;
    private int Quantidade_OBRA;
    private int nota;
    private int ID;
    private boolean Disponibilidade;

    public ObraBean() {

    }

    public ObraBean(String Titulo_OBRA, String Editora_OBRA, String Descricao_OBRA, String localizacao, String edicao, String ano, String genero, String autor, Date data, int Quantidade_OBRA, int nota, int ID, boolean Disponibilidade) {
        this.Titulo_OBRA = Titulo_OBRA;
        this.Editora_OBRA = Editora_OBRA;
        this.Descricao_OBRA = Descricao_OBRA;
        this.localizacao = localizacao;
        this.edicao = edicao;
        this.ano = ano;
        this.genero = genero;
        this.autor = autor;
        this.data = data;
        this.Quantidade_OBRA = Quantidade_OBRA;
        this.nota = nota;
        this.Disponibilidade = Disponibilidade;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getEdicao() {
        return edicao;
    }

    public void setEdicao(String edicao) {
        this.edicao = edicao;
    }

    public String getAno() {
        return ano;
    }

    public void setAno(String ano) {
        this.ano = ano;
    }

    public String getTitulo_OBRA() {
        return Titulo_OBRA;
    }

    public void setTitulo_OBRA(String Titulo_OBRA) {
        this.Titulo_OBRA = Titulo_OBRA;
    }

    public String getEditora_OBRA() {
        return Editora_OBRA;
    }

    public void setEditora_OBRA(String Editora_OBRA) {
        this.Editora_OBRA = Editora_OBRA;
    }

    public String getDescricao_OBRA() {
        return Descricao_OBRA;
    }

    public void setDescricao_OBRA(String Descricao_OBRA) {
        this.Descricao_OBRA = Descricao_OBRA;
    }

    public int getQuantidade_OBRA() {
        return Quantidade_OBRA;
    }

    public void setQuantidade_OBRA(int Quantidade_OBRA) {
        this.Quantidade_OBRA = Quantidade_OBRA;
    }

    public boolean isDisponibilidade() {
        return Disponibilidade;
    }

    public void setDisponibilidade(boolean Disponibilidade) {
        this.Disponibilidade = Disponibilidade;
    }

    public String getLocalizacao() {
        return localizacao;
    }

    public void setLocalizacao(String localizacao) {
        this.localizacao = localizacao;
    }

    public int getNota() {
        return nota;
    }

    public void setNota(int nota) {
        this.nota = nota;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
        
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

}
