package org.xmartinez.poointerfaces.modelo;

public class Productos extends BaseEntity {

    private String descripcion;
    private Double precio;

    public Productos(String descripcion, double precio) {
        super();
        this.descripcion = descripcion;
        this.precio = precio;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    @Override
    public String toString() {
        return "descripcion=`" + descripcion + '\'' +
                ", precio='" + precio + '\'' +
                ", id='" + id;
    }
}
