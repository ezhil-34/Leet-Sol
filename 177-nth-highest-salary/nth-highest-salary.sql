CREATE FUNCTION getNthHighestSalary(N IN NUMBER) RETURN NUMBER IS
result NUMBER;
BEGIN
    /* Write your PL/SQL query statement below */
    SELECT MAX(salary) into result from
        (SELECT salary, DENSE_RANK() over (ORDER BY salary DESC) rnk from Employee) 
        WHERE rnk = N;

    RETURN result;
END;