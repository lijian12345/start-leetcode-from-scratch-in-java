--
-- @lc app=leetcode.cn id=175 lang=mysql
--
-- [175] 组合两个表
--

-- @lc code=start
# Write your MySQL query statement below
select p.FirstName,
    p.LastName,
    a.City,
    a.State
from Person p
    left join Address a on p.PersonId = a.PersonId;
-- @lc code=end

