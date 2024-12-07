<script lang="ts">
    export let data;
</script>

<div>
    <table class="striped">
        <thead>
            <tr>
                <th scope="col">ID</th>
                <th scope="col">Name</th>
                <th scope="col">Email</th>
                <th scope="col">Bills</th>
            </tr>
        </thead>
        <tbody>
            {#each data.customers as customer}
                <tr>
                    <td>{customer.id}</td>
                    <td>{customer.name}</td>
                    <td>{customer.email}</td>
                    <td><a href="/"><button>Bills</button></a></td>
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