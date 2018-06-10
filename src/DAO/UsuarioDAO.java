package DAO;

import Beans.UsuarioBean;
import java.sql.*;
import java.util.*;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class UsuarioDAO extends JFrame {

    private Connection con;
    private final Icon erro = new ImageIcon(getToolkit().createImage(getClass().getResource("/Imagens/erro.png")));
    private final Icon sucesso = new ImageIcon(getToolkit().createImage(getClass().getResource("/Imagens/sucesso.png")));

    public UsuarioDAO(Connection con) {

        setCon(con);

    }

    public Connection getCon() {
        return con;
    }

    public void setCon(Connection con) {
        this.con = con;
    }

    public void inserir(UsuarioBean usuario) {

        String sql = "insert into usuario(nome,login,senha,dataCad) values (?,?,?,CURDATE())";
        try {
            PreparedStatement ps = getCon().prepareStatement(sql);
            ps.setString(1, usuario.getNOME());
            ps.setString(2, usuario.getLOGIN());
            ps.setString(3, usuario.getSENHA());
            ps.executeUpdate();
            ps.close();

            JOptionPane.showMessageDialog(null, "<html><h3>Usuário inserido com Sucesso !!</h3></html>", "AVISO", JOptionPane.INFORMATION_MESSAGE, sucesso);

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "<html><h3>Erro ao Inserir Usuário !!</h3></html>" + e, "ERRO SQL", JOptionPane.ERROR_MESSAGE, erro);
        }

    }

    public void alterar(UsuarioBean usuario) {
        String sql = "update usuario set nome = ?,login = ?, senha = ?";
        sql += "where id_USUARIO = ?";

        try {

            PreparedStatement ps = getCon().prepareStatement(sql);

            ps.setString(1, usuario.getNOME());
            ps.setString(2, usuario.getLOGIN());
            ps.setString(3, usuario.getSENHA());
            ps.setInt(4, usuario.getID());

            ps.executeUpdate();

            ps.close();

            JOptionPane.showMessageDialog(null, "<html><h3>Usuário alterado com Sucesso !!</h3></html>", "AVISO", JOptionPane.INFORMATION_MESSAGE, sucesso);

        } catch (SQLException e) {

            JOptionPane.showMessageDialog(null, "<html><h3>Erro ao Alterar !!</h3></html>" + e, "ERRO SQL", JOptionPane.ERROR_MESSAGE, erro);

        }

    }

    public void excluir(UsuarioBean usuario) {

        String sql = "delete from usuario where id_USUARIO = ?";

        try {

            PreparedStatement ps = getCon().prepareStatement(sql);

            ps.setInt(1, usuario.getID());
            
            ps.executeUpdate();
            
            ps.close();

            JOptionPane.showMessageDialog(null, "<html><h3>Usuário excluído com Sucesso !!</h3></html>", "AVISO", JOptionPane.INFORMATION_MESSAGE, sucesso);

        } catch (SQLException e) {

            JOptionPane.showMessageDialog(null, "<html><h3>Erro ao excluir Usuário !!</h3></html>", "ERRO SQL", JOptionPane.ERROR_MESSAGE, erro);

        }

    }

    public List<UsuarioBean> listarTodos() {
        String sql = "select * from usuario";

        List<UsuarioBean> listaUsuario = new ArrayList<UsuarioBean>();
        try {

            PreparedStatement ps = getCon().prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            if (rs != null) {

                while (rs.next()) {
                    UsuarioBean ub = new UsuarioBean();
                    ub.setID(rs.getInt(1));
                    ub.setNOME(rs.getString(2));
                    ub.setLOGIN(rs.getString(3));
                    ub.setData(rs.getDate(5));

                    listaUsuario.add(ub);

                }
                return listaUsuario;
            } else {

                return null;
            }
        } catch (SQLException e) {

            return null;
        }
//
    }

    public int logar(String login, String senha) {
        String sql = "select * from usuario where Login ='" + login + "'";
        try {
            PreparedStatement ps = getCon().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            rs.first();
            if (rs.getString("Senha").equals(senha)) {

                return 0;

            } else {

                return 1;

            }
        } catch (SQLException e) {

            return 1;
        }

    }

    public String carregaCODIGO() {
        String id = "";
        try {
            Connection con = Conexao.abrirConexao();
            String sql = "SELECT id_USUARIO FROM USUARIO ORDER BY id_USUARIO DESC LIMIT 1";

            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                int codigo = rs.getInt("id_USUARIO");
                codigo += 1;
                id = (String.valueOf(codigo));

            } else {
                id = "1";

            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "<html><h3>Erro ao preencher Código!</h3></html>" + ex, "ERRO SQL", JOptionPane.ERROR_MESSAGE, erro);
        }
        return id;
    }

    public String retornarUsuario(String login) {
        String usuario = "";
        String sql = "Select Nome from usuario where Login = '" + login + "'";
        try {
            PreparedStatement ps = getCon().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                usuario = rs.getString("Nome");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "<html><h3>Erro no Banco!\n" + "Erro: </h3></html>" + e, "ERRO SQL", JOptionPane.ERROR_MESSAGE, erro);
        }

        return usuario;

    }

}
