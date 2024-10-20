package com.peri.ws_soap.ws;

import java.util.Date;

public class Compte {
    private int code;
    private double solde;
    private Date createdAt;

    public Compte(int code, double solde, Date createdAt) {
        this.code = code;
        this.solde = solde;
        this.createdAt = createdAt;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public double getSolde() {
        return solde;
    }

    public void setSolde(double solde) {
        this.solde = solde;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }
}
