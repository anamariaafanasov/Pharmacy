package Farmacie.ReadWriteBuffer;
import Farmacie.Medicament.Antibiotic;
import Farmacie.Medicament.FaraReteta;
import Farmacie.Pacient.Adult;
import Farmacie.Pacient.Copil;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import static java.lang.Boolean.parseBoolean;
import static java.lang.Integer.parseInt;
import static java.lang.Long.parseLong;

public class ReadWrite {

//    private ArrayList <Adult> allAdults= new ArrayList<>();
//    private ArrayList <Copil> allAChildren= new ArrayList<>();
//    private ArrayList <Antibiotic> allAntibiotics= new ArrayList<>();
//    private ArrayList <FaraReteta> allWithoutPrescription= new ArrayList<>();
    private Adult newAdult;
    private Copil newCopil;
    private Antibiotic newAntibiotic ;
    private FaraReteta newFaraReteta ;
    Database db= new Database();

    public Database getDb() {
        return db;
    }

    public void importDatabase(String fileName) throws IOException
    {
        FileReader fileReader = new FileReader("src/Farmacie/fisiere/"+fileName+".csv");
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String line;
        bufferedReader.readLine();

        while ((line = bufferedReader.readLine()) != null) {
            String[] values = line.split(",");

            switch (fileName) {
                case "Adulti":
                    this.newAdult = new Adult(parseInt(values[0]),values[1],values[2],parseInt(values[3]),values[4],values[5],parseInt(values[6]));
                    this.db.addAdult(this.newAdult);
                    break;
                case "Copii":
                    this.newCopil = new Copil(parseInt(values[0]),values[1],values[2],parseInt(values[3]),values[4],values[5],parseInt(values[6]));
                    this.db.addCopil(this.newCopil);
                    break;
                case "Antibiotice":
                    this.newAntibiotic = new Antibiotic(values[0],parseInt(values[1]),parseInt(values[2]),values[3],parseInt(values[4]),values[5],parseBoolean(values[6]));
                    this.db.addAntibiotic(this.newAntibiotic);
                    break;
                case "FaraReteta":
                    this.newFaraReteta = new FaraReteta(values[0],parseInt(values[1]),parseInt(values[2]),values[3],values[4],parseInt(values[5]));
                    this.db.addFaraReteta(this.newFaraReteta);
                    break;
            }
        }
        bufferedReader.close();

        long t = System.currentTimeMillis();
    }

    public void exportDatabase(String filePath) throws IOException
    {
        FileWriter fw = new FileWriter(filePath,false);

        BufferedWriter bufferedWriter = new BufferedWriter(fw);

        try(PrintWriter printWriter = new PrintWriter(bufferedWriter)) {

            List<Adult> tempAdultList = this.db.getAdultList();
            for (int i = 0; i < tempAdultList.size(); i++){
                printWriter.println(tempAdultList.get(i).getId()+","
                                    +tempAdultList.get(i).getFirst_name()+","
                                    +tempAdultList.get(i).getLast_name()+","
                                    +tempAdultList.get(i).getAnul_nasterii()+","
                                    +tempAdultList.get(i).getSubstanta_alergica()+","
                                    +tempAdultList.get(i).getSerieCI()+","
                                    +tempAdultList.get(i).getCodCardSanatate()
                );

            }

            List<Copil> tempCopilList = this.db.getCopilList();
            for (int i = 0; i < tempCopilList.size(); i++)
                printWriter.println(tempCopilList.get(i).getId()+","
                                    +tempCopilList.get(i).getFirst_name()+","
                                    +tempCopilList.get(i).getLast_name()+","
                                    +tempCopilList.get(i).getAnul_nasterii()+","
                                    +tempCopilList.get(i).getSubstanta_alergica()+","
                                    +tempCopilList.get(i).getCnp()+","
                                    +tempCopilList.get(i).getProcent_reducere()
                );

            List<Antibiotic> tempAntibioticList = this.db.getAntibioticList();
            for (int i = 0; i < tempAntibioticList.size(); i++)
                printWriter.println(tempAntibioticList.get(i).getDenumire()+","
                                    +tempAntibioticList.get(i).getStoc()+","
                                    +tempAntibioticList.get(i).getPret()+","
                                    +tempAntibioticList.get(i).getSubstantaActiva()+","
                                    +tempAntibioticList.get(i).getConcentratie()+","
                                    +tempAntibioticList.get(i).getModadministrare()+","
                                    +tempAntibioticList.get(i).isNecesitapreparare()

                );

            List<FaraReteta> tempFaraRetetaList = this.db.getFaraRetetaList();
            for (int i = 0; i < tempFaraRetetaList.size(); i++)
                printWriter.println(tempFaraRetetaList.get(i).getDenumire()+","
                                    +tempFaraRetetaList.get(i).getStoc()+","
                                    +tempFaraRetetaList.get(i).getPret()+","
                                    +tempFaraRetetaList.get(i).getSubstantaActiva()+","
                                    +tempFaraRetetaList.get(i).getDistribuitor()+","
                                    +tempFaraRetetaList.get(i).getNr_Max_comprimate_vandute()
                );
            printWriter.flush();
        }
    }
}


