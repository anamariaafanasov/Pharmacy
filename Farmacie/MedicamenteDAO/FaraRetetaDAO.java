package Farmacie.MedicamenteDAO;

import Farmacie.  Medicament.FaraReteta;


import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;

public class FaraRetetaDAO extends MedicamentDAO {

    ArrayList<FaraReteta> medicamente=new ArrayList<>();
    public void add_Antibiotic(String denumire, int stoc, int pret, String SubstantaActiva, int concentratie, String mod_administrare, boolean necesita_preparare) {
        try {
            throw new NullPointerException("demo");
        } catch (NullPointerException e) {
            System.out.println("Try to use add_FaraReteta Function");

        }
    }

    public void add_FaraReteta(String denumire, int stoc, int pret, String SubstantaActiva,String distribuitor, int nr_Max_comprimate_vandute) {

        FaraReteta A = new FaraReteta(denumire, stoc, pret, SubstantaActiva, distribuitor, nr_Max_comprimate_vandute);
        medicamente.add(A);
    }


    @Override
    public void delete_Medicament(int index) {

        medicamente.remove(index);
    }

    @Override
    public int find_Medicament(String denumire) {
        boolean found = false;
        int position=-1;
            Iterator<FaraReteta> iterator = medicamente.iterator();
            while (iterator.hasNext()) {
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
                    }
                    else if(found==false)
                        System.out.println("No such medicine");

                    }
            return position;

    }
    public FaraReteta getMedicament(int i) {
        return medicamente.get(i);
    }

    public ArrayList<FaraReteta> getMedicamente() {
        return medicamente;
    }
}
