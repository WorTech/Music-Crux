package com.Models;

import com.google.gson.annotations.Expose;
import lombok.Data;

@Data
public class Track {
    @Expose
    private String title;
    @Expose
    private String position;
    @Expose
    private String duration;
}