package Farmacie.DBDAO;
import Farmacie.DBconnection.DBconnection;
import Farmacie.Pacient.Copil;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class CopilDAODB {
    ArrayList<Copil> copiliList = new ArrayList<>();
    public ArrayList<Copil> getCopil() throws SQLException {
        String query="SELECT * FROM copil";
        Statement st= DBconnection.get_instance().connection().createStatement();
        ResultSet rez= st.executeQuery(query);
        while (rez.next()){
            copiliList.add(new Copil(rez.getInt("id"),rez.getString("nume"),rez.getString("prenume"),rez.getInt("anul_nasterii"),rez.getString("substanta_alergica"),rez.getString("seriaCI"),rez.getInt("codCardSanatate")));
        }
        return copiliList;
    }
    public void addCopil(int id,String nume, String prenume, int anul_nasterii, String substanta_alergica, String seriaCI, int codCardSanatate) throws SQLException{
        String query= "INSERT into copil (id,nume,prenume,anul_nasterii,substanta_alergica,seriaCI,codCardSanatate)VALUES(?,?,?,?,?,?,?)";
        PreparedStatement pst=DBconnection.get_instance().connection().prepareStatement(query);
        pst.setInt(1,id);
        pst.setString(2,nume);
        pst.setString(3,prenume);
        pst.setInt(4,anul_nasterii);
        pst.setString(5,substanta_alergica);
        pst.setString(6,seriaCI);
        pst.setInt(7,codCardSanatate);
        int x=pst.executeUpdate();
    }
    public  void deleteCopil(int id) throws  SQLException{
        String query ="DELETE FROM copil WHERE id=?";
        PreparedStatement pst= DBconnection.get_instance().connection().prepareStatement(query);
        pst.setInt(1,id);
        int x=pst.executeUpdate();
    }
}
