import type { Product } from "$lib/Models/Product";

export class ProdcutService {
    constructor() {}

    async getProducts(id: number): Promise<Product> {
        const promise = fetch("http://localhost:8888/INVENTORY-SERVICE/products/" + id).then(
            (res) => {
                if (!res.ok) {
                    return Promise.reject("Failed to fetch the product");
                }
                return res.json();
            }
        ).then((data: any) => {
            const product: Product = {
                id: data["id"],
                name: data["name"],
                quantity: data["quantity"],
                price: data["price"],
            };
            return product;
        }).catch((error) => {
            throw new Error(error);
        })

        return promise;
    }

    async getAllProducts(): Promise<Product[]> {
        const promise = fetch("http://localhost:8888/INVENTORY-SERVICE/products").then(
            (res) => {
                if (!res.ok) {
                    return Promise.reject("Failed to fetch the Products");
                }
                return res.json();
            }
        ).then((data: any) => {
            let products: Product[] = [];
            const len = data["_embedded"]["products"].length
            for (let i = 0 ; i < len ; i++) {
                const product = data["_embedded"]["products"][i];
                console.log(product);
                products.push({
                    id: product["id"],
                    name: product["name"],
                    quantity: product["quantity"],
                    price: product["price"],
                });
            }
            console.log(products);
            return products;
        }).catch((error) => {
            throw new Error(error);
        })

        return promise;
    }
}