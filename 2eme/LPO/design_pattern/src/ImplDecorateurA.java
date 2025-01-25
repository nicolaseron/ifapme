public class ImplDecorateurA extends Decorateur {
    public ImplDecorateurA(final Abstraction pAbstraction) {
        super(pAbstraction);
    }

    @Override
    public void operation() {
        System.out.println("ImplDecorateurA avant");
        abstraction.operation();
        System.out.println("ImplDecorateurA apres");
    }
}
