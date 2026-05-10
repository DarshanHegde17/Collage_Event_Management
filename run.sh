#!/bin/bash

echo "========================================"
echo "College Event Management System"
echo "========================================"
echo ""
echo "Starting the application..."
echo ""
echo "Make sure MongoDB is running on localhost:27017"
echo ""
echo "Building the project..."
mvn clean install
echo ""
echo "Starting Spring Boot application..."
mvn spring-boot:run
