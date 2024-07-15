package controller;

import interfaces.Telefone;

import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

public class TelefoneController extends Thread implements Telefone {
    public TelefoneController(){
        start();
    }
    @Override
    public void ligar(String telefone) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ligando: " + telefone);
        int numeroAleatorio = (int) (Math.random() * 2);
        if (numeroAleatorio == 1) {
            System.out.println("ligacao atendida");
        }
        else {
            System.out.println("ligacao nao atendida");
            System.out.println("1 para realizar um correio de voz");
            int res = scanner.nextInt();
            if (res == 1) {
                iniciarCorreioDeVoz();
            }
        }

    }

    @Override
    public void atender() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Você recebeu uma ligação para atender. Digite 1 para atender:");
        int input = scanner.nextInt();
        if (input == 1){
            System.out.println("Ligação atendida com sucesso.");
        } else {
            System.out.println("Ligação recusada com sucesso.");
        }
    }

    @Override
    public void iniciarCorreioDeVoz() {
        System.out.println("Correio de Voz realizado com sucesso.");
    }

    public void run() {
        Timer timer = new Timer();
        final boolean[] timerEmExecucao = {false};
        while (true) {
            if (!timerEmExecucao[0]) {
                long numeroAleatorio = (long) (Math.random() * 6) * 1000000000;
                timer.schedule(new TimerTask() {
                    public void run() {
                        atender();
                        timerEmExecucao[0] = false;
                    }
                }, numeroAleatorio);

                timerEmExecucao[0] = true;
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    public void parar() {
        if (isAlive()) {
            interrupt();
            try {
                join(); // Espera até que o thread atual termine
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
