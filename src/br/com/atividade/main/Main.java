package br.com.atividade.main;

import br.com.atividade.modelo.CartaoCredito;
import br.com.atividade.modelo.Produto;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.printf("Digite o limite do cartão de credito:\n");
        double limite = scanner.nextDouble();
        scanner.nextLine();

        var cartao = new CartaoCredito(limite);

        int resposta = 1;

        while (resposta != 0) {
            System.out.printf("digite a descricao da compra: \n");
            String nome = scanner.nextLine();

            System.out.printf("digite o valor da compra: \n");
            double valor = scanner.nextDouble();

            var produto = new Produto(nome, valor);
            if (cartao.passarCartao(produto)) {
                System.out.printf("""
                        \nQuer adicionar fazer mais alguma compra?
                        (qualquer numero) - sim
                        0 - ir para o checklist
                        """);
                resposta = scanner.nextInt();
                scanner.nextLine();
            } else {
                break;
            }
        }
        cartao.getExtrato().sort(Comparator.comparing(Produto::getPreco).reversed());
        cartao.getCheckList();



    }
}

