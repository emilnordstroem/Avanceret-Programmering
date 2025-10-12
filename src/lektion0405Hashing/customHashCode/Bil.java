package lektion0405Hashing.customHashCode;

public class Bil {
    private String registreringsnummer;
    private String maerke;
    private String model;
    private String farve;

    public Bil(String registreringsnummer, String maerke, String model, String farve) {
        this.registreringsnummer = registreringsnummer;
        this.maerke = maerke;
        this.model = model;
        this.farve = farve;
    }

    @Override
    public int hashCode() {
        return registreringsnummer.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return this.hashCode() == obj.hashCode();
    }

    public String getRegistreringsnummer() {
        return registreringsnummer;
    }

    public String getMaerke() {
        return maerke;
    }

    public String getModel() {
        return model;
    }

    public String getFarve() {
        return farve;
    }

    public void setRegistreringsnummer(String registreringsnummer) {
        this.registreringsnummer = registreringsnummer;
    }

    public void setMaerke(String maerke) {
        this.maerke = maerke;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setFarve(String farve) {
        this.farve = farve;
    }

    @Override
    public String toString() {
        return String.format("[%s] %s %s (%s)",
                registreringsnummer,
                maerke,
                model,
                farve
        );
    }
}
