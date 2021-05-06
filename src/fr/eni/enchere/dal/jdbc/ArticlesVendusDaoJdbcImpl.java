package fr.eni.enchere.dal.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import fr.eni.enchere.bo.Articles_Vendus;
import fr.eni.enchere.dal2.DALException;
import fr.eni.enchere.dal2.InterfaceDAO;

public class ArticlesVendusDaoJdbcImpl implements InterfaceDAO<Articles_Vendus> {

	private static final String INSERT = "insert into ARTICLES_VENDUS(nom_article,description,date_debut_encheres,prix_initial,prix_vente,no_utilisateur,no_categorie)"
			+ "values(?,?,?,?,?,?,?,?)";

	private static final String SELECT_BY_ID = "Select no_article(no_article,nom_article,description,date_debut_encheres,prix_initial,prix_vente,no_utilisateur,no_categorie)"
			+ "from ARTICLES_VENDUS where no_article=?";

	private static final String UPDATE = "Update ARTICLES_VENDUS set no_article=?,nom_article=?,description=?,date_debut_encheres=?,prix_initial=?,prix_vente=?,no_utilisateur=?,no_categorie=?, where no_article=?";

	private static final String DELETE = "delete from ARTICLES_VENDUS where no_article=?";

	private static final String SELECT_ALL = "Select no_article,nom_article,description,date_debut_encheres,date_fin_encheres,prix_initial,prix_vente,no_utilisateur,no_categorie)"
			+ "from ARTICLES_VENDUS";
	private static final String SELECT_BY_CAT = "Select no_article,nom_article,description,date_debut_encheres,date_fin_encheres,prix_initial,prix_vente,no_utilisateur,no_categorie)"
			+ "from ARTICLES_VENDUS where no_categorie = ?";

