import { ProdcutService } from "$lib/Services/ProductService";

export const load = async ({ }) => {
    let productService = new ProdcutService() ;
    try {
        const products = await productService.getAllProducts();
        return { products }
    } catch (err) {
        return { err }
    }
}