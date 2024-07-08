package modelo;

public class Moneda {
    String monedaBase;
    String monedaDestino;
    float tasaConversion;
    float montoConvertido;

    public Moneda(MonedaDto miMOnedaDTo) {
        this.monedaBase= miMOnedaDTo.base_code();
        this.monedaDestino= miMOnedaDTo.target_code();
        this.tasaConversion=Float.parseFloat(miMOnedaDTo.conversion_rate());
        this.montoConvertido=Float.parseFloat(miMOnedaDTo.conversion_result());
    }

    public String getMonedaBase() {
        return monedaBase;
    }

    public void setMonedaBase(String monedaBase) {
        this.monedaBase = monedaBase;
    }

    public float getTasaConversion() {
        return tasaConversion;
    }

    public void setTasaConversion(float tasaConversion) {
        this.tasaConversion = tasaConversion;
    }

    public String getMonedaDestino() {
        return monedaDestino;
    }

    public void setMonedaDestino(String monedaDestino) {
        this.monedaDestino = monedaDestino;
    }

    public float getMontoConvertido() {
        return montoConvertido;
    }

    public void setMontoConvertido(float montoConvertido) {
        this.montoConvertido = montoConvertido;
    }
    @Override
    public String toString() {
        return "(moneda base=" + monedaBase +
                ", moneda destino=" + monedaDestino+
                ", tasa de conversion usada="+tasaConversion+
                ", resultado de conversio="+montoConvertido+")";
    }
}

