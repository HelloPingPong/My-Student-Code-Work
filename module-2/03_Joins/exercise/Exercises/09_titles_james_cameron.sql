-- 9. The titles of movies directed by James Cameron, sorted alphabetically.
-- (6 rows)
select title
from movie
join person on movie.director_id = person.person_id
where person_name = 'James Cameron'
order by title;

