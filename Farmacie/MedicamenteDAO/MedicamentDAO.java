package Farmacie.MedicamenteDAO;

import Farmacie.Medicament.Medicament;

import java.util.Date;

public abstract  class MedicamentDAO {

   // protected Medicament[] medicamente=new Medicament[0];
    public abstract void add_Antibiotic(String denumire, int stoc, int pret, String SubstantaActiva, int concentratie, String mod_administrare, boolean necesita_preparare);
    public abstract void add_FaraReteta(String denumire, int stoc, int pret, String SubstantaActiva, String distribuitor, int nr_Max_comprimate_vandute );
    public abstract void delete_Medicament(int index);
    public abstract int find_Medicament(String denumire );


}