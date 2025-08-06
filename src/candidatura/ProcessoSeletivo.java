package candidatura;
import java.util.concurrent.ThreadLocalRandom;

public class ProcessoSeletivo {

    public static void main (String[] args){
        selecaoCandidatos();
    }

    static void selecaoCandidatos(){
      String[] candidatos = {"Felipe", "Marcia","Julia", "Paulo"};

      int candidatosSelecionados = 0;
      int candidatoAtual = 0;
      double salarioBase = 2000.0;

      while(candidatosSelecionados < 5 && candidatoAtual < candidatos.length){
          String candidato = candidatos[candidatoAtual];
          double salarioPretendido = ValorPretendido();

          System.out.println("O candidato " + candidato + " Solicitou este valor de sálario " + salarioPretendido);

          if (salarioBase >= salarioPretendido){
              System.out.println("O candidato " + candidato + " foi selecionado para a vaga");
              candidatosSelecionados++;
          }
          candidatoAtual++;
      }
    }

    static double ValorPretendido(){
        return ThreadLocalRandom.current().nextDouble(1800,2200);
    }

    static void analisarCanditdato(double salarioPretendido){
        double salarioBase = 2000.0;

        if(salarioBase > salarioPretendido){
            System.out.println("Ligar para o condidato");
        }
        else if (salarioBase == salarioPretendido){
            System.out.println("Aguardando contra proposta");
        }

        else{
            System.out.println("Aguardando resultado dos demais candidatos");
        }
    }
}
