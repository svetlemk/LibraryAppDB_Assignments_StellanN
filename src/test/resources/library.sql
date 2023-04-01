
-- US 01
select count(id) from users; --
-- 1855

select count(distinct id) from users;
-- 1855


-- RESULT --> MANUALLY IT IS PASSED


-- US02 VASYL ---------------------
select * from users;


select * from books;
=======
SELECT count(book_id) from book_borrow
WHERE returned_date IS NULL;



-- US 03
select count(*) from book_borrow
where is_returned=0;


--US 04

SELECT name FROM book_categories;

SELECT name, isbn , year , author from books;

