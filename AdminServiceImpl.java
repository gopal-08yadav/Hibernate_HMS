package com.hms.serviceImp;


import com.hms.Admin;
import com.hms.Dao.AdminDao;
import com.hms.DaoImp.AdminDaoImpl;
import Services.AdminService;

public class AdminServiceImpl implements AdminService {

    private AdminDao adminDao = new AdminDaoImpl();

    @Override
    public boolean authenticateAdmin(String username, String password) {
        Admin admin = adminDao.getAdminByUsername(username);
        if (admin != null) {
            // In a real application, use hashed passwords
            return admin.getPassword().equals(password);
        }
        return false;
    }

    @Override
    public void registerAdmin(Admin admin) {
        // Hash password before saving
        // admin.setPassword(hashPassword(admin.getPassword()));
        adminDao.saveAdmin(admin);
    }

    @Override
    public Admin getAdminByUsername(String username) {
        return adminDao.getAdminByUsername(username);
    }

    // Example of password hashing method (use a library for production)
    // private String hashPassword(String password) {
    //     return BCrypt.hashpw(password, BCrypt.gensalt());
    // }
}
