package com.backendapiRest.Controllers;


import com.backendapiRest.models.Services.IWaterService;
import com.backendapiRest.models.entity.Water;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.dao.DataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import javax.xml.crypto.Data;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;

@CrossOrigin(origins = {"http://localhost:4200"})
@RestController
@RequestMapping("/api")
public class WaterRestController {

    @Autowired
    private IWaterService waterService;

    private final Logger log = LoggerFactory.getLogger(WaterRestController.class);

    @GetMapping("/water")
    public List<Water> index() {
        return waterService.finAll();
    }

    @PostMapping("/wateradd")
    //@ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<?> create(@Valid @RequestBody Water water, BindingResult result) {
        Water water2 = null;
        Map<String, Object> response = new HashMap<>();

        if (result.hasErrors()) {
            List<String> errors = result.getFieldErrors()
                    .stream()
                    .map(err -> "El campo " + err.getField() + " " + err.getDefaultMessage()
                    ).collect(Collectors.toList());

            response.put("errors", errors);
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.BAD_REQUEST);
        }
        try {
            water2 = waterService.save(water);
        } catch (DataAccessException e) {
            response.put("mensaje", "Error al realizar el insert en la base de datos");
            response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        response.put("mensaje", "El water ha sido creado con éxito!");
        response.put("water", water2);
        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
    }



    @PostMapping("/waterupdate/{id}")
    //@ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<?>  update(@Valid @RequestBody Water water, BindingResult result, @PathVariable Long id){
        Water waterActual= waterService.findById(id);
        Water waterUpdated = null;
        Map<String, Object> response = new HashMap<>();
        if (result.hasErrors()){
            List<String> errors = result.getFieldErrors()
                    .stream()
                    .map(err -> "El campo " + err.getField() + " " + err.getDefaultMessage()
                    ).collect(Collectors.toList());
            response.put("errors", errors);
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.BAD_REQUEST);
        }
        if (waterActual == null){
            response.put("mensaje", "Error, no se pudo editar, el water con el Id: ".concat(id.toString().concat(" No Existe en la base de datos")));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
        }
        try{
            waterActual.setWatername(water.getWatername());
            waterActual.setWatericon(water.getWatericon());
            waterActual.setWaterstyle(water.getWaterstyle());
            waterActual.setWatersize(water.getWatersize());
            waterActual.setWaterprice(water.getWaterprice());
            waterActual.setShopaccount(water.getShopaccount());
            waterActual.setShopname(water.getShopname());
            waterUpdated =waterService.save(waterActual);
        }catch (DataAccessException e){
            response.put("mensaje", "Error al actualizar el water en la base de datos");
            response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        response.put("mensaje","El water ha sido actualizado con éxito!");
        response.put("water", waterUpdated);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }




}