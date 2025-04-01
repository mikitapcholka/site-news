-- Create the database "site-news-db"
CREATE DATABASE IF NOT EXISTS `site-news-db`;

-- Switch to the "site-news-db" database
USE `site-news-db`;

-- Create the "posts" table
CREATE TABLE IF NOT EXISTS `post` (
    `id` INT AUTO_INCREMENT PRIMARY KEY,    -- Unique identifier for each post
    `title` VARCHAR(255) NOT NULL,           -- Title of the post
    `description` TEXT,                         -- Short announcement or preview of the post
    `full_text` TEXT,                        -- Full content of the post
    `views` INT DEFAULT 0                    -- Number of views, initialized to 0
);

INSERT INTO `post` (`title`, `description`, `full_text`, `views`) VALUES
    ('Sample Post 1', 'This is a sample announcement for post 1.', 'This is the full text for post 1.', 0),
    ('Sample Post 2', 'This is a sample announcement for post 2.', 'This is the full text for post 2.', 0);