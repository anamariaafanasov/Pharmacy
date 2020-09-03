package Farmacie.ReadWriteBuffer;
import Farmacie.Medicament.Antibiotic;
import Farmacie.Medicament.FaraReteta;
import Farmacie.Pacient.Adult;
import Farmacie.Pacient.Copil;
import java.util.ArrayList;
import java.util.List;

public class Database{

    private List<Adult> adultList = new ArrayList<Adult>();
    private List<Copil> copilList = new ArrayList<Copil>();
    private List<Antibiotic> antibioticList = new ArrayList<Antibiotic>();
    private List<FaraReteta> faraRetetaList = new ArrayList<FaraReteta>();
    private static Database database;

    public static Database Database() {
        if(database == null) {
            database = new Database();
            return database;
        }
        return database;
    }
    public List<Adult> getAdultList(){
        return adultList;

    }
    public List<Copil> getCopilList() {
        return copilList;
    }

    public void setCopilList(List<Copil> copilList) {
        this.copilList = copilList;
    }
    public List<Antibiotic> getAntibioticList() {
        return antibioticList;
    }

    public void setAntibioticList(List<Antibiotic> antibioticList) {
        this.antibioticList = antibioticList;
    }

    public List<FaraReteta> getFaraRetetaList() {
        return faraRetetaList;
    }

    public void setFaraRetetaList(List<FaraReteta> faraRetetaList) {
        this.faraRetetaList = faraRetetaList;
    }

    public void addAdult(Adult adult){
        adultList.add(adult);
    }

    public void addCopil(Copil copil){
        copilList.add(copil);
    }

    public void addAntibiotic(Antibiotic antibiotic){
        antibioticList.add(antibiotic);
    }

    public void addFaraReteta(FaraReteta faraReteta){
        faraRetetaList.add(faraReteta);
    }
}
