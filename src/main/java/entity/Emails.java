package entity;

import javax.persistence.*;

@Entity
@Table
public class Emails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String email;
    private String currency;


    public Emails() {
    }


    public Emails(int id, String email, String currency) {
        this.id = id;
        this.email = email;
        this.currency = currency;
    }

    public Emails(String email, String currency) {
        this.email = email;
        this.currency = currency;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    @Override
    public String toString() {
        return "Emails{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", currency='" + currency + '\'' +
                '}';
    }
}
