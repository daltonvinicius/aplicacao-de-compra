package br.com.atividade.modelo;

import java.util.ArrayList;
import java.util.List;

public class CartaoCredito {
    private  double limite;
    private double saldo;
    private List<Produto> extrato;
    private double gastoTotal;

    public double calcularGasto(){
        return gastoTotal = (limite - saldo);
    }

    public CartaoCredito(double limite){
        this.limite = limite;
        this.saldo = limite;
        this.extrato = new ArrayList<>();
    }

    public double getLimite() {
        return limite;
    }

    public double getSaldo() {
        return saldo;
    }

    public List<Produto> getExtrato() {
        return extrato;
    }

    public void adicionarProduto(Produto produto){
        this.extrato.add(produto);
    }

    public boolean passarCartao(Produto produto){
        if (produto.getPreco() < getSaldo()){
            this.saldo -= produto.getPreco();
            this.extrato.add(produto);
            System.out.printf("Compra de %s no valor de %.2f aprovada.\n",produto.getNome(),produto.getPreco());
            System.out.printf("Saldo atual do cartão: %.2f\n",this.getSaldo());
            return true;
        } else {
            System.out.printf("Saldo insuficiente para compra.\n");
            System.out.printf("Redirecionando para Checklist...\n");
            return false;
        }
    }

    public void getCheckList(){
        System.out.printf("""
                ******************************************
                           CheckList de compras
                ******************************************
                """);
        System.out.printf("O total de itens comprados foi: " + this.extrato.size() + "\n");
        for (Produto item : this.getExtrato() ) {
            System.out.println(item);
        }
        System.out.printf("\n");
        System.out.printf("O total a ser descontado na proxima fatura é de: " + this.calcularGasto() + "\n");
        System.out.printf("O limite disponível do cartão está em: %.2f\n", this.getSaldo());
        System.out.printf("******************************************");
    }
}
