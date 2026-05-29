package com.espe.tech.dto;

import java.math.BigDecimal;

public class CategoriaResumenDTO {

    private String categoria;
    private BigDecimal total;
    private BigDecimal promedio;
    private String equipoMasCaro;

    public CategoriaResumenDTO(String categoria,
                               BigDecimal total,
                               BigDecimal promedio,
                               String equipoMasCaro) {

        this.categoria = categoria;
        this.total = total;
        this.promedio = promedio;
        this.equipoMasCaro = equipoMasCaro;
    }

    public String getCategoria() {
        return categoria;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public BigDecimal getPromedio() {
        return promedio;
    }

    public String getEquipoMasCaro() {
        return equipoMasCaro;
    }
}