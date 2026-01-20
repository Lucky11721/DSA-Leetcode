# Write your MySQL query statement below

select E.name from Employee E
join Employee M
on M.managerId = E.id
group by M.managerId
having count(M.managerId) >= 5

