package com.aps;
import java.util.Scanner;
import java.io.IOException;
public class Main {
    public static void clear() throws IOException {
        if (System.getProperty("os.name").contains("Windows")) {
            try {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } catch (InterruptedException | IOException e) {
                e.printStackTrace();
            }
        }
        else {
            Runtime.getRuntime().exec("clear");
        }
    }
    public static void main(String[] args) throws IOException {
        Scanner ler = new Scanner(System.in);
        System.out.println("Quantos Produtos Tera Sua Revenda  ?");
        int n;
        int numeroDeProdutos = ler.nextInt();
        clear();
        RevendaComArray r= new RevendaComArray(numeroDeProdutos);
        //Limpa a tela no windows, no linux e no MacOS
        while(true){
            System.out.println("Para Operacao        Digite");
            System.out.println("Para Criar Produto     [1]");
            System.out.println("Para Comprar Produto   [2]");
            System.out.println("Para Vender Produto    [3]");
            System.out.println("Para Consultar Preco   [4]");
            System.out.println("Para Lista Preco       [5]");
            System.out.println("Para Alterar Atributos [6]");
            System.out.println("Para Sair              [7]");
            n = ler.nextInt();
            clear();
            if(n ==1){
                if(numeroDeProdutos ==0){
                    System.out.println("Todos os Produtos Ja Cadrastados");
                    continue;
                }
                clear();
                System.out.println("Digite o Codigo do Produto ");
                int codigo;
                codigo = ler.nextInt();
                ler.nextLine();
                System.out.println("Digite a Descricao do Produto ");
                String descricao;
                 descricao = ler.nextLine();
                System.out.println("Digite o Valor de Compra do Produto ");
                double valorCompra;
                valorCompra = ler.nextDouble();
                System.out.println("Digite o Valor de Custo do Produto ");
                double custo;
                custo = ler.nextDouble();
                System.out.println("Digite o Valor da Margem de Lucro do Produto ");
                double margemLucro;
                margemLucro = ler.nextDouble();
                System.out.println("Digite o Valor do Estoque do Produto ");
                int estoque;
                estoque = ler.nextInt();
                Produto p = new Produto(codigo, descricao, valorCompra, custo, margemLucro, estoque);
                r.inserirProduto(p);
                clear();
                System.out.println("Produto cadrastado com Sucesso");
                //r.inserirProduto(p);
            }
            else if(n ==2){
                System.out.println("Digite o Codigo do Produto ");
                int codigo;
                codigo = ler.nextInt();
                ler.nextLine();
                System.out.println("Digite a Quantidade Comprada do Produto ");
                int qntd;
                qntd = ler.nextInt();
                clear();
                r.comprar(codigo, qntd);
            }
            else if(n ==3){
                System.out.println("Digite o Codigo do Produto ");
                int codigo;
                codigo = ler.nextInt();
                ler.nextLine();
                System.out.println("Digite a Quantidade A Ser Vendida do Produto ");
                int qntd;
                qntd = ler.nextInt();
                clear();
                r.vender(codigo, qntd);
            }
            else if(n ==4){
                System.out.println("Digite o Codigo do Produto ");
                int codigo;
                codigo = ler.nextInt();
                clear();
                r.consultarPreco(codigo);
            }
            else if(n ==5){
                r.listarPrecos();
            }
            else if(n ==6){
                System.out.println("Digite o Codigo do Produto ");
                int codigo;
                codigo = ler.nextInt();
                Produto p = r.getProduto(codigo);
                clear();
                if (p.getCodProduto() == codigo) {
                    while(true){
                        System.out.println("Para Operacao                 Digite");
                        System.out.println("Alterar Valor de Compra          [1]");
                        System.out.println("Alterar Valor de Custo           [2]");
                        System.out.println("Alterar Valor de Margem de Lucro [3]");
                        int nn;
                        nn = ler.nextInt();
                        if(nn==1){
                            System.out.println("Digite o Novo Valor de Compra do Produto");
                            double valorDeCompra;
                            valorDeCompra = ler.nextDouble();
                            p.setValorCompra(valorDeCompra);
                            r.atualizaProduto(p);
                        }
                        else if(nn==2){
                            System.out.println("Digite o Novo Valor de Custo do Produto");
                            double valorDecusto;
                            valorDecusto = ler.nextDouble();
                            p.setCusto(valorDecusto);
                            r.atualizaProduto(p);
                        }
                        else if(nn==3){
                            System.out.println("Digite o Novo Valor de Margem de Lucro do Produto");
                            double margemlucro;
                            margemlucro = ler.nextDouble();
                            p.setCusto(margemlucro);
                            r.atualizaProduto(p);
                        }
                        else {
                            clear();
                        }
                        System.out.println("Deseja Alterar algo Mais Digite [1]Sim [Qualquer Numero] Não ");
                        int cont = ler.nextInt();
                        if(cont ==1) {
                            clear();
                            continue;
                        }
                        clear();
                        break;
                    }
                }
                System.out.println("Produto  Inexistente");
            }
            else if(n ==7){break;}
            else{
                clear();
            }
        }

    }
}
