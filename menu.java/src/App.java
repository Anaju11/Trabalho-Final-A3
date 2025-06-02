import java.util.ArrayList;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Seja Bem vindo!");
        ArrayList<Animais> listaDeAnimais = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("1. Criar novo registro");
            System.out.println("2. Listar todos os registros");
            System.out.println("3. Buscar registro (por identificador)");
            System.out.println("4. Editar registro");
            System.out.println("5. Excluir registro");
            System.out.println("6. Sair");
            System.out.print("Escolha uma opção: ");

            opcao = scanner.nextInt();

            switch(opcao) {
                case 1:
                    // Criar novo animal
                    break;
                case 2:
                    // Listar animais
                    break;
                case 3:
                    // Buscar animal
                    break;
                case 4:
                    // Editar animal
                    break;
                case 5:
                    // Excluir animal
                    break;
                case 6:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        } while(opcao != 6);
    }
}
    

