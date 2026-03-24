package aula_03.Cliente;
import aula_03.Produtos.Produto;
import aula_03.Estoque.Estoque;
public class Cliente {

    private String nome;
    private String cpf;
    
    public Cliente(){
    }

    public Cliente(String nome, String cpf){
        this.cpf = cpf;
        this.nome = nome;
    }

    public void comprarProduto(Estoque estoque, String nomeProduto, int quantidade){
        Produto produto = estoque.buscarProduto(nomeProduto);
        if(produto == null) {
            System.out.println("Produto não encontrado.");
            return;
        } 
        if(produto.getQntdEmEstoque() < quantidade){
            System.out.println("Produto fora de estoque.");
            return;
        }

        produto.removerEstoque();
        System.out.println(nome + " comprou " + quantidade + " " + produto.getNome() + " e pagou " + produto.getPreco() + "R$");

    }

    public String getCpf(String cpf){
        return this.cpf = cpf;
    }
}
