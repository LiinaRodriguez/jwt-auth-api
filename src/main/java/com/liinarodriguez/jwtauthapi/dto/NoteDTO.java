package com.liinarodriguez.jwtauthapi.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.relational.core.sql.In;

@Getter
@Setter
@AllArgsConstructor
public class NoteDTO {
    protected Integer Id;
    protected String Note;
    protected  UserDTO userDTO;
}
