package com.aps;
public class Produto {

    private int codProduto;
    private String descricao;
    private double valorCompra;
    private double custo;
    private double margemLucro;
    private int estoque;

    public Produto (){}
    public Produto(int codProduto ){
        this.codProduto = codProduto;
    }
    public Produto(int codProduto , String descricao){
        this.codProduto = codProduto;
        this.descricao = descricao;
    }

    public Produto(int codProduto , String descricao, double valorCompra, double custo,double margemLucro){
        this.codProduto = codProduto;
        this.descricao = descricao;
        setValorCompra(valorCompra);
        setCusto(custo);
        setMargemDeLucro(margemLucro);
    }


    public Produto(int codProduto , String descricao, double valorCompra, double custo,double margemLucro,int estoque){
        this.codProduto = codProduto;
        this.descricao = descricao;
        setValorCompra(valorCompra);
        setCusto(custo);
        setMargemDeLucro(margemLucro);
        this.estoque = estoque;
    }

    public void venda(int quant){
        if( quant > estoque) {
            System.out.println("Quantidade Não disponivel no estoque");
        }
        estoque -= quant;
    }
    public void compra(int quant){
        estoque += quant;
    }
    public double calculaPrecoVenda( ){
        return valorCompra+custo+(margemLucro *(valorCompra+custo));
    }

    public double getValorCompra(){
        return valorCompra;
    }

    public double getCusto(){
        return custo;
    }
    public int getCodProduto(){
        return codProduto;
    }

    public String getDescricao(){
        return descricao ;
    }

    public double getMargemLucro(){
        return margemLucro;
    }

    public void setValorCompra(double valorCompra){
        this.valorCompra = valorCompra;
    }

    public void setCusto(double custo){
        this.custo = custo;
    }

    public void setMargemDeLucro(double margemLucro){
        this.margemLucro = margemLucro;
    }
}
