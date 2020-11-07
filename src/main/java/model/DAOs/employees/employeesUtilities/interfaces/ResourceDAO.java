package model.DAOs.employees.employeesUtilities.interfaces;

import model.beans.employees.employeesUtilities.Resource;

public interface ResourceDAO {

    int insertResource(Resource resource);

    boolean updateResource(Resource resource);

    Resource selectResource(int id);

    boolean deleteResource(int id);
}
