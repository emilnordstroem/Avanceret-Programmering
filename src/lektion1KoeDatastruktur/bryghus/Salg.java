package lektion1KoeDatastruktur.bryghus;

import lektion1KoeDatastruktur.bryghus.Produkt;

import java.time.LocalDate;
import java.util.ArrayList;

public class Salg
{
    int ordreNr;
    LocalDate dato;
    ArrayList<bryghus.SalgsLinje> salgsLinjer = null;
    SalgsStatus status;

    public Salg(int ordreNr)
    {
        this.ordreNr = ordreNr;
        this.dato = LocalDate.now();
        this.salgsLinjer = new ArrayList<bryghus.SalgsLinje>();
        this.status = SalgsStatus.EjBetalt;
    }

    public bryghus.SalgsLinje createSalgsLinje(Produkt produkt, int antal, int samletPris)
    {
        bryghus.SalgsLinje salgsLinje = new bryghus.SalgsLinje(this, produkt, antal, samletPris);

        salgsLinjer.add(salgsLinje);

        return salgsLinje;
    }

    public int getSamletPris()
    {
        int samletPris = 0;

        for (bryghus.SalgsLinje s : salgsLinjer)
        {
            samletPris += s.getSamletPris();
        }
        return samletPris;
    }

    @Override
    public String toString()
    {
        return "Ordre nr: " + ordreNr + " (Samlet pris: " + getSamletPris() + ")";
    }
}
