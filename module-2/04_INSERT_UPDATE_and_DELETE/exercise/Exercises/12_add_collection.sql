-- 12. Create a "Bill Murray Collection" in the collection table. For the movies that have Bill Murray in them, set their collection ID to the "Bill Murray Collection". (1 row, 6 rows)

insert into collection (collection_name) values ('Bill Murray Collection');

UPDATE movie
set collection_id = (select collection_id from collection where collection_name = 'Bill Murray Collection')
where movie.movie_id in (select movie.movie_id from movie
  join movie_actor on movie.movie_id = movie_actor.movie_id
  join person on person.person_id = movie_actor.actor_id
  where person.person_name = 'Bill Murray');