package edu.miu.cs.cs489.quiz.model;

public class EmailAddress {
    private String email;
    private String label;

    public EmailAddress(String email, String label) {
        this.email = email;
        this.label = label;
    }

    public String getEmail() {
        return email;
    }

    public String getLabel() {
        return label;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    @Override
    public String toString() {
        return "EmailAddress [email=" + email + ", label=" + label + "]";
    }
}
