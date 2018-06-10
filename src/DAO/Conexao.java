package DAO;

import java.sql.*;

public class Conexao {

    public static Connection abrirConexao() {
        Connection con = null;
        try {

            Class.forName("com.mysql.jdbc.Driver").newInstance();
            String url = "";
            url += "jdbc:mysql://localhost/btk?";
            url += "user=root&password=_c@n3t@321_&useSSL=false"; //_c@n3t@321_
            con = DriverManager.getConnection(url);
            System.out.println("Conexão Aberta");

        } catch (SQLException e) {
            System.out.println(e.getMessage());

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return con;
    }

    public static void fecharConexao(Connection con) {
        try {
            con.close();
            System.out.println("Conexão Fechada");

        } catch (SQLException e) {
            System.out.println(e.getMessage());

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
