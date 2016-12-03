package br.com.teste.call.model;

import java.io.Serializable;

public class MyImages implements Serializable{
    private static final long serialVersionUID = -5204066633446672697L;

    private String hidpi;
    private String normal;
    private String teaser;

    public String getHidpi() {
        return hidpi;
    }

    public void setHidpi(String hidpi) {
        this.hidpi = hidpi;
    }

    public String getNormal() {
        return normal;
    }

    public void setNormal(String normal) {
        this.normal = normal;
    }

    public String getTeaser() {
        return teaser;
    }

    public void setTeaser(String teaser) {
        this.teaser = teaser;
    }
}
