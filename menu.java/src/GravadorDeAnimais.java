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
                gravador.write(a.toString() + "\n");
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
                if (partes.length == 5) {
                    int id = Integer.parseInt(partes[0]);
                    String nome = partes[1];
                    String especie = partes[2];
                    int idade = Integer.parseInt(partes[3]);
                    double peso = Double.parseDouble(partes[4]);

                    Animais a = new Animais(id, nome, especie, idade, peso);
                    lista.add(a);
                }
            }
        } catch (IOException e) {
            System.out.println("Arquivo não encontrado. Começando com lista vazia.");
        }

        return lista;
    }
}

