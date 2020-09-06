CREATE TABLE experience (
experience_id serial PRIMARY KEY,
player_id int NOT NULL,
balance int,
created_at_timestamp TIMESTAMP WITH TIME ZONE DEFAULT now(),
updated_at_timestamp TIMESTAMP WITH TIME ZONE DEFAULT now()
);

CREATE TABLE experience_log (
experience_log_id UUID PRIMARY KEY,
experience_id int NOT NULL REFERENCES experience (experience_id),
player_id int NOT NULL,
amount int,
type character varying(9),
remarks varchar(255),
created_at_timestamp TIMESTAMP WITH TIME ZONE DEFAULT now()
);