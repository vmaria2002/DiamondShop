package com.maria.ass1.business.controller;

import com.maria.ass1.business.service.AdminService;
import com.maria.ass1.dao.AdminDAO;
import com.maria.ass1.model.user.Admin;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("api/admin")
public class AdminController {
    private final AdminService adminService;
    private final AdminDAO adminDAO;
    public AdminController(AdminService adminService, AdminDAO adminDAO){
        super();
        this.adminService=adminService;
        this.adminDAO = adminDAO;
    }
    @PostMapping()
    public ResponseEntity<?> saveAdmin(@RequestBody @Valid AdminService adminDto){
        try{return new ResponseEntity<>(adminService.saveAdmin(adminDto), HttpStatus.CREATED);}
        catch (DataIntegrityViolationException e) {
            return new ResponseEntity<>("Username is already used.", HttpStatus.BAD_REQUEST);
        }
    }


    @GetMapping("{id}")
    public ResponseEntity<Admin> getAdminById(@PathVariable("id") Long adminId){
        return new ResponseEntity<>(adminService.getAdminById(adminId), HttpStatus.OK);
    }
    @PutMapping()
    public ResponseEntity<Admin> updateAdmin (@RequestBody AdminService adminDto){
        adminDAO.findByLastName(adminDto.getAdminById(0L).getName());
        return new ResponseEntity<>(adminService.updateAdmin(adminDto), HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteAdmin(@PathVariable("id") Long id){
        //delete admin from database

        adminService.deleteAdmin(id);
        return new ResponseEntity<>("Admin deteted successfully.", HttpStatus.OK);
    }

    @PutMapping("/login")
    ResponseEntity<Admin> logIn(@RequestBody AdminService authDTO){
        return new ResponseEntity<>(adminService.findByUserName(authDTO),HttpStatus.OK);
    }


}
