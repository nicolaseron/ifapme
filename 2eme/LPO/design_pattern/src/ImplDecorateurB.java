public class ImplDecorateurB extends Decorateur {
    public ImplDecorateurB(final Abstraction pAbstraction) {
        super(pAbstraction);
    }

    @Override
    public void operation() {
        System.out.println("ImplDecorateurB avant");
        abstraction.operation();
        System.out.println("ImplDecorateurB apres");
    }
}
