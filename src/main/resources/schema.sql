DROP TABLE IF EXISTS game_machine;
CREATE TABLE IF NOT EXISTS game_machine(id IDENTITY, type varchar(64) unique,
    primary key (id)
);

DROP TABLE IF EXISTS game;
CREATE TABLE IF NOT EXISTS game(
    id IDENTITY, path varchar(256), name varchar(256), description CLOB, image_path varchar(256),
    rating varchar(4), release_date varchar(24), developer varchar(64), publisher varchar(64), genre varchar(64), players varchar(16),
    play_count int, last_played varchar(24), game_machine int,
    primary key(id),
    foreign key(game_machine) references game_machine(id)
  );


