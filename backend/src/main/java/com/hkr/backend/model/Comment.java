package com.hkr.backend.model;


import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Comment {
    public Long id;
    public String text;
    public Long blogid;
    public Date created_at;
}
