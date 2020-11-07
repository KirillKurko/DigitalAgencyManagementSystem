package model.DAOs.employees.employeesUtilities.implementations;

import model.DAOs.employees.employeesUtilities.interfaces.ToolDAO;
import model.beans.employees.employeesUtilities.Tool;
import utilities.DatabaseUtility;
import java.sql.*;

public class ToolDAOImplementation implements ToolDAO {

    private static final String INSERT_TOOL = "INSERT INTO Tool(name, description) VALUES (?, ?);";
    private static final String UPDATE_TOOL = "UPDATE Tool SET name = ?, description = ? WHERE id = ?;";
    private static final String SELECT_TOOL = "SELECT * FROM Tool WHERE id = ?;";
    private static final String DELETE_TOOL = "DELETE FROM Tool WHERE id = ?;";

    @Override
    public int insertTool(Tool tool) {
        int id = 0;
        try (Connection connection = DatabaseUtility.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_TOOL, Statement.RETURN_GENERATED_KEYS)) {
            preparedStatement.setString(1, tool.getName());
            preparedStatement.setString(2, tool.getDescription());
            preparedStatement.executeUpdate();
            ResultSet resultSet = preparedStatement.getGeneratedKeys();
            while (resultSet.next()) {
                id = resultSet.getInt(1);
            }
        }
        catch (SQLException exception) {
            exception.printStackTrace();
        }
        return 0;
    }

    @Override
    public boolean updateTool(Tool tool) {
        boolean rowUpdated = false;
        try (Connection connection = DatabaseUtility.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_TOOL)) {
            preparedStatement.setString(1, tool.getName());
            preparedStatement.setString(2, tool.getDescription());
            rowUpdated = preparedStatement.executeUpdate() > 0;
        }
        catch (SQLException exception) {
            exception.printStackTrace();
        }
        return rowUpdated;
    }

    @Override
    public Tool selectTool(int id) {
        Tool tool = null;
        try (Connection connection = DatabaseUtility.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_TOOL)) {
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String name = resultSet.getString("name");
                String description = resultSet.getString("description");
                tool = new Tool(id, name, description);
            }
        }
        catch (SQLException exception) {
            exception.printStackTrace();
        }
        return tool;
    }

    @Override
    public boolean deleteTool(int id) {
        boolean rowDeleted = false;
        try (Connection connection = DatabaseUtility.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(DELETE_TOOL)) {
            preparedStatement.setInt(1, id);
            rowDeleted = preparedStatement.executeUpdate() > 0;
        }
        catch (SQLException exception) {
            exception.printStackTrace();
        }
        return rowDeleted;
    }
}
