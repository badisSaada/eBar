package be.helha.eBar.dao.daoimpl;

import be.helha.eBar.biere.Biere;
import be.helha.eBar.dao.BiereDao;

import java.sql.*;
import java.util.*;

public class BiereDaoImpl implements BiereDao {
    public DaoFactory instance;

    public BiereDaoImpl() {
        this.instance = DaoFactory.getInstance();
        Comparator<String> comp = new ComparateurBieres();

    }

    public static void cloturer(ResultSet res,PreparedStatement stm,Connection con) throws SQLException {
        res.close();
        stm.close();
        con.close();
    }
    @Override
    public boolean ajouterBiere(Biere biere) throws SQLException {
        if (biere == null) {
            return false; // Ne peut pas ajouter une bière null ou déjà existante
        }
        Connection con = this.instance.getConnection();
        PreparedStatement pstmt = con.prepareStatement("INSERT INTO bieres(nom, type, couleur,brasserie) VALUES (?, ?, ?,?)");
        pstmt.setString(1, biere.getNom());
        pstmt.setString(2, biere.getType());
        pstmt.setString(3, biere.getCouleur());
        pstmt.setString(4, biere.getBrasserie());
        pstmt.executeUpdate();
        return true;
    }

    @Override
    public Biere getBiere(String nom) throws SQLException {
        if (nom == null) {
            throw new RuntimeException(); // Ne peut pas ajouter une bière null ou déjà existante
        }
        Connection con = this.instance.getConnection();
        PreparedStatement pstmt = con.prepareStatement("select * from bieres WHERE nom = ?");
        pstmt.setString(1, nom);
        ResultSet rs = pstmt.executeQuery();
        String brasserie = null;
        String couleur = null;
        String type = null;
        String name= null;
        while (rs.next()) {
            name = rs.getString("nom");
            type = rs.getString("type");
            couleur = rs.getString("couleur");
            brasserie = rs.getString("brasserie");

        }
        Biere biere = new Biere(brasserie, couleur, name, type);
        return biere;
    }

    @Override
    public List<Biere> listerBiere() throws SQLException {
        Connection con = this.instance.getConnection();
        PreparedStatement pstmt = con.prepareStatement(" select * from bieres");
        ResultSet rs = pstmt.executeQuery();
        String brasserie = null;
        String couleur = null;
        String type = null;
        String name= null;
        List<Biere> list = new ArrayList<>();
        while (rs.next()) {
            name = rs.getString("nom");
            type = rs.getString("type");
            couleur = rs.getString("couleur");
            brasserie = rs.getString("brasserie");
            Biere biere = new Biere(brasserie, couleur, name, type);
            list.add(biere);


        }
        return list;
    }

    @Override
    public boolean modifierBiere(Biere biere) throws SQLException {
        if (biere == null) {
            return false; // Ne peut pas modifier une bière null ou inexistante
        }
        Connection con = this.instance.getConnection();
        PreparedStatement pstmt = con.prepareStatement("update bieres set nom=?,type=?,couleur=?,brasserie=? where nom=?");
        pstmt.setString(1, biere.getNom());
        pstmt.setString(2, biere.getType());
        pstmt.setString(3, biere.getCouleur());
        pstmt.setString(4, biere.getBrasserie());
        pstmt.setString(5, biere.getNom());
        pstmt.executeUpdate();
        return true;
    }

    @Override
    public boolean supprimerBiere(Biere biere) throws SQLException {
        if (biere == null) {
            return false; // Ne peut pas supprimer une bière null ou inexistante
        }
        Connection con = this.instance.getConnection();
        Statement statement = con.createStatement();
        PreparedStatement pstmt = con.prepareStatement("delete from bieres WHERE nom =?");
        pstmt.setString(1, biere.getNom());
        pstmt.executeUpdate();
        return true;
    }

    private static class ComparateurBieres implements Comparator<String> {
        @Override
        public int compare(String nom1, String nom2) {
            return nom1.compareTo(nom2);
        }
    }
}
