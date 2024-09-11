package com.hms.Dao;



import com.hms.Admin;

public interface AdminDao {
    void saveAdmin(Admin admin);
    Admin getAdminByUsername(String username);
}
