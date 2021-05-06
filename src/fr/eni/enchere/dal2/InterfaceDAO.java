package fr.eni.enchere.dal2;

import java.util.List;

public interface InterfaceDAO<T> {

	public void insert(T util) throws DALException;

	public T selectById(int id) throws DALException;
	
	public void update(T data) throws DALException;
	
	public void delete(int id) throws DALException;
	
	public List<T> selectAll() throws DALException;
	
	public List<T> selectByCat(Integer no_categorie) throws DALException;

}
