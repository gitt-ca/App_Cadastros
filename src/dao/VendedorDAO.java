package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import connection.ConnectionFactory;
import model.Vendedor;

public class VendedorDAO  implements DAO<Vendedor> {

	private Connection socket = null;
	private PreparedStatement stmt;
	
	public VendedorDAO() {
		
		socket = ConnectionFactory.getConnection();
	}
	
	@Override
	public Optional<Vendedor> getbyID(int id) {
		// TODO Auto-generated method stub
		Vendedor vendor = new Vendedor();
		
		
		try {
			
			String sql = "select * vendedor where id="+id;
			
			PreparedStatement stmt = this.socket.prepareStatement(sql);
			
			ResultSet rs = stmt.executeQuery();
			
			if(rs.next()){
				
				vendor.setId(rs.getInt("id"));
				vendor.setNome(rs.getString("nome"));
				//colocar os outros metodos de set
				
			}
			
			
		}catch (SQLException ex){
		
			System.err.println("Erro"+ex);
			return Optional.empty();
			
		} finally {
			ConnectionFactory.closeConnection(socket, stmt);
		}
		return Optional.ofNullable(vendor);
	}
	
	
	@Override
	public List<Vendedor> selectALL() {
		// TODO Auto-generated method stub
		try {
			
			List<Vendedor> vendedores =  new ArrayList<Vendedor>();
			
			String sql = "select * from vendedor";
			
			PreparedStatement stmt = this.socket.prepareStatement(sql);
			
			ResultSet rs = stmt.executeQuery();
			
			while (rs.next()) {
				Vendedor vendor = new Vendedor();
				
				vendor.setId(rs.getInt("id"));
				vendor.setNome(rs.getString("nome"));

				//colocar os outros metodos de set
				
				vendedores.add(vendor);
		
				
			}
				return vendedores;
			
			
		}catch (SQLException ex){
		
			System.err.println("Erro"+ex);
			//return Optional.empty();
			
		} finally {
			ConnectionFactory.closeConnection(socket, stmt);
		}
		return null;
	}

	@Override
	public boolean save(Vendedor t) {
		// TODO Auto-generated method stub
		String sql = "INSERT INTO vendedor(nome,sobrenome,habilitado) VALUES (?,?,?)";
		
		PreparedStatement stmt = null;
				
		try {
			
			stmt = socket.prepareStatement(sql);
			stmt.setString(1,"Joao");
			stmt.setString(2,"Czar");
			stmt.setBoolean(3, false);
			
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
	public boolean updatebyID(Vendedor t) {
		// TODO Auto-generated method stub
		String sql = "UPDATE vendedor SET habilitado=? where id=?";
		
		PreparedStatement stmt = null;
		
		
		try {
			
			stmt = socket.prepareStatement(sql);
			stmt.setBoolean(1,false);
			stmt.setInt(2, 2);
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
	public boolean deletebyID(Vendedor t) {
		// TODO Auto-generated method stub
		String sql = "DELETE FROM vendedor where id=?";
		
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