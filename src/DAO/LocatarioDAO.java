package DAO;

import Beans.LocatarioBean;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.*;
import java.util.*;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class LocatarioDAO extends JFrame {

    private Connection con;
    private final Icon sucesso = new ImageIcon(getToolkit().createImage(getClass().getResource("/Imagens/sucesso.png")));
    private final Icon erro = new ImageIcon(getToolkit().createImage(getClass().getResource("/Imagens/erro.png")));

    public LocatarioDAO(Connection con) {

        setCon(con);

    }

    public Connection getCon() {
        return con;
    }

    public void setCon(Connection con) {
        this.con = con;
    }

    //"insert into locatario (Nome,Serie, Periodo, Telefone, Celular, Email, Tipo )values(?,?,?,?,?,?,?)");
    public void inserir(LocatarioBean locatario) {

        String sql = "insert into locatario(Nome,Serie, Periodo, Telefone, Celular, Email, Tipo )values(?,?,?,?,?,?,?)";
        try {
            PreparedStatement ps = getCon().prepareStatement(sql);
            ps.setString(1, locatario.getNome());
            ps.setString(2, locatario.getSerie());
            ps.setString(3, locatario.getPeriodo());
            ps.setString(4, locatario.getTel());
            ps.setString(5, locatario.getCel());
            ps.setString(6, locatario.getEmail());
            ps.setString(7, locatario.getTipo());

            ps.executeUpdate();
            ps.close();

            JOptionPane.showMessageDialog(null, "<html><h3>Locatário inserido com Sucesso !!</h3></html>", "AVISO", JOptionPane.INFORMATION_MESSAGE, sucesso);

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "<html><h3>Erro ao inserir Locatário !!</h3></html>" + e, "ERRO SQL", JOptionPane.ERROR_MESSAGE, erro);
        }

    }

    public void alterar(LocatarioBean locatario) {
        String sql = "update locatario set Nome = ?, Serie = ?, Periodo = ?, Telefone = ?, Celular = ?, Email = ?, Tipo = ?";
        sql += "where id_LOCATARIO = ?";

        try {

            PreparedStatement ps = getCon().prepareStatement(sql);
            ps.setString(1, locatario.getNome());
            ps.setString(2, locatario.getSerie());
            ps.setString(3, locatario.getPeriodo());
            ps.setString(4, locatario.getTel());
            ps.setString(5, locatario.getCel());
            ps.setString(6, locatario.getEmail());
            ps.setString(7, locatario.getTipo());
            ps.setInt(8, locatario.getID());

            ps.executeUpdate();

            ps.close();

            JOptionPane.showMessageDialog(null, "<html><h3>Locatário alterado com Sucesso !!</h3></html>", "AVISO", JOptionPane.INFORMATION_MESSAGE, sucesso);

        } catch (SQLException e) {

            JOptionPane.showMessageDialog(null, "<html><h3>Erro ao alterar Locatário !!</h3></html>" + e, "ERRO SQL", JOptionPane.ERROR_MESSAGE, erro);

        }

    }

    public void excluir(LocatarioBean locatario) {

        String sql = "delete from locatario where id_LOCATARIO = ?";

        try {

            PreparedStatement ps = getCon().prepareStatement(sql);

            ps.setInt(1, locatario.getID());

            ps.executeUpdate();

            ps.close();

            JOptionPane.showMessageDialog(null, "<html><h3>Locatário excluído com Sucesso !!</h3></html>", "AVISO", JOptionPane.INFORMATION_MESSAGE, sucesso);

        } catch (SQLException e) {

            JOptionPane.showMessageDialog(null, "<html><h3>Erro ao excluir Locatário !! <br></h3></html>" + e, "ERRO SQL", JOptionPane.ERROR_MESSAGE, erro);

        }

    }

    public List<LocatarioBean> listarTodos() {
        String sql = "select * from locatario";

        List<LocatarioBean> listaLocatário = new ArrayList<>();
        try {

            PreparedStatement ps = getCon().prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            if (rs != null) {

                while (rs.next()) {
                    LocatarioBean ub = new LocatarioBean();
                    ub.setID(rs.getInt(1));
                    ub.setNome(rs.getString(2));
                    ub.setSerie(rs.getString(3));
                    ub.setPeriodo(rs.getString(4));
                    ub.setTel(rs.getString(5));
                    ub.setCel(rs.getString(6));
                    ub.setEmail(rs.getString(7));
                    ub.setTipo(rs.getString(8));

                    listaLocatário.add(ub);

                }
                return listaLocatário;
            } else {

                return null;
            }
        } catch (SQLException e) {

            return null;
        }

    }

    public List<LocatarioBean> listarPorNome(String nome) {
        String sql = "select * from locatario where nome like '%" + nome + "%'";

        List<LocatarioBean> listarPorNome = new ArrayList<>();
        try {

            PreparedStatement ps = getCon().prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            if (rs != null) {

                while (rs.next()) {
                    LocatarioBean ub = new LocatarioBean();
                    ub.setID(rs.getInt(1));
                    ub.setNome(rs.getString(2));
                    ub.setSerie(rs.getString(3));
                    ub.setPeriodo(rs.getString(4));
                    ub.setTel(rs.getString(5));
                    ub.setCel(rs.getString(6));
                    ub.setEmail(rs.getString(7));
                    ub.setTipo(rs.getString(8));

                    listarPorNome.add(ub);

                }
                return listarPorNome;
            } else {

                return null;
            }
        } catch (SQLException e) {

            return null;
        }

    }

    public String carregaCODIGO() {
        String id = "";
        try {
            Connection con = Conexao.abrirConexao();
            String sql = "SELECT id_LOCATARIO FROM LOCATARIO ORDER BY id_LOCATARIO DESC LIMIT 1";

            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                int codigo = rs.getInt("id_LOCATARIO");
                codigo += 1;
                id = (String.valueOf(codigo));

            } else {
                id = "1";

            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "<html><h3>Erro ao preencher Código!<br></h3></html>" + ex, "ERRO SQL", JOptionPane.ERROR_MESSAGE, erro);
        }
        return id;
    }
    
    public String verificarEmail(String locatario){
       String email = "";
        try {
            Connection con = Conexao.abrirConexao();
            String sql = "SELECT Email FROM LOCATARIO where nome = '" + locatario + "' and Email is not null ORDER BY id_LOCATARIO";

            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            if (rs.next()) {
                email = rs.getString("Email");
            } 
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "<html><h3>Erro ao buscar E-mail!<br></h3></html>" + ex, "ERRO SQL", JOptionPane.ERROR_MESSAGE, erro);
        }
        return email;

    }

}
