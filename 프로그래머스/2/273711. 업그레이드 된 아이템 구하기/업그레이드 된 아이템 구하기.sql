-- 코드를 작성해주세요
select i.item_id as 'ITEM_ID', i.item_name as 'ITEM_NAME' , i.rarity as 'RARITY'
from item_info i
inner join item_tree t
on i.item_id = t.item_id
where t.parent_item_id in(
    select item_id
    from item_info
    where rarity = 'RARE'
)
order by i.item_id desc
;