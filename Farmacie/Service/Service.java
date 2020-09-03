package Farmacie.Service;

import Farmacie.DBDAO.AntibioticDAODB;
import Farmacie.Medicament.Antibiotic;
import Farmacie.Medicament.FaraReteta;
import Farmacie.Pacient.Adult;
import Farmacie.DBDAO.FaraRetetaDAODB;
import Farmacie.DBDAO.AntibioticDAODB;
import Farmacie.DBDAO.AdultDBDAO;

import java.sql.SQLException;
import java.util.ArrayList;

public class Service {

    ArrayList<Antibiotic> antibiotice=new ArrayList<>();
    ArrayList<FaraReteta> faraReteta=new ArrayList<>();
    ArrayList<Adult> adulti=new ArrayList<>();

    public ArrayList<Antibiotic>addAntibiotice(){
       AntibioticDAODB antibioticDAODB= new AntibioticDAODB();
        try {
            antibiotice = antibioticDAODB.getAntibiotic();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return antibiotice;

    }

    public ArrayList<FaraReteta>addFaraReteta(){

        FaraRetetaDAODB faraRetetaDAODB= new FaraRetetaDAODB();
        try {
            faraReteta = faraRetetaDAODB.getFaraReteta();
        }catch (SQLException e){
            e.printStackTrace();
        }
        return faraReteta;

    }

    public ArrayList<Adult> addAdulti() {

        AdultDBDAO adult= new AdultDBDAO() ;
        try {
            adulti = adult.getAdult();
        }catch(SQLException e){
          e.printStackTrace();
        }
        return adulti;
    }

    public float TotalPlata(ArrayList<Antibiotic> antibiotice, ArrayList<FaraReteta> fara_reteta) {
         float result=0;
         for(int i=0;i<antibiotice.size();i++){
             result=result + antibiotice.get(i).getPret();
         }
        for(int i=0;i<fara_reteta.size();i++){
            result=result + fara_reteta.get(i).getPret();
        }
        System.out.println(result);
    return result;
    }


   public static  ArrayList <Antibiotic>antibioticePrescrise= new ArrayList();
   public static  ArrayList <FaraReteta> prescriseFaraReteta= new ArrayList<>();

    public boolean prescriereAntibiotic(String denumire,  Adult adult, ArrayList<Antibiotic> antibiotice) {
        AntibioticDAODB antibiotic = new AntibioticDAODB();

        int poz = antibiotic.find_Medicament(antibiotice,denumire);
        if (poz != -1) {
            if (antibiotice.get(poz).getSubstantaActiva() != adult.getSubstanta_alergica()) {
                System.out.println("S-a prescris " + denumire);
                antibioticePrescrise.add(antibiotice.get(poz));
                return true;
            }
        }
                System.out.println("Nu s-a prescris " + denumire);
                return false;

    }

    public boolean prescriereFaraReteta(String denumire,  Adult adult, ArrayList<FaraReteta> faraRetetaArr) {
        FaraRetetaDAODB faraReteta = new FaraRetetaDAODB();
        int poz = faraReteta.find_Medicament(faraRetetaArr,denumire);
        if (poz != -1) {
            if (faraRetetaArr.get(poz).getSubstantaActiva() != adult.getSubstanta_alergica()) {
                System.out.println("S-a prescris " + denumire);
                prescriseFaraReteta.add(faraRetetaArr.get(poz));
                return true;
            }
        }
        System.out.println("Nu s-a prescris " + denumire);
            return false;
    }

    public String eliberareBon(ArrayList<Antibiotic> antibiotic,ArrayList<FaraReteta> faraReteta){

        String result="";
        for (int i=0;i<antibiotic.size();i++){
            result=result+antibiotic.get(i).getDenumire()+"....."+antibiotic.get(i).getPret()+"\n";
        }
        for (int i=0;i<faraReteta.size();i++){
            result=result+faraReteta.get(i).getDenumire()+"....."+faraReteta.get(i).getPret()+"\n";
        }
        return result;
    }

}
