package Services;



import com.hms.Admin;

public interface AdminService {
    boolean authenticateAdmin(String username, String password);
    void registerAdmin(Admin admin);
    Admin getAdminByUsername(String username);
}
