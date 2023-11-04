package Controllers;

import java.util.List;

import Models.ProdutoModel;
import Produto.Produto;
import Views.ProdutoView;

public class ProdutoController {
	private ProdutoModel produtoModel;
    private ProdutoView produtoView;
    
    public ProdutoController(ProdutoModel produtoModel, ProdutoView produtoView) {
    	this.produtoModel = produtoModel;
    	this.produtoView = produtoView;
    }
    
    public void inserirProduto(Produto produto) {
    	produtoModel.inserirProduto(produto);
    	produtoView.exibirMensagem("Produto adicionado com sucesso!");
    }
    
    public void buscarProdutoID(int id) {
    	produtoModel.buscarProdutoID(id);
    }
    
    public void listarProdutos() {
    	List<Produto> produtos = produtoModel.buscarTodosProdutos();
    	if(produtos.isEmpty()) {
    		produtoView.exibirMensagem("Nenhum produto cadastrado.");
    	}else {
    		produtoView.imprimirProdutos(produtos);
    	}
    }
    
    public void atualizarProduto(String nome, double preco, int quantidade, int id) {
    	produtoModel.atualizarProduto(nome, preco, quantidade, id);
    	produtoView.exibirMensagem("Produto atualizado com sucesso.");
    }
    
    public void excluirProduto(int idProduto) {
    	produtoModel.excluirProduto(idProduto);
    	produtoView.exibirMensagem("Produto excluído.");
    }
}