	@Override
	public void insert(Articles_Vendus util) throws DALException {
		Connection uneConnection = null;
		PreparedStatement pStmt = null;

		try {
			uneConnection = JdbcTools.getConnection();
			System.out.println("Connection réussie");

			pStmt = uneConnection.prepareStatement(INSERT, Statement.RETURN_GENERATED_KEYS);

			pStmt.setString(1, util.getNom_article());
			pStmt.setString(2, util.getDescription());
			pStmt.setDate(3, java.sql.Date.valueOf(util.getDate_debut_encheres()));
			pStmt.setDate(4, java.sql.Date.valueOf(util.getDate_fin_encheres()));
			pStmt.setInt(5, util.getPrix_initial());
			pStmt.setInt(6, util.getPrix_vente());
			pStmt.setObject(7, util.getUtilisateur().getNo_utilisateur());
			pStmt.setObject(8, util.getCategorie().getNo_categorie());

			pStmt.executeUpdate();
			ResultSet rsId = pStmt.getGeneratedKeys();
			if (rsId.next()) {
				util.setNo_article(rsId.getInt(1));
			}
		} catch (SQLException e) {
			throw new DALException("Erreur à l'ajout d'un utilisateur : " + util, e);
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
	public Articles_Vendus selectById(int id) throws DALException {
		ResultSet rs = null;
		Articles_Vendus util = null;
		try (Connection cnx = JdbcTools.getConnection(); PreparedStatement rqt = cnx.prepareStatement(SELECT_BY_ID);) {
			rqt.setInt(1, id);
			rs = rqt.executeQuery();
			if (rs.next()) {
				util = new Articles_Vendus(rs.getInt("no_article"), rs.getString("nom_article"),
						rs.getString("description"), rs.getDate("date_debut_encheres").toLocalDate(),
						rs.getDate("date_fin_enchecres").toLocalDate(), rs.getInt("prix_initial"),
						rs.getInt("prix_vente"), new UtilisateursDaoJdbcImpl().selectById(rs.getInt("no_utilisateur")),
						new CategoriesDaoJdbcImpl().selectById(rs.getInt("no_categorie")));

			}
		} catch (SQLException e) {
			throw new DALException("selectbyid - id = " + id, e);
		}
		return util;
	}

	@Override
	public void update(Articles_Vendus data) throws DALException {
		Connection cnx = null;
		PreparedStatement pStmt = null;
		try {
			cnx = JdbcTools.getConnection();
			pStmt = cnx.prepareStatement(UPDATE);
			pStmt.setInt(1, data.getNo_article());
			pStmt.setString(2, data.getNom_article());
			pStmt.setString(3, data.getDescription());
			pStmt.setDate(4, java.sql.Date.valueOf(data.getDate_debut_encheres()));
			pStmt.setDate(3, java.sql.Date.valueOf(data.getDate_fin_encheres()));
			pStmt.setInt(6, data.getPrix_initial());
			pStmt.setInt(7, data.getPrix_vente());
			pStmt.setObject(8, data.getUtilisateur().getNo_utilisateur());
			pStmt.setObject(9, data.getCategorie().getNo_categorie());

			pStmt.executeUpdate();
		} catch (SQLException e) {
			throw new DALException("update Utilisateur failed - " + data, e);
		}

	}

	@Override
	public void delete(int id) throws DALException {
		try (Connection cnx = JdbcTools.getConnection(); PreparedStatement rqt = cnx.prepareStatement(DELETE);) {
			rqt.setInt(1, id);
			int nbRows = rqt.executeUpdate();
			if (nbRows != 1) {
				throw new DALException("delete article vendu failed - Utilisateur inconnue");
			}
		} catch (SQLException e) {
			throw new DALException("delete article vendu  failed - id = " + id, e);
		}
	}

	@Override
	public List<Articles_Vendus> selectAll() throws DALException {
		Connection cnx = null;
		Statement rqt = null;
		ResultSet rs = null;
		List<Articles_Vendus> liste = new ArrayList<Articles_Vendus>();

		try {
			cnx = JdbcTools.getConnection();
			rqt = cnx.createStatement();
			rs = rqt.executeQuery(SELECT_ALL);
			Articles_Vendus article = null;

			while (rs.next()) {
				article = new Articles_Vendus(rs.getInt("no_article"), rs.getString("nom_article"),
						rs.getString("description"), rs.getDate("date_debut_encheres").toLocalDate(),
						rs.getDate("date_fin_enchecres").toLocalDate(), rs.getInt("prix_initial"),
						rs.getInt("prix_vente"), new UtilisateursDaoJdbcImpl().selectById(rs.getInt("no_utilisateur")),
						new CategoriesDaoJdbcImpl().selectById(rs.getInt("no_categorie")));

				liste.add(article);
			}
		} catch (SQLException e) {
			throw new DALException("selectAll failed - ", e);
		}
		return liste;

	}

	@Override
	public List<Articles_Vendus> selectByCat(Integer no_categorie) throws DALException {
		ResultSet rs = null;
		List<Articles_Vendus> liste = new ArrayList<Articles_Vendus>();

		try (Connection cnx = JdbcTools.getConnection(); PreparedStatement rqt = cnx.prepareStatement(SELECT_BY_CAT);) {
			rqt.setInt(1, no_categorie);
			rs = rqt.executeQuery();
			Articles_Vendus article = null;

			while (rs.next()) {
				article = new Articles_Vendus(rs.getInt("no_article"), rs.getString("nom_article"),
						rs.getString("description"), rs.getDate("date_debut_encheres").toLocalDate(),
						rs.getDate("date_fin_enchecres").toLocalDate(), rs.getInt("prix_initial"),
						rs.getInt("prix_vente"), new UtilisateursDaoJdbcImpl().selectById(rs.getInt("no_utilisateur")),
						new CategoriesDaoJdbcImpl().selectById(rs.getInt("no_categorie")));

				liste.add(article);
			}
		} catch (SQLException e) {
			throw new DALException("selectByCat failed - ", e);
		}
		return liste;
	}

}
