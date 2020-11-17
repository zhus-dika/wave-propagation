<template>
    <div class="home row">
        <div class="col-md-5">
            <h3 class="main-title">Fill data and get charts for your case!</h3>
            <h5>This is your work panel</h5>
            <form @submit.prevent.default="submitData">
                <div class="form-group-wrapper">
                    <div class="form-group form-group-custom first">
                        <label for="rho1">Density at rest in the first environment:</label>
                        <input class="form-control" v-model="rho1" id="rho1">
                    </div>
                    <div class="form-group form-group-custom">
                        <label for="rho2">Density at rest in the second environment:</label>
                        <input class="form-control" v-model="rho2" id="rho2">
                    </div>
                </div>
                <div class="form-group-wrapper">
                    <div class="form-group form-group-custom first">
                        <label for="speed1">Choose speed of sound in the first environment:</label>
                        <input class="form-control" v-model="v1" id="speed1">
                    </div>
                    <div class="form-group form-group-custom">
                        <label for="speed2">Choose speed of sound in the second environment:</label>
                        <input class="form-control" v-model="v2" id="speed2">
                    </div>
                </div>
                <button type="submit" class="btn btn-danger">Submit</button>
            </form>
        </div>
        <div class="col-md-7 col-main">
            <h3 class="graphics-title">Your output:</h3>
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
.small {
    margin: auto !important;
}
.form-group-wrapper {
    display: flex;
}
.form-group-custom .first {
    width: 45%;
    margin-right: 10%;
}
.first {
    margin-right: 10%;
}
.col-main {
    border-radius: 5px;
}
.main-title {
    color: #fb8817;
}
.graphics-title {
    color: #2d2d2d;
}
</style>
