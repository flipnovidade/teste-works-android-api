package br.com.teste.call.model;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

public class Team implements Serializable{
    private static final long serialVersionUID = -5148308186449580379L;

    @SerializedName("avatar_url")
    private String urlAvatar;

    public String getUrlAvatar() {
        return urlAvatar;
    }

    public void setUrlAvatar(String urlAvatar) {
        this.urlAvatar = urlAvatar;
    }
}
