SELECT EmployeeUNI.unique_id, Employees.name 
FROM Employees 
LEFT JOIN 
EmployeeUNI Using (id)