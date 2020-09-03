package Farmacie.Pacient;

public class Copil extends Pacient {
    private String cnp;
    protected int procent_reducere;

       public Copil(){
        this("",0);
    }

    public Copil(String cnp, int procent_reducere) {
        this.cnp = cnp;
        this.procent_reducere = procent_reducere;
    }

    public Copil(int id, String first_name, String last_name, int anul_nasterii, String substanta_alergica, String cnp, int procent_reducere) {
        super(id, first_name, last_name, anul_nasterii, substanta_alergica);
        this.cnp = cnp;
        this.procent_reducere = procent_reducere;
    }

    public String getCnp() {
        return cnp;
    }

    public void setCnp(String cnp) {
        this.cnp = cnp;
    }

    public int getProcent_reducere() {
        return procent_reducere;
    }

    public void setProcent_reducere(int procent_reducere) {
        this.procent_reducere = procent_reducere;
    }
}
