/* Write your PL/SQL query statement below */
 select p.firstName, p.lastName, a.city, a.state from person p left join address a on p.personId = a.personId;