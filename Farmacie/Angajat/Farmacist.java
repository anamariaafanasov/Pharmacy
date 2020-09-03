package Farmacie.Angajat;

public class Farmacist extends Angajat {
    private int nrAniExperienta;
    private int nrPacientiConsultati;

    public Farmacist(int nrAniExperienta, int nr_PacientiConsultati) {
        nrAniExperienta = nrAniExperienta;
        nrPacientiConsultati = nr_PacientiConsultati;
    }

    public Farmacist(String firstName, String lastName, int workingHoursPerDay, int salary, int nrAniExperienta, int nr_PacientiConsultati) {
        super(firstName, lastName, workingHoursPerDay, salary);
        nrAniExperienta = nrAniExperienta;
        nrPacientiConsultati = nr_PacientiConsultati;
    }

    public int getNrAniExperienta() {
        return nrAniExperienta;
    }

    public void setNrAniExperienta(int nrAniExperienta) {
        nrAniExperienta = nrAniExperienta;
    }

    public int getnrPacientiConsultati() {
        return nrPacientiConsultati;
    }

    public void setnrPacientiConsultati(int nr_PacientiConsultati) {
        nrPacientiConsultati = nr_PacientiConsultati;
    }
}
