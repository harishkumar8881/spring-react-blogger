package com.hkr.backend.model;


import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Blog {
    private Long id;
    private String title;
    private String content;
    private Date created_at;    

}
