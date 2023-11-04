package util;

import Controllers.ProdutoController;
import Controllers.VendaController;
import Models.ProdutoModel;
import Models.VendaModel;
import Produto.Produto;
import Views.ProdutoView;
import Views.VendaView;

public class Principal {

	public static void main(String[] args) {
		ProdutoModel PM = new ProdutoModel();
		ProdutoView PV = new ProdutoView();
		ProdutoController PC = new ProdutoController(PM, PV);
		
		VendaModel VM = new VendaModel();
		VendaView VV = new VendaView();
		VendaController VC = new VendaController(VM, VV);
		
		//Inserir dois produtos.
		PC.inserirProduto(new Produto(1, "Jaca", 8.00, 10));
		PC.inserirProduto(new Produto(1, "Melancia", 15.00, 9));
		
		//Realizar uma venda de cada produto.
		VC.cadastrarVenda(4, 8);
		VC.cadastrarVenda(6, 9);
		
		//Listar os produtos.
		PC.listarProdutos();
		
		//Cancelar a venda de um dos produtos.
		VC.excluirVenda(4);
		
		//Listar novamente os produtos.
		PC.listarProdutos();
		
		//Atualizar a quantidade de um dos produtos.
		PC.atualizarProduto("Melancia", 15.00, 15, 9);
		
		//Excluir o produto que não teve uma venda realizada.
		PC.excluirProduto(8);
		
		//Listar o produto restante.
		PC.listarProdutos();
		
	}

}
