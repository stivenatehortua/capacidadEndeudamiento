package clases;

public class CapacidadEndedudamiento {
    private Integer ingresosTotales;
    private Integer gastosFijos;
    private Integer gastoVaribales;
    static final double POR_FIJO = 0.35;

    //Metodos getter and setter para la clase
    public Integer getIngresosTotales() {
        return ingresosTotales;
    }

    public void setIngresosTotales(Integer ingresosTotales) {
        this.ingresosTotales = ingresosTotales;
    }

    public Integer getGastosFijos() {
        return gastosFijos;
    }

    public void setGastosFijos(Integer gastosFijos) {
        this.gastosFijos = gastosFijos;
    }

    public Integer getGastoVaribales() {
        return gastoVaribales;
    }

    public void setGastoVaribales(Integer gastoVaribales) {
        this.gastoVaribales = gastoVaribales;
    }

    public double getPorFijo() {
        return POR_FIJO;
    }

    //Construye un metodo que retorne una cadena con las propiedades de la clase

    @Override
    public String toString() {
        return "ingresos Totales=" + ingresosTotales +
                ", gastos Fijos=" + gastosFijos +
                ", gasto Varibales=" + gastoVaribales +
                ", POR_FIJO=" + POR_FIJO;
    }

    public String getCapacidadEndeudamiento() {
        // retornar la capacidad de endeudamiento puede ser una cadena con el valor
        return Double.toString((getIngresosTotales() - getGastosFijos() - getGastoVaribales()) * getPorFijo());
    }
}
