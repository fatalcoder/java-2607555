create table pokemon(
    id BIGSERIAL PRIMARY KEY,
    name VARCHAR,
    size INTEGER,
    external_id INTEGER
);

create table user_favourites(
    user_id INTEGER,
    pokemon_id INTEGER
);
