-- 13. The directors of the movies in the "Harry Potter Collection", sorted alphabetically.
-- (4 rows)
select distinct person_name
from person
join movie on person.person_id = movie.director_id
join collection on movie.collection_id = collection.collection_id
where collection_name = 'Harry Potter Collection'
order by person_name;
