package Farmacie.Pacient;

public abstract class Pacient {
    private int id;
    private String first_name;
    private String last_name;
    private int anul_nasterii;
    private String substanta_alergica;

    public Pacient(){
        this(-1,"NO_Name","NO_LastName",0,"");
    }

    public Pacient(int id, String first_name, String last_name, int anul_nasterii, String substanta_alergica) {
        this.id = id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.anul_nasterii = anul_nasterii;
        this.substanta_alergica = substanta_alergica;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public int getAnul_nasterii() {
        return anul_nasterii;
    }

    public void setAnul_nasterii(int anul_nasterii) {
        this.anul_nasterii = anul_nasterii;
    }

    public String getSubstanta_alergica() {
        return substanta_alergica;
    }

    public void setSubstanta_alergica(String substanta_alergica) {
        this.substanta_alergica = substanta_alergica;
    }
}


