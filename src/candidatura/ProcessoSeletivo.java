package candidatura;
import javax.swing.*;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class ProcessoSeletivo {

    public static void main (String[] args){
        String[] candidatos = {"Felipe", "Marcia","Julia", "Paulo"};
        for(String candidato: candidatos){
            entrandoEmContato(candidato);
        }
    }

    static void entrandoEmContato(String candidato){
        int tentativasRealizadas = 1;
        boolean continuarTentando = true;
        boolean atendeu=false;
        do {
            atendeu=atender();
            continuarTentando = !atendeu;
            if(continuarTentando){
                tentativasRealizadas++;
            } else{
                System.out.println("Contato realizado com sucesso");
            }
        }
        while(continuarTentando && tentativasRealizadas < 3);{
            if(atendeu){
                System.out.println("Conseguimos contato com " + candidato + " na " + tentativasRealizadas + " tentativas");
                System.out.println("Não conseguimos contato com " + candidato + ", número máximo de tentativas " + tentativasRealizadas + " realizadas");
            }
        }
    }

    // métado auxiliar

    static boolean atender (){
        return new Random().nextInt(3) ==1;
    }

    static void imprimirSelecionados(){
        String[] candidatos = {"Felipe", "Marcia","Julia", "Paulo"};

        System.out.println("Imprimindo a lista de candidatos informando o indice do elemento");
        for (int indice=0; indice < candidatos.length; indice++){
            System.out.println("O candidato de n " + indice + " é o " + candidatos[indice]);
        }

        for (String candidato : candidatos){
            System.out.println("O Candidato selecionado foi " + candidato);
        }
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
