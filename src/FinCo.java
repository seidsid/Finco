/**
 * @author MinPhone, Seid, Asrat
 */
public class FinCo {

    public static void main(String[] args) {
        FinCo finCo = new FinCo();
        finCo.start();
    }

    public void start() {
        IFincoAbstractFactory abstractFactory = new FinCoComponentFactory();
        abstractFactory.getGui().start();
    }

}
