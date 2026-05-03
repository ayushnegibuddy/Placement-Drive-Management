package service;

import dao.CompanyDAO;
import model.Company;

public class CompanyService {
    private CompanyDAO companyDAO;

    public CompanyService() {
        this.companyDAO = new CompanyDAO();
    }

    public boolean registerCompany(String name, String location) {
        if (name == null || name.trim().isEmpty() || location == null || location.trim().isEmpty()) {
            return false;
        }
        Company company = new Company(0, name, location);
        return companyDAO.addCompany(company);
    }
}
