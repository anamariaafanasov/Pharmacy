package Farmacie.Medicament;

import java.util.Date;

public class Medicament {
    private int id;
    private  String denumire;
    private int stoc;
    private int pret;
    private String substantaActiva;


    public Medicament() {
        this(0,"",0,0,"");
    }

    public Medicament(int id, String denumire, int stoc, int pret, String substantaActiva ) {
        this.id=id;
        this.denumire = denumire;
        this.stoc = stoc;
        this.pret = pret;
        this.substantaActiva = substantaActiva;
    }
    public Medicament(String denumire, int stoc, int pret, String substantaActiva ) {
        this.denumire = denumire;
        this.stoc = stoc;
        this.pret = pret;
        this.substantaActiva = substantaActiva;
    }

    public int getId() { return id; }

    public void setId(int id) {this.id = id; }

    public int getStoc() {
        return stoc;
    }

    public void setStoc(int stoc) {
        this.stoc = stoc;
    }

    public String getSubstantaActiva() {
        return this.substantaActiva;
    }

    public void setSubstantaActiva(String substantaActiva) {
        this.substantaActiva = substantaActiva;
    }

    public String getDenumire() {
        return denumire;
    }

    public void setDenumire(String denumire) {
        this.denumire = denumire;
    }

    public int getPret(){return pret;}

    public void setPret(int pret) {
        this.pret = pret;
    }
}
