import java.util.ArrayList;
import java.util.Scanner;
public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("=======================================");
        System.out.println("      Bem-vindo ao Pet Shop!");
        System.out.println("=======================================");
        System.out.println("Gerencie os pets cadastrados no sistema.");
        System.out.println("Digite o número da opção desejada:");


        // Carrega dados do arquivo
        ArrayList<Animais> listaDeAnimais = GravadorDeAnimais.carregar("animais.txt");
        
        // Atualiza o contador 
        int idCounter = listaDeAnimais.stream().mapToInt(Animais::getId).max().orElse(0) + 1;
        
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
            scanner.nextLine(); 

            switch(opcao) {
               case 1:
    String nomeTutor;
    do {
        System.out.print("Nome do Tutor: ");
        nomeTutor = scanner.nextLine();
        if (nomeTutor.trim().isEmpty()) {
            System.out.println("Erro: o nome do tutor não pode estar vazio.");
        }
    } while (nomeTutor.trim().isEmpty());

    String nome;
    do {
        System.out.print("Nome do pet: ");
        nome = scanner.nextLine();
        if (nome.trim().isEmpty()) {
            System.out.println("Erro: o nome do pet não pode estar vazio.");
        }
    } while (nome.trim().isEmpty());

    System.out.print("Espécie: ");
    String especie = scanner.nextLine();

    int idade;
    do {
        System.out.print("Idade: ");
        while (!scanner.hasNextInt()) {
            System.out.println("Erro: idade deve ser um número inteiro.");
            scanner.next(); 
        }
        idade = scanner.nextInt();
        if (idade < 0 || idade > 100) {
            System.out.println("Erro: idade deve estar entre 0 e 100.");
        }
    } while (idade < 0 || idade > 100);

    double peso;
    do {
        System.out.print("Peso: ");
        while (!scanner.hasNextDouble()) {
            System.out.println("Erro: peso deve ser um número.");
            scanner.next(); 
        }
        peso = scanner.nextDouble();
        if (peso <= 0) {
            System.out.println("Erro: peso deve ser maior que 0.");
        }
    } while (peso <= 0);

    scanner.nextLine(); // limpa quebra de linha

    String atendimento;
    do {
        System.out.print("Descrição do atendimento: ");
        atendimento = scanner.nextLine();
        if (atendimento.trim().isEmpty()) {
            System.out.println("Erro: a descrição do atendimento não pode estar vazia.");
        }
    } while (atendimento.trim().isEmpty());

    Animais novoAnimal = new Animais(idCounter++, nomeTutor, nome, especie, idade, peso, atendimento);
    listaDeAnimais.add(novoAnimal);
    GravadorDeAnimais.salvar(listaDeAnimais, "animais.txt");
    System.out.println("Animal foi registrado.");
    break;
    case 2:
    if (listaDeAnimais.isEmpty()) {
        System.out.println("Nenhum animal registrado.");
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
                                GravadorDeAnimais.salvar(listaDeAnimais, "animais.txt");
                                animalEditar = a;
                                break;
                            }
                        }

                        if (animalEditar != null) {
                             System.out.println("Novo nome do Tutor (" + animalEditar.getNomeTutor() + "): ");
                             animalEditar.setNomeTutor(scanner.nextLine());
                            System.out.println("Novo nome (" + animalEditar.getNome()+ "): ");
                            animalEditar.setNome(scanner.nextLine());
                             System.out.println("Nova espécie (" + animalEditar.getEspecie()+ "): ");
                            animalEditar.setEspecie(scanner.nextLine());
                             System.out.println("Nova idade (" + animalEditar.getIdade()+ "): ");
                            animalEditar.setIdade(scanner.nextInt());
                             System.out.println("Novo peso(" + animalEditar.getPeso()+ "): ");
                            animalEditar.setPeso(scanner.nextDouble());
                            scanner.nextLine(); // ← LIMPA o ENTER pendente
                            System.out.println("Nova Descrição (" + animalEditar.getAtendimento() + "): ");
                            animalEditar.setAtendimento(scanner.nextLine());

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
                                GravadorDeAnimais.salvar(listaDeAnimais, "animais.txt");
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

