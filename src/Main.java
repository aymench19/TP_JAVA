import java.util.Date;

public class Main {
    public static void main(String[] args) {
        Banque banque = new Banque();

        CompteCourant cc1 = new CompteCourant("RIB123", 500, new Date(), Compte.Etat.ACTIF);
        CompteEpargne ce1 = new CompteEpargne("RIB456", 1000, new Date(), Compte.Etat.ACTIF, 0.03);

        banque.ajouterCompte(cc1);
        banque.ajouterCompte(ce1);

        cc1.retirer(600);
        ce1.appliquerInteret();

        banque.afficherTousLesComptes();

        banque.transferer("RIB456", "RIB123", 200);

        System.out.println("Comptes avec solde négatif : " + banque.getComptesAvecSoldeNegatif());
        System.out.println("Comptes épargne récents : " + banque.getComptesEpargneRecents());
    }
}