package aula_03.Produtos;

public class Produto {

    private String nome;
    private double preco;
    private int qntdEmEstoque;

    public Produto(){
    }

    public Produto(String nome, double preco, int qntdEmEstoque){
        this.nome = nome;
        this.preco = preco;
        this.qntdEmEstoque = qntdEmEstoque;
    }

    public Produto(String nome){
        this.nome = nome;
    }

    public Produto(double preco){
        this.preco = preco;
    }

    public Produto(int qntdEmEstoque){
        this.qntdEmEstoque = qntdEmEstoque;
    }

    public String getNome(){
        return nome;
    }
    public double getPreco(){
        return preco;
    }
    public int getQntdEmEstoque(){
        return qntdEmEstoque;
    }

    public void removerEstoque(){
        this.qntdEmEstoque -= qntdEmEstoque;
    }
    
}
