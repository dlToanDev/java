CREATE DATABASE TimeManager;
GO

USE TimeManager;
GO

CREATE TABLE Users (
    id INT IDENTITY(1,1) PRIMARY KEY,
    username NVARCHAR(50) UNIQUE NOT NULL,
    password NVARCHAR(255) NOT NULL
);

CREATE TABLE Schedule (
    id INT IDENTITY(1,1) PRIMARY KEY,
    user_id INT NOT NULL,
    day_of_week NVARCHAR(20),
    title NVARCHAR(100),
    start_time TIME,
    end_time TIME,
    note NVARCHAR(255),
    FOREIGN KEY (user_id) REFERENCES Users(id)
);
