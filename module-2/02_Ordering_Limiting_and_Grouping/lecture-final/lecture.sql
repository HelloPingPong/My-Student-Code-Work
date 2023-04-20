-- ORDERING RESULTS

-- Populations of all states from largest to smallest.
SELECT state_name, population
FROM state
ORDER BY population DESC;

-- States sorted alphabetically (A-Z) within their census region. 
-- The census regions are sorted in reverse alphabetical (Z-A) order.
SELECT state_name, census_region 
FROM state
ORDER BY census_region DESC, state_name;

-- The biggest park by area
SELECT * 
FROM park
ORDER BY area DESC;


-- LIMITING RESULTS

-- The 10 largest cities by populations
SELECT city_name, population
FROM city
ORDER BY population DESC
LIMIT 10;

-- The 20 oldest parks from oldest to youngest in years, sorted alphabetically by name.
SELECT CURRENT_DATE - date_established AS age_in_days, park_name
FROM park
ORDER BY age_in_days DESC, park_name ASC
LIMIT 20;

SELECT (CURRENT_DATE - date_established) / 365 AS age_in_years, park_name
FROM park
ORDER BY age_in_years DESC, park_name ASC;

SELECT (date_part('year', CURRENT_DATE) - date_part('year', date_established)) AS age_in_years, park_name
FROM park
ORDER BY age_in_years DESC, park_name ASC;

-- CONCATENATING OUTPUTS

-- All city names and their state abbreviation.
SELECT (city_name || ', ' || state_abbreviation) AS city_and_state
FROM city
ORDER BY state_abbreviation ASC, population DESC;

-- The all parks by name and date established.
SELECT ('Name: ' || park_name || ' Date Established: ' || date_established) as park_and_date 
FROM park;

-- The census region and state name of all states in the West & Midwest sorted in ascending order.
SELECT (census_region || ': ' || state_name) AS region_and_state
FROM state
WHERE census_region IN ('West', 'Midwest')
ORDER BY census_region, state_name;

-- Database have built in functions, like ones that can help with numbers and do things like round or absolute value, etc.
SELECT round((area / population), 5)
FROM city;

SELECT round(10/3.0, 2);

-- AGGREGATE FUNCTIONS

-- Average population across all the states. Note the use of alias, common with aggregated values.
SELECT AVG(population) AS avg_state_population
FROM state;

-- Total population in the West and South census regions
SELECT SUM(population) AS west_south_population
FROM state
WHERE census_region IN ('West', 'South');

-- The number of cities with populations greater than 1 million
SELECT COUNT(population)
FROM city
WHERE population > 1000000;

-- The number of state nicknames.
-- If use a column name in count() it counts the rows that have a value for that column ignoring null
-- If use * in count() it counts all rows including those that have null
SELECT COUNT(state_nickname) AS nickname_count, COUNT(*) AS row_count
FROM state;

-- The area of the smallest and largest parks.
SELECT MIN(area) AS smallest_park, MAX(area) AS largest_park
FROM park;


-- GROUP BY

SELECT MIN(population), census_region
FROM state
GROUP BY census_region;

-- Count the number of cities in each state, ordered from most cities to least.
SELECT COUNT(city_name) AS cities, state_abbreviation
FROM city
GROUP BY state_abbreviation
ORDER BY cities DESC;

-- Determine the average park area depending upon whether parks allow camping or not.
SELECT has_camping, AVG(area) AS avg_park_area
FROM park
GROUP BY has_camping;

-- Sum of the population of cities in each state ordered by state abbreviation.
SELECT state_abbreviation, SUM(population) AS sum_of_city_population 
FROM city
GROUP BY state_abbreviation
ORDER BY state_abbreviation;

-- The smallest city population in each state ordered by city population.
SELECT state_abbreviation, MIN(population) AS smallest_city_population
FROM city
GROUP BY state_abbreviation
ORDER BY smallest_city_population ASC;


-- Miscelleneous

-- While you can use LIMIT to limit the number of results returned by a query,
-- it's recommended to use OFFSET and FETCH if you want to get
-- "pages" of results.
-- For instance, to get the first 10 rows in the city table
-- ordered by the name, you could use the following query.
-- (Skip 0 rows, and return only the first 10 rows from the sorted result set.)
SELECT city_name, population
FROM city
ORDER BY city_name
LIMIT 10 OFFSET 10;

-- OFFSET 10 ROWS FETCH NEXT 10 ROWS ONLY;


-- SUBQUERIES (optional)

-- City in the states in the South and West census region
SELECT state_abbreviation
FROM state
WHERE census_region IN ('South', 'West');

SELECT * 
FROM city
WHERE state_abbreviation IN (
	SELECT state_abbreviation
	FROM state
	WHERE census_region IN ('South', 'West')
);

-- Include state name rather than the state abbreviation while counting the number of cities in each state,
SELECT COUNT(city_name) AS cities, 
	(
		SELECT state_name 
		FROM state
		WHERE state.state_abbreviation = city.state_abbreviation
	)
FROM city
GROUP BY state_abbreviation
ORDER BY cities DESC;

-- Include the names of the smallest and largest parks
SELECT park_name, area
FROM park AS p,
	( 
		SELECT MIN(area) AS smallest, MAX(area) AS largest
		FROM park
		WHERE area > 0
	) AS sl
WHERE p.area = sl.smallest OR p.area = sl.largest;

-- List the capital cities for the states in the Northeast census region.
SELECT state_abbreviation, city_name
FROM city
WHERE city_id IN (
	SELECT capital
	FROM state
	WHERE census_region = 'Northeast'
)
ORDER BY state_abbreviation;

-- Another way of getting the list of capital cities for states in the Norteast census region
SELECT 
	state_abbreviation, 
	(SELECT city_name FROM city WHERE city_id = capital)
FROM state
WHERE census_region = 'Northeast'
ORDER BY state_abbreviation

