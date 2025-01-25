package be.ifapme.spring_batch.model;

import jakarta.persistence.*;

@Entity
@Table(name = "personnes")
public class Personne {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nom", nullable = false, length = 100)
    private String nom;

    @Column(name = "prenom", nullable = false, length = 100)
    private String prenom;

    @Column(name = "rue")
    private String rue;

    @Column(name = "numero_rue")
    private String numeroRue;

    @Column(name = "ville")
    private String ville;

    @Column(name = "numero_portable")
    private String numeroPortable;

    @Column(name = "numero_fixe")
    private String numeroFixe;

    @Column(name = "genre")
    private String genre;

    @Column(name = "email")
    private String email;

    @Column(name = "job")
    private String job;

    @Column(name = "suffix")
    private String suffix;

    public Personne() {
    }

    public Personne(String nom, String prenom, String rue, String numeroRue, String ville, String numeroPortable, String numeroFixe, String genre, String email, String job, String suffix) {
        this.nom = nom;
        this.prenom = prenom;
        this.rue = rue;
        this.numeroRue = numeroRue;
        this.ville = ville;
        this.numeroPortable = numeroPortable;
        this.numeroFixe = numeroFixe;
        this.genre = genre;
        this.email = email;
        this.job = job;
        this.suffix = suffix;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getRue() {
        return rue;
    }

    public void setRue(String rue) {
        this.rue = rue;
    }

    public String getNumeroRue() {
        return numeroRue;
    }

    public void setNumeroRue(String numeroRue) {
        this.numeroRue = numeroRue;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public String getNumeroPortable() {
        return numeroPortable;
    }

    public void setNumeroPortable(String numeroPortable) {
        this.numeroPortable = numeroPortable;
    }

    public String getNumeroFixe() {
        return numeroFixe;
    }

    public void setNumeroFixe(String numeroFixe) {
        this.numeroFixe = numeroFixe;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public String getSuffix() {
        return suffix;
    }

    public void setSuffix(String suffix) {
        this.suffix = suffix;
    }
}
