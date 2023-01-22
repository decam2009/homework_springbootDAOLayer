
select product_name from orders a
left join customers c on c.id = a.customer_id
where lower(c.name) = lower(:name)
group by a.product_name;

