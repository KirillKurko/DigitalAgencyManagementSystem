CREATE DATABASE DigitalAgencies;

USE DigitalAgencies;

CREATE TABLE User (
	ID INT AUTO_INCREMENT PRIMARY KEY,
    login VARCHAR(30) NOT NULL,
    password VARCHAR(40) NOT NULL,
    email VARCHAR(50) NOT NULL,
    hash VARCHAR(255),
    activated BOOLEAN DEFAULT FALSE
);

CREATE TABLE Employee (
	ID INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(50) NOT NULL,
    surname VARCHAR(50) NOT NULL,
    experience INT NOT NULL,
    salary DOUBLE NOT NULL,
    userID INT NOT NULL,
    projectID INT,
	CONSTRAINT FK_UserEmployee FOREIGN KEY (userID) REFERENCES User(ID),
    CONSTRAINT FK_ProjectEmployee FOREIGN KEY (projectID) REFERENCES Project(ID)
);

CREATE TABLE Director (
	ID INT AUTO_INCREMENT PRIMARY KEY,
	finances DOUBLE NOT NULL,
    employeeID INT NOT NULL,
    CONSTRAINT FK_EmployeePublisher FOREIGN KEY (employeeID) REFERENCES Employee(ID)
);

CREATE TABLE Tool (
	ID INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(50) NOT NULL,
    description VARCHAR(200) NOT NULL
);

CREATE TABLE EmployeesTools (
	employeeID INT,
    toolID INT,
	PRIMARY KEY (employeeID, toolID),
    CONSTRAINT FK_Employee_EmployeesTools FOREIGN KEY (employeeID) REFERENCES Employee(ID),
    CONSTRAINT FK_Tool_EmployeesTools FOREIGN KEY (toolID) REFERENCES Tool(ID)
);

CREATE TABLE Resource (
	ID INT AUTO_INCREMENT PRIMARY KEY,
	name VARCHAR(50) NOT NULL,
    description VARCHAR(200) NOT NULL,
    link VARCHAR(150) NOT NULL
);

CREATE TABLE EmployeesResources (
	employeeID INT,
    resourceID INT,
	PRIMARY KEY (employeeID, resourceID),
    CONSTRAINT FK_Employee_EmployeesResources FOREIGN KEY (employeeID) REFERENCES Employee(ID),
    CONSTRAINT FK_Resource_EmployeesResources FOREIGN KEY (resourceID) REFERENCES Resource(ID)
);

CREATE TABLE Designer (
	ID INT AUTO_INCREMENT PRIMARY KEY,
    specialEducation BOOLEAN NOT NULL DEFAULT FALSE,
	employeeID INT NOT NULL,
    CONSTRAINT FK_DesignerEmoloyee FOREIGN KEY (employeeID) REFERENCES Employee(ID)
);

CREATE TABLE Copywriter (
	ID INT AUTO_INCREMENT PRIMARY KEY,
    mainStyle VARCHAR(50) NOT NULL,
	employeeID INT NOT NULL,
    CONSTRAINT FK_EmployeeCopywriter FOREIGN KEY (employeeID) REFERENCES Employee(ID)
);

CREATE TABLE Role (
	ID INT AUTO_INCREMENT PRIMARY KEY,
    description VARCHAR(255) NOT NULL
);

CREATE TABLE Permission (
	ID INT AUTO_INCREMENT PRIMARY KEY,
    description VARCHAR(255) NOT NULL
);

CREATE TABLE RolesPermissions (
	roleID INT,
    permissionID INT,
    PRIMARY KEY (roleID, permissionID),
    CONSTRAINT FK_Role_RolesPermissions FOREIGN KEY (roleID) REFERENCES Role(ID),
    CONSTRAINT FK_Permission_RolesPermissions FOREIGN KEY (permissionID) REFERENCES Permission(ID)
);

CREATE TABLE EmployeesRoles (
	employeeID INT,
    roleID INT,
	PRIMARY KEY (employeeID, roleID),
    CONSTRAINT FK_Employee_EmployeesRoles FOREIGN KEY (employeeID) REFERENCES Employee(ID),
    CONSTRAINT FK_Role_EmployeesRoles FOREIGN KEY (roleID) REFERENCES Role(ID)
);

CREATE TABLE DigitalAgency (
	ID INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(50) NOT NULL,
    email VARCHAR(50) NOT NULL,
    description VARCHAR(255),
	directorID INT NOT NULL,
    CONSTRAINT FK_Director_DigitalAgency FOREIGN KEY (directorID) REFERENCES Director(ID)
);

CREATE TABLE Project (
	ID INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(50) NOT NULL,
    description VARCHAR(300) NOT NULL,
	budget DOUBLE NOT NULL
);

CREATE TABLE Task (
	ID INT AUTO_INCREMENT PRIMARY KEY,
    description VARCHAR(255) NOT NULL,
    employeeID INT NOT NULL,
    CONSTRAINT FK_EmployeeTask FOREIGN KEY (employeeID) REFERENCES Employee(ID)
);

CREATE TABLE Heading (
	ID INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(50) NOT NULL,
    description VARCHAR(300) NOT NULL,
    periodicity VARCHAR(300) NOT NULL
);

CREATE TABLE ProjectsHeadings (
	projectID INT,
    headingID INT,
	PRIMARY KEY (projectID, headingID),
    CONSTRAINT FK_Project_ProjectsHeadings FOREIGN KEY (projectID) REFERENCES Project(ID),
    CONSTRAINT FK_Heading_ProjectsHeadings FOREIGN KEY (headingID) REFERENCES Heading(ID)
);
