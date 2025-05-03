package lowleveldesign.solidprinciples.ocp.after;

public class AnimalApplicaton {
    void animalAction(Beast animal){
        animal.beastAction();
    }

    public static void main(String[] args) {
        AnimalApplicaton animalApplicaton=new AnimalApplicaton();
        Beast dragon=new Dragon();
        Beast unicorn= new Unicorn();
        Beast dinosaur= new Dinosaur();
        animalApplicaton.animalAction(dragon);
        animalApplicaton.animalAction(unicorn);
        animalApplicaton.animalAction(dinosaur);
    }
}
