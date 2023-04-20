-- 11. Hollywood is remaking the classic movie "The Blob" and doesn't have a director yet. Add yourself to the person table, and assign yourself as the director of "The Blob" (the movie is already in the movie table). (1 record each)
insert into person (person_name, birthday)
values ('Travis Nyland', '1996-08-29');

Update movie
set director_id = (select person_id From person Where person_name = 'Travis Nyland')
where title = 'The Blob';
