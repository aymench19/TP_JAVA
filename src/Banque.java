import java.util.*;

public class Banque {
    private Map<String, Compte> comptes = new HashMap<>();

    public void ajouterCompte(Compte compte) {
        if (comptes.containsKey(compte.getRIB())) {
            System.out.println("Un compte avec ce RIB existe déjà.");
        } else {
            comptes.put(compte.getRIB(), compte);
            System.out.println("Compte ajouté avec succès.");
        }
    }

    public void supprimerCompte(String RIB) {
        if (comptes.remove(RIB) != null) {
            System.out.println("Compte supprimé.");
        } else {
            System.out.println("Aucun compte trouvé avec ce RIB.");
        }
    }

    public Compte rechercherCompte(String RIB) {
        return comptes.get(RIB);
    }

    public void afficherTousLesComptes() {
        comptes.values().forEach(System.out::println);
    }

    public void transferer(String RIBSource, String RIBDestination, double montant) {
        Compte source = comptes.get(RIBSource);
        Compte destination = comptes.get(RIBDestination);

        if (source == null || destination == null) {
            System.out.println("L'un des comptes n'existe pas.");
            return;
        }

        if (source.retirer(montant)) {
            destination.deposer(montant);
            System.out.println("Transfert réussi de " + montant + " de " + RIBSource + " vers " + RIBDestination);
        } else {
            System.out.println("Transfert échoué : Solde insuffisant.");
        }
    }

    public List<Compte> getComptesAvecSoldeNegatif() {
        List<Compte> comptesNegatifs = new ArrayList<>();
        for (Compte compte : comptes.values()) {
            if (compte.getSolde() < 0) {
                comptesNegatifs.add(compte);
            }
        }
        return comptesNegatifs;
    }

    public List<CompteEpargne> getComptesEpargneRecents() {
        List<CompteEpargne> comptesRecents = new ArrayList<>();
        Date dateLimite = new Date(System.currentTimeMillis() - (3L * 365 * 24 * 60 * 60 * 1000));
        for (Compte compte : comptes.values()) {
            if (compte instanceof CompteEpargne && compte.getDateCreation().after(dateLimite)) {
                comptesRecents.add((CompteEpargne) compte);
            }
        }
        return comptesRecents;
    }
}