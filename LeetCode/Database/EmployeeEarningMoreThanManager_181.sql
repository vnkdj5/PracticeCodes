/* Write your T-SQL query statement below */

Select e.Name as Employee from Employee e 
inner join Employee e2 on e.ManagerId=e2.Id
where e.Salary> e2.Salary


/*
SELECT e.Name as Employee from Employee e, Employee e2 where e.ManagerId=e2.Id and e.Salary> e2.Salary

*/

/* --Simple Nester query
Select Name as Employee from Employee e where e.Salary > (Select Salary from Employee e2 where e2.Id=e.ManagerId)
*/
