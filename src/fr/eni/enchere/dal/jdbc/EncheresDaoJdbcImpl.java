package fr.eni.enchere.dal.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import fr.eni.enchere.bo.Encheres;
import fr.eni.enchere.dal2.DALException;
import fr.eni.enchere.dal2.InterfaceDAO;

public class EncheresDaoJdbcImpl implements InterfaceDAO<Encheres> {

	private static final String INSERT = "insert into encheres(no_utilisateur,no_article,date_enchere,montant_enchere)"
			+ "values (?,?,?,?)";
	private static final String SELECT_BY_ID = "select no_utilisateur,no_article,date_enchere,montant_enchere"
			+ " from encheres where no_article = ?";
	private static final String UPDATE = "update encheres set no_utilisateur=?, no_article=?, date_enchere=?, montant_enchere=? where no_article=?";
	private static final String DELETE = "delete from encheres where no_article=?";
	private static final String SELECT_ALL = "select no_utilisateur,no_article,date_enchere,montant_enchere"
			+ " from encheres";

	@Override
	public void insert(Encheres util) throws DALException {
		Connection uneConnection = null;
		PreparedStatement pStmt = null;

		try {
			uneConnection = JdbcTools.getConnection();
			System.out.println("Connection réussie");

			pStmt = uneConnection.prepareStatement(INSERT);
			pStmt.setObject(1, util.getUtilisateur().getNo_utilisateur());
			pStmt.setObject(2, util.getArticle().getNo_article());
			pStmt.setDate(3, java.sql.Date.valueOf(util.getDate_enchere()));
			pStmt.setInt(4, util.getMontant_enchere());

			pStmt.executeUpdate();
		} catch (SQLException e) {
			throw new DALException("Erreur à l'ajout d'une enchere : " + util, e);
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
	public Encheres selectById(int id) throws DALException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(Encheres data) throws DALException {
		Connection uneConnection = null;
		PreparedStatement pStmt = null;

		try {
			uneConnection = JdbcTools.getConnection();
			pStmt = uneConnection.prepareStatement(UPDATE);
			pStmt.setObject(1, data.getUtilisateur().getNo_utilisateur());
			pStmt.setObject(2, data.getArticle().getNo_article());
			pStmt.setDate(3, java.sql.Date.valueOf(data.getDate_enchere()));
			pStmt.setInt(4, data.getMontant_enchere());

			pStmt.executeUpdate();
		} catch (SQLException e) {
			throw new DALException("Update Enchere failed : " + data, e);
		}
	}

	@Override
	public void delete(int id) throws DALException {
		try (Connection cnx = JdbcTools.getConnection(); PreparedStatement rqt = cnx.prepareStatement(DELETE);) {
			rqt.setInt(1, id);
			int nbRows = rqt.executeUpdate();
			if (nbRows != 1) {
				throw new DALException("delete Enchere failed - Utilisateur inconnue");
			}
		} catch (SQLException e) {
			throw new DALException("delete Enchere failed - id = " + id, e);
		}
	}

	@Override
	public List<Encheres> selectAll() throws DALException {
		// TODO Auto-generated method stub
		return null;
	}

}
