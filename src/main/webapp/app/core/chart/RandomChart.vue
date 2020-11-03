<template>
    <div class="small">
        <line-chart :data="charts"></line-chart>
    </div>
</template>

<script>
import LineChart from './LineChart.js'

export default {
    components: {
        LineChart
    },
    data () {
        return {
        }
    },
    props: {
      charts: Array
    }
}
</script>

<style>
.small {
    max-width: 600px;
    margin:  150px auto;
    color: #666600;
}
</style>
