package Models;

import Venda.VendaDAO;
import Venda.VendaDAOImpl;

public class VendaModel {
	private VendaDAO vendaDAO;
	
	public VendaModel() {
		vendaDAO = new VendaDAOImpl();
	}
	
	public void CadastrarVenda(int quantidade, int idProduto) {
		vendaDAO.Cadastrar(quantidade, idProduto);
	}
	
	public void ExcluirVenda(int id) {
		vendaDAO.Cancelar(id);
	}
}
