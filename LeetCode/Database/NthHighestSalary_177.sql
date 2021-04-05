CREATE FUNCTION getNthHighestSalary(@N INT) RETURNS INT AS
BEGIN
    RETURN (
        /* Write your T-SQL query statement below. */
        select distinct Salary from (select *,DENSE_RANK() OVER (Order by Salary DESC) as Rnk from Employee) tmp where Rnk=@N
        
    );
END


/*


CREATE FUNCTION getNthHighestSalary(N INT) RETURNS INT
BEGIN
SET N=N-1;
  RETURN (
      # Write your MySQL query statement below.
      select distinct(salary) from Employee order by Salary Desc limit N, 1
  );
END

*/
