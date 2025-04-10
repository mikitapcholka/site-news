# Use official MySQL image from Docker Hub
FROM mysql:8.0

# Set environment variables for MySQL
ENV MYSQL_ROOT_PASSWORD=rootpassword
#ENV MYSQL_DATABASE=site-news-db

# Copy the db.sql file into the container (this will be used to initialize the database)
COPY db.sql /docker-entrypoint-initdb.d/

# Expose MySQL port
EXPOSE 3306