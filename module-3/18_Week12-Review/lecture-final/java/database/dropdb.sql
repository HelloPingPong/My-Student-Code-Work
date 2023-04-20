-- **************************************************************
-- This script destroys the database and associated users
-- **************************************************************

-- The following line terminates any active connections to the database so that it can be destroyed
SELECT pg_terminate_backend(pid)
FROM pg_stat_activity
WHERE datname = 'final_review';

DROP DATABASE final_review;

DROP USER final_review_owner;
DROP USER final_review_appuser;
