package Models;
import Produto.ProdutoDAO;
import Produto.ProdutoDAOImpl;
import java.util.List;
import Produto.Produto;

public class ProdutoModel {
	private ProdutoDAO produtodao;
	
	public ProdutoModel() {
		produtodao = new ProdutoDAOImpl();
	}
	
	public void inserirProduto(Produto produto) {
		produtodao.inserir(produto);
	}
	
	public void buscarProdutoID(int id) {
		produtodao.buscarPorID(id);
	}
	
	public List<Produto> buscarTodosProdutos() {
		return produtodao.buscarTodos();
	}
	
	public void atualizarProduto(String nome, double preco, int quantidade, int id) {
		produtodao.atualizar(nome, preco, quantidade, id);
	}
	
	public void excluirProduto(int idProduto) {
		produtodao.excluir(idProduto);
	}
}
