<script lang="ts">
    export let data;
</script>

<div>
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
            {#each data.products as product}
                <tr>
                    <td>{product.id}</td>
                    <td>{product.name}</td>
                    <td>{product.quantity}</td>
                    <td>$ {product.price}</td>
                </tr>
            {/each}
        </tbody>
    </table>
</div>

<style>
    div {
        display: flex;
        align-items: center;
        justify-content: center;
        min-height: 80vh;
    }
</style>