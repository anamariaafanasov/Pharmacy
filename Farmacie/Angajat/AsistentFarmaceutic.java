package Farmacie.Angajat;

public class AsistentFarmaceutic extends  Angajat{
   private int nrParticipariInventar;
    private boolean practicant;
    public AsistentFarmaceutic(int nrParticipariInventar, boolean practicant) {
        nrParticipariInventar = nrParticipariInventar;
        this.practicant = practicant;
    }

    public AsistentFarmaceutic(String firstName, String lastName, int workingHoursPerDay, int salary, int nrParticipariInventar, boolean practicant) {
        super(firstName, lastName, workingHoursPerDay, salary);
        nrParticipariInventar = nrParticipariInventar;
        this.practicant = practicant;
    }

    public int getNrParticipariInventar() {
        return nrParticipariInventar;
    }

    public void setNrParticipariInventar(int nrParticipariInventar) {
        nrParticipariInventar = nrParticipariInventar;
    }

    public boolean isPracticant() {
        return practicant;
    }

    public void setPracticant(boolean practicant) {
        this.practicant = practicant;
    }
}
