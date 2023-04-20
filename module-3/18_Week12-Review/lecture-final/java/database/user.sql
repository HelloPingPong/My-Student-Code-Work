-- ********************************************************************************
-- This script creates the database users and grants them the necessary permissions
-- ********************************************************************************

CREATE USER final_review_owner
WITH PASSWORD 'finalreview';

GRANT ALL
ON ALL TABLES IN SCHEMA public
TO final_review_owner;

GRANT ALL
ON ALL SEQUENCES IN SCHEMA public
TO final_review_owner;

CREATE USER final_review_appuser
WITH PASSWORD 'finalreview';

GRANT SELECT, INSERT, UPDATE, DELETE
ON ALL TABLES IN SCHEMA public
TO final_review_appuser;

GRANT USAGE, SELECT
ON ALL SEQUENCES IN SCHEMA public
TO final_review_appuser;
