package Farmacie.DBDAO;
import Farmacie.DBconnection.DBconnection;
import Farmacie.Medicament.Antibiotic;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;


public class AntibioticDAODB {

    public ArrayList<Antibiotic> getAntibiotic() throws SQLException {
        ArrayList<Antibiotic> antibioticList = new ArrayList<>();
        String query = "SELECT * FROM antibiotic";
        Statement st = DBconnection.get_instance().connection().createStatement();
        ResultSet rez = st.executeQuery(query);
        while(rez.next()){
            antibioticList.add(new Antibiotic(rez.getInt("id"),rez.getString("denumire"),rez.getInt("stoc"),rez.getInt("pret"),rez.getString("substanta_activa"),rez.getInt("concentratie"),rez.getString("mod_administrare"),rez.getBoolean("necesita_preparare")));
        }
        return antibioticList;
    }

    public void addAntibiotic(int id, String denumire, int stoc, int pret, String SubstantaActiva, int concentratie, String mod_administrare, boolean necesita_preparare) throws SQLException{
        String query = "INSERT INTO antibiotic (id,denumire, stoc, pret, substanta_activa, concentratie, mod_administrare, necesita_preparare) VALUES (? , ?, ? , ? , ?, ?, ?,?)";
        PreparedStatement pst = DBconnection.get_instance().connection().prepareStatement(query);
        pst.setInt(1,id);
        pst.setString(2,denumire);
        pst.setInt(3,stoc);
        pst.setInt(4,pret);
        pst.setString(5,SubstantaActiva);
        pst.setInt(6,concentratie);
        pst.setString(7,mod_administrare);
        int myInt = necesita_preparare ? 1 : 0;
        pst.setInt(8,myInt);
        int x = pst.executeUpdate();
    }
    public void deleteAntibiotic(int id) throws SQLException{
        String query = "DELETE FROM antibiotic WHERE id = ?";
        PreparedStatement pst = DBconnection.get_instance().connection().prepareStatement(query);
        pst.setInt(1,id);
        int x = pst.executeUpdate();
    }

    public int find_Medicament(ArrayList<Antibiotic> medicamente, String denumire) {
        boolean found=false;
        int position=-1;

        Iterator<Antibiotic> iterator = medicamente.iterator();
        while (iterator.hasNext() && found==false) {
            position++;
            Antibiotic medicament = iterator.next();
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

