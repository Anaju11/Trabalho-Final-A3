import java.util.ArrayList;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Seja Bem vindo!");
        ArrayList<Animais> listaDeAnimais = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        int opcao;
        int idCounter = 1;

        do {
            System.out.println("1. Criar novo registro");
            System.out.println("2. Listar todos os registros");
            System.out.println("3. Buscar registro (por identificador)");
            System.out.println("4. Editar registro");
            System.out.println("5. Excluir registro");
            System.out.println("6. Sair");
            System.out.print("Escolha uma opção: ");

            opcao = scanner.nextInt();
            scanner.nextLine(); 

            switch(opcao) {
                case 1:
                    // Criar
                    System.out.print("Nome: ");
                    String nome = scanner.nextLine();
                    System.out.print("Especie: ");
                    String especie = scanner.nextLine();
                    System.out.print("Idade: ");
                    int idade = scanner.nextInt();
                    System.out.print("Peso ");
                    double peso = scanner.nextDouble();

                    Animais novoAnimal = new Animais(idCounter++, nome,especie,idade,peso);
                        listaDeAnimais.add(novoAnimal);
                        System.out.println("Animal foi registrado.");
                    break;

                case 2:
                    // Lista
                    if (listaDeAnimais.isEmpty()) {
                        System.out.println ("Nenhum animal registrado.");
                    } else {
                        for (Animais a : listaDeAnimais) {
                            System.out.println(a);
                        }
                    }
                    break;

                case 3:
                    // Busca
                    System.out.print("Digite o ID do animal: ");
                    int idBusca = scanner.nextInt();
                    boolean encontrar= false;
                        for (Animais a : listaDeAnimais) {
                            if (a.getId() == idBusca) {
                                System.out.println("Registro:" + a);
                                encontrar = true;
                                break;
                            }
                        }
                        if (!encontrar) {
                            System.out.print("Animal com ID" + idBusca + "não foi encontrado.");
                        }
                    break;

                case 4:
                    // Edita
                    System.out.println("Digite o Id do animal que deseja que seja editato: ");
                    int idEditar = scanner.nextInt();
                    scanner.nextLine();
                    Animais animalEditar = null;
                        for (Animais a : listaDeAnimais) {
                            if (a.getId() == idEditar) {
                                animalEditar = a;
                                break;
                            }
                        }

                        if (animalEditar != null) {
                            System.out.println("Novo nome (" + animalEditar.getNome()+ "): ");
                            animalEditar.setNome(scanner.nextLine());
                             System.out.println("Nova espécie (" + animalEditar.getEspecie()+ "): ");
                            animalEditar.setEspecie(scanner.nextLine());
                             System.out.println("Nova idade (" + animalEditar.getIdade()+ "): ");
                            animalEditar.setIdade(scanner.nextInt());
                             System.out.println("Novo peso(" + animalEditar.getPeso()+ "): ");
                            animalEditar.setPeso(scanner.nextDouble());

                            System.out.println("Regitro atualizado.");

                        } else {
                            System.out.print("Animal com ID"+ idEditar + "não foi encontrado.");
                        }
                    break;

                case 5:
                    // Exclui
                    System.out.print("Digite o Id do animal que deseja excluir: ");
                    int idExcluir = scanner.nextInt();
                    boolean remover = false;
                        for (int i = 0; i < listaDeAnimais.size(); i++) {
                            if (listaDeAnimais.get(i).getId() == idExcluir) {
                                listaDeAnimais.remove(i);
                                remover = true;
                                System.out.println("O animal foi removido.");
                                break;
                            }
                        }
                        if (!remover) {
                            System.out.println("Animal com ID" + idExcluir + " não dfoi encontrado.");
                        }
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

