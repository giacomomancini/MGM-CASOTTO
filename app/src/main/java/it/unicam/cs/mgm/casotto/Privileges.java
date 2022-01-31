package it.unicam.cs.mgm.casotto;

public enum Privileges {
    Cliente,
    Cassiere,
    Cameriere,
    OrganizzatoreEventi,
    Gestore;

    public static Privileges fromInt(int x) {
        switch(x) {
            case 1:
                return Cliente;
            case 2:
                return Cassiere;
            case 3:
                return Cameriere;
            case 4:
                return OrganizzatoreEventi;
            case 5:
                return Gestore;
        }
        return null;
    }
}
