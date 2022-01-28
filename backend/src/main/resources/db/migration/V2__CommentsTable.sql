CREATE TABLE comment (
    comment_id BIGSERIAL NOT NULL PRIMARY KEY,
    comment_text TEXT NOT NULL,
    comment_blogid BIGINT REFERENCES blog (id),
    created_at DATE DEFAULT NOW()::DATE
);