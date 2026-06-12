/* Write your PL/SQL query statement below */
DELETE FROM Person 
    WHERE Id NOT IN ( 
        SELECT MIN(Id) from Person GROUP BY email 
    );