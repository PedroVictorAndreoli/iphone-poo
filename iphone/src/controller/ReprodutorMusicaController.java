package controller;

import entity.Musica;
import interfaces.ReprodutorMusica;

import java.util.Timer;
import java.util.TimerTask;

public class ReprodutorMusicaController extends Thread implements ReprodutorMusica {
    private Musica musica;
    private boolean pausado = false;

    @Override
    public synchronized void tocar() {
        if (this.pausado) {
            this.pausado = false;
            notify();
            System.out.println(musica.getNome() + " retomada");
        }else
            System.out.println("musica ja esta tocando");
    }

    @Override
    public synchronized void pausar() {
        if (!this.pausado) {
            this.pausado = true;
            System.out.println(musica.getNome() + " pausada");
        }else
            System.out.println("musica ja esta pausada");
    }

    @Override
    public void selecionarMusica(Musica musica) {
        this.musica = musica;
        this.pausado = false;
        System.out.println("Música " + musica.getNome() + " começou");
        start();
    }

    public Musica gerarMusica(String titulo) {
        Double numeroAleatorio = Math.random() * 13;
        selecionarMusica(new Musica(titulo, numeroAleatorio));
        return new Musica(titulo, numeroAleatorio);
    }

    public void parar() {
        if (isAlive()) {
            interrupt();
            try {
                join(); // Espera até que a thread atual termine
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void run() {
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                if (!pausado) {
                    System.out.println("Música " + musica.getNome() + " terminou");
                    timer.cancel();
                    interrupt();
                }
            }
        }, (long) (musica.getMinutos() * 60 * 1000), 1);

        try {
            while (!Thread.currentThread().isInterrupted()) {
                synchronized (this) {
                    while (pausado) {
                        wait();
                    }
                }
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            System.out.println(e);
        }
    }
}
