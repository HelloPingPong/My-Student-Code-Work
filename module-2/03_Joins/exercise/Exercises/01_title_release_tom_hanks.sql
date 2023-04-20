-- 1. The titles and release dates of movies that Tom Hanks has appeared in. 
-- Order the results by release date, newest to oldest.
-- (47 rows)
select title, release_date
from movie
join movie_actor ON movie.movie_id = movie_actor.movie_id
join person on person.person_id = movie_actor.actor_id
where person_name = 'Tom Hanks'
order by release_date DESC
