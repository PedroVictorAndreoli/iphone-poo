package interfaces;

public interface Navegador {
    void exibirPagina();
    void adcionarPagina(String url);
    void atualizarPagina();
    void mudarPagina(int id);
}
