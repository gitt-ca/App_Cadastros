package dao;

import java.util.List;
import java.util.Optional;

import model.Produto;


public interface DAO<T> {


	Optional<T> getbyID(int id);
	
	
	List<T> selectALL();
	
	boolean save(T t);
	
	boolean updatebyID(T t);

	
	boolean deletebyID(T t);


}
