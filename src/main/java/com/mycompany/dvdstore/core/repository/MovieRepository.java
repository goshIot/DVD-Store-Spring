package com.mycompany.dvdstore.core.repository;

import com.mycompany.dvdstore.core.entity.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Repository
public class MovieRepository implements MovieRepositoryInterface{

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public Movie save(Movie movie) {
        GeneratedKeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(connection -> {
            PreparedStatement ps=connection.prepareStatement("INSERT INTO MOVIE (TITLE, GENRE, DESCRIPTION) VALUES (?, ?, ?)", Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, movie.getTitle());
            ps.setString(2, movie.getGenre());
            ps.setString(3, movie.getDescription());
            return ps;
        }, keyHolder);
        movie.setId(Long.parseLong(Objects.requireNonNull(keyHolder.getKey()).toString()));
        return movie;
    }

    @Override
    public Iterable<Movie> findAll() {
        return jdbcTemplate.query("SELECT ID, TITLE, GENRE FROM MOVIE",
                (rs, rowNum) -> new Movie(rs.getLong("ID"), rs.getString("TITLE"), rs.getString("GENRE")));
    }

    @Override
    public Iterable<Movie> findAllById(Iterable<Long> longs) {
        throw new UnsupportedOperationException();    }

    @Override
    public long count() {
        throw new UnsupportedOperationException();    }

    @Override
    public void deleteById(Long aLong) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void delete(Movie entity) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void deleteAllById(Iterable<? extends Long> longs) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void deleteAll(Iterable<? extends Movie> entities) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void deleteAll() {
        throw new UnsupportedOperationException();
    }

    @Override
    public <S extends Movie> Iterable<S> saveAll(Iterable<S> entities) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Optional<Movie> findById(Long id) {
        return Optional.ofNullable(jdbcTemplate.queryForObject("SELECT ID, TITLE, GENRE, DESCRIPTION FROM MOVIE WHERE ID=?",
                (rs, rowNum) ->new Movie(rs.getLong("ID"), rs.getString("TITLE"), rs.getString("GENRE"), rs.getString("DESCRIPTION")), id));
    }

    @Override
    public boolean existsById(Long aLong) {
        throw new UnsupportedOperationException();    }
}
