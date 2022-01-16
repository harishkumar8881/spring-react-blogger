CREATE TABLE blog (
    id BIGSERIAL PRIMARY KEY,
    title TEXT NOT NULL,
    content TEXT NOT NULL,
    created_at DATE DEFAULT NOW()::DATE
);