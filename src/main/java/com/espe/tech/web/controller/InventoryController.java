package com.espe.tech.web.controller;

import com.espe.tech.ai.AiService;
import com.espe.tech.dto.CategoriaResumenDTO;
import com.espe.tech.service.InventoryService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class InventoryController {

    private final InventoryService inventoryService;
    private final AiService aiService;

    public InventoryController(InventoryService inventoryService, AiService aiService) {
        this.inventoryService = inventoryService;
        this.aiService = aiService;
    }

    @GetMapping("/inventario/imperativo")
    public List<CategoriaResumenDTO> reporteImperativo() {
        return inventoryService.procesarImperativo();
    }

    @GetMapping("/inventario/funcional")
    public List<CategoriaResumenDTO> reporteFuncional() {
        return inventoryService.procesarFuncional();
    }

    @GetMapping("/inventario/resumen-ai")
    public String resumenAi() {
        return aiService.generarResumen();
    }
}
