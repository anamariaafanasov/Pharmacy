package Farmacie;
import Farmacie.DBDAO.AntibioticDAODB;
import Farmacie.Medicament.Antibiotic;
import Farmacie.Medicament.FaraReteta;
import Farmacie.Pacient.Adult;
import Farmacie.Service.Service;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import Farmacie.ReadWriteBuffer.ReadWrite;
import Farmacie.ReadWriteBuffer.Database;
import Farmacie.AuditService.AuditService;

import static Farmacie.Service.Service.antibioticePrescrise;
import static Farmacie.Service.Service.prescriseFaraReteta;


public class Main {


    public static void main(String[] args) throws IOException {

        Service S=new Service();
        ArrayList<Antibiotic> myAntibioticeList=new ArrayList<Antibiotic>();
        ArrayList<FaraReteta> myFaraRetetaList=new ArrayList<>();
        myAntibioticeList=S.addAntibiotice();
        myFaraRetetaList=S.addFaraReteta();
        AntibioticDAODB a= new AntibioticDAODB();
//        try {
//            a.addAntibiotic(6, "Amoksiklav", 4, 25, "amikacinum", 25, "orala", false);
//       }catch(SQLException e){
//            e.printStackTrace();
//       }
        try {
            a.deleteAntibiotic(9);
        }catch(SQLException e){
            e.printStackTrace();
        }

        myAntibioticeList.clear();
        myAntibioticeList=S.addAntibiotice();
        System.out.println("Dupa stergere:\n");
        for (int i=0;i< myAntibioticeList.size();i++)
            System.out.println(myAntibioticeList.get(i).getDenumire());
        AuditService auditService = new AuditService();
        ArrayList<Adult> adults= new ArrayList<>();
        adults=S.addAdulti();
        System.out.println("Alege optiune:\n" +
                "1. Total Plata\n" +
                "2. Prescriere medicament fara reteta\n" +
                "3. Prescriere antibiotic\n" +
                "4. Eliberare bon\n " +
                "0. Exit" );
        Scanner input = new Scanner(System.in);
        Scanner inputMedicine = new Scanner(System.in);
        int option=5;
        while (option != 0) {
            System.out.println("Alege optiune:\n");
            option = input.nextInt();

            switch (option) {
                case 1: {
                    auditService.addFunction("totalPlata", "src/Farmacie/fisiereScriere/functiiApelate.csv");
                    System.out.println("\nTotal:");
                    S.TotalPlata(antibioticePrescrise, prescriseFaraReteta);
                    break;

                }
                case 2:{
                    System.out.println("Cere medicament:\n");
                    String cereMedicament= inputMedicine.nextLine();
                    auditService.addFunction("prescriereFaraReteta","src/Farmacie/fisiereScriere/functiiApelate.csv");
                    S.prescriereFaraReteta(cereMedicament,adults.get(1),myFaraRetetaList);
                    break;
                }
                case 3:{
                    System.out.println("Cere antibiotic:\n");
                    String cereMedicament= inputMedicine.nextLine();
                    auditService.addFunction("prescriereAntibiotic","src/Farmacie/fisiereScriere/functiiApelate.csv");
                        S.prescriereAntibiotic(cereMedicament, adults.get(1), myAntibioticeList);
                        break;
                }
                case 4:{
                    System.out.println("Eliberare bon:\n");
                    auditService.addFunction("eliberareBon","src/Farmacie/fisiereScriere/functiiApelate.csv");
                    System.out.println(S.eliberareBon(antibioticePrescrise,prescriseFaraReteta));
                    break;
                }
            }
        }
        ReadWrite readFileAdults= new ReadWrite();
        readFileAdults.importDatabase("Adulti");
        readFileAdults.exportDatabase("src/Farmacie/fisiereScriere/dateAdulti.csv");

        ReadWrite readFileAntibiotics= new ReadWrite();
        readFileAntibiotics.importDatabase("Antibiotice");
        readFileAntibiotics.exportDatabase("src/Farmacie/fisiereScriere/dateAntibiotice.csv");

        ReadWrite readFileChildren= new ReadWrite();
        readFileChildren.importDatabase("Copii");
        readFileAntibiotics.exportDatabase("src/Farmacie/fisiereScriere/dateCopii.csv");

        ReadWrite readFileWithoutPrescription= new ReadWrite();
        readFileWithoutPrescription.importDatabase("FaraReteta");
        readFileWithoutPrescription.exportDatabase("src/Farmacie/fisiereScriere/dateFaraReteta.csv");
    }
}

