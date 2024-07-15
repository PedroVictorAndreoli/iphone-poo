package interfaces;

import entity.Musica;

public interface ReprodutorMusica {
    void tocar();
    void pausar() throws InterruptedException;
    void selecionarMusica(Musica musica);
}
