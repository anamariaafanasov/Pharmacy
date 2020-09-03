package Farmacie.Medicament;

import java.util.Date;

public class FaraReteta extends  Medicament {
    private String distribuitor;
    private int nrMaxComprimateVandute;

    public FaraReteta(String distribuitor, int nrMaxComprimateVandute) {
        this.distribuitor = distribuitor;
        this.nrMaxComprimateVandute = nrMaxComprimateVandute;
    }

    public FaraReteta(int id, String denumire, int stoc, int pret, String substantaActiva, String distribuitor, int nrMaxComprimateVandute) {
        super(id, denumire, stoc, pret, substantaActiva);
        this.distribuitor = distribuitor;
        this.nrMaxComprimateVandute = nrMaxComprimateVandute;
    }

    public FaraReteta( String denumire, int stoc, int pret, String substantaActiva, String distribuitor, int nrMaxComprimateVandute) {
        super( denumire, stoc, pret, substantaActiva);
        this.distribuitor = distribuitor;
        this.nrMaxComprimateVandute = nrMaxComprimateVandute;
    }


    public String getDistribuitor() {
        return distribuitor;
    }

    public void setDistribuitor(String distribuitor) {
        this.distribuitor = distribuitor;
    }

    public int getNr_Max_comprimate_vandute() {
        return nrMaxComprimateVandute;
    }

    public void setNr_Max_comprimate_vandute(int nrMaxComprimateVandute) {
        this.nrMaxComprimateVandute = nrMaxComprimateVandute;
    }
}
