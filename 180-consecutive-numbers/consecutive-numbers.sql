/* Write your PL/SQL query statement below */
SELECT DISTINCT num as ConsecutiveNums from 
    (SELECT num, 
        LAG(num,1) OVER (ORDER BY id) as prev1,
        LAG(num,2) OVER (ORDER BY id) as prev2
        FROM Logs)

    WHERE num = prev1
    AND num = prev2;