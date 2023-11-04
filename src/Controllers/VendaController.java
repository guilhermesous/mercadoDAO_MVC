package Controllers;

import Models.VendaModel;
import Views.VendaView;

public class VendaController {
	private VendaModel vendaModel;
	private VendaView vendaView;

	public VendaController(VendaModel vendaModel, VendaView vendaView) {
	    this.vendaModel = vendaModel;
	    this.vendaView = vendaView;
	}

	public void cadastrarVenda(int quantidade, int idProduto) {
		vendaModel.CadastrarVenda(quantidade, idProduto);
		vendaView.exibirMensagem("Venda registrada!");
	}
	
	public void excluirVenda (int id) {
		vendaModel.ExcluirVenda(id);
		vendaView.exibirMensagem("Venda apagada.");
	}
}
