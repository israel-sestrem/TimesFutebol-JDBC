package Repositories;

import java.sql.Connection;
import java.sql.SQLException;

public class TestaClasses {

    public static void main(String[] args) throws SQLException {

        ConnectionFactory connectionFactory = new ConnectionFactory();
        try (Connection con = connectionFactory.fazerConexao()){
            Times time = new Times();
            // testes CRUD
//            time.listarTimes();
//            time.cadastrarTime("Flamengo","Rio de Janeiro");
//            time.listarTimes();
//            time.editarTime(1,"Mengão","Rio");
//            time.cadastrarTime("Palmeiras","São Paulo");
//            time.listarTimes();
//            time.deletarTime(1);
//            time.listarTimes();
//            time.deletarTime(2);
//            time.listarTimes();

            // testes VerificaId;
//            time.listarTimes();
//            time.verificarId(2);
//            time.cadastrarTime("abc","abc");
//            time.listarTimes();
//            time.verificarId(5);
        }

    }

}
