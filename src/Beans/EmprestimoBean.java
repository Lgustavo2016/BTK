package Beans;

import java.sql.Date;

public class EmprestimoBean {

    private int id;
    private String usuario;
    private String locatario;
    private String status;
    private Date data_emprestimo;
    private Date data_dev_real;
    private Date data_dev_prev;

    public EmprestimoBean() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getLocatario() {
        return locatario;
    }

    public void setLocatario(String locatario) {
        this.locatario = locatario;
    }

    public Date getData_dev_real() {
        return data_dev_real;
    }

    public void setData_dev_real(Date data_dev_real) {
        this.data_dev_real = data_dev_real;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getData_dev_prev() {
        return data_dev_prev;
    }

    public void setData_dev_prev(Date data_dev_prev) {
        this.data_dev_prev = data_dev_prev;
    }

    public Date getData_emprestimo() {
        return data_emprestimo;
    }

    public void setData_emprestimo(Date data_emprestimo) {
        this.data_emprestimo = data_emprestimo;
    }

}
