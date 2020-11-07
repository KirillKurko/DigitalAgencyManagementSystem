package model.DAOs.employees.employeesUtilities.implementations;

import model.DAOs.employees.employeesUtilities.interfaces.ResourceDAO;
import model.beans.employees.employeesUtilities.Resource;
import utilities.DatabaseUtility;

import java.sql.*;

public class ResourceDAOImplementation implements ResourceDAO {

    private static final String INSERT_RESOURCE = "INSERT INTO Resource(name, description, link) VALUES (?, ?, ?);";
    private static final String UPDATE_RESOURCE = "UPDATE Resource SET name = ?, description = ?, link = ? WHERE id = ?;";
    private static final String SELECT_RESOURCE = "SELECT * FROM Resource WHERE id = ?;";
    private static final String DELETE_RESOURCE = "DELETE FROM Resource WHERE id = ?;";

    @Override
    public int insertResource(Resource resource) {
        int id = 0;
        try (Connection connection = DatabaseUtility.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_RESOURCE, Statement.RETURN_GENERATED_KEYS)) {
            preparedStatement.setString(1, resource.getName());
            preparedStatement.setString(2, resource.getDescription());
            preparedStatement.setString(3, resource.getLink());
            preparedStatement.executeUpdate();
            ResultSet resultSet = preparedStatement.getGeneratedKeys();
            while (resultSet.next()) {
                id = resultSet.getInt(1);
            }
        }
        catch (SQLException exception) {
            exception.printStackTrace();
        }
        return id;
    }

    @Override
    public boolean updateResource(Resource resource) {
        boolean rowUpdated = false;
        try (Connection connection = DatabaseUtility.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_RESOURCE)) {
            preparedStatement.setString(1, resource.getName());
            preparedStatement.setString(2, resource.getDescription());
            preparedStatement.setString(3, resource.getLink());
            rowUpdated = preparedStatement.executeUpdate() > 0;
        }
        catch (SQLException exception) {
            exception.printStackTrace();
        }
        return rowUpdated;
    }

    @Override
    public Resource selectResource(int id) {
        Resource resource = null;
        try (Connection connection = DatabaseUtility.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_RESOURCE)) {
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String name = resultSet.getString("name");
                String description = resultSet.getString("description");
                String link = resultSet.getString("link");
                resource = new Resource(id, name, description, link);
            }
        }
        catch (SQLException exception) {
            exception.printStackTrace();
        }
        return resource;
    }

    @Override
    public boolean deleteResource(int id) {
        boolean rowDeleted = false;
        try (Connection connection = DatabaseUtility.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(DELETE_RESOURCE)) {
            preparedStatement.setInt(1, id);
            rowDeleted = preparedStatement.executeUpdate() > 0;
        }
        catch (SQLException exception) {
            exception.printStackTrace();
        }
        return rowDeleted;
    }
}
