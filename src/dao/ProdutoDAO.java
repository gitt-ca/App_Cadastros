package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import connection.ConnectionFactory;
import model.Produto;

public class ProdutoDAO implements DAO<Produto> {
	
	private Connection socket = null;
	private PreparedStatement stmt;
	
	public ProdutoDAO() {
		
		socket = ConnectionFactory.getConnection();
	}

	
	@Override
	public Optional<Produto> getbyID(int id) {
		// TODO Auto-generated method stub
		
		Produto prod = new Produto();
		
		
		try {
			
			String sql = "select * from produto where id="+id;
			
			PreparedStatement stmt = this.socket.prepareStatement(sql);
			
			ResultSet rs = stmt.executeQuery();
			
			if(rs.next()){
				
				prod.setId(rs.getInt("id"));
				prod.setNome(rs.getString("nome"));
				//colocar os outros metodos de set
				
			}
			
			
		}catch (SQLException ex){
		
			System.err.println("Erro"+ex);
			return Optional.empty();
			
		} finally {
			ConnectionFactory.closeConnection(socket, stmt);
		}
		return Optional.ofNullable(prod);
	
	}
		


	@Override
	public List<Produto> selectALL() {
		// TODO Auto-generated method stub
		
		try {
			
			List<Produto> produtos =  new ArrayList<Produto>();
			
			String sql = "select * from produto";
			
			PreparedStatement stmt = this.socket.prepareStatement(sql);
			
			ResultSet rs = stmt.executeQuery();
			
			while (rs.next()) {
				Produto prod = new Produto();
				
				prod.setId(rs.getInt("id"));
				prod.setNome(rs.getString("nome"));
				prod.setQtde_estoque(rs.getInt("qtde_estoque"));
				prod.setValor_unitario(rs.getInt("qtde_estoque"));
				//colocar os outros metodos de set
				
				produtos.add(prod);
		
				
			}
				return produtos;
			
			
		}catch (SQLException ex){
		
			System.err.println("Erro"+ex);
			//return Optional.empty();
			
		} finally {
			ConnectionFactory.closeConnection(socket, stmt);
		}
		return null;
	
	}


	@Override
	public boolean save(Produto t) {
		// TODO Auto-generated method stub
		
		String sql = "INSERT INTO produto(nome,qtde_estoque,valor_unitario) VALUES (?,?,?)";
		
		PreparedStatement stmt = null;
				
		try {
			
			stmt = socket.prepareStatement(sql);
			stmt.setString(1,"Caio");
			stmt.setInt(2, 10);
			stmt.setDouble(3, 235);
			
			stmt.executeUpdate();
				
			
			return true;
			
		}catch (SQLException ex){
		
			System.err.println("Erro"+ex);
			return false;
			
		} finally {
			ConnectionFactory.closeConnection(socket, stmt);
		}
	}

	@Override
	public boolean updatebyID(Produto t) {
		// TODO Auto-generated method stub
		
		String sql = "UPDATE produto SET qtde_estoque=? where id=?";
		
		PreparedStatement stmt = null;
		
		
		try {
			
			stmt = socket.prepareStatement(sql);
			stmt.setInt(1,2);
			stmt.setInt(2, 8);
			//adcionar outros campos do update
			
			stmt.executeUpdate();
				
			
			return true;
			
		}catch (SQLException ex){
		
			System.err.println("Erro"+ex);
			return false;
			
		} finally {
			ConnectionFactory.closeConnection(socket, stmt);
		}
	}
		

	@Override
	public boolean deletebyID(Produto t) {
		// TODO Auto-generated method stub
		String sql = "DELETE FROM produto where id=?";
		
		PreparedStatement stmt = null;
		
		
		try {
			
			stmt = socket.prepareStatement(sql);
			stmt.setInt(1,10);

			
			stmt.executeUpdate();
				
			
			return true;
			
		}catch (SQLException ex){
		
			System.err.println("Erro"+ex);
			return false;
			
		} finally {
			ConnectionFactory.closeConnection(socket, stmt);
		}
	
	}
	
}