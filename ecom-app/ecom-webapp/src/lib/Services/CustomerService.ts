import type { Customer } from "$lib/Models/Customer";

export class CustomerService {
    constructor() {}

    async getCustomer(id: number): Promise<Customer> {
        const promise = fetch("http://localhost:8888/CUSTOMER-SERVICE/customers/" + id).then(
            (res) => {
                if (!res.ok) {
                    return Promise.reject("Failed to fetch the customer");
                }
                return res.json();
            }
        ).then((data: any) => {
            const customer: Customer = {
                id: data["id"],
                name: data["name"],
                email: data["email"],
            };
            return customer;
        }).catch((error) => {
            throw new Error(error);
        })

        return promise;
    }

    async getAllCustomers(): Promise<Customer[]> {
        const promise = fetch("http://localhost:8888/CUSTOMER-SERVICE/customers").then(
            (res) => {
                if (!res.ok) {
                    return Promise.reject("Failed to fetch the customers");
                }
                return res.json();
            }
        ).then((data: any) => {
            let customers: Customer[] = [];
            const len = data["_embedded"]["customers"].length
            for (let i = 0 ; i < len ; i++) {
                const customer = data["_embedded"]["customers"][i];
                customers.push({
                    id: customer["id"],
                    name: customer["name"],
                    email: customer["email"],
                });
            }
            return customers;
        }).catch((error) => {
            throw new Error(error);
        })

        return promise;
    }
}