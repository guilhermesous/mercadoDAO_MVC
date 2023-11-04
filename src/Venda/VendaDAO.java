package Venda;

public interface VendaDAO {
	void Cadastrar(int quantidade, int idProduto);
	
	void Cancelar(int id);
}
