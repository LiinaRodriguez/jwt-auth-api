package com.liinarodriguez.jwtauthapi.repository;

import com.liinarodriguez.jwtauthapi.entity.Note;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NoteRepository extends JpaRepository<Note, Integer> {
}
