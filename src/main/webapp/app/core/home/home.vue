<template>
    <div class="home row">
        <div class="col-md-5">
            <h1 class="display-4">Welcome, Wave Propagation Tools!</h1>
            <div>
                <div class="alert alert-success" v-if="authenticated">
                    <span v-if="username">You are logged in as user "{{username}}"</span>
                </div>

                <div class="alert alert-warning" v-if="!authenticated">
                    <span>If you want to </span>
                    <a class="alert-link" v-on:click="openLogin()">sign in</a><span >, you can try the default account:<br/>- User (login="user" and password="user").</span>
                </div>
                <div class="alert alert-warning" v-if="!authenticated">
                    <span>You don't have an account yet?</span>&nbsp;
                    <router-link class="alert-link" to="/register">Register a new account</router-link>
                </div>
            </div>
        </div>
        <div class="col-md-7 col-main">
            <h3 class="main-title">Fill data and get charts for your case!</h3>
            <h5>This is your work panel</h5>
            <form>
                <div class="form-group">
                    <label for="rho1">Choose rho of the first element:</label>
                    <input class="form-control" type="number" v-model="rho1" id="rho1" min="0">
                </div>
                <div class="form-group">
                    <label for="rho2">Choose rho of the second element:</label>
                    <input class="form-control" type="number" v-model="rho2" id="rho2" min="0">
                </div>
                <div class="form-group">
                    <label for="speed1">Choose speed of sound in the first element:</label>
                    <input class="form-control" type="number" v-model="speed1" id="speed1" min="0">
                </div>
                <div class="form-group">
                    <label for="speed2">Choose speed of sound in the second element:</label>
                    <input class="form-control" type="number" v-model="speed2" id="speed2" min="0">
                </div>
                <button type="submit" class="btn btn-danger">Submit</button>
            </form>
            <random-chart></random-chart>
        </div>
    </div>
</template>

<script lang="ts">
import RandomChart from '@/core/chart/RandomChart.vue';

export default {
    components: { RandomChart }
};
</script>
<style lang="scss" scoped>
.col-main {
    border-radius: 5px;
}
.main-title {
    color: #fb8817;
}
</style>
