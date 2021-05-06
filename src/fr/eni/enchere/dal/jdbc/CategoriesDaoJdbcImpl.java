package fr.eni.enchere.dal.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import fr.eni.enchere.bo.Categories;
import fr.eni.enchere.dal2.DALException;
import fr.eni.enchere.dal2.InterfaceDAO;

public class CategoriesDaoJdbcImpl implements InterfaceDAO<Categories> {

	private static final String INSERT = "insert into categories(libelle)" + "values (?)";
	private static final String SELECT_BY_ID = "select no_categorie, libelle"
			+ " from categories where no_categorie = ?";
	private static final String SELECT_ALL = "select no_categorie, libelle" + " from categories";

	@Override
	public void insert(Categories util) throws DALException {
		Connection uneConnection = null;
		PreparedStatement pStmt = null;

		try {
			uneConnection = JdbcTools.getConnection();
			System.out.println("Connection réussie");

			pStmt = uneConnection.prepareStatement(INSERT, Statement.RETURN_GENERATED_KEYS);

			pStmt.setString(1, util.getLibelle());

			pStmt.executeUpdate();
			ResultSet rsId = pStmt.getGeneratedKeys();
			if (rsId.next()) {
				util.setNo_categorie(rsId.getInt(1));
			}
		} catch (SQLException e) {
			throw new DALException("Erreur à l'ajout d'une catégorie : " + util, e);
		} finally {
			try {
				if (uneConnection != null) {
					uneConnection.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

	@Override
	public Categories selectById(int id) throws DALException {
		ResultSet rs = null;
		Categories cat = null;
		try (Connection cnx = JdbcTools.getConnection(); PreparedStatement rqt = cnx.prepareStatement(SELECT_BY_ID);) {
			rqt.setInt(1, id);
			rs = rqt.executeQuery();
			if (rs.next()) {
				cat = new Categories(rs.getInt("no_categorie"), rs.getString("libelle"));
			}
		} catch (SQLException e) {
			throw new DALException("selectbyid - id = " + id, e);
		}
		return cat;
	}

	@Override
	public void update(Categories data) throws DALException {
		// TODO Auto-generated method stub
	}

	@Override
	public void delete(int id) throws DALException {
		// TODO Auto-generated method stub
	}

	@Override
	public List<Categories> selectAll() throws DALException {
		Connection cnx = null;
		Statement rqt = null;
		ResultSet rs = null;
		List<Categories> liste = new ArrayList<Categories>();

		try {
			cnx = JdbcTools.getConnection();
			rqt = cnx.createStatement();
			rs = rqt.executeQuery(SELECT_ALL);
			Categories cat = null;

			while (rs.next()) {
				cat = new Categories(rs.getInt("no_categorie"), rs.getString("libelle"));
				liste.add(cat);
			}
		} catch (SQLException e) {
			throw new DALException("selectAll failed - ", e);
		}
		return liste;
	}

	@Override
	public List<Categories> selectByCat(Integer no_categorie) throws DALException {
		// TODO Auto-generated method stub
		return null;
	}

}
