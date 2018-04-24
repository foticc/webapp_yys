<template>
    <div>
        <mt-cell v-for="(n,key) in ss" :key="n.id" :title="n.name" is-link :to="'/info/'+key">
           
            <img v-bind:src="imgurl+key+'.png'" height="50" width="50" />
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
        // this.imgurl = 'https://yys.res.netease.com/pc/zt/20161108171335/data/shishen/302.png';
        this.imgurl = 'https://yys.res.netease.com/pc/zt/20161108171335/data/shishen/';
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
