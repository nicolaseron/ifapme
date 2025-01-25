public abstract class Decorateur implements Abstraction {
    protected Abstraction abstraction;
    public Decorateur (final Abstraction pAbstraction) {
        abstraction = pAbstraction;
    }
}
