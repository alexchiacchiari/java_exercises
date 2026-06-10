public class Intercity extends Treno{

    private Integer capacitaSerbatorio;

    public Integer getCapacitaSerbatorio() {
        return capacitaSerbatorio;
    }

    public void setCapacitaSerbatorio(Integer capacitaSerbatorio) {
        this.capacitaSerbatorio = capacitaSerbatorio;
    }

    public Intercity(String id, String marca, String modello, Integer annoProduzione, Integer numCarrozze,
                     Integer annoRevisione, Integer capacita, Integer potenza, Integer capacitaSerbatorio) {

        super(id, marca, modello, annoProduzione, numCarrozze, annoRevisione, capacita, potenza);
        this.capacitaSerbatorio = capacitaSerbatorio;
    }

    @Override
    public Integer getNumCarrozze() {
        return super.getNumCarrozze();
    }

    @Override
    public String toString() {
        return "ID: " + getId() + " | Marca: " + getMarca()  + " | Modello: " + getModello() +
                " | Posti: " + getCapacita() + " | Potenza: " + getPotenza() + "kW"+ " | Capacita serbatorio: "+capacitaSerbatorio+ " l.";
    }
}
