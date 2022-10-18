package com.example.nativeandroidtasks.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Todos_response {
    @SerializedName("userId")
    @Expose
    public Integer userId;
    @SerializedName("id")
    @Expose
    public Integer id;
    @SerializedName("title")
    @Expose
    public String title;
    @SerializedName("completed")
    @Expose
    public Boolean completed;
}
