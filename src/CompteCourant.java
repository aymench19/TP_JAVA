import lombok.*;

import java.util.Date;

@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@NoArgsConstructor
public class CompteCourant extends Compte {
    private static final double SOLDE_MINIMUM = -900;

    public CompteCourant(String RIB, double solde, Date dateCreation, Etat etat) {
        super(RIB, solde, dateCreation, etat);
    }

    @Override
    public boolean retirer(double montant) {
        if (montant > 0 && getSolde() - montant >= SOLDE_MINIMUM) {
            setSolde(getSolde() - montant);
            System.out.println("Retrait réussi (CompteCourant). Nouveau solde : " + getSolde());
            return true;
        } else {
            System.out.println("Retrait refusé (CompteCourant) : Solde insuffisant.");
            return false;
        }
    }
}