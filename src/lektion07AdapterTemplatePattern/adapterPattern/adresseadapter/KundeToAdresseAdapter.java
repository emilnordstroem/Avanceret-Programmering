
package lektion07AdapterTemplatePattern.adapterPattern.adresseadapter;

public class KundeToAdresseAdapter implements adresseadapter.Adresse {
	private Kunde kunde;

	public KundeToAdresseAdapter(Kunde kunde) {
		this.kunde = kunde;
	}
	public String getVejOgHusNr() {
		return kunde.getGadeNavn() + " " + kunde.getHusNr();
	}
	public String getPostNrOgByNavn() {
		return kunde.getPostNr() + " " + kunde.getByNavn();
	}
	public String getLandeKode() {
		return "DK";
	}
}
