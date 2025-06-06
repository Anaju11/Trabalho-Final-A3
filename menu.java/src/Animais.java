public class Animais {
  private  int id;
     private String nomeTutor;
   private String nome;
  private  String especie;
   private int idade;
   private double peso;
   private String atendimento;

  public Animais(int id, String nomeTutor, String nome, String especie, int idade, double peso, String atendimento)
{
    this.id=id;
    this.nomeTutor=nomeTutor;
    this.nome=nome;
    this.especie=especie;
    this.idade=idade;
    this.peso= peso;
    this.atendimento=atendimento;

   }
   //método para acessar dado.
   public int getId() {
    return id;
}

public String getNomeTutor(){
    return nomeTutor;
}

public void setNomeTutor(String nome){
    this.nomeTutor=nomeTutor;
}
public String getNome(){
    return nome;
}

public void setNome(String nome){
    this.nome=nome;
}

public String getEspecie(){
return especie;
}

public void setEspecie(String especie){
    this.especie=especie;
}

public int getIdade(){
    return idade;
}

public void setIdade(int idade) {

    this.idade = idade;
}

public double getPeso(){
    return peso;
}
public void setPeso(double peso){
this.peso=peso;
}
public String getAtendimento(){
    return atendimento;
}

public void setAtendimento(String nome){
    this.nome=atendimento;
}
   public String toString() {
    return id +","+nomeTutor+","+nome+","+especie+","+idade+","+peso+","+atendimento+".";
}
}
