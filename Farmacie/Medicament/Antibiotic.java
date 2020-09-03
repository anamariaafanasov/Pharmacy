package Farmacie.Medicament;

import java.util.Date;

public class Antibiotic extends Medicament {
    private int concentratie;
    private String modAdministrare;
    private boolean necesitaPreparare;

    public Antibiotic(int concentratie, String modAdministrare, boolean necesitaPreparare) {
        this.concentratie = concentratie;
        this.modAdministrare = modAdministrare;
        this.necesitaPreparare = necesitaPreparare;
    }

    public Antibiotic(int id, String denumire, int stoc,int pret, String substantaActiva, int concentratie, String modAdministrare, boolean necesitaPreparare) {
        super(id, denumire,stoc ,pret, substantaActiva);
        this.concentratie = concentratie;
        this.modAdministrare = modAdministrare;
        this.necesitaPreparare = necesitaPreparare;
    }
    public Antibiotic( String denumire, int stoc,int pret, String substantaActiva, int concentratie, String modAdministrare, boolean necesitaPreparare) {
        super( denumire,stoc ,pret, substantaActiva);
        this.concentratie = concentratie;
        this.modAdministrare = modAdministrare;
        this.necesitaPreparare = necesitaPreparare;
    }
    public Antibiotic(int id, String denumire, int stoc, String pret, String substanta_activa, int concentratie, String mod_administrare, int necesita_pretarare) {
    }

    public int getConcentratie() {
        return concentratie;
    }

    public void setConcentratie(int concentratie) {
        this.concentratie = concentratie;
    }

    public String getModadministrare() {
        return modAdministrare;
    }

    public void setModadministrare(String modAdministrare) {
        this.modAdministrare = modAdministrare;
    }

    public boolean isNecesitapreparare() {
        return necesitaPreparare;
    }

    public void setNecesitapreparare(boolean necesitaPreparare) {
        this.necesitaPreparare = necesitaPreparare;
    }
}
