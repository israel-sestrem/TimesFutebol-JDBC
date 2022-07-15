package Service;

import Repositories.Times;

import java.sql.SQLException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws SQLException {

        Scanner leitor = new Scanner(System.in);
        Times times = new Times();

        Integer id = 0;
        boolean idExiste = false;

        String op;

        System.out.println("Seja bem vindo ao meu sistema!\n");

        do{
            leitor = new Scanner(System.in);
            System.out.println("\n1 - Listar Times");
            System.out.println("2 - Cadastrar Time");
            System.out.println("3 - Editar Time");
            System.out.println("4 - Deletar Time");
            System.out.println("5 - Sair");
            System.out.print("Escolha a opção desejada: ");
            op = leitor.next();

            System.out.println();

            switch(op){
                case "1":
                    times.listarTimes();
                    break;
                case "2":
                    System.out.print("Informe o nome do time: ");
                    leitor.nextLine();
                    String time = leitor.nextLine();
                    System.out.print("Informe o estado de origem: ");
                    String estadoOrigem = leitor.nextLine();

                    times.cadastrarTime(time, estadoOrigem);
                    break;
                case "3":
                    id = getId(leitor);
                    if(id==-1){
                        break;
                    }
                    idExiste = times.verificarId(id);
                    if(!idExiste){
                        break;
                    }
                    System.out.print("Informe o novo nome do time: ");
                    leitor.nextLine();
                    String novoNome = leitor.nextLine();
                    System.out.print("Informe o novo estado de origem do time: ");
                    String novoEstadoOrigem = leitor.nextLine();

                    times.editarTime(id, novoNome, novoEstadoOrigem);
                    break;
                case "4":
                    id = getId(leitor);
                    if(id==-1){
                        break;
                    }
                    idExiste = times.verificarId(id);
                    if(!idExiste){
                        break;
                    }
                    times.deletarTime(id);
                    break;
                case "5":
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
                    break;
            }
        }while(!op.equals("5"));

        System.out.println("Obrigado por utilizar meu sistema!");
    }

    public static Integer getId(Scanner leitor){
        Integer id = 0;
        try {
            System.out.print("Informe o id do time: ");
            id = leitor.nextInt();
        } catch (Exception e) {
            System.out.println("Id inválido.");
            return -1;
        }
        return id;
    }

}
