package designpatterns.structural.adapter;

//Note:
//The adapter will take a adaptee(source) and adapt/convert it to the target
//adaptee -> adapter -> target
interface AdapteeBird {
    public void makeSound();
}

class Sparrow implements AdapteeBird {
    public void makeSound() {
        System.out.println("Chirp Chirp");
    }
}

interface TargetToyBird {
    public void whistle();
}

class BirdToTargetToyBirdAdapter implements TargetToyBird {
    // You need to implement the interface your that client expects to use.
    AdapteeBird adapteeBird;

    public BirdToTargetToyBirdAdapter(AdapteeBird adapteeBird) {
        this.adapteeBird = adapteeBird;
    }

    @Override
    public void whistle() {
        // translate the methods appropriately
        adapteeBird.makeSound();
    }
}

public class AdapterPatternClient {
    public static void main(String args[]) {
        AdapteeBird adapteeSparrowBird = new Sparrow();
        // Wrap a adapteeBird in a ToyBirdAdapter so that it
        // behaves like TargetToyBird
        TargetToyBird birdAdapter = new BirdToTargetToyBirdAdapter(adapteeSparrowBird);
        birdAdapter.whistle();
    }
}
