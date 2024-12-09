import { error } from "@sveltejs/kit";
import type { PageLoad } from "../bills/$types";

export const load: PageLoad = async ({ params }) => {
    const customerID = params.slug;
    console.log(customerID);

    try {
        let res = await fetch("http://localhost:8888/BILLING-SERVICE/fullBill/" + customerID);

        if (!res.ok) {
            throw new Error('Failed to fetch the bill');
        }

        const bill = await res.json();  // Ensure we await the JSON response here
        console.log(bill);
        return bill;
    } catch (error) {
        console.error("Error fetching bill:", error);
        throw error;  // Rethrow or handle the error as needed
    }
}