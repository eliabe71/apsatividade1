package com.aps;
public class RevendaComArray{
    private Produto[] produtos;
    private int indice; //proxima posição livre do vetor de produtosc
    public RevendaComArray(int tamanho){
        this.produtos = new Produto[tamanho];
    }
    public Produto getProduto(int cod){
        for(int i= 0; i <indice ; i++){
            if(this.produtos[i].getCodProduto() == cod){
                return this.produtos[i];
            }
        }
        Produto novo = new Produto(-1);
        return novo;
    }
    public void atualizaProduto(Produto p){
        for(int i=0; i< indice ; i++){
            if(this.produtos[i].getCodProduto() == p.getCodProduto() ){
                this.produtos[i]= p;
                break;
            }
        }
    }
    public void inserirProduto(Produto p){
        if(indice < this.produtos.length ) {
            this.produtos[indice] = p;
            indice++;
        }
    }
    public void comprar(int cod , int qtd){
        for(int i= 0; i <indice ; i++){
            if(this.produtos[i].getCodProduto() == cod){
                this.produtos[i].compra(qtd);
                System.out.println("Produto Comprado Com Sucesso");
                return;
            }
            System.out.println("Err");
        }
    }
    public void vender(int cod , int qtd){
        for(int i= 0; i <indice ; i++){
            if(this.produtos[i].getCodProduto() == cod){
                this.produtos[i].venda(qtd);
                System.out.println("Produto Vendido Com Sucesso");
                return;
            }
            System.out.println("Err");
        }
    }
    public void consultarPreco(int cod){
        for(int i= 0; i <indice ; i++){
            if(this.produtos[i].getCodProduto() == cod){
                System.out.println("preço : "+this.produtos[i].calculaPrecoVenda());
                return;
            }
            System.out.println("Err");
        }
    }
    public void listarPrecos(){
        for(int i= 0; i <indice ; i++) {
            System.out.println("Codigo :  "+ this.produtos[i].getCodProduto());
            System.out.println(" Descricao: " + this.produtos[i].getDescricao());
            System.out.println(" Valor: "+ this.produtos[i].calculaPrecoVenda() +" R$");
        }
    }
}
