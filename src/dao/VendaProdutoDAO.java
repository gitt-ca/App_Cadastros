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
import model.VendaProduto;

public class VendaProdutoDAO implements DAO<VendaProduto>{

	private Connection socket = null;
	private PreparedStatement stmt;
	
	@Override
	public Optional<VendaProduto> getbyID(int id) {
		// TODO Auto-generated method stub
		VendaProduto vp = new VendaProduto();
		
		
		try {
			
			String sql = "select * from venda_produto where id="+id;
			
			PreparedStatement stmt = this.socket.prepareStatement(sql);
			
			ResultSet rs = stmt.executeQuery();
			
			if(rs.next()){
				
				vp.setId(rs.getInt("id"));
				vp.setId_venda(rs.getInt("id_venda"));
				//colocar os outros metodos de set
				
			}
			
			
		}catch (SQLException ex){
		
			System.err.println("Erro"+ex);
			return Optional.empty();
			
		} finally {
			ConnectionFactory.closeConnection(socket, stmt);
		}
		return Optional.ofNullable(vp);
	}
	
	@Override
	public List<VendaProduto> selectALL() {
		// TODO Auto-generated method stub
		try {
			
			List<VendaProduto> vprodutos =  new ArrayList<VendaProduto>();
			
			String sql = "select * from venda_produto";
			
			PreparedStatement stmt = this.socket.prepareStatement(sql);
			
			ResultSet rs = stmt.executeQuery();
			
			while (rs.next()) {
				VendaProduto vp = new VendaProduto();
				
				vp.setId(rs.getInt("id"));
				vp.setId_venda(rs.getInt("id_venda"));
		
				//colocar os outros metodos de set
				
				vprodutos.add(vp);
		
				
			}
				return vprodutos;
			
			
		}catch (SQLException ex){
		
			System.err.println("Erro"+ex);
			//return Optional.empty();
			
		} finally {
			ConnectionFactory.closeConnection(socket, stmt);
		}
		return null;
	}

	@Override
	public boolean save(VendaProduto t) {
		// TODO Auto-generated method stub
		String sql = "INSERT INTO venda_produto(qtde,valor_unitario,valor_total_produto,id_venda,id_produto) VALUES (?,?,?,?,?";
		
		PreparedStatement stmt = null;
				
		try {
			
			stmt = socket.prepareStatement(sql);
			stmt.setInt(1,2);
			stmt.setInt(2, 10);
			stmt.setDouble(3, 20);
			stmt.setInt(4, 1);
			stmt.setInt(5, 15);
			
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
	public boolean updatebyID(VendaProduto t) {
		// TODO Auto-generated method stub
		String sql = "UPDATE venda_produto SET qtde=? where id=?";
		
		PreparedStatement stmt = null;
		
		
		try {
			
			stmt = socket.prepareStatement(sql);
			stmt.setInt(1,12);
			stmt.setInt(2, 1);
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
	public boolean deletebyID(VendaProduto t) {
		// TODO Auto-generated method stub
		String sql = "DELETE FROM venda_produto where id=?";
		
		PreparedStatement stmt = null;
		
		
		try {
			
			stmt = socket.prepareStatement(sql);
			stmt.setInt(1,1);

			
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