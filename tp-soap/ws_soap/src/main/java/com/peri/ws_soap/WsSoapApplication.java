package com.peri.ws_soap;

import com.peri.ws_soap.ws.BanqueService;
import jakarta.xml.ws.Endpoint;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class WsSoapApplication {

	public static void main(String[] args) {
		Endpoint.publish("http://0.0.0.0:8080/", new BanqueService());
		System.out.println("Web services started on http://0.0.0.0:8080/");
	}
}
