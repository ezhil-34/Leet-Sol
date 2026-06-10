/* Write your PL/SQL query statement below */
 
SELECT e.name as Employee from Employee e 
    JOIN Employee m on e.managerId = m.id 
    WHERE e.salary>m.salary;