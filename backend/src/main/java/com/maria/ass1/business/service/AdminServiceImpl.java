package com.maria.ass1.business.service;


import com.maria.ass1.exception.ResourceNotFoundException;
import com.maria.ass1.model.user.Admin;
import com.maria.ass1.repository.AdminRepository;
import org.springframework.http.HttpStatus;

import org.springframework.stereotype.Service;

import javax.validation.ConstraintViolationException;
import javax.validation.Valid;
import java.util.List;
import java.util.Observable;
import java.util.Observer;


@Service
public class AdminServiceImpl implements AdminService, Observer {
    private final AdminRepository adminRepository;
    private static int orderNumber = 0;

    public AdminServiceImpl(AdminRepository adminRepository){
        this.adminRepository=adminRepository;

    }
    @Override
    public Admin saveAdmin(@Valid AdminService adminDto) throws ConstraintViolationException {
        Admin admin=new Admin();

        return adminRepository.save(admin);
    }

    @Override
    public List<Admin> getAllAdmins() {
        return adminRepository.findAll();
    }

    @Override
    public Admin getAdminById(Long id) {
        return adminRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Admin","Id",id,HttpStatus.NOT_FOUND));
    }

    @Override
    public Admin updateAdmin(AdminService adminDto) {

        Admin existingAdmin=adminRepository.findById(adminDto.getAllAdmins().get(0).getId()).orElseThrow(()->new ResourceNotFoundException("Admin","Id",adminDto.getAllAdmins().get(0),HttpStatus.NOT_FOUND));
        if(adminDto.getAllAdmins().get(0)!=null) {
            existingAdmin.setUsername(adminDto.getAllAdmins().get(0).getUsername());
        }
        if(adminDto.getAllAdmins().get(0)!=null) {
            existingAdmin.setName(adminDto.getAllAdmins().get(0).getName());
        }

        if(adminDto.getAllAdmins().get(0)!=null) {
            existingAdmin.setPassword(adminDto.getAllAdmins().get(0).getPassword());
        }

        if(adminDto.getAllAdmins().get(0)!=null) {
            existingAdmin.setEmail(adminDto.getAllAdmins().get(0).getEmail());
        }
        adminRepository.save(existingAdmin);
        return existingAdmin;
    }

    @Override
    public void deleteAdmin(Long id) {
        adminRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Admin","Id",id,HttpStatus.NOT_FOUND));
        adminRepository.deleteById(id);
    }

    @Override
    public Admin findByUserName(AdminService authDTO) {
        Admin admin=adminRepository.findByUserName(authDTO.getAllAdmins().get(0).getName());
        if(admin==null){
            throw new ResourceNotFoundException("Admin","Username",authDTO.getAllAdmins().get(0).getName(), HttpStatus.NOT_FOUND);
        }else{
            if(this.getAdminById(0L).getPassword().matches(authDTO.getAllAdmins().get(0).getPassword())){

            }
            else{
                throw new ResourceNotFoundException("Customer","Username",authDTO.getAllAdmins().get(0).getUsername(), HttpStatus.NOT_FOUND);
            }
        }
        return admin;
    }

    @Override
    public void update(Observable o, Object arg) {
       orderNumber++;
       String nameFile="chitanta"+orderNumber;
       String[] string=(String[])arg;
       String[] parts = string[1].split("/");
       System.out.println(parts[0]);
       System.out.println(parts[1]);
       String message="Dear, "+parts[0]+"\n"+"Good news!\n" + "Your order is ready for delivery! Thank you for buying from us.";

    }
}
