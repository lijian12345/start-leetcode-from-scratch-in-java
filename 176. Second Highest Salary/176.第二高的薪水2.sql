--
-- @lc app=leetcode.cn id=176 lang=mysql
--
-- [176] 第二高的薪水
--

-- @lc code=start
# Write your MySQL query statement below

SELECT ifnull(
        (
            SELECT DISTINCT Salary
            FROM Employee
            ORDER BY Salary DESC
            LIMIT 1 OFFSET 1
        ),
        NULL
    ) AS SecondHighestSalary
    
-- @lc code=end

