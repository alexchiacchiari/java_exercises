public class Regionale extends Treno{

    private Integer capacitaSerbatoio;

    public Regionale(String id, String marca, String modello, Integer annoProduzione, Integer numCarrozze,
                     Integer annoRevisione, Integer capacita, Integer potenza, Integer capacitaSerbatoio) {

        super(id, marca, modello, annoProduzione, numCarrozze, annoRevisione, capacita, potenza);
        this.capacitaSerbatoio = capacitaSerbatoio;
    }

    public Integer getCapacitaSerbatoio() {
        return capacitaSerbatoio;
    }

    public void setCapacitaSerbatoio(Integer capacitaSerbatoio) {
        this.capacitaSerbatoio = capacitaSerbatoio;
    }

    @Override
    public String toString() {
        return "ID: " + getId() + " | Marca: " + getMarca()  + " | Modello: " + getModello() +
                " | Posti: " + getCapacita() + " | Potenza: " + getPotenza() + "kW"+ " | Capacita serbatorio: "+capacitaSerbatoio+ " l.";
    }

}
