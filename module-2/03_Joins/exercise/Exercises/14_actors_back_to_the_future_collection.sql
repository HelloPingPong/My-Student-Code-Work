-- 14. The names of actors who've appeared in the movies in the "Back to the Future Collection", sorted alphabetically.
-- (28 rows)
select distinct person_name
from person
join movie_actor on person.person_id = movie_actor.actor_id
join movie on movie_actor.movie_id = movie.movie_id
join collection on movie.collection_id = collection.collection_id
where collection_name = 'Back to the Future Collection'
order by person_name;
