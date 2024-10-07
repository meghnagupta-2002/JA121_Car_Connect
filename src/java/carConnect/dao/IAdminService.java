package carConnect.dao;

import java.sql.SQLException;

import carConnect.entity.Admin;
import carConnect.exception.AdminNotFoundException;

public interface IAdminService {
	//Declaration of Non-Implemented Methods
	Admin getAdminByID(int adminID) throws SQLException, AdminNotFoundException;
    Admin getAdminByUsername(String username) throws SQLException, AdminNotFoundException;
    void registerAdmin(Admin admin) throws SQLException;
    void updateAdmin(Admin admin) throws SQLException, AdminNotFoundException;
    void deleteAdmin(int adminID) throws SQLException, AdminNotFoundException;
}
