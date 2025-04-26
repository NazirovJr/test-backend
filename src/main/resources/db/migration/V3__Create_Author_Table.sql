CREATE TABLE author
(
    id              SERIAL PRIMARY KEY,
    name            TEXT NOT NULL,
    created_at      TIMESTAMP NOT NULL DEFAULT NOW()
);

-- Add author_id to budget table
ALTER TABLE budget ADD COLUMN author_id INT NULL;
ALTER TABLE budget ADD CONSTRAINT fk_budget_author FOREIGN KEY (author_id) REFERENCES author(id); 