package Produto;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import util.conexao;


public class ProdutoDAOImpl implements ProdutoDAO {
	public void inserir(Produto produto) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = DriverManager.getConnection(conexao.getJdbcURL(), conexao.getUser(), conexao.getPassword());        	
            String sql = "INSERT INTO produto (nome, preco, quantidade) VALUES (?, ?, ?)";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, produto.getNome());
            preparedStatement.setDouble(2, produto.getPreco());
            preparedStatement.setInt(3, produto.getQuantidade());
            preparedStatement.executeUpdate();
            System.out.println("Produto inserido com sucesso!");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
	
	public void buscarPorID(int idProduto) {
	    Connection connection = null;
	    PreparedStatement preparedStatement = null;
	    ResultSet resultSet = null;
	    try {
	        connection = DriverManager.getConnection(conexao.getJdbcURL(), conexao.getUser(), conexao.getPassword());
	        String sql = "SELECT * FROM produto WHERE id = ?";
	        preparedStatement = connection.prepareStatement(sql);
	        preparedStatement.setInt(1, idProduto);
	        resultSet = preparedStatement.executeQuery();
	        while (resultSet.next()) {
	            Integer id = resultSet.getInt("id");
	            String nome = resultSet.getString("nome");
	            Double preco = resultSet.getDouble("preco");
	            Integer quantidade = resultSet.getInt("quantidade");
	            System.out.println("Id: " + id + ", Nome: " + nome + ", Preço: R$" + preco + ", Quantidade: " + quantidade);
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    } finally {
	        try {
	            if (resultSet != null) {
	                resultSet.close();
	            }
	            if (preparedStatement != null) {
	                preparedStatement.close();
	            }
	            if (connection != null) {
	                connection.close();
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }
	}
	
	public List<Produto> buscarTodos() {
		List<Produto> produtos = new ArrayList<>();
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
        try {
        	connection = DriverManager.getConnection(conexao.getJdbcURL(), conexao.getUser(), conexao.getPassword());        	
            String sql = "SELECT * FROM produto";
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
            	Integer id = resultSet.getInt("id"); 
                String nome = resultSet.getString("nome");
                Double preco = resultSet.getDouble("preco"); 
                Integer quantidade = resultSet.getInt("quantidade");
                System.out.println("Id: " + id + ", Nome: " + nome + ", Preço: R$" + preco + ", Quantidade: " + quantidade);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
            	if(resultSet != null) {
            		resultSet.close();
				}
            	if(preparedStatement != null) {
					preparedStatement.close();
				}
				if(connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
        return produtos;
	}
	
	public void atualizar(String nome, double preco, int quantidade, int id) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = DriverManager.getConnection(conexao.getJdbcURL(), conexao.getUser(), conexao.getPassword());        	
            String sql = "UPDATE produto SET nome = ?, preco = ?, quantidade = ? WHERE id = ?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, nome);
            preparedStatement.setDouble(2, preco);
            preparedStatement.setInt(3, quantidade);
            preparedStatement.setInt(4, id);
            preparedStatement.executeUpdate();
            System.out.println("Produto atualizado com sucesso!");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
	
	public void excluir(int idProduto) {
    	Connection connection = null;
		PreparedStatement preparedStatement = null;
        try {
        	connection = DriverManager.getConnection(conexao.getJdbcURL(), conexao.getUser(), conexao.getPassword());        	
            String sql = "DELETE FROM produto WHERE id = ?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, idProduto);
            preparedStatement.executeUpdate();
            System.out.println("Produto de id " + idProduto + " excluido com sucesso!");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
            	if(preparedStatement != null) {
					preparedStatement.close();
				}
				if(connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
    }

}
