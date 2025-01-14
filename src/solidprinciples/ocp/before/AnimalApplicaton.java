package solidprinciples.ocp.before;

public class AnimalApplicaton {

    //this code is problematic, it's open for modification, violates OCP

    void animalAction(Object animal){
        if(animal instanceof Dragon)
        {
            Dragon dragon= (Dragon) animal;
            dragon.breathe();
        }
        if(animal instanceof Unicorn){
            ((Unicorn) animal).attack();
        }

    }

    public static void main(String[] args) {
        AnimalApplicaton animalApplicaton=new AnimalApplicaton();
        Dragon dragon=new Dragon();
        Object unicorn= new Unicorn();
        animalApplicaton.animalAction(dragon);
        animalApplicaton.animalAction(unicorn);
    }
}
