# Write your MySQL query statement below
SELECT p.firstName , 
p.lastname , 
a.city , 
a.state
from Person p left outer join Address a 
on p.personId = a.personId;