package Views;
import java.util.List;
import Produto.Produto;

public class ProdutoView {
	public void imprimirProdutos(List<Produto> produtos) {
		System.out.println("-----LISTA DE PRODUTOS-----");
		for (Produto produto : produtos) {
			System.out.println(produto.toString());
		}
		System.out.println("-----------------------------");
	}
	
	
	public void exibirMensagem(String mensagem) {
        System.out.println(mensagem);
    }
}