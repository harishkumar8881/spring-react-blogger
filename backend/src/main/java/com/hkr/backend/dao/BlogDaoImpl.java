package com.hkr.backend.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import com.hkr.backend.exception.NotFoundException;
import com.hkr.backend.mapper.BlogResultSetExtractor;
import com.hkr.backend.model.Blog;
import com.hkr.backend.model.Comment;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

@Repository
public class BlogDaoImpl implements BlogDao {
    private JdbcTemplate jdbcTemplate;

    public BlogDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Long createBlog(Blog blog) {
        var sql = """
                    INSERT INTO blog (title, content) VALUES (?, ?) RETURNING id;
                """;

        KeyHolder keyHolder = new GeneratedKeyHolder();
        PreparedStatementCreator preparedStatementCreator = new PreparedStatementCreator() {

            @Override
            public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
                PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
                ps.setString(1, blog.getTitle());
                ps.setString(2, blog.getContent());
                return ps;
            }

        };
        jdbcTemplate.update(preparedStatementCreator, keyHolder);
        return (Long) keyHolder.getKey();
    }

    @Override
    public List<Blog> getBlogs() {
        var sql = """
                    SELECT b.id AS b_id, b.title AS b_title, b.content AS b_content, b.created_at AS b_created_at,
                            c.comment_id AS c_id, c.comment_text AS c_text, c.comment_blogid AS c_blogid, c.created_at AS c_created_at
                    FROM blog AS b LEFT JOIN comment AS c ON b.id = c.comment_blogid;
                """;
        return jdbcTemplate.query(sql, new BlogResultSetExtractor());
    }

    @Override
    public Blog getBlogById(Long id) {
        var sql = """
                    SELECT b.id AS b_id, b.title AS b_title, b.content AS b_content, b.created_at AS b_created_at,
                        c.comment_id AS c_id, c.comment_text AS c_text, c.comment_blogid AS c_blogid, c.created_at AS c_created_at
                    FROM blog AS b LEFT JOIN comment AS c ON b.id = c.comment_blogid WHERE b.id = ?;
                """;
        return jdbcTemplate.query(sql, new BlogResultSetExtractor(), id).stream().findFirst()
                .orElseThrow(() -> new NotFoundException("Requested Resource Not Found"));
    }

    @Override
    public void updateBlog(Blog blog, Long id) {

        var sql = """
                    UPDATE blog SET title = COALESCE(NULLIF(?, '') , title), content = COALESCE(NULLIF(?, ''), content) WHERE id = ?;
                """;

        jdbcTemplate.update(sql, blog.getTitle(), blog.getContent(), id);
    }

    @Override
    public void deleteBlog(Long id) {
        var sql = """
                    DELETE FROM blog WHERE id = ?;
                """;

        jdbcTemplate.update(sql, id);
    }

    @Override
    public Long addCommentToBlog(Comment comment) {
        var sql = """
            INSERT INTO comment (comment_blogid, comment_text) VALUES (?, ?) RETURNING comment_id;
        """;

        KeyHolder keyHolder = new GeneratedKeyHolder();
        PreparedStatementCreator preparedStatementCreator = new PreparedStatementCreator() {

            @Override
            public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
                PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
                ps.setLong(1, comment.getBlogid());
                ps.setString(2, comment.getText());
                return ps;
            }
        };

        jdbcTemplate.update(preparedStatementCreator, keyHolder);
        

        return (Long)keyHolder.getKey();
    }

}
