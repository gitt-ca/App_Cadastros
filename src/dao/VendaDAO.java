package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import connection.ConnectionFactory;
import model.Venda;

public class VendaDAO  implements DAO<Venda>{

	private Connection socket = null;
	private PreparedStatement stmt;
	
	public VendaDAO() {
		
		socket = ConnectionFactory.getConnection();
	}
	
	@Override
	public Optional<Venda> getbyID(int id) {
		// TODO Auto-generated method stub
		
		Venda vend = new Venda();
		
		
		try {
			
			String sql = "select * from venda where id="+id;
			
			PreparedStatement stmt = this.socket.prepareStatement(sql);
			
			ResultSet rs = stmt.executeQuery();
			
			if(rs.next()){
				
				vend.setId(rs.getInt("id"));
				vend.setQtde(rs.getInt("qtde"));
				//colocar os outros metodos de set
				
			}
			
			
		}catch (SQLException ex){
		
			System.err.println("Erro"+ex);
			return Optional.empty();
			
		} finally {
			ConnectionFactory.closeConnection(socket, stmt);
		}
		return Optional.ofNullable(vend);
	
	}
	
	
	@Override
	public List<Venda> selectALL() {
		// TODO Auto-generated method stub

		try {
			
			List<Venda> vendas=  new ArrayList<Venda>();
			
			String sql = "select * from venda";
			
			PreparedStatement stmt = this.socket.prepareStatement(sql);
			
			ResultSet rs = stmt.executeQuery();
			
			while (rs.next()) {
				Venda vend = new Venda();
				
				vend.setId(rs.getInt("id"));
				vend.setQtde(rs.getInt("qtde"));
				vend.setData(rs.getDate("data_venda"));
				vend.setValor_total(rs.getDouble("valor_total"));
				//colocar os outros metodos de set
				
				vendas.add(vend);
		
				
			}
				return vendas;
			
			
		}catch (SQLException ex){
		
			System.err.println("Erro"+ex);
			//return Optional.empty();
			
		} finally {
			ConnectionFactory.closeConnection(socket, stmt);
		}
		return null;
	}

	@Override
	public boolean save(Venda t) {
		// TODO Auto-generated method stub
		
		String sql = "INSERT INTO venda(qtde,valor_total) VALUES (?,?)";
		
		PreparedStatement stmt = null;
		
		try {
			
			stmt = socket.prepareStatement(sql);
			stmt.setInt(1,2);
			stmt.setInt(2, 10);
	
			
			stmt.executeUpdate();
				
			
			return true;
			
		} catch (SQLException ex) {
			
			System.err.println("Erro"+ex);
			return false;
			
		} finally {
			ConnectionFactory.closeConnection(socket, stmt);
			
		}		
	}

	@Override
	public boolean updatebyID(Venda t) {
		// TODO Auto-generated method stub

		String sql = "update venda set qtde=? where id=?";
		
		PreparedStatement stmt = null;
				
		try {
			
			stmt = socket.prepareStatement(sql);
			stmt.setInt(1,26);
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
	public boolean deletebyID(Venda t) {
		// TODO Auto-generated method stub
		String sql = "DELETE FROM venda where id=?";
		
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