import { CustomerService } from "$lib/Services/CustomerService"

export const load = async ({}) => {
    let customerService = new CustomerService();
    try {
        const customers = await customerService.getAllCustomers();
        return { customers }
    } catch (err) {
        return { err }
    }
}