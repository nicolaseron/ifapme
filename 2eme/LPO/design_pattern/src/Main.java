public class Main {
    public static void main(String[] args) {
        // Création de l'implémentation et des décorateurs
        final Implementation lImpl = new Implementation();
        final ImplDecorateurB lImplDecB = new ImplDecorateurB(lImpl);
        final ImplDecorateurA lImplDecA = new ImplDecorateurA(lImplDecB);

        // Appel de la méthode du décorateur "conteneur"
        lImplDecA.operation();
    }
}