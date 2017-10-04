package com.yves.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.yves.model.Note;

/**
 * Created by rajeevkumarsingh on 27/06/17.
 */
public interface NoteRepository extends JpaRepository<Note, Long> {

}
