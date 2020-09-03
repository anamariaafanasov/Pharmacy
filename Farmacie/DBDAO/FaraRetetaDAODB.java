package Farmacie.DBDAO;
import Farmacie.DBconnection.DBconnection;
import Farmacie.Medicament.FaraReteta;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;

public class FaraRetetaDAODB {

    public ArrayList<FaraReteta> getFaraReteta() throws SQLException {
        ArrayList<FaraReteta> faraRetetaList = new ArrayList<>();
        String query = "SELECT * FROM farareteta";
        Statement st = DBconnection.get_instance().connection().createStatement();
        ResultSet rez = st.executeQuery(query);
        while(rez.next()){
            faraRetetaList.add(new FaraReteta(rez.getInt("id"),rez.getString("denumiere"),rez.getInt("stoc"),rez.getInt("pret"),rez.getString("substantaActiva"),rez.getString("distribuitor"),rez.getInt("nrMaxComprVandute")));
        }
        return faraRetetaList;
    }

    public void addFaraReteta(int id, String denumire, int stoc, int pret, String substantaActiva, String distribuitor,int nrMaxComprimateVandute) throws SQLException{
        String query = "INSERT INTO farareteta (id,denumire, stoc, pret, SubstantaActiva, distribuitor, nrMaxComrimateVandute) VALUES (? , ?, ? , ? , ?, ?, ?)";
        PreparedStatement pst = DBconnection.get_instance().connection().prepareStatement(query);
        pst.setInt(1,id);
        pst.setString(2,denumire);
        pst.setInt(3,stoc);
        pst.setInt(4,pret);
        pst.setString(5,substantaActiva);
        pst.setString(6,distribuitor);
        pst.setInt(7,nrMaxComprimateVandute);
        int x = pst.executeUpdate();
    }
    public void deleteFaraReteta(int id) throws SQLException{
        //trebuie sa dau delete doar dupa cheie primara?
        String query = "DELETE FROM farareteta WHERE id = ?";
        PreparedStatement pst = DBconnection.get_instance().connection().prepareStatement(query);
        pst.setInt(1,id);
        int x = pst.executeUpdate();
    }

    public int find_Medicament(ArrayList<FaraReteta> medicamente,String denumire) {
        boolean found=false;
        int position=-1;

        Iterator<FaraReteta> iterator = medicamente.iterator();
        while (iterator.hasNext() && found==false) {
            position++;
            FaraReteta medicament = iterator.next();
            if (medicament.getDenumire().equals(denumire)&& medicament.getStoc() > 0) {
                System.out.println(denumire + " was found.");
                found=true;
                return position;
            }
            else if (medicament.getDenumire().equals(denumire)) {
                System.out.println(denumire + " is out of stock");
                found=true;
                return -1;
            }
        }
        if(found==false)
            System.out.println("No such medicine");
        return position;
    }
}
