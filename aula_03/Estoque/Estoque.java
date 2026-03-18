package aula_03.Estoque;
import java.util.List;
import java.util.ArrayList;
import aula_03.Produtos.Produto;

public class Estoque {

    private int qntdEmEstoque;
    private List<Produto> produtos;

    public Estoque(){
        produtos = new ArrayList<>();
    }

    public int getQntdEmEstoque(){
        return qntdEmEstoque;
    }

    public void adicionarProduto(String nome, double preco, int qntdEmEstoque){
        Produto novoProduto = new Produto(nome, preco, qntdEmEstoque);
        produtos.add(novoProduto);
    }

    public Produto buscarProduto(String nome){
        for (Produto produto : produtos) {
            if(produto.getNome().equalsIgnoreCase(nome)){
            return produto;
            }
        } return null;
    }
        
}
