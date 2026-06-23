# Write your MySQL query statement below
SELECT id,visit_date,people FROM (
    SELECT id,visit_date,people,
        LAG(people,1) OVER (ORDER BY id) p1,
        LAG(people,2) OVER (ORDER BY id) p2,
        LEAD(people,1) OVER (ORDER BY id) n1,
        LEAD(people,2) OVER (ORDER BY id) n2
        FROM Stadium
) t
WHERE people>=100
 
    AND(
        (people>=100 AND p1>=100 AND p2>=100)
    OR  (people>=100 AND p1>=100 AND n1>=100)
     OR  (people>=100 AND n1>=100 AND n2>=100)
    )

    ORDER BY visit_date;
