package fr.eni.enchere.dal.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import fr.eni.enchere.bo.Utilisateurs;
import fr.eni.enchere.dal2.DALException;
import fr.eni.enchere.dal2.InterfaceDAO;

public class UtilisateursDaoJdbcImpl implements InterfaceDAO<Utilisateurs> {

	private static final String INSERT = "insert into utilisateurs(pseudo,nom,prenom,email,telephone,rue,code_postal,ville,mot_de_passe,credit,administrateur)"
			+ "values (?,?,?,?,?,?,?,?,?,?,?)";
	private static final String SELECT_BY_ID = "select no_utilisateurs,pseudo,nom,prenom,email,telephone,rue,code_postal,ville,mot_de_passe,credit,administrateur"
			+ " from utilisateurs where no_utilisateurs = ?";
	private static final String UPDDATE = "update utilisateurs set no_utilisateurs=?,pseudo=?,nom=?,prenom=?,email=?,telephone=?,rue=?,code_postal=?,ville=?,mot_de_passe=?,credit=?,administrateur=? where no_utilisateurs=?";
	private static final String DELETE = "delete from utilisateurs where no_utilisateurs=?";
	private static final String SELECT_ALL = "select no_utilisateurs,pseudo,nom,prenom,email,telephone,rue,code_postal,ville,mot_de_passe,credit,administrateur"
			+ " from utilisateurs";

	@Override
	public void insert(Utilisateurs util) throws DALException {
		Connection uneConnection = null;
		PreparedStatement pStmt = null;

		try {
			uneConnection = JdbcTools.getConnection();
			System.out.println("Connection réussie");

			pStmt = uneConnection.prepareStatement(INSERT, Statement.RETURN_GENERATED_KEYS);

			pStmt.setString(1, util.getPseudo());
			pStmt.setString(2, util.getNom());
			pStmt.setString(3, util.getPrenom());
			pStmt.setString(4, util.getEmail());
			pStmt.setString(5, util.getTelephone());
			pStmt.setString(6, util.getCode_postal());
			pStmt.setString(7, util.getVille());
			pStmt.setString(8, util.getMot_de_passe());
			pStmt.setInt(9, util.getCredit());
			pStmt.setBoolean(10, util.getAdministrateur());

			pStmt.executeUpdate();
			ResultSet rsId = pStmt.getGeneratedKeys();
			if (rsId.next()) {
				util.setNo_utilisateur(rsId.getInt(1));
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
	public Utilisateurs selectById(int id) throws DALException {
		ResultSet rs = null;
		Utilisateurs util = null;
		try (Connection cnx = JdbcTools.getConnection(); PreparedStatement rqt = cnx.prepareStatement(SELECT_BY_ID);) {
			rqt.setInt(1, id);
			rs = rqt.executeQuery();
			if (rs.next()) {
				util = new Utilisateurs(rs.getInt("no_utilisateurs"), rs.getString("pseudo"), rs.getString("nom"),
						rs.getString("prenom"), rs.getString("email"), rs.getString("telephone"), rs.getString("rue"),
						rs.getString("code_postal"), rs.getString("ville"), rs.getString("mot_de_passe"),
						rs.getInt("credit"), rs.getBoolean("administrateur"));
			}
		} catch (SQLException e) {
			throw new DALException("selectbyid - id = " + id, e);
		}
		return util;
	}

	@Override
	public void update(Utilisateurs data) throws DALException {
		Connection cnx = null;
		PreparedStatement pStmt = null;
		try {
			cnx = JdbcTools.getConnection();
			pStmt = cnx.prepareStatement(UPDDATE);
			pStmt.setString(1, data.getPseudo());
			pStmt.setString(2, data.getNom());
			pStmt.setString(3, data.getPrenom());
			pStmt.setString(4, data.getEmail());
			pStmt.setString(5, data.getTelephone());
			pStmt.setString(6, data.getCode_postal());
			pStmt.setString(7, data.getVille());
			pStmt.setString(8, data.getMot_de_passe());
			pStmt.setInt(9, data.getCredit());
			pStmt.setBoolean(10, data.getAdministrateur());

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
				throw new DALException("delete Utilisateur failed - Utilisateur inconnue");
			}
		} catch (SQLException e) {
			throw new DALException("delete Utilisateur failed - id = " + id, e);
		}
	}

	@Override
	public List<Utilisateurs> selectAll() throws DALException {
		Connection cnx = null;
		Statement rqt = null;
		ResultSet rs = null;
		List<Utilisateurs> liste = new ArrayList<Utilisateurs>();

		try {
			cnx = JdbcTools.getConnection();
			rqt = cnx.createStatement();
			rs = rqt.executeQuery(SELECT_ALL);
			Utilisateurs util = null;

			while (rs.next()) {
				util = new Utilisateurs(rs.getInt("no_utilisateurs"), rs.getString("pseudo"), rs.getString("nom"),
						rs.getString("prenom"), rs.getString("email"), rs.getString("telephone"), rs.getString("rue"),
						rs.getString("code_postal"), rs.getString("ville"), rs.getString("mot_de_passe"),
						rs.getInt("credit"), rs.getBoolean("administrateur"));
				liste.add(util);
			}
		} catch (SQLException e) {
			throw new DALException("selectAll failed - ", e);
		}
		return liste;
	}

}
