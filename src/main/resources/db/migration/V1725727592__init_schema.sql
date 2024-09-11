CREATE TABLE IF NOT EXISTS dog_document (
    dog_id SERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    dog_breed VARCHAR(50),
    created_at TIMESTAMP NOT NULL,
    updated_at TIMESTAMP NOT NULL
);