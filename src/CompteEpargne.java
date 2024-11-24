import lombok.*;

import java.util.Date;

@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@NoArgsConstructor
public class CompteEpargne extends Compte {
    private static final double SOLDE_MINIMUM = 10;
    private double tauxInteret;

    public CompteEpargne(String RIB, double solde, Date dateCreation, Etat etat, double tauxInteret) {
        super(RIB, solde, dateCreation, etat);
        this.tauxInteret = tauxInteret;
    }

    public void appliquerInteret() {
        if (getSolde() >= SOLDE_MINIMUM) {
            double interet = getSolde() * tauxInteret;
            setSolde(getSolde() + interet);
            System.out.println("Intérêts appliqués. Nouveau solde : " + getSolde());
        } else {
            System.out.println("Impossible d'appliquer les intérêts : solde insuffisant.");
        }
    }

    @Override
    public boolean retirer(double montant) {
        if (montant > 0 && getSolde() - montant >= SOLDE_MINIMUM) {
            setSolde(getSolde() - montant);
            System.out.println("Retrait réussi (CompteEpargne). Nouveau solde : " + getSolde());
            return true;
        } else {
            System.out.println("Retrait refusé (CompteEpargne) : Solde insuffisant.");
            return false;
        }
    }
}