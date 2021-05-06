package fr.eni.enchere.dal.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import fr.eni.enchere.bo.Articles_Vendus;
import fr.eni.enchere.bo.Retraits;
import fr.eni.enchere.bo.Utilisateurs;
import fr.eni.enchere.dal2.DALException;
import fr.eni.enchere.dal2.InterfaceDAO;

public class RetraitsDaoJdbcImpl implements InterfaceDAO<Retraits> {
	
	
	private static final String INSERT = "insert into RETRAITS(no_article,rue,code_postal,ville)"+"values(?,?,?,?)";
	
	private static final String SELECT_BY_ID = "Select no_article(no_article,rue,code_postal,ville)"+"from RETRAITS where no_article=?";
			
	private static final String UPDATE = "Update RETRAITS set no_article=?,rue=?,code_postal=?,ville=?, where no_article=?";			
	
	private static final String DELETE = "delete from RETRAITS where no_article=?";
	
	private static final String SELECT_ALL = "Select no_article,rue,code_postal,ville,"+"from RETRAITS";


	@Override
	public void insert(Retraits util) throws DALException {
		Connection uneConnection = null;
		PreparedStatement pStmt = null;
		
		try {
			uneConnection = JdbcTools.getConnection();
			System.out.println("Connection réussie");

			pStmt = uneConnection.prepareStatement(INSERT, Statement.RETURN_GENERATED_KEYS);
			
			pStmt.setObject(1, util.getArticle().getNo_article());
			pStmt.setString(2, util.getRue());
			pStmt.setString(3, util.getCode_postal());
			pStmt.setString(4, util.getVille());


			pStmt.executeUpdate();
			ResultSet rsId = pStmt.getGeneratedKeys();
			if (rsId.next()) {
				//util.getArticle().getNo_article()(rsId.getObject(1));
				
			}
		} catch (SQLException e) {
			throw new DALException("Erreur à l'ajout d'un retrait : " + util, e);
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
	public Retraits selectById(int id) throws DALException {
		ResultSet rs = null;
		Retraits util = null;
		try (Connection cnx = JdbcTools.getConnection(); PreparedStatement rqt = cnx.prepareStatement(SELECT_BY_ID);) {
			rqt.setInt(1, id);
			rs = rqt.executeQuery();
			if (rs.next()) {
				//util = new Retraits(rs.getInt("no_article"), rs.getString("rue"), rs.getString("code_postal"),
					//	rs.getString("Ville"), rs.getDate_("date_fin_encheres"), rs.getInt("prix_initial"), rs.getInt("prix_vente"),
						//rs.getInt("no_utlisateur"), rs.getInt("no_categorie"));
				
						
			}
		} catch (SQLException e) {
			throw new DALException("selectbyid - id = " + id, e);
		}
		return util;
	}
	
	

	@Override
	public void update(Retraits data) throws DALException {
		Connection cnx = null;
		PreparedStatement pStmt = null;
		try {
			cnx = JdbcTools.getConnection();
			pStmt = cnx.prepareStatement(UPDATE);
			//pStmt.setInt(1, data.getNo_article());	
			pStmt.setString(2, data.getRue());
			pStmt.setString(3, data.getCode_postal());
			pStmt.setString(4, data.getVille());
	
			pStmt.executeUpdate();
		} catch (SQLException e) {
			throw new DALException("update Retraits failed - " + data, e);
		}

	}

	@Override
	public void delete(int id) throws DALException {
		try (Connection cnx = JdbcTools.getConnection(); PreparedStatement rqt = cnx.prepareStatement(DELETE);) {
			rqt.setInt(1, id);
			int nbRows = rqt.executeUpdate();
			if (nbRows != 1) {
				throw new DALException("delete Retraits failed - Utilisateur inconnue");
			}
		} catch (SQLException e) {
			throw new DALException("delete Retraits  failed - id = " + id, e);
		}
	}

		


	@Override
	public List<Retraits> selectAll() throws DALException {
		Connection cnx = null;
		Statement rqt = null;
		ResultSet rs = null;
		List<Retraits> liste = new ArrayList<Retraits>();

		try {
			cnx = JdbcTools.getConnection();
			rqt = cnx.createStatement();
			rs = rqt.executeQuery(SELECT_ALL);
			Retraits util = null;

			while (rs.next()) {
			//	util = new Retraits(rs.getString("no_article"), rs.getString("rue"), rs.getString("code_postal"),
				//		rs.getString("ville"));
				liste.add(util);
			}
		} catch (SQLException e) {
			throw new DALException("selectAll failed - ", e);
		}
		return liste;
	}


	}



