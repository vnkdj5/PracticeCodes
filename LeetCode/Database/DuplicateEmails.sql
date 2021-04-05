/* Write your T-SQL query statement below */
Select Email from Person group by Email having count(Email)>1
