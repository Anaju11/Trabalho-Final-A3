import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class GravadorDeAnimais {

    // Método para salvar os dados em um arquivo
    public static void salvar(ArrayList<Animais> lista, String nomeArquivo) {
        try (FileWriter gravador = new FileWriter(nomeArquivo)) {
            for (Animais a : lista) {
                gravador.write(a.getId() + "," +
                               a.getNomeTutor() + "," +
                               a.getNome() + "," +
                               a.getEspecie() + "," +
                               a.getIdade() + "," +
                               a.getPeso() + "," +
                               a.getAtendimento() + "\n");
            }
        } catch (IOException e) {
            System.out.println("Erro ao salvar os dados.");
            e.printStackTrace();
        }
    }

    // Método para carregar os dados de um arquivo
    public static ArrayList<Animais> carregar(String nomeArquivo) {
        ArrayList<Animais> lista = new ArrayList<>();

        try (BufferedReader leitor = new BufferedReader(new FileReader(nomeArquivo))) {
            String linha;
            while ((linha = leitor.readLine()) != null) {
                String[] partes = linha.split(",");
                if (partes.length == 7) {
                    int id = Integer.parseInt(partes[0]);
                    String nomeTutor = partes[1];
                    String nome = partes[2];
                    String especie = partes[3];
                    int idade = Integer.parseInt(partes[4]);
                    double peso = Double.parseDouble(partes[5]);
                    String atendimento = partes[6];

                    Animais a = new Animais(id, nomeTutor, nome, especie, idade, peso, atendimento);
                    lista.add(a);
                }
            }
        } catch (IOException e) {
            System.out.println("Arquivo não encontrado. Começando com lista vazia.");
        }

        return lista;
    }
}
