package DAO;

import Beans.GeneroBean;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.*;
import java.util.*;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class GeneroDAO extends JFrame {

    private Connection con;
    private final Icon erro = new ImageIcon(getToolkit().createImage(getClass().getResource("/Imagens/erro.png")));
    private final Icon sucesso = new ImageIcon(getToolkit().createImage(getClass().getResource("/Imagens/sucesso.png")));

    public GeneroDAO(Connection con) {

        setCon(con);

    }

    public Connection getCon() {
        return con;
    }

    public void setCon(Connection con) {
        this.con = con;
    }

    public void inserir(GeneroBean genero) {

        String sql = "insert into genero(Descricao) value (?)";
        try {
            PreparedStatement ps = getCon().prepareStatement(sql);
            ps.setString(1, genero.getDescricao());

            ps.executeUpdate();
            ps.close();

            JOptionPane.showMessageDialog(null, "<html><h3>Gênero inserido com Sucesso !!</h3></html>", "AVISO", JOptionPane.INFORMATION_MESSAGE, sucesso);

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "<html><h3>Erro ao Inserir Gênero !! <br></h3></html>" + e, "ERRO SQL", JOptionPane.ERROR_MESSAGE, erro);
        }

    }

    public void alterar(GeneroBean genero) {
        String sql = "update genero set Descricao = ?";
        sql += " where id_GENERO = ?";

        try {

            PreparedStatement ps = getCon().prepareStatement(sql);
            ps.setString(1, genero.getDescricao());
            ps.executeUpdate();
            ps.close();

            JOptionPane.showMessageDialog(null, "<html><h3>Gênero alterado com Sucesso !!</h3></html>", "AVISO", JOptionPane.INFORMATION_MESSAGE, sucesso);

        } catch (SQLException e) {

            JOptionPane.showMessageDialog(null, "<html><h3>Erro ao alterar Gênero !!<br></h3></html>" + e, "ERRO SQL", JOptionPane.ERROR_MESSAGE, erro);

        }

    }

    public void excluir(GeneroBean genero) {

        String sql = "delete from genero where id_GENERO = ?";

        try {

            PreparedStatement ps = getCon().prepareStatement(sql);

            ps.setInt(1, genero.getID());
            ps.executeUpdate();
            ps.close();
            JOptionPane.showMessageDialog(null, "<html><h3>Gênero excluído com Sucesso !!</h3></html>", "AVISO", JOptionPane.INFORMATION_MESSAGE, sucesso);

        } catch (SQLException e) {

            JOptionPane.showMessageDialog(null, "<html><h3>Erro ao excluir Gênero !!<br></h3></html>" + e, "ERRO SQL", JOptionPane.ERROR_MESSAGE, erro);

        }

    }

    public List<GeneroBean> listarTodos() {
        String sql = "select * from genero";

        List<GeneroBean> listaGenero = new ArrayList<GeneroBean>();
        try {

            PreparedStatement ps = getCon().prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            if (rs != null) {

                while (rs.next()) {
                    GeneroBean ub = new GeneroBean();
                    ub.setID(rs.getInt(1));
                    ub.setDescricao(rs.getString(2));
                    listaGenero.add(ub);

                }
                return listaGenero;
            } else {

                return null;
            }
        } catch (SQLException e) {

            return null;
        }

    }

}
