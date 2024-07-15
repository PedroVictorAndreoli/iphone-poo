package controller;

import interfaces.Navegador;

import java.util.ArrayList;
import java.util.List;

public class NavegadorController implements Navegador {
    List<String> paginas = new ArrayList<String>();
    int pagina = 0;
    @Override
    public void exibirPagina() {
        System.out.println(paginas.get(pagina));
    }

    @Override
    public void adcionarPagina(String url) {
        paginas.add(url);
        this.pagina++;
    }

    @Override
    public void atualizarPagina() {
        if (paginas.get(this.pagina) != null) {
        System.out.println("pagina "+pagina + " atualizada");
        }else
            System.out.println("nao ha pagina");
    }

    @Override
    public void mudarPagina(int id) {
        if (id> paginas.size()) {
        this.pagina = id;
        System.out.println("mudando pagina "+pagina);
        }else
            System.out.println("nao ha pagina");
    }
}
