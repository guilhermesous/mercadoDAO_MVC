package Venda;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import util.conexao;

public class VendaDAOImpl implements VendaDAO {
	public void Cadastrar(int quantidade, int idProduto) {
	    Connection connection = null;
	    PreparedStatement estoqueStatement = null;
	    PreparedStatement updateStatement = null;
	    PreparedStatement vendaStatement = null;
	    ResultSet resultSet = null;

	    try {
	        connection = DriverManager.getConnection(conexao.getJdbcURL(), conexao.getUser(), conexao.getPassword());
	        connection.setAutoCommit(false);

	        String estoqueSql = "SELECT quantidade FROM produto WHERE id = ?";
	        estoqueStatement = connection.prepareStatement(estoqueSql);
	        estoqueStatement.setInt(1, idProduto);
	        resultSet = estoqueStatement.executeQuery();

	        if (resultSet.next()) {
	            int quantidadeEmEstoque = resultSet.getInt("quantidade");
	            if (quantidadeEmEstoque >= quantidade) {
	                int novaQuantidadeEmEstoque = quantidadeEmEstoque - quantidade;
	                String updateEstoqueSql = "UPDATE produto SET quantidade = ? WHERE id = ?";
	                updateStatement = connection.prepareStatement(updateEstoqueSql);
	                updateStatement.setInt(1, novaQuantidadeEmEstoque);
	                updateStatement.setInt(2, idProduto);
	                updateStatement.executeUpdate();

	                String vendaSql = "INSERT INTO venda (dataVenda, quantidade, idProduto) VALUES (CURRENT_DATE(), ?, ?)";
	                vendaStatement = connection.prepareStatement(vendaSql);
	                vendaStatement.setInt(1, quantidade);
	                vendaStatement.setInt(2, idProduto);
	                vendaStatement.executeUpdate();

	                connection.commit();
	                System.out.println("Venda Efetuada com sucesso!");
	            } else {
	                System.out.println("Não há estoque suficiente para realizar a venda.");
	            }
	        } else {
	            System.out.println("Produto não encontrado.");
	        }
	    } catch (Exception e) {
	        if (connection != null) {
	            try {
	                connection.rollback();
	            } catch (SQLException rollbackException) {
	                rollbackException.printStackTrace();
	            }
	        }
	        e.printStackTrace();
	    } finally {
	        try {
	            if (resultSet != null) {
	                resultSet.close();
	            }
	            if (vendaStatement != null) {
	                vendaStatement.close();
	            }
	            if (updateStatement != null) {
	                updateStatement.close();
	            }
	            if (estoqueStatement != null) {
	                estoqueStatement.close();
	            }
	            if (connection != null) {
	                connection.close();
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }
	}
	
	public void Cancelar(int id) {
	    Connection connection = null;
	    PreparedStatement cancelarStatement = null;
	    PreparedStatement selecionarVendaStatement = null;
	    ResultSet resultadoVenda = null;

	    try {
	        connection = DriverManager.getConnection(conexao.getJdbcURL(), conexao.getUser(), conexao.getPassword());
	        
	        String selecionarVendaSql = "SELECT idProduto, quantidade FROM venda WHERE id = ?";
	        selecionarVendaStatement = connection.prepareStatement(selecionarVendaSql);
	        selecionarVendaStatement.setInt(1, id);
	        resultadoVenda = selecionarVendaStatement.executeQuery();

	        if (resultadoVenda.next()) {
	            int idProduto = resultadoVenda.getInt("idProduto");
	            int quantidadeVendida = resultadoVenda.getInt("quantidade");

	            String cancelarVendaSql = "DELETE FROM venda WHERE id = ?";
	            cancelarStatement = connection.prepareStatement(cancelarVendaSql);
	            cancelarStatement.setInt(1, id);
	            cancelarStatement.executeUpdate();

	            String atualizarEstoqueSql = "UPDATE produto SET quantidade = quantidade + ? WHERE id = ?";
	            PreparedStatement atualizarEstoqueStatement = connection.prepareStatement(atualizarEstoqueSql);
	            atualizarEstoqueStatement.setInt(1, quantidadeVendida);
	            atualizarEstoqueStatement.setInt(2, idProduto);
	            atualizarEstoqueStatement.executeUpdate();

	            System.out.println("Venda cancelada com sucesso.");
	        } else {
	            System.out.println("Venda não encontrada.");
	        }
	    } catch (Exception e) {
	        try {
	            if (connection != null) {
	                connection.rollback();
	            }
	        } catch (SQLException rollbackException) {
	            rollbackException.printStackTrace();
	        }
	        e.printStackTrace();
	    } finally {
	        try {
	            if (resultadoVenda != null) {
	                resultadoVenda.close();
	            }
	            if (selecionarVendaStatement != null) {
	                selecionarVendaStatement.close();
	            }
	            if (cancelarStatement != null) {
	                cancelarStatement.close();
	            }
	            if (connection != null) {
	                connection.close();
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }
	}
}
