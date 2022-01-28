ALTER TABLE comment ADD CONSTRAINT fk_comment_blogid_blog_id FOREIGN KEY (comment_blogid) REFERENCES blog(id)
ON DELETE CASCADE ON UPDATE NO ACTION; 