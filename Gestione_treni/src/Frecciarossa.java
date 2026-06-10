public class Frecciarossa extends Treno{
    public Frecciarossa(String id, String marca, String modello, Integer annoProduzione, Integer numCarrozze,
                        Integer annoRevisione, Integer capacita, Integer potenza) {
        super(id, marca, modello, annoProduzione, numCarrozze, annoRevisione, capacita, potenza);
    }

    @Override
    public Integer getCapacita() {
        return super.getCapacita();
    }
}
