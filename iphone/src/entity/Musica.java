package entity;

public class Musica {
    String nome;
    Double minutos;

    public Musica(String nome, Double minutos) {
        this.nome = nome;
        this.minutos = minutos;
    }


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Double getMinutos() {
        return minutos;
    }

    public void setMinutos(Double minutos) {
        this.minutos = minutos;
    }
}
