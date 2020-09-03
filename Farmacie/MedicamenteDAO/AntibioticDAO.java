package Farmacie.MedicamenteDAO;
import Farmacie.Medicament.Antibiotic;
import Farmacie.Medicament.Antibiotic;


import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class AntibioticDAO extends MedicamentDAO{

     ArrayList<Antibiotic> medicamente= new ArrayList<Antibiotic>();

    public void setMedicamente( ArrayList<Antibiotic> medicamente) {
        this.medicamente = medicamente;
    }
    public  Antibiotic getMedicament(int i) {
        return medicamente.get(i);
    }
    public ArrayList<Antibiotic> getMedicamente() {
        return medicamente;
    }

    public void add_Antibiotic(String denumire, int stoc, int pret, String SubstantaActiva, int concentratie, String mod_administrare, boolean necesita_preparare) {
        Antibiotic A=new Antibiotic(denumire,stoc,pret,SubstantaActiva,concentratie,mod_administrare,necesita_preparare);
       medicamente.add(A);
    }
    public void add_FaraReteta(String denumire, int stoc, int pret, String SubstantaActiva,  String distribuitor, int nr_Max_comprimate_vandute) {
        try
        {
            throw new NullPointerException("demo");
        }
        catch(NullPointerException e)
        {
            System.out.println("Try to use addAntibiotic Function");

        }

    }

    @Override
    public void delete_Medicament(int index) {
      medicamente.remove(index);
    }
    
    

    //@Override
    public int find_Medicament(String denumire) {
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
