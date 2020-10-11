/* Write your T-SQL query statement below */


--SHORT SOLUTION
select MAX(Salary) as SecondHighestSalary from Employee where salary < (select MAX(Salary) from Employee)


--MSSQL SOLUTION
/*
WITH T AS (
SELECT * ,DENSE_RANK() OVER (ORDER BY Salary Desc) as Rank from Employee
)

Select Salary as SecondHighestSalary from T where Rank=2
*/


/* THIS IS ALSO ONE OPTION
Select Salary as SecondHighestSalary from (
    select *  from (

        Select top 2 Salary, DENSE_RANK() OVER(ORDER BY Salary Desc) Rank from Employee order by salary desc
    ) tmpInternal where Rank=2
) tmp

*/
SELECT MAX(Salary) SecondHighestSalary
FROM Employee e1
WHERE (SELECT COUNT(DISTINCT Salary) FROM Employee e2 WHERE e2.Salary > e1.Salary) = 1;
