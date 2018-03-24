package com.example.salim.db_test.modele;

/**
 * Created by Salim on 23/03/2018.
 */

public class Calendrier {
    private int id;
    private String titre,couleur,priorite,description;
    boolean visib;

    public Calendrier() {
    }

    public Calendrier(int id, String titre, String couleur, String priorite, String description, boolean visib) {
        this.id = id;
        this.titre = titre;
        this.couleur = couleur;
        this.priorite = priorite;
        this.description = description;
        this.visib = visib;

    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getCouleur() {
        return couleur;
    }

    public void setCouleur(String couleur) {
        this.couleur = couleur;
    }

    public String getPriorite() {
        return priorite;
    }

    public void setPriorite(String priorité) {
        this.priorite = priorité;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isVisib() {
        return visib;
    }

    public void setVisib(boolean visib) {
        this.visib = visib;
    }
}
