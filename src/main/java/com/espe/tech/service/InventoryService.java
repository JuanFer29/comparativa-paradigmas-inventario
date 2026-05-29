package com.espe.tech.service;

import com.espe.tech.dto.CategoriaResumenDTO;
import com.espe.tech.entity.HardwareEntity;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.stream.Collectors;

@Service
public class InventoryService {

    public List<HardwareEntity> generarHardware() {

        List<HardwareEntity> lista = new ArrayList<>();

        String[] categorias = {"Laptop", "PC", "Servidor"};
        String[] estados = {"ACTIVO", "DEBAJA"};

        Random random = new Random();

        for (int i = 1; i <= 10000; i++) {

            lista.add(
                    new HardwareEntity(
                            (long) i,
                            "Modelo-" + i,
                            categorias[random.nextInt(categorias.length)],
                            BigDecimal.valueOf(500 + random.nextInt(5000)),
                            LocalDate.now().minusYears(random.nextInt(10)),
                            estados[random.nextInt(estados.length)]
                    )
            );
        }

        return lista;
    }

    public List<CategoriaResumenDTO> procesarImperativo() {

        List<HardwareEntity> lista = generarHardware();
        List<HardwareEntity> filtrados = new ArrayList<>();

        LocalDate fechaLimite = LocalDate.now().minusYears(5);

        for (HardwareEntity h : lista) {

            if (h.getEstado().equals("ACTIVO")
                    && h.getFechaCompra().isAfter(fechaLimite)) {

                filtrados.add(h);
            }
        }

        List<CategoriaResumenDTO> respuesta = new ArrayList<>();
        String[] categorias = {"Laptop", "PC", "Servidor"};

        for (String categoria : categorias) {

            BigDecimal total = BigDecimal.ZERO;
            HardwareEntity equipoMasCaro = null;
            int contador = 0;

            for (HardwareEntity h : filtrados) {

                if (h.getCategoria().equals(categoria)) {

                    total = total.add(h.getPrecio());
                    contador++;

                    if (equipoMasCaro == null
                            || h.getPrecio().compareTo(equipoMasCaro.getPrecio()) > 0) {

                        equipoMasCaro = h;
                    }
                }
            }

            if (contador > 0) {

                BigDecimal promedio = total.divide(
                        BigDecimal.valueOf(contador),
                        2,
                        RoundingMode.HALF_UP
                );

                respuesta.add(
                        new CategoriaResumenDTO(
                                categoria,
                                total,
                                promedio,
                                equipoMasCaro.getModelo()
                        )
                );
            }
        }

        return respuesta;
    }

    public List<CategoriaResumenDTO> procesarFuncional() {

        List<HardwareEntity> lista = generarHardware();

        LocalDate fechaLimite = LocalDate.now().minusYears(5);

        Map<String, List<HardwareEntity>> agrupados = lista.stream()
                .filter(h -> h.getEstado().equals("ACTIVO"))
                .filter(h -> h.getFechaCompra().isAfter(fechaLimite))
                .collect(Collectors.groupingBy(HardwareEntity::getCategoria));

        return agrupados.entrySet()
                .stream()
                .map(entry -> {

                    String categoria = entry.getKey();
                    List<HardwareEntity> equipos = entry.getValue();

                    BigDecimal total = equipos.stream()
                            .map(HardwareEntity::getPrecio)
                            .reduce(BigDecimal.ZERO, BigDecimal::add);

                    BigDecimal promedio = total.divide(
                            BigDecimal.valueOf(equipos.size()),
                            2,
                            RoundingMode.HALF_UP
                    );

                    HardwareEntity equipoMasCaro = equipos.stream()
                            .max(Comparator.comparing(HardwareEntity::getPrecio))
                            .orElse(null);

                    return new CategoriaResumenDTO(
                            categoria,
                            total,
                            promedio,
                            equipoMasCaro.getModelo()
                    );
                })
                .collect(Collectors.toList());
    }
}