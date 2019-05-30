package laboratoare;

public class Lab2 {

	public static void main(String[] args) {

		ContBancar cont1 = new ContBancar("1231241231", 1000);
		ContBancar cont2 = new ContBancar("2535421231", 2500);
		ContBancar cont3 = new ContBancar("1976867867", 500.20);
		cont1.setNume(" Gimi");
		cont2.setNume(" Ion");
		cont3.setNume(" Vasile");
		System.out.println("Nume:" + cont1.getNume());
		cont1.arataBalanta();
		cont1.Depunere(500);
		cont1.Depunere(1000);
		cont1.platireFacturi(791);
		cont1.acumulareInteres();
		System.out.println(cont1.toString());
		System.out.println();
		System.out.println(cont2.toString());
		System.out.println();
		System.out.println(cont3.toString());
		System.out.println();
	}

	private static class ContBancar implements IInteres {
		// Proprietatile Contului Bancar
		private static int ID = 1000;
		private String nume;
		private String numarCont; // ID + random 2 numere + primele doua numere din CNP
		private static String numarRulare = " 0412395342";
		private String CNP;
		private double balanta;

		// Constructor
		public ContBancar(String CNP, double initDepozit) {
			System.out.println("Noul cont creat");
			this.CNP = CNP;
			this.balanta = initDepozit;
			ID++;
			System.out.println("ID:" + ID + " CNP:" + CNP + " Balanta" + balanta);
			setNumarCont();
		}

		private void setNumarCont() {
			int random = (int) (Math.random() * 100);
			numarCont = ID + "" + random + CNP.substring(0, 2);
			System.out.println("Numar cont: " + numarCont);
		}

		public void setNume(String nume) {
			this.nume = nume;

		}

		public String getNume() {
			return nume;
		}

		public void platireFacturi(double cantitate) {
			balanta = balanta - cantitate;
			System.out.println("Plata factura:" + cantitate);
			arataBalanta();
		}

		public void Depunere(double cantitate) {
			balanta = balanta + cantitate;
			System.out.println("Depunere:" + cantitate);
			arataBalanta();
		}

		public void arataBalanta() {
			System.out.println("Balanta ta este:" + balanta + " lei");
		}

		@Override
		public void acumulareInteres() {
			balanta = balanta * (1 + rata / 100);
			arataBalanta();
		}

		@Override
		public String toString() {
			return " [Nume: \t" + nume + "\t]\n [Numar Cont: \t" + numarCont + "\t]\n [Numar Rulare: " + numarRulare
					+ "\t]\n [CNP: \t\t" + CNP + "\t]\n [Balanta: \t" + balanta + " lei\t]";
		}
	}
}
