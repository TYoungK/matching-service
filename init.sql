USE mysql;
CREATE USER 'tyk'@'%' IDENTIFIED BY '1111';

-- 해당 사용자에게 appdb 데이터베이스에 대한 모든 권한 부여
CREATE DATABASE IF NOT EXISTS matching_service DEFAULT CHARACTER SET utf8;

GRANT ALL PRIVILEGES ON matching_service.* TO 'tyk'@'%';

-- 권한 적용
FLUSH PRIVILEGES;