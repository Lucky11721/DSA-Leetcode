/* Write your T-SQL query statement below */


SELECT s.user_id, 
       ROUND(
            cast(SUM(CASE WHEN c.action = 'confirmed' THEN 1 ELSE 0 END) as decimal(10,2)) / 
            cast(COUNT(*) as decimal(10,2)), 
           2
       ) AS confirmation_rate 
FROM Signups s
LEFT JOIN Confirmations c ON s.user_id = c.user_id
GROUP BY s.user_id;
