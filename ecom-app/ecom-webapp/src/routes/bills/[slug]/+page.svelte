<script lang="ts">
    export let data
</script>
<div>
    <h1>{data.customer.name} : {data.customer.email}</h1>
    <table class="striped">
        <thead>
            <tr>
                <th scope="col">ID</th>
                <th scope="col">Name</th>
                <th scope="col">Quantity</th>
                <th scope="col">Price</th>
            </tr>
        </thead>
        <tbody>
            {#each data.productItems as product}
                <tr>
                    <td>{product.id}</td>
                    <td>{product.product.name}</td>
                    <td>{product.quantity}</td>
                    <td>$ {product.price}</td>
                </tr>
            {/each}
        </tbody>
    </table>
</div>