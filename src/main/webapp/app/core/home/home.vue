<template>
    <div class="home row">
        <div class="col-md-5">
            <h2>Welcome, Wave Propagation Tools!</h2>
            <div>
                <div class="alert alert-success" v-if="authenticated">
                    <span v-if="username">You are logged in as user "{{username}}"</span>
                </div>

                <div class="alert alert-success" v-if="!authenticated">
                    <span>If you want to </span>
                    <a class="alert-link" v-on:click="openLogin()">sign in</a><span >, you can try the default account:<br/>- User (login="user" and password="user").</span>
                </div>
                <div class="alert alert-success" v-if="!authenticated">
                    <span>You don't have an account yet?</span>&nbsp;
                    <router-link class="alert-link" to="/register">Register a new account</router-link>
                </div>
            </div>
        </div>
        <div class="col-md-7 col-main">
            <h3 class="main-title">Fill data and get charts for your case!</h3>
            <h5>This is your work panel</h5>
            <form @submit.prevent.default="submitData">
                <div class="form-group">
                    <label for="rho1">Choose rho of the first element:</label>
                    <input class="form-control" type="number" v-model="rho1" id="rho1" min="1">
                </div>
                <div class="form-group">
                    <label for="rho2">Choose rho of the second element:</label>
                    <input class="form-control" type="number" v-model="rho2" id="rho2" min="1">
                </div>
                <div class="form-group">
                    <label for="speed1">Choose speed of sound in the first element:</label>
                    <input class="form-control" type="number" v-model="v1" id="speed1" min="1">
                </div>
                <div class="form-group">
                    <label for="speed2">Choose speed of sound in the second element:</label>
                    <input class="form-control" type="number" v-model="v2" id="speed2" min="1">
                </div>
                <button type="submit" class="btn btn-danger">Submit</button>
            </form>
            <random-chart
                :charts = "charts"
            ></random-chart>
        </div>
    </div>
</template>

<script lang="javascript">
import RandomChart from '@/core/chart/RandomChart.vue';
import axios from 'axios';

export default {
    components: { RandomChart },
    data() {
        return {
            rho1: 999,
            rho2: 1.204,
            v1: 1500,
            v2: 331,
            charts: []
        };
    },
    mounted() {
        this.initData();
    },
    computed: {
        authenticated: function (){
            return this.$store.getters.authenticated;
        }
    },
    methods: {
        submitData() {
            axios.get(`chart/all?rho1=${this.rho1}&rho2=${this.rho2}&v1=${this.v1}&v2=${this.v2}`).then(res => {
                this.charts = res.data;
            });
        },
        initData() {
            axios.get(`chart/all?rho1=${this.rho1}&rho2=${this.rho2}&v1=${this.v1}&v2=${this.v2}`).then(res => {
                this.charts = res.data;
            });
        },
    }
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
