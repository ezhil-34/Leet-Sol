/* Write your PL/SQL query statement below */
SELECT w1.id as id FROM Weather w1 
    join  Weather w2 on w1.recordDate = w2.recordDate+1
    WHERE w1.temperature>w2.temperature;