package com.maria.ass1.business.service;


import com.maria.ass1.model.user.Admin;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.util.List;

@Service
public interface AdminService {
    Admin saveAdmin(@Valid AdminService adminDto);
    List<Admin> getAllAdmins();
    Admin getAdminById(Long id);
    Admin updateAdmin(AdminService adminDto);
    void deleteAdmin(Long id);
    Admin findByUserName(AdminService authDTO);

}
