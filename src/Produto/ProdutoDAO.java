package Produto;
import java.util.List;

public interface ProdutoDAO {
	void inserir(Produto produto);
	
	void buscarPorID(int id);
	
	List<Produto> buscarTodos();
	
	void atualizar(String nome, double preco, int quantidade, int id);
	
	void excluir(int idProduto);
}
