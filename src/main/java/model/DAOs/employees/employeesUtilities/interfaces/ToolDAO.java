package model.DAOs.employees.employeesUtilities.interfaces;

import model.beans.employees.employeesUtilities.Tool;

public interface ToolDAO {

    int insertTool(Tool tool);

    boolean updateTool(Tool tool);

    Tool selectTool(int id);

    boolean deleteTool(int id);
}
