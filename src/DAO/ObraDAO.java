package DAO;

import Beans.AutorBean;
import Beans.ObraBean;
import java.sql.*;
import java.util.*;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class ObraDAO extends JFrame {

    private Connection con;
    private final Icon erro = new ImageIcon(getToolkit().createImage(getClass().getResource("/Imagens/erro.png")));
    private final Icon sucesso = new ImageIcon(getToolkit().createImage(getClass().getResource("/Imagens/sucesso.png")));

    public ObraDAO(Connection con) {

        setCon(con);

    }

    public Connection getCon() {
        return con;
    }

    public void setCon(Connection con) {
        this.con = con;
    }

    public void inserir(ObraBean obra) {

        String sql = "insert into obra(Titulo, Editora,Descricao,";
        sql += "Localizacao,Edicao,Ano,id_AUTOR, id_GENERO, Quantidade, Disponibilidade, DataEntrada) values (?,?,?,?,?,?,?,?,?,?,CURDATE())";

        try {
            PreparedStatement ps = getCon().prepareStatement(sql);
            ps.setString(1, obra.getTitulo_OBRA());
            ps.setString(2, obra.getEditora_OBRA());
            ps.setString(3, obra.getDescricao_OBRA());
            ps.setString(4, obra.getLocalizacao());
            ps.setString(5, obra.getEdicao());
            ps.setString(6, obra.getAno());
            ps.setInt(7, retornaAutor(obra.getAutor()));
            ps.setInt(8, retornaGenero(obra.getGenero()));
            ps.setInt(9, obra.getQuantidade_OBRA());
            ps.setBoolean(10, obra.isDisponibilidade());

            ps.executeUpdate();
            ps.close();
            
            
            JOptionPane.showMessageDialog(null, "<html><h3>Obra inserida com Sucesso !!</h3></html>", "AVISO", JOptionPane.INFORMATION_MESSAGE, sucesso);

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "<html><h3>Erro ao inserir Obra !!</h3></html>", "ERRO SQL", JOptionPane.ERROR_MESSAGE, erro);
        }

    }

    public void alterar(ObraBean obra) {
        String sql = "update obra set Titulo = ?,Editora = ?, Descricao = ?, Localizacao =?, Quantidade = ?, Disponibilidade = ?, Edicao =?,";
        sql += " Ano = ?, id_AUTOR = ?, id_GENERO = ? where id_OBRA = ?";

        try {

            PreparedStatement ps = getCon().prepareStatement(sql);
            ps.setString(1, obra.getTitulo_OBRA());
            ps.setString(2, obra.getEditora_OBRA());
            ps.setString(3, obra.getDescricao_OBRA());
            ps.setString(4, obra.getLocalizacao());
            ps.setInt(5, obra.getQuantidade_OBRA());
            ps.setBoolean(6, obra.isDisponibilidade());
            ps.setString(7, obra.getEdicao());
            ps.setString(8, obra.getAno());
            ps.setInt(9, retornaAutor(obra.getAutor()));
            ps.setInt(10, retornaGenero(obra.getGenero()));
            ps.setInt(11, obra.getID());

            ps.executeUpdate();
            ps.close();

            JOptionPane.showMessageDialog(null, "<html><h3>Obra alterada com Sucesso !!</h3></html>", "AVISO", JOptionPane.INFORMATION_MESSAGE, sucesso);

        } catch (SQLException e) {

            JOptionPane.showMessageDialog(null, "<html><h3>Erro ao alterar Obra !!</h3></html>", "ERRO SQL", JOptionPane.ERROR_MESSAGE, erro);

        }

    }

    public void excluir(ObraBean obra) {

        String sql = "delete from obra where id_OBRA = ?";

        try {

            PreparedStatement ps = getCon().prepareStatement(sql);

            ps.setInt(1, obra.getID());

            ps.executeUpdate();
            ps.close();

            JOptionPane.showMessageDialog(null, "<html><h3>Obra excluída com Sucesso !!</h3></html>", "AVISO", JOptionPane.INFORMATION_MESSAGE, sucesso);

        } catch (SQLException e) {

            JOptionPane.showMessageDialog(null, "<html><h3>Erro ao excluir Obra !!</h3></html>", "ERRO SQL", JOptionPane.ERROR_MESSAGE, erro);

        }

    }

    public List<ObraBean> listarTodos() {
        String sql = "select obra.id_OBRA, obra.DataEntrada, obra.Titulo, obra.Edicao, obra.Ano,"
                + " obra.Editora, genero.Descricao, autor.Nome, obra.Localizacao, obra.Quantidade, "
                + "obra.Disponibilidade";
        sql += " from obra as obra inner join autor as autor on obra.id_AUTOR = autor.id_AUTOR ";
        sql += "inner join genero as genero on obra.id_GENERO = genero.id_GENERO order by obra.id_OBRA";

        List<ObraBean> listaObra = new ArrayList<>();
        try {

            PreparedStatement ps = getCon().prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            if (rs != null) {

                while (rs.next()) {
                    ObraBean cb = new ObraBean();

                    cb.setID(rs.getInt(1));
                    cb.setData(rs.getDate(2));
                    cb.setTitulo_OBRA(rs.getString(3));
                    cb.setEdicao(rs.getString(4));
                    cb.setAno(rs.getString(5));
                    cb.setEditora_OBRA(rs.getString(6));
                    cb.setGenero(rs.getString(7));
                    cb.setAutor(rs.getString(8));
                    cb.setLocalizacao(rs.getString(9));
                    cb.setQuantidade_OBRA(rs.getInt(10));
                    cb.setDisponibilidade(rs.getBoolean(11));

                    listaObra.add(cb);
                }
                return listaObra;
            } else {

                return null;
            }
        } catch (SQLException e) {

            return null;
        }

    }

    //Realiza a pesquisa pelo codigo digitado pelo usuário
    public ArrayList<ObraBean> listarPorCodigo(String codigo) {
        String sql = "select obra.id_OBRA, obra.DataEntrada, obra.Titulo, obra.Edicao, obra.Ano,"
                + " obra.Editora, genero.Descricao, autor.Nome, obra.Localizacao, obra.Quantidade, "
                + "obra.Disponibilidade";
        sql += " from obra as obra inner join autor as autor on obra.id_AUTOR = autor.id_AUTOR ";
        sql += "inner join genero as genero on obra.id_GENERO = genero.id_GENERO ";
        sql += "where obra.id_OBRA ='" + codigo + "'" + "order by obra.id_OBRA";

        ArrayList<ObraBean> listaPorCodigo = new ArrayList<>();
        try {

            PreparedStatement ps = getCon().prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            if (rs != null) {

                while (rs.next()) {
                    ObraBean cb = new ObraBean();

                    cb.setID(rs.getInt(1));
                    cb.setData(rs.getDate(2));
                    cb.setTitulo_OBRA(rs.getString(3));
                    cb.setEdicao(rs.getString(4));
                    cb.setAno(rs.getString(5));
                    cb.setEditora_OBRA(rs.getString(6));
                    cb.setGenero(rs.getString(7));
                    cb.setAutor(rs.getString(8));
                    cb.setLocalizacao(rs.getString(9));
                    cb.setQuantidade_OBRA(rs.getInt(10));
                    cb.setDisponibilidade(rs.getBoolean(11));

                    listaPorCodigo.add(cb);
                }
                return listaPorCodigo;
            } else {

                return null;
            }
        } catch (SQLException e) {

            return null;
        }

    }

    public ArrayList<ObraBean> listarPorAutor(String nome) {
        String sql = "select obra.id_OBRA, obra.DataEntrada, obra.Titulo, obra.Edicao, obra.Ano,"
                + " obra.Editora, genero.Descricao, autor.Nome, obra.Localizacao, obra.Quantidade, "
                + "obra.Disponibilidade";
        sql += " from obra as obra inner join autor as autor on obra.id_AUTOR = autor.id_AUTOR ";
        sql += "inner join genero as genero on obra.id_GENERO = genero.id_GENERO ";
        sql += "where autor.nome like '%" + nome + "%'" + " order by obra.id_OBRA";

        ArrayList<ObraBean> listaPorAutor = new ArrayList<>();
        try {

            PreparedStatement ps = getCon().prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            if (rs != null) {

                while (rs.next()) {
                    ObraBean cb = new ObraBean();

                    cb.setID(rs.getInt(1));
                    cb.setData(rs.getDate(2));
                    cb.setTitulo_OBRA(rs.getString(3));
                    cb.setEdicao(rs.getString(4));
                    cb.setAno(rs.getString(5));
                    cb.setEditora_OBRA(rs.getString(6));
                    cb.setGenero(rs.getString(7));
                    cb.setAutor(rs.getString(8));
                    cb.setLocalizacao(rs.getString(9));
                    cb.setQuantidade_OBRA(rs.getInt(10));
                    cb.setDisponibilidade(rs.getBoolean(11));

                    listaPorAutor.add(cb);

                }
                return listaPorAutor;
            } else {

                return null;
            }
        } catch (SQLException e) {

            return null;
        }
    }

    public ArrayList<ObraBean> listarPorTitulo(String titulo) {
        String sql = "select obra.id_OBRA, obra.DataEntrada, obra.Titulo, obra.Edicao, obra.Ano,"
                + " obra.Editora, genero.Descricao, autor.Nome, obra.Localizacao, obra.Quantidade, "
                + "obra.Disponibilidade";
        sql += " from obra as obra inner join autor as autor on obra.id_AUTOR = autor.id_AUTOR ";
        sql += "inner join genero as genero on obra.id_GENERO = genero.id_GENERO ";
        sql += "where obra.Titulo like '%" + titulo + "%'" + "order by obra.Titulo";

        ArrayList<ObraBean> listaPorTitulo = new ArrayList<>();
        try {

            PreparedStatement ps = getCon().prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            if (rs != null) {

                while (rs.next()) {
                    ObraBean cb = new ObraBean();

                    cb.setID(rs.getInt(1));
                    cb.setData(rs.getDate(2));
                    cb.setTitulo_OBRA(rs.getString(3));
                    cb.setEdicao(rs.getString(4));
                    cb.setAno(rs.getString(5));
                    cb.setEditora_OBRA(rs.getString(6));
                    cb.setGenero(rs.getString(7));
                    cb.setAutor(rs.getString(8));
                    cb.setLocalizacao(rs.getString(9));
                    cb.setQuantidade_OBRA(rs.getInt(10));
                    cb.setDisponibilidade(rs.getBoolean(11));

                    listaPorTitulo.add(cb);
                }
                return listaPorTitulo;
            } else {

                return null;
            }
        } catch (SQLException e) {

            return null;
        }

    }

    public ArrayList<ObraBean> listarPorGenero(String genero) {
        String sql = "select obra.id_OBRA, obra.DataEntrada, obra.Titulo, obra.Edicao, obra.Ano,"
                + " obra.Editora, genero.Descricao, autor.Nome, obra.Localizacao, obra.Quantidade, "
                + "obra.Disponibilidade";
        sql += " from obra as obra inner join autor as autor on obra.id_AUTOR = autor.id_AUTOR ";
        sql += "inner join genero as genero on obra.id_GENERO = genero.id_GENERO ";
        sql += "where genero.Descricao like '%" + genero + "%'" + " order by genero.Descricao";

        ArrayList<ObraBean> listaPorGenero = new ArrayList<>();
        try {

            PreparedStatement ps = getCon().prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            if (rs != null) {

                while (rs.next()) {
                    ObraBean cb = new ObraBean();

                    cb.setID(rs.getInt(1));
                    cb.setData(rs.getDate(2));
                    cb.setTitulo_OBRA(rs.getString(3));
                    cb.setEdicao(rs.getString(4));
                    cb.setAno(rs.getString(5));
                    cb.setEditora_OBRA(rs.getString(6));
                    cb.setGenero(rs.getString(7));
                    cb.setAutor(rs.getString(8));
                    cb.setLocalizacao(rs.getString(9));
                    cb.setQuantidade_OBRA(rs.getInt(10));
                    cb.setDisponibilidade(rs.getBoolean(11));

                    listaPorGenero.add(cb);
                }
                return listaPorGenero;
            } else {

                return null;
            }
        } catch (SQLException e) {

            return null;
        }

    }

    public ArrayList<ObraBean> listarPorLocalizacao(String localizacao) {
        String sql = "select obra.id_OBRA, obra.DataEntrada, obra.Titulo, obra.Edicao, obra.Ano,"
                + " obra.Editora, genero.Descricao, autor.Nome, obra.Localizacao, obra.Quantidade, "
                + "obra.Disponibilidade";
        sql += " from obra as obra inner join autor as autor on obra.id_AUTOR = autor.id_AUTOR ";
        sql += "inner join genero as genero on obra.id_GENERO = genero.id_GENERO ";
        sql += "where obra.Localizacao like '%" + localizacao + "%'" + " order by obra.Localizacao";

        ArrayList<ObraBean> listaPorLocalizacao = new ArrayList<>();
        try {

            PreparedStatement ps = getCon().prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            if (rs != null) {

                while (rs.next()) {
                    ObraBean cb = new ObraBean();

                    cb.setID(rs.getInt(1));
                    cb.setData(rs.getDate(2));
                    cb.setTitulo_OBRA(rs.getString(3));
                    cb.setEdicao(rs.getString(4));
                    cb.setAno(rs.getString(5));
                    cb.setEditora_OBRA(rs.getString(6));
                    cb.setGenero(rs.getString(7));
                    cb.setAutor(rs.getString(8));
                    cb.setLocalizacao(rs.getString(9));
                    cb.setQuantidade_OBRA(rs.getInt(10));
                    cb.setDisponibilidade(rs.getBoolean(11));

                    listaPorLocalizacao.add(cb);
                }
                return listaPorLocalizacao;
            } else {

                return null;
            }
        } catch (SQLException e) {

            return null;
        }

    }

    public ArrayList<ObraBean> listarPorEditora(String editora) {
        String sql = "select obra.id_OBRA, obra.DataEntrada, obra.Titulo, obra.Edicao, obra.Ano,"
                + " obra.Editora, genero.Descricao, autor.Nome, obra.Localizacao, obra.Quantidade, "
                + "obra.Disponibilidade";
        sql += " from obra as obra inner join autor as autor on obra.id_AUTOR = autor.id_AUTOR ";
        sql += "inner join genero as genero on obra.id_GENERO = genero.id_GENERO ";
        sql += "where obra.Editora like '%" + editora + "%'" + " order by obra.Editora";

        ArrayList<ObraBean> listaPorEditora = new ArrayList<>();
        try {

            PreparedStatement ps = getCon().prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            if (rs != null) {

                while (rs.next()) {
                    ObraBean cb = new ObraBean();

                    cb.setID(rs.getInt(1));
                    cb.setData(rs.getDate(2));
                    cb.setTitulo_OBRA(rs.getString(3));
                    cb.setEdicao(rs.getString(4));
                    cb.setAno(rs.getString(5));
                    cb.setEditora_OBRA(rs.getString(6));
                    cb.setGenero(rs.getString(7));
                    cb.setAutor(rs.getString(8));
                    cb.setLocalizacao(rs.getString(9));
                    cb.setQuantidade_OBRA(rs.getInt(10));
                    cb.setDisponibilidade(rs.getBoolean(11));

                    listaPorEditora.add(cb);
                }
                return listaPorEditora;
            } else {

                return null;
            }
        } catch (SQLException e) {

            return null;
        }

    }

    public int retornaAutor(String autor) {
        int autorID = 0;
        String sql = "select * from autor where nome = '" + autor + "'";
        try {
            PreparedStatement ps = getCon().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                autorID = rs.getInt("id_AUTOR");
                return autorID;
            } else {
                AutorBean ab = new AutorBean();
                AutorDAO ad = new AutorDAO(con);
                ab.setNome(autor);
                ad.inserir(ab);

                PreparedStatement ps2 = getCon().prepareStatement(sql);
                ResultSet rs2 = ps2.executeQuery();
                rs2.next();
                autorID = rs2.getInt("id_AUTOR");
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao buscar código do Autor!!\nERRO:" + ex, "ERRO SQL", JOptionPane.ERROR_MESSAGE);
        }
        return autorID;
    }

    public int retornaGenero(String genero) {
        int generoID = 0;
        String sql = "select * from genero where descricao = '" + genero + "'";
        try {
            PreparedStatement ps = getCon().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            rs.first();
            generoID = rs.getInt("id_GENERO");

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "<html><h3>Erro ao buscar código do Gênero!! <br> ERRO:</h3></html> " + ex, "ERRO SQL", JOptionPane.ERROR_MESSAGE, erro);

        }
        return generoID;

    }

    //CARREGA O NUMERO DE TOMBO DA OBRA
    public String carregaCODIGO() {
        String tombo = "";
        try {
            Connection con = Conexao.abrirConexao();
            String sql = "SELECT id_OBRA FROM OBRA ORDER BY id_OBRA DESC LIMIT 1";

            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                int codigo = rs.getInt("id_OBRA");
                codigo += 1;
                tombo = (String.valueOf(codigo));

            } else {
                tombo = "1";

            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "<html><h3>Erro ao preencher Código!</h3></html>" + ex, "ERRO SQL", JOptionPane.ERROR_MESSAGE, erro);
        }
        return tombo;
    }

}
