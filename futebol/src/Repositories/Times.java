package Repositories;

import java.sql.*;

public class Times {

    public void listarTimes() throws SQLException {
        ConnectionFactory connectionFactory = new ConnectionFactory();
        try(Connection con = connectionFactory.fazerConexao()){
            con.setAutoCommit(false);
            String sql = "SELECT * FROM times;";
            try(PreparedStatement stm = con.prepareStatement(sql)){
                stm.execute();
                try(ResultSet rst = stm.getResultSet()){
                    boolean possuiDados = false;
                    while(rst.next()){
                        Integer id = rst.getInt(1);
                        System.out.print("Id: " + id + ", ");
                        String nome = rst.getString(2);
                        System.out.print("Nome: " + nome + ", ");
                        String estadoOrigem = rst.getString(3);
                        System.out.print("Estado De Origem: " + estadoOrigem + "\n");
                        possuiDados = true;
                    }
                    if(!possuiDados){
                        System.out.println("Não há registro no banco de dados.");
                    }
                    con.commit();
                }
            }
        }
    }

    public void cadastrarTime(String time, String estadoOrigem) throws SQLException{
        ConnectionFactory connectionFactory = new ConnectionFactory();
        try(Connection con = connectionFactory.fazerConexao()){
            con.setAutoCommit(false);
            String sql = "INSERT INTO times (nome, estado_origem) VALUES (?,?);";
            try(PreparedStatement stm = con.prepareStatement(sql)){
                stm.setString(1,time);
                stm.setString(2,estadoOrigem);
                stm.execute();
                con.commit();
                System.out.println("Time cadastrado com sucesso!");
            } catch(Exception e){
                e.printStackTrace();
                System.out.println("Houve um erro, dando rollback...");
                con.rollback();
            }
        }
    }

    public void editarTime(Integer id, String novoNome, String novoEstadoOrigem) throws SQLException{
        ConnectionFactory connectionFactory = new ConnectionFactory();
        try(Connection con = connectionFactory.fazerConexao()){
            con.setAutoCommit(false);
            String sql = "UPDATE times SET nome=?, estado_origem=? WHERE id=?;";
            try(PreparedStatement stm = con.prepareStatement(sql)){
                stm.setString(1,novoNome);
                stm.setString(2,novoEstadoOrigem);
                stm.setInt(3,id);
                stm.execute();
                con.commit();
                System.out.println("Time editado com sucesso!");
            } catch(Exception e){
                e.printStackTrace();
                System.out.println("Houve um erro, dando rollback...");
                con.rollback();
            }
        }
    }

    public void deletarTime(Integer id) throws SQLException{
        ConnectionFactory connectionFactory = new ConnectionFactory();
        try(Connection con = connectionFactory.fazerConexao()){
            con.setAutoCommit(false);
            String sql = "DELETE FROM times WHERE id=?;";
            try(PreparedStatement stm = con.prepareStatement(sql)){
                stm.setInt(1,id);
                stm.execute();
                con.commit();
                System.out.println("Time deletado com sucesso!");
            } catch(Exception e){
                e.printStackTrace();
                System.out.println("Houve um erro, dando rollback...");
                con.rollback();
            }
        }
    }

    public boolean verificarId(Integer id) throws SQLException{
        ConnectionFactory connectionFactory = new ConnectionFactory();
        try(Connection con = connectionFactory.fazerConexao()){
            con.setAutoCommit(false);
            String sql = "SELECT id FROM times WHERE id=?;";
            try(PreparedStatement stm = con.prepareStatement(sql)){
                stm.setInt(1,id);
                stm.execute();
                try(ResultSet rst = stm.getResultSet()){
                    if(rst.next()){
                        return true;
                    } else {
                        System.out.println("Id não existe. Tente novamente.");
                        return false;
                    }
                }
            }
        }
    }

}
