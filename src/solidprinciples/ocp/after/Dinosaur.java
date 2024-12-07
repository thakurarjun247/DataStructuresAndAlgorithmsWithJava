package solidprinciples.ocp.after;

public class Dinosaur implements  Beast{
    @Override
    public void beastAction() {
        System.out.println("Dinosaur: Walks to shake the ground");
    }
}
