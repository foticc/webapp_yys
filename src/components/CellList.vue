<template>
    <!-- <div>
        <mt-cell v-for="(n,key) in ss" :key="n.id" :title="n.name" is-link :to="'/info/'+key">
            <img v-bind:src="imgurl+key+'.png'" height="50" width="50" />
        </mt-cell>
    </div> -->
    
    <div>  
    <div class="nav">  
      <mt-button size="small" @click.native.prevent="active  = 'ssr'">SSR</mt-button>  
      <mt-button size="small" @click.native.prevent="active  = 'sr'">SR</mt-button>  
      <mt-button size="small" @click.native.prevent="active  = 'r'">R</mt-button>
      <mt-button size="small" @click.native.prevent="active  = 'n'">N</mt-button>  
    </div>  
   

    <div class="page-tab-container">
        <mt-tab-container class="page-tabbar-tab-container" v-model="active" swipeable>
                <mt-tab-container-item id="ssr">
                        <mt-cell v-for="(n,key) in ss" :key="n.id" :title="n.name" is-link :to="'/info/'+key">
                            <img v-bind:src="imgurl+key+'.png'" height="50" width="50" />
                        </mt-cell>
                </mt-tab-container-item>
            <mt-tab-container-item id="sr">
                <mt-cell v-for="(n,key) in ss" :key="n.id" :title="n.name" is-link :to="'/info/'+key">
                    <img v-bind:src="imgurl+key+'.png'" height="50" width="50" />
                </mt-cell>
            </mt-tab-container-item>
            <mt-tab-container-item id="r">
                <mt-cell v-for="(n,key) in ss" :key="n.id" :title="n.name" is-link :to="'/info/'+key">
                    <img v-bind:src="imgurl+key+'.png'" height="50" width="50" />
                </mt-cell>
            </mt-tab-container-item>
            <mt-tab-container-item id="n">
                <mt-cell v-for="(n,key) in ss" :key="n.id" :title="n.name" is-link :to="'/info/'+key">
                    <img v-bind:src="imgurl+key+'.png'" height="50" width="50" />
                </mt-cell>
            </mt-tab-container-item>
        </mt-tab-container>
    </div>


  </div>  
</template>

<script>
import { Toast } from 'mint-ui';
export default {
    name: 'CellList',
    data() {
        return {
            active: "ssr",
            ss: [],
            imgurl: ''
        }
    },
    props: ['selected'],
    created:function(){
        // this.imgurl = 'https://yys.res.netease.com/pc/zt/20161108171335/data/shishen/302.png'; ssr -4
        this.imgurl = 'https://yys.res.netease.com/pc/zt/20161108171335/data/shishen/';
        this.getData("4");
    },
    watch:{
        active: function(){
            let retype;
            console.log("~~~~"+this.active);
            switch (this.active) {
                case "ssr":
                    retype = "4";
                    break;
                case "sr":
                    retype = "3";
                    break;
                case "r":
                    retype = "2";
                    break;
                case "n":
                    retype = "1";
                    break;
                default:
                    break;
            }
            // this.getData(retype);
        }
    },
    methods: {
        getData: function(type) {
            this.$indicator.open('loading...');
            this.$http.jsonp('https://g37simulator.webapp.163.com/get_heroid_list?rarity='+type+'&page=1&per_page=200')
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
<style>
.nav{
    width: 100%;

}
.nav > button{
    width: 25%;
    float:left;
    border: none;
}
.page-tab-container{
    clear: both;
}
</style>
