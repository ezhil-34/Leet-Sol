# Write your MySQL query statement below
SELECT id,
    CASE 
        WHEN p_id is NULL THEN 'Root'
        WHEN id IN (SELECT p_id FROM Tree WHERE p_id is NOT NULL )
         THEN 'Inner'
         ELSE 'Leaf'
    END as type 
    FROM Tree;