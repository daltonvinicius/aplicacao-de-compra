package br.com.atividade.modelo;

public class Produto implements Comparable<Produto>{
    private String nome;
    private double preco;

    public String getNome() {
        return nome;
    }

    public double getPreco() {
        return preco;
    }

    public Produto(String nome, double preco) {
        this.nome = nome;
        this.preco = preco;
    }

    @Override
    public String toString() {
        return this.nome + " -- " + "R$ " + this.preco;
    }

    @Override
    public int compareTo(Produto o) {
        return Double.valueOf(this.getPreco()).compareTo(Double.valueOf(o.getPreco()));
    }
}


