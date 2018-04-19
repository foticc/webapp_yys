<template>
    <div>
        <mt-cell v-for="(n,key) in ss" :key="n.id" :title="n.name" is-link :to="'/info/'+key">
           
            <img v-bind:src="imgurl" height="50" width="50" />
        </mt-cell>
    </div>
</template>

<script>
import { Toast } from 'mint-ui'
export default {
    name: 'CellList',
    data() {
        return {
            ss: [],
            imgurl: ''
        }
    },
    props: ['selected'],
    created:function(){
        // this.imgurl = 'http://yys.res.netease.com/pc/zt/20161108171335/data/shishen_big_beforeAwake/200.png';
        this.imgurl = 'https://img1.doubanio.com/view/photo/l/public/p2504903297.jpg';
        this.getData();
    },
    methods: {
        getData: function() {
            this.$indicator.open('loading...');
            this.$http.jsonp('https://g37simulator.webapp.163.com/get_heroid_list?rarity=0&page=1&per_page=200')
            .then(function(response) {
                console.log(response.data.data);
                this.ss = response.data.data;
                // this.$set("ss",response.data.data)
                this.$indicator.close();
            },function(response){
                this.$indicator.close();
                Toast({message:'Link Error!',position:'bottom'});
            })
        },
    }
}
</script>
