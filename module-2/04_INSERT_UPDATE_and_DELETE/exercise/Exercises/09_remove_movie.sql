-- 9. Remove "Memento" from the movie table
-- You'll have to remove data from two other tables before you can remove it (13 rows, 2 rows, 1 row)

delete from movie_genre
where movie_id = (select movie_id From movie Where title = 'Memento');

delete from movie_actor
where movie_id = (select movie_id From movie Where title = 'Memento');

delete from movie
where movie_id = (select movie_id From movie Where title = 'Memento');
