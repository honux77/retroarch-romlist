DROP TABLE IF EXISTS GAME;
CREATE TABLE IF NOT EXISTS GAME(id IDENTITY , path varchar(256), name varchar(256), description CLOB, image_path varchar(256),
 rating varchar(4), release_date varchar(24), developer varchar(64), publisher varchar(64), genre varchar(64), players varchar(16),
  play_count int, last_played varchar(24));