/* Write your PL/SQL query statement below */
SELECT score, 
    DENSE_RANK() over (ORDER BY score DESC) AS rank from Scores 
    ORDER BY score DESC;