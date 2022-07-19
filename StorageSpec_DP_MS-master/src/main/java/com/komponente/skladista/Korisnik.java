package com.komponente.skladista;

abstract public class Korisnik {

    private String username;
    private String password;
    private boolean save;
    private boolean read;
    private boolean delete;
    private boolean download;
    private boolean isActive;
    private Korisnici privilegije;

    public Korisnik(){

    }

    public Korisnik(String username, String password){
        this.username = username;
        this.password = password;
    }

    public Korisnik(String username, String password, Korisnici tip) {
        this.username = username;
        this.password = password;
        this.privilegije = tip;
        this.setRead(true);

        if(tip.equals(Korisnici.premium)){
            this.setDelete(true);
            this.setSave(true);
            this.setDownload(true);
        }else if(tip.equals(Korisnici.medior)){
            this.setDelete(false);
            this.setSave(true);
            this.setDownload(true);
        }else if(tip.equals(Korisnici.lightWithDownload)){
            this.setDelete(false);
            this.setSave(false);
            this.setDownload(true);
        }else if(tip.equals(Korisnici.light)){
            this.setDelete(false);
            this.setSave(false);
            this.setDownload(false);
        }

    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isSave() {
        return save;
    }

    public void setSave(boolean save) {
        this.save = save;
    }

    public boolean isRead() {
        return read;
    }

    public void setRead(boolean read) {
        this.read = read;
    }

    public boolean isDelete() {
        return delete;
    }

    public void setDelete(boolean delete) {
        this.delete = delete;
    }

    public boolean isDownload() {
        return download;
    }

    public void setDownload(boolean download) {
        this.download = download;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public Korisnici getPrivilegije() {
        return privilegije;
    }

    public void setPrivilegije(Korisnici privilegije) {
        this.privilegije = privilegije;
    }
}
