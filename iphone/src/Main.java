import controller.NavegadorController;
import controller.ReprodutorMusicaController;
import controller.TelefoneController;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Scanner sc = new Scanner(System.in);
        ReprodutorMusicaController reprodutorMusicaController = new ReprodutorMusicaController();
        TelefoneController telefoneController = new TelefoneController();
        NavegadorController navegadorController = new NavegadorController();
        int res = 1;
        System.out.println("Bem vindo ao iphone");
        while (res != 0) {
            System.out.println("Digite 1 para tocar uma musica" +
                    "\n" +
                    "Digite 2 para ligar para um numero" +
                    "\n" +
                    "Digite 3 para pausar uma musica" +
                    "\n" +
                    "Digite 4 para despausar uma musica" +
                    "\n" +
                    "Digite 5 para adcionar pagina" +
                    "\n"+
                    "Digite 6 para mudar pagina" +
                    "\n"+
                    "Digite 7 para atualizar pagina" +
                    "\n"+
                    "Digite 0 para desligar");
            res = sc.nextInt();
            sc.nextLine();
            switch (res) {
                case 1:
                    if (!reprodutorMusicaController.isAlive()) {
                        System.out.println("Digite o nome da musica");
                        String nomeMusica = sc.nextLine();
                        reprodutorMusicaController.gerarMusica(nomeMusica);
                    } else {
                        System.out.println("Música tocando no momento");
                    }
                    break;
                case 2:
                    System.out.println("Digite o telefone");
                    String numeroTelefone = sc.nextLine();
                    telefoneController.ligar(numeroTelefone);
                    break;
                case 3:
                    if (reprodutorMusicaController.isAlive()) {
                        reprodutorMusicaController.pausar();
                    } else {
                        System.out.println("Nenhuma música tocando no momento");
                    }
                    break;
                case 4:
                    if (reprodutorMusicaController.isAlive()) {
                        reprodutorMusicaController.tocar();
                    } else {
                        System.out.println("Nenhuma música tocando no momento");
                    }
                    break;
                case 5:
                    System.out.println("Digite a url de paginas");
                    String nome = sc.nextLine();
                    navegadorController.adcionarPagina(nome);
                case 6:
                    System.out.println("Digite o numero da pagina para mudar");
                    int numeroPagina = sc.nextInt();
                    navegadorController.mudarPagina(numeroPagina);
                case 7:
                    navegadorController.atualizarPagina();
                case 0:
                    System.out.println("Iphone desligou");
                    break;
                default:
                    System.out.println("Opção inválida");
                    break;
            }
        }
    }
}
