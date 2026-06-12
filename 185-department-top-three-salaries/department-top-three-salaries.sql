/* Write your PL/SQL query statement below */
SELECT d.name as Department,
        e.name as Employee,
        e.salary as Salary 
        FROM (
            SELECT name,salary,departmentId,
                DENSE_RANK() OVER ( PARTITION BY departmentId ORDER BY salary DESC) as rnk
                FROM Employee
        ) e
        join Department d on e.departmentId = d.id
        WHERE e.rnk<=3;