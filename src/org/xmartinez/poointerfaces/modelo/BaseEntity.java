package org.xmartinez.poointerfaces.modelo;

import java.util.Objects;

public class BaseEntity {

    protected Integer id;

    private static int ultimoId;


    //Constructor


    public BaseEntity() {
        this.id= ++ultimoId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BaseEntity base = (BaseEntity) o;
        return this.id != null && this.id.equals(base.id);   //Objects.equals(id, cliente.id);  es lo mismo
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
