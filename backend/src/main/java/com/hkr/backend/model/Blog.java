package com.hkr.backend.model;


import java.util.ArrayList;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Blog {
    private Long id;
    private String title;
    private String content;
    private ArrayList<Comment> comments;
    private Date created_at;    

}
