package com.tpi_pais.mega_store.products.controller.talleController;

import com.tpi_pais.mega_store.exception.ResponseService;
import com.tpi_pais.mega_store.products.model.Talle;
import com.tpi_pais.mega_store.products.service.ITalleService;
import com.tpi_pais.mega_store.utils.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products")
public class DeleteTalleController {

    private final ITalleService modelService;

    private final ResponseService responseService;

    public DeleteTalleController(ITalleService modelService, ResponseService responseService) {
        this.modelService = modelService;
        this.responseService = responseService;
    }

    @DeleteMapping("/talle/{id}")
    public ResponseEntity<ApiResponse<Object>>  eliminar(@PathVariable Integer id) {
        Talle model = modelService.buscarPorId(id);
        modelService.eliminar(model);
        return responseService.successResponse(model, "Objeto eliminado");
    }
}