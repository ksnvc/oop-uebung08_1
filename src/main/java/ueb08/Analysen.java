package ueb08;


import java.io.IOException;
import java.util.List;


class Analysen {

	/**
	 * Wie viele Tore fallen durchschnittlich in jedem Spiel?
	 */
	static double torstatistikenToreProSpiel() throws IOException {

		Bundesliga b = Bundesliga.loadFromResource();

        double tore = 0;
        for(Spiel s : b.spiele) {
        	tore += s.getToreGast() + s.getToreHeim();
		}
		return (tore/(b.spiele.size()));
	}

	/**
	 * Wie viele Tore fallen durchschnittlich in einem Spiel der 1. Liga?
	 */
	static double torstatustikenToreProErstligaspiel() throws IOException {

      Bundesliga b = Bundesliga.loadFromResource();

      double tore = 0;
      double zähler = 0;

      	for(Verein v: b.vereine.values()) {
      		if(v.getLiga() == 1){
				for(Spiel s : b.spiele){
      			if(v.getId() == s.getGast())
      		        tore += s.getToreGast();
      			if(v.getId() == s.getHeim())
      				tore += s.getToreHeim();

      				zähler += 1;
      		}
		}
      }
      return tore/zähler;
	  }



	/**
	 * Wie viele Tore fallen durchschnittlich an einem Spieltag der 2. Liga?
	 */
	static double torstatistikenToreProSpieltag2teLiga() throws IOException {

		Bundesliga b = Bundesliga.loadFromResource();

		double tore = 0;
		double tag = 0;

		for(Verein v: b.vereine.values()) {
			if(v.getLiga() == 2){
				for(Spiel s : b.spiele){

					if(v.getId() == s.getGast()){
						tore += s.getToreGast();
					if(s.getSpieltag()>tag)
						tag = s.getSpieltag();
					}

					if(v.getId() == s.getHeim()){
						tore += s.getToreHeim();
					if(s.getSpieltag()>tag);
						tag = s.getSpieltag();}

				}
			}
		}
		return tore/tag;
	}

	/**
	 * Stimmt es, dass in den Nachmittagsspielen (15:30:00) im Schnitt mehr Tore fallen, wie in den Abendspielen?
	 */
	static boolean torstatistikenToreNachmittagsAbends() throws IOException {

		Bundesliga b = Bundesliga.loadFromResource();


		double toreNach = 0;
		double anzNach = 0;

		double toreAbend = 0;
		double anzAbend = 0;

		for(Spiel s : b.spiele){
			if(s.getUhrzeit().equals("15:30:00")){
				toreNach += s.getToreGast() + s.getToreHeim();
				anzNach++;
			}
			else{
				toreAbend += s.getToreGast() + s.getToreHeim();
				anzAbend++;
			}
		}

		if((toreNach/anzNach)>(toreAbend/anzAbend))
			return true;

		return false;

	}

	/**
	 * Stimmt es, dass Vereine der 3. Liga zuhause im Schnitt mehr Tore schießen als auswärts?
	 */
	static boolean torstatistikenToreDaheim() throws IOException {

		Bundesliga b = Bundesliga.loadFromResource();

		double toreHeim = 0;

		double toreGast = 0;
		double anz = 0;
		double anzVereine = 0;

		for(Verein v: b.vereine.values()) {
			if(v.getLiga() == 3) {
				anzVereine++;
				for (Spiel s : b.spiele) {
					if(v.getId() == s.getHeim()) {
						toreHeim += s.getToreHeim();
						anz++;
					}
					if(v.getId() == s.getGast())
						toreGast += s.getToreGast();
				}
			}

	}
	anz /= anzVereine;
	if((toreHeim/anz)>(toreGast/anz))
		return true;

	return false;

	}

	/**
	 * Wie viele Tore hat der FC Bayern München (Verein 1) erzielt?
	 */
	static int vereineToreVerein1erzielt() throws IOException {

		return 0;
	}

	/**
	 * Wie viele Tore hat der FC Schalke 04 (Verein 2) erhalten?
	 */
	static int vereineToreVerein2erhalten() throws IOException {

		return 0;
	}

	/**
	 * Wie viele Punkte hat der 1. FC Nürnberg (Verein 20)?
	 * Ein Sieg zählt 3 Punkte, ein Unentschieden 1, eine Niederlage 0 Punkte.
	 */
	static int vereineToreVerein20punkte() throws IOException {

		return 0;
	}

	/**
	 * Was ist das Torverhältnis des VfL Bochum (Verein 26)?
	 */
	static int vereineTorverhaeltnis26() throws IOException {

		return 0;
	}

	/**
	 * Hilfsklasse.
	 */
	static class VereinTore {
		String verein;
		int tore;

		public VereinTore(String v, int t) {
			this.verein = v;
			this.tore = t;
		}

		@Override
		public boolean equals(Object o) {
			if (this == o)
				return true;
			if (!(o instanceof VereinTore))
				return false;
			VereinTore that = (VereinTore) o;
			return tore == that.tore && verein.equals(that.verein);
		}
	}


	/**
	 * Welche drei Vereine haben die meisten Tore zuhause geschossen, und wie viele?
	 */
	static List<VereinTore> vereineMeisteToreZuhause() throws IOException {

		return null;
	}

	/**
	 * Welcher Verein hat die wenigsten Tore auswärts geschossen, und wie viele?
	 */
	static VereinTore vereineWenigsteToreAuswaerts() throws IOException {

		return null;
	}

}