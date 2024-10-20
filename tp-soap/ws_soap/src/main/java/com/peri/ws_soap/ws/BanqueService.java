package com.peri.ws_soap.ws;

import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import jakarta.jws.WebService;

import java.util.Date;
import java.util.List;

@WebService(serviceName = "BanqueWS")
public class BanqueService {
    @WebMethod(operationName = "Convert")
    public double conversion(@WebParam(name = "montant") double mt) {
        return mt * 10.54;
    }

    public Compte getCompte(@WebParam(name = "code") int code) {
        return new Compte(code, Math.random() * 9888, new Date());
    }

    public List<Compte> getComptes() {
        return List.of(
            new Compte(0, Math.random() * 9888, new Date()),
            new Compte(0, Math.random() * 9888, new Date()),
            new Compte(0, Math.random() * 9888, new Date())
        );
    }
}
