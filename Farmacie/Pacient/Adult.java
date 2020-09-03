package Farmacie.Pacient;

public class Adult extends Pacient {
    private String serieCI;
    private int CodCardSanatate;

    public Adult(String serieCI, int codCardSanatate) {
        this.serieCI = serieCI;
        CodCardSanatate = codCardSanatate;
    }

    public Adult() {
        this(0,"","",0,"","",0);
    }

    public Adult(int id, String first_name, String last_name, int anul_nasterii, String substanta_alergica, String serieCI, int codCardSanatate) {
        super(id, first_name, last_name, anul_nasterii, substanta_alergica);
        this.serieCI = serieCI;
        CodCardSanatate = codCardSanatate;
    }

    public String getSerieCI() {
        return serieCI;
    }

    public void setSerieCI(String serieCI) {
        this.serieCI = serieCI;
    }

    public int getCodCardSanatate() {
        return CodCardSanatate;
    }

    public void setCodCardSanatate(int codCardSanatate) {
        CodCardSanatate = codCardSanatate;
    }
}
