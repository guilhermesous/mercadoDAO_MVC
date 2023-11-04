package Venda;

public class Venda {
	private int id;
    private String dataVenda;
    private int quantidade;
    private int idProduto;

    public Venda(int id, String dataVenda, int quantidade, int idProduto) {
        this.id = id;
        this.dataVenda = dataVenda;
        this.quantidade = quantidade;
        this.idProduto = idProduto;
    }

    // Getters
    public int getId() {
        return id;
    }

    public String getDataVenda() {
        return dataVenda;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public int getIdProduto() {
        return idProduto;
    }
}