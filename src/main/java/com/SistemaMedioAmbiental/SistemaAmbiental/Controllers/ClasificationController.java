package com.SistemaMedioAmbiental.SistemaAmbiental.Controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.http.HttpStatus;
import com.SistemaMedioAmbiental.SistemaAmbiental.Message.Exception.ResourceNotFoundException;
import com.SistemaMedioAmbiental.SistemaAmbiental.Models.Clasification;
import com.SistemaMedioAmbiental.SistemaAmbiental.Repositories.ClasificationRepository;
import com.SistemaMedioAmbiental.SistemaAmbiental.Repositories.SubDistrictRepository;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api")
@Api(value = "Clasification Management", description = "Operations pertaining to classifications in Classification Management")

public class ClasificationController {
    @Autowired
    ClasificationRepository clasificationRepository;
    @Autowired
    SubDistrictRepository subDistrictRepository;


    @ApiOperation(value = "View a list of available classifications", response = List.class)
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "Successfully retrieved list of classifications"),
        @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
        @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
        @ApiResponse(code = 404, message = "The resource you were trying to reach has not been found") })
    @GetMapping("/clasification")
    public List<Clasification> showClasification() {
        return clasificationRepository.findAll();
    }

    @ApiOperation(value = "Get a classification by Id")
    @GetMapping("/clasification/{id}")
    public Optional<Clasification> showClasification(@PathVariable("id") Long id) {
        return clasificationRepository.findById(id);
    }

    @ApiOperation(value = "View a list of classifications of it's respective subdistrict", response = List.class)
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "Successfully retrieved list of classifications"),
        @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
        @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
        @ApiResponse(code = 404, message = "The resource you were trying to reach has not been found") })
    @GetMapping("/{id}/clasification")
    public List<Clasification> showClasificationsSubDistrict(@PathVariable("id") Long id) {
       List<Clasification> clas= clasificationRepository.findAll();
       List<Clasification> aux= new ArrayList<>();
        for(Integer i = 0;i< clas.size();i++){
            if(clas.get(i).getSubDistrict().getId() == id ){
                aux.add(clas.get(i));
            }
        } 
        return aux;
    }

    @ApiOperation(value = "Add a classification")
    @PostMapping("/{id}/clasification")
    @ResponseStatus(HttpStatus.CREATED)
    public Clasification create(@RequestBody Clasification cl,@PathVariable("id") Long id) {
        return subDistrictRepository.findById(id).map(sd ->{
            cl.setSubDistrict(sd);
            return clasificationRepository.save(cl);
        }).orElseThrow(() -> new ResourceNotFoundException("Sub District " + id + " not found"));
    }

    @ApiOperation(value = "Update a classification")
    @PutMapping("/clasification/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Clasification update(@PathVariable( "id" ) Long id, @RequestBody Clasification cl) {
        
        return clasificationRepository.findById(id)
                .map(clT -> {
                    clT.setName(cl.getName());
                    clT.setInformation(cl.getInformation());
                    clT.setSubDistrict(cl.getSubDistrict());
                    return clasificationRepository.save(cl);
                }).orElseThrow(() -> new ResourceNotFoundException("Clasification not found with id " + id));
    }
    
    @ApiOperation(value = "Delete a classification")
    @DeleteMapping(value = "/clasification/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable("id") Long id) {
        clasificationRepository.deleteById(id);
    }


}