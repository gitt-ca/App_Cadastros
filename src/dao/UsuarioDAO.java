package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import connection.ConnectionFactory;
import model.Usuario;

public class UsuarioDAO implements DAO<Usuario> {
	
	private Connection socket = null;
	private PreparedStatement stmt;
	
	public UsuarioDAO() {
		
		socket = ConnectionFactory.getConnection();
	}


	@Override
	public Optional<Usuario> getbyID(int id) {
		// TODO Auto-generated method stub
		Usuario user = new Usuario();
		
		
		try {
			
			String sql = "select * from usuario where id="+id;
			
			PreparedStatement stmt = this.socket.prepareStatement(sql);
			
			ResultSet rs = stmt.executeQuery();
			
			if(rs.next()){
				
				user.setId(rs.getInt("id"));
				user.setSenha(rs.getString("setSenha"));
				//colocar os outros metodos de set
				
			}
			
			
		}catch (SQLException ex){
		
			System.err.println("Erro"+ex);
			return Optional.empty();
			
		} finally {
			ConnectionFactory.closeConnection(socket, stmt);
		}
		return Optional.ofNullable(user);
	
	}
	
	@Override
	public List<Usuario> selectALL() {
		// TODO Auto-generated method stub
		try {
			
			List<Usuario> usuarios =  new ArrayList<Usuario>();
			
			String sql = "select * from usuario";
			
			PreparedStatement stmt = this.socket.prepareStatement(sql);
			
			ResultSet rs = stmt.executeQuery();
			
			while (rs.next()) {
				Usuario user = new Usuario();
				
				user.setId(rs.getInt("id"));
				user.setNome(rs.getString("nome"));
				//colocar os outros metodos de set
				
				
				usuarios.add(user);
		
				
			}
				return usuarios;
			
			
		}catch (SQLException ex){
		
			System.err.println("Erro"+ex);
			//return Optional.empty();
			
		} finally {
			ConnectionFactory.closeConnection(socket, stmt);
		}
		return null;
	}
	
	
	@Override
	public boolean save(Usuario t) {
		// TODO Auto-generated method stub
		String sql = "INSERT INTO usuario(nome,sobrenome,senha,habilitado) VALUES (?,?,?,?)";
		
		PreparedStatement stmt = null;
		
		
		try {
			
			stmt = socket.prepareStatement(sql);
			stmt.setString(1,"Caio");
			stmt.setString(2,"Giaretton");
			stmt.setString(3,"123");
			stmt.setBoolean(4, true);
			
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
	public boolean updatebyID(Usuario t) {
		// TODO Auto-generated method stub
		String sql = "UPDATE usuario SET nome=? where id=?";
		
		PreparedStatement stmt = null;
		
		
		try {
			
			stmt = socket.prepareStatement(sql);
			stmt.setString(1,"Joao");
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
	public boolean deletebyID(Usuario t) {
		// TODO Auto-generated method stub
		String sql = "DELETE FROM usuario where id=?";
		
		PreparedStatement stmt = null;
		
		
		try {
			
			stmt = socket.prepareStatement(sql);
			stmt.setInt(1,2);

			
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
