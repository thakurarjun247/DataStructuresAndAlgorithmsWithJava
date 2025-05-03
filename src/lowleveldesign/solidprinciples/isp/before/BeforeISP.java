package lowleveldesign.solidprinciples.isp.before;

public class BeforeISP {
}
interface Plant{
    void grow();
    void flowering();
    void fruiting();
}
class Mango implements Plant{

    @Override
    public void grow() {

    }

    @Override
    public void flowering() {

    }

    @Override
    public void fruiting() {

    }
}

class Rose implements Plant{

    @Override
    public void grow() {

    }

    @Override
    public void flowering() {

    }

    @Override
    public void fruiting() {
//dummy
    }
}
