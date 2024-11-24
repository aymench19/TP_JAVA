import lombok.*;

import java.util.Date;
import java.util.Objects;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Compte {
    private String RIB;
    private double solde;
    private Date dateCreation;
    private Etat etat;

    public enum Etat {
        ACTIF,
        INACTIF
    }

    public void deposer(double montant) {
        if (montant > 0) {
            solde += montant;
            System.out.println("Dépôt réussi. Nouveau solde : " + solde);
        } else {
            System.out.println("Montant de dépôt invalide.");
        }
    }

    public boolean retirer(double montant) {
        if (montant > 0 && solde - montant >= 0) {
            solde -= montant;
            System.out.println("Retrait réussi. Nouveau solde : " + solde);
            return true;
        } else {
            System.out.println("Retrait refusé : Solde insuffisant.");
            return false;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Compte compte = (Compte) o;
        return RIB.equals(compte.RIB);
    }

    @Override
    public int hashCode() {
        return Objects.hash(RIB);
    }

    @Override
    public String toString() {
        return "Compte{" +
                "RIB='" + RIB + '\'' +
                ", solde=" + solde +
                ", dateCreation=" + dateCreation +
                ", etat=" + etat +
                '}';
    }
}