-- 10. The names of directors who have directed a movie over 3 hours [180 minutes], sorted alphabetically.
-- (15 rows)
select distinct person_name
from person
join movie on person.person_id = movie.director_id
where length_minutes > 180
order by person_name;

