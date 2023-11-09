package graphics;

public class TableauTest {
	
	    public static void main(String[] args) {
	        Tableau table = new Tableau(4); // Supposons que le mot à deviner a 4 lettres
	        if (table.addAttempt("test")) {
	            table.printTabInput();
	        } else {
	            System.out.println("Erreur : mot de longueur incorrecte ou trop de tentatives.");
	        }

	        if (table.addAttempt("cool")) {
	            table.printTabInput();
	        } else {
	            System.out.println("Erreur : mot de longueur incorrecte ou trop de tentatives.");
	        }

	    }
	
}
