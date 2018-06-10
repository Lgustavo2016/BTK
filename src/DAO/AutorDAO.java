package DAO;

import Beans.AutorBean;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.*;
import java.util.*;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class AutorDAO extends JFrame {

    private Connection con;
    private final Icon erro = new ImageIcon(getToolkit().createImage(getClass().getResource("/Imagens/erro.png")));
    private final Icon sucesso = new ImageIcon(getToolkit().createImage(getClass().getResource("/Imagens/sucesso.png")));

    public AutorDAO(Connection con) {

        setCon(con);

    }

    public Connection getCon() {
        return con;
    }

    public void setCon(Connection con) {
        this.con = con;
    }

    public void inserir(AutorBean autor) {

        String sql = "insert into autor(Nome) value (?)";
        try {
            PreparedStatement ps = getCon().prepareStatement(sql);
            ps.setString(1, autor.getNome());

            ps.executeUpdate();

            ps.close();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "<html><h3>Erro ao Inserir Autor !!</h3></html>" + e, "ERRO SQL", JOptionPane.ERROR_MESSAGE, erro);
        }

    }

    public void alterar(AutorBean autor) {
        String sql = "update autor set Nome = ?";
        sql += " where id_AUTOR = ?";

        try {

            PreparedStatement ps = getCon().prepareStatement(sql);
            ps.setString(1, autor.getNome());

            if (ps.executeUpdate() == 0) {

                JOptionPane.showMessageDialog(null, "<html><h3>Autor alterado com Sucesso !!</h3></html>", "AVISO", JOptionPane.INFORMATION_MESSAGE, sucesso);

            } else {
                JOptionPane.showMessageDialog(null, "<html><h3>Erro ao alterar Autor !!</h3></html>", "ERRO", JOptionPane.ERROR_MESSAGE, erro);
            }
        } catch (SQLException e) {

            JOptionPane.showMessageDialog(null, "<html><h3>Erro ao alterar Autor !!</h3></html>" + e, "ERRO SQL", JOptionPane.ERROR_MESSAGE, erro);

        }

    }

    public void excluir(AutorBean autor) {

        String sql = "delete from autor where id_AUTOR = ?";

        try {

            PreparedStatement ps = getCon().prepareStatement(sql);

            ps.setInt(1, autor.getID());

            if (ps.executeUpdate() == 0) {

                JOptionPane.showMessageDialog(null, "<html><h3>Autor excluído com Sucesso !!</h3></html>", "AVISO", JOptionPane.INFORMATION_MESSAGE, sucesso);

            } else {

                JOptionPane.showMessageDialog(null, "<html><h3>Erro ao excluir Autor !!</h3></html>", "ERRO", JOptionPane.ERROR_MESSAGE, erro);

            }
        } catch (SQLException e) {

            JOptionPane.showMessageDialog(null, "<html><h3>Erro ao excluir Autor !!</h3></html>", "ERRO SQL", JOptionPane.ERROR_MESSAGE, erro);

        }

    }

    public List<AutorBean> listarTodos() {
        String sql = "select * from autor";

        List<AutorBean> listaAutor = new ArrayList<AutorBean>();
        try {

            PreparedStatement ps = getCon().prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            if (rs != null) {

                while (rs.next()) {
                    AutorBean ub = new AutorBean();
                    ub.setID(rs.getInt(1));
                    ub.setNome(rs.getString(2));
                    listaAutor.add(ub);

                }
                return listaAutor;
            } else {

                return null;
            }
        } catch (SQLException e) {

            return null;
        }

    }

}
