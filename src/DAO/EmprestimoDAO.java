package DAO;

import Beans.EmprestimoBean;
import Beans.ObraBean;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class EmprestimoDAO extends JFrame {

    private Connection con;
    private final Icon erro = new ImageIcon(getToolkit().createImage(getClass().getResource("/Imagens/erro.png")));
    private final Icon sucesso = new ImageIcon(getToolkit().createImage(getClass().getResource("/Imagens/sucesso.png")));

    public EmprestimoDAO(Connection con) {

        setCon(con);

    }

    public Connection getCon() {
        return con;
    }

    public void setCon(Connection con) {
        this.con = con;
    }

    //* 
    //Método para realizar o Empréstimo das Obras
    public void emprestar(EmprestimoBean emprestimo) {
        String sql = "insert into emprestimo (id_usuario, id_locatario,"
                + " status_emprestimo, data_emprestimo, data_devolucao_prevista) values (?,?,?,?,?)";

        try {
            PreparedStatement ps = getCon().prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);

            ps.setInt(1, verificaUsuario(emprestimo.getUsuario()));
            ps.setInt(2, verificaLocatario(emprestimo.getLocatario()));
            ps.setString(3, emprestimo.getStatus());
            ps.setDate(4, emprestimo.getData_emprestimo());
            ps.setDate(5, emprestimo.getData_dev_prev());

            ps.executeUpdate();

            ResultSet rs = ps.getGeneratedKeys();

            if (rs.next()) {
                int id;
                id = rs.getInt(1);
                emprestimo.setId(id);

            }
            ps.close();

        } catch (SQLException e) {

            JOptionPane.showMessageDialog(null, "Erro ao Realizar Empréstimo!\n" + "Erro: " + e, "ERRO SQL", JOptionPane.ERROR_MESSAGE, erro);

        }

    }

    public void devolver(EmprestimoBean emprestimo) {
        String sql = "update emprestimo set data_devolucao_real = ?, status_emprestimo = ? where id_emprestimo = ?";

        try {
            PreparedStatement ps = getCon().prepareStatement(sql);
            ps.setDate(1, emprestimo.getData_dev_real());
            ps.setString(2, emprestimo.getStatus());
            ps.setInt(3, emprestimo.getId());

            ps.executeUpdate();

            ps.close();

            JOptionPane.showMessageDialog(null, "<html><h3>Devolução Realizada com Sucesso!</h3></html>", "SUCESSO", JOptionPane.INFORMATION_MESSAGE, sucesso);

        } catch (SQLException e) {

            JOptionPane.showMessageDialog(null, "Erro ao alterar Obra !!", "ERRO SQL", JOptionPane.ERROR_MESSAGE);

        }

    }

    public void renovar(EmprestimoBean emprestimo) {
        String sql = "update emprestimo set data_DEVOLUCAO_PREVISTA = ?, status_emprestimo = ? where id_emprestimo = ?";

        try {
            PreparedStatement ps = getCon().prepareStatement(sql);
            ps.setDate(1, emprestimo.getData_dev_prev());
            ps.setString(2, emprestimo.getStatus());
            ps.setInt(3, emprestimo.getId());

            ps.executeUpdate();

            ps.close();

            JOptionPane.showMessageDialog(null, "<html><h3>Renovação realizada com Sucesso!</h3></html>", "BTK Informa", JOptionPane.INFORMATION_MESSAGE, sucesso);

        } catch (SQLException e) {

            JOptionPane.showMessageDialog(null, "<html><h3> Erro ao Renovar Empréstimo!<br></h3></html>" + e, "BTK Informa", JOptionPane.ERROR_MESSAGE, erro);

        }

    }

    //*
    //Verifica o Usuário que está realizando o Empréstimo e retorna o seu ID.
    //@return id
    private int verificaUsuario(String usuario) {
        String sql = "select id_usuario from usuario where Nome = '" + usuario + "'";
        int id = 0;
        try {
            PreparedStatement ps = getCon().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            rs.first();
            id = rs.getInt("id_usuario");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao Verificar id_Usuario\n" + "Erro: " + e, "ERRO SQL", JOptionPane.ERROR_MESSAGE);
        }

        return id;

    }

    //*
    //Verifica o Locatário da Obra e retorna o seu ID.
    private int verificaLocatario(String locatario) {
        String sql = "Select id_LOCATARIO from locatario where nome = '" + locatario + "'";
        int id = 0;
        try {
            PreparedStatement ps = getCon().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            rs.first();
            id = rs.getInt("id_LOCATARIO");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao Verificar id_Locatario\n" + "Erro: " + e, "ERRO SQL", JOptionPane.ERROR_MESSAGE);
        }

        return id;

    }

    public List<EmprestimoBean> listarTodos() {

        String sql = "Select emprestimo.id_EMPRESTIMO, usuario.nome, locatario.nome, ";
        sql += " emprestimo.Data_EMPRESTIMO, emprestimo.Data_DEVOLUCAO_PREVISTA, emprestimo.status_emprestimo ";
        sql += " from emprestimo as emprestimo inner join usuario as usuario ";
        sql += " on emprestimo.id_USUARIO = usuario.id_USUARIO inner join locatario as locatario ";
        sql += " on emprestimo.id_LOCATARIO = locatario.id_LOCATARIO where ";
        sql += " emprestimo.status_emprestimo ='Em Aberto' order by emprestimo.id_EMPRESTIMO";

        ArrayList<EmprestimoBean> listaEmprestimo = new ArrayList<>();
        try {

            PreparedStatement ps = getCon().prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            if (rs != null) {

                while (rs.next()) {
                    EmprestimoBean eb = new EmprestimoBean();

                    eb.setId(rs.getInt(1));
                    eb.setUsuario(rs.getString(2));
                    eb.setLocatario(rs.getString(3));
                    eb.setData_emprestimo(rs.getDate(4));
                    eb.setData_dev_prev(rs.getDate(5));
                    eb.setStatus(rs.getString(6));

                    listaEmprestimo.add(eb);
                }
                return listaEmprestimo;
            } else {

                return null;
            }
        } catch (SQLException e) {

            return null;
        }

    }

    public List<EmprestimoBean> listarPorLocatario(String locatario) {

        String sql = "Select emprestimo.id_EMPRESTIMO, usuario.nome, locatario.nome, ";
        sql += " emprestimo.Data_EMPRESTIMO, emprestimo.Data_DEVOLUCAO_PREVISTA ";
        sql += " from emprestimo as emprestimo inner join usuario as usuario ";
        sql += " on emprestimo.id_USUARIO = usuario.id_USUARIO inner join locatario as locatario ";
        sql += " on emprestimo.id_LOCATARIO = locatario.id_LOCATARIO ";
        sql += " where locatario.nome '%" + locatario + "%' order by emprestimo.id_EMPRESTIMO";

        ArrayList<EmprestimoBean> listaPorLocatario = new ArrayList<>();
        try {

            PreparedStatement ps = getCon().prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            if (rs != null) {

                while (rs.next()) {
                    EmprestimoBean eb = new EmprestimoBean();

                    eb.setId(rs.getInt(1));
                    eb.setUsuario(rs.getString(2));
                    eb.setLocatario(rs.getString(3));
                    eb.setData_emprestimo(rs.getDate(4));
                    eb.setData_dev_prev(rs.getDate(5));

                    listaPorLocatario.add(eb);
                }
                return listaPorLocatario;
            } else {

                return null;
            }
        } catch (SQLException e) {

            return null;
        }

    }
    
     public List<EmprestimoBean> listarAtrasos() {

        String sql = "Select emprestimo.id_EMPRESTIMO, usuario.nome, locatario.nome, ";
        sql += " emprestimo.Data_EMPRESTIMO, emprestimo.Data_DEVOLUCAO_PREVISTA ";
        sql += " from emprestimo as emprestimo inner join usuario as usuario ";
        sql += " on emprestimo.id_USUARIO = usuario.id_USUARIO inner join locatario as locatario ";
        sql += " on emprestimo.id_LOCATARIO = locatario.id_LOCATARIO ";
        sql += " where emprestimo.Data_DEVOLUCAO_PREVISTA < CURDATE()";

        ArrayList<EmprestimoBean> listaPorLocatario = new ArrayList<>();
        try {

            PreparedStatement ps = getCon().prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            if (rs != null) {

                while (rs.next()) {
                    EmprestimoBean eb = new EmprestimoBean();

                    eb.setId(rs.getInt(1));
                    eb.setUsuario(rs.getString(2));
                    eb.setLocatario(rs.getString(3));
                    eb.setData_emprestimo(rs.getDate(4));
                    eb.setData_dev_prev(rs.getDate(5));

                    listaPorLocatario.add(eb);
                }
                return listaPorLocatario;
            } else {

                return null;
            }
        } catch (SQLException e) {

            return null;
        }

    }

    
    
}
