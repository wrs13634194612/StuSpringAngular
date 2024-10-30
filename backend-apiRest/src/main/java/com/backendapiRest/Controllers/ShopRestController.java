package com.backendapiRest.Controllers;



import com.backendapiRest.models.Services.IShopService;
import com.backendapiRest.models.entity.Cliente;
import com.backendapiRest.models.entity.Shop;
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
public class ShopRestController {

    @Autowired
    private IShopService   shopService;

    private final Logger log = LoggerFactory.getLogger(ClienteRestController.class);

    @GetMapping("/shop")
    public List<Shop> index() {
        return shopService.finAll();
    }

    @PostMapping("/shopadd")
    //@ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<?> create(@Valid @RequestBody Shop shop, BindingResult result) {
        Shop shop2 = null;
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
            shop2 = shopService.save(shop);
        } catch (DataAccessException e) {
            response.put("mensaje", "Error al realizar el insert en la base de datos");
            response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        response.put("mensaje", "El shop ha sido creado con éxito!");
        response.put("water", shop2);
        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
    }



    @PostMapping("/shopupdate/{id}")
    //@ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<?>  update(@Valid @RequestBody Shop shop, BindingResult result, @PathVariable Long id){
        Shop shopActual= shopService.findById(id);
        Shop shopUpdated = null;
        Map<String, Object> response = new HashMap<>();
        if (result.hasErrors()){
            List<String> errors = result.getFieldErrors()
                    .stream()
                    .map(err -> "El campo " + err.getField() + " " + err.getDefaultMessage()
                    ).collect(Collectors.toList());
            response.put("errors", errors);
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.BAD_REQUEST);
        }
        if (shopActual == null){
            response.put("mensaje", "Error, no se pudo editar, el water con el Id: ".concat(id.toString().concat(" No Existe en la base de datos")));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
        }
        try{
            shopActual.setPosition(shop.getPosition());
            shopActual.setName(shop.getName());
            shopActual.setIcon(shop.getIcon());
            shopActual.setPhone(shop.getPhone());
            shopActual.setAddress(shop.getAddress());
            shopUpdated =shopService.save(shopActual);
        }catch (DataAccessException e){
            response.put("mensaje", "Error al actualizar el water en la base de datos");
            response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        response.put("mensaje","El water ha sido actualizado con éxito!");
        response.put("water", shopUpdated);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }


    @PostMapping("/shopdelete/{id}")
    //@ResponseStatus(HttpStatus.NO_CONTENT)
    public ResponseEntity<?> delete(@PathVariable Long id){
        Map<String, Object> response = new HashMap<>();
        try{
            shopService.delete(id);
        }catch (DataAccessException e){
            response.put("mensaje", "Error al Eliminar el cliente de la base de datos");
            response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        response.put("mensaje","El cliente ha sido eliminado con éxito!");
        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
    }

}