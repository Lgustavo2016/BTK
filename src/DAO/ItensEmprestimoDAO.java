package DAO;

import Beans.GeneroBean;
import Beans.ItensEmprestimoBean;
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

public class ItensEmprestimoDAO extends JFrame {

    private Connection con;
    private final Icon sucesso = new ImageIcon(getToolkit().createImage(getClass().getResource("/Imagens/sucesso.png")));
    private final Icon erro = new ImageIcon(getToolkit().createImage(getClass().getResource("/Imagens/erro.png")));

    public ItensEmprestimoDAO(Connection con) {

        setCon(con);

    }

    public Connection getCon() {
        return con;
    }

    public void setCon(Connection con) {
        this.con = con;
    }

    public void adicionar(ItensEmprestimoBean itens) {

        String sql = "insert into itens_emprestimo(id_OBRA, Quantidade, id_Emprestimo) values (?,?,?)";
        try {
            PreparedStatement ps = getCon().prepareStatement(sql);

            int obra = itens.getObra();
            int qtd = itens.getQuantidade();

            diminuirQtd(obra, qtd);

            ps.setInt(1, obra);
            ps.setInt(2, qtd);
            ps.setInt(3, itens.getIdEmprestimo());

            ps.executeUpdate();

            ps.close();

            JOptionPane.showMessageDialog(null, "<html><h3>Empréstimo Realizado com Sucesso!</h3></html>", "BTK Informa", JOptionPane.INFORMATION_MESSAGE, sucesso);

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "<html><h3>Erro ao Realizar Empréstimo!!</h3></html>" + e, "ERRO ITENS", JOptionPane.ERROR_MESSAGE, erro);
        }

    }

    public void excluir(GeneroBean genero) {

        String sql = "delete from genero where id_GENERO = ?";

        try {

            PreparedStatement ps = getCon().prepareStatement(sql);

            ps.setInt(1, genero.getID());

            if (ps.executeUpdate() > 0) {

                JOptionPane.showMessageDialog(null, "Gênero excluído com Sucesso !!", "AVISO", JOptionPane.INFORMATION_MESSAGE);

            } else {

                JOptionPane.showMessageDialog(null, "Erro ao excluir Gênero !!", "ERRO", JOptionPane.ERROR_MESSAGE);

            }
        } catch (SQLException e) {

            JOptionPane.showMessageDialog(null, "Erro ao excluir Gênero !!", "ERRO SQL", JOptionPane.ERROR_MESSAGE);

        }

    }

    public List<ItensEmprestimoBean> listarTodos() {
        String sql = "select * from  itens_emprestimo";

        List<ItensEmprestimoBean> listaItens = new ArrayList<ItensEmprestimoBean>();
        try {

            PreparedStatement ps = getCon().prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            if (rs != null) {

                while (rs.next()) {
                    ItensEmprestimoBean itb = new ItensEmprestimoBean();
                    itb.setObra(rs.getInt(2));
                    itb.setQuantidade(rs.getInt(3));

                }
                return listaItens;
            } else {

                return null;
            }
        } catch (SQLException e) {

            return null;
        }

    }

    public int verificaItens() {
        String sql = "Select COUNT(id_Itens_Emprestimo)total from Itens_Emprestimo";
        int id = 0;
        try {
            PreparedStatement ps = getCon().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {

                id = rs.getInt("total");

            }

        } catch (SQLException e) {

            JOptionPane.showMessageDialog(null, "Erro ao Selecionar ID dos Itens", "ERRO SQL", JOptionPane.ERROR_MESSAGE);
        }

        return id;
    }

    private void diminuirQtd(int obra, int qtd) {
        String sql;
        int qtd2 = buscarObra(obra);
        qtd = qtd2 - qtd;

        if (qtd == 0) {
            sql = "Update obra set disponibilidade = "
                    + false + ", quantidade = "
                    + String.valueOf(qtd)
                    + " where id_obra = "
                    + String.valueOf(obra);

        } else {
            sql = "Update obra set quantidade = "
                    + String.valueOf(qtd)
                    + " where id_obra = "
                    + String.valueOf(obra);
        }
        try {
            PreparedStatement ps;
            ps = getCon().prepareStatement(sql);
            ps.executeUpdate();
            ps.close();
            System.out.println("Sucesso, pessoal");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao Atualizar Quantidade! \n" + ex, "ERRO SQL", JOptionPane.ERROR_MESSAGE);
        }

    }

    private int buscarObra(int obra) {
        int qtd = 0;
        String sql = "Select quantidade from Obra where id_obra = " + String.valueOf(obra) + "";
        try {
            PreparedStatement ps = getCon().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                qtd = rs.getInt("quantidade");
            }
        } catch (SQLException e) {

            JOptionPane.showMessageDialog(null, "Erro ao Selecionar Quantidade da Obra\n" + e, "ERRO SQL", JOptionPane.ERROR_MESSAGE);

        }

        return qtd;
    }
    
      public List<ObraBean> adicionarItens(String titulo) {
        String sql = "select obra.id_OBRA, obra.Titulo, autor.Nome, obra.Editora, genero.Descricao, obra.Edicao, obra.Ano";
        sql += " from obra as obra inner join autor as autor on obra.id_AUTOR = autor.id_AUTOR ";
        sql += "inner join genero as genero on obra.id_GENERO = genero.id_GENERO ";
        sql += "where obra.Titulo like '%" + titulo + "%'" + " order by obra.id_OBRA";

        ArrayList<ObraBean> adicionarItens = new ArrayList<>();
        try {

            PreparedStatement ps = getCon().prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            if (rs != null) {

                while (rs.next()) {
                    ObraBean cb = new ObraBean();

                    cb.setID(rs.getInt(1));
                    cb.setTitulo_OBRA(rs.getString(2));
                    cb.setAutor(rs.getString(3));
                    cb.setEditora_OBRA(rs.getString(4));
                    cb.setGenero(rs.getString(5));
                    cb.setEdicao(rs.getString(6));
                    cb.setAno(rs.getString(7));

                    adicionarItens.add(cb);
                }
                return adicionarItens;
            } else {

                return null;
            }
        } catch (SQLException e) {

            return null;
        }

    }


    public List<ObraBean> listarTodos(String id_emprestimo) {

        String sql = "select obra.id_OBRA, obra.Titulo, autor.Nome, obra.Editora, genero.Descricao, "
                + " obra.Edicao, obra.Ano, itens.Quantidade, obra.Nota ";
        sql += " from obra as obra inner join autor as autor on obra.id_AUTOR = autor.id_AUTOR ";
        sql += "inner join genero as genero on obra.id_GENERO = genero.id_GENERO ";
        sql += "inner join itens_emprestimo as itens on itens.id_OBRA = obra.id_OBRA ";
        sql += "inner join emprestimo as emprestimo on itens.id_EMPRESTIMO = emprestimo.id_EMPRESTIMO ";
        sql += "where itens.id_EMPRESTIMO = " + id_emprestimo + "" + " order by id_OBRA";

        List<ObraBean> listaObra = new ArrayList<>();

        try {

            PreparedStatement ps = getCon().prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            if (rs != null) {

                while (rs.next()) {
                    ObraBean ob = new ObraBean();

                    ob.setID(rs.getInt(1));
                    ob.setTitulo_OBRA(rs.getString(2));
                    ob.setAutor(rs.getString(3));
                    ob.setEditora_OBRA(rs.getString(4));
                    ob.setGenero(rs.getString(5));
                    ob.setEdicao(rs.getString(6));
                    ob.setAno(rs.getString(7));
                    ob.setQuantidade_OBRA(rs.getInt(8));
                    ob.setNota(rs.getInt(9));

                    listaObra.add(ob);

                }
                return listaObra;
            } else {

                return null;
            }
        } catch (SQLException e) {

            return null;
        }

    }

}
