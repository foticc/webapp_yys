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
                    <mt-cell v-for="(n,key) in ssr" :key="n.id" :title="n.name" is-link :to="'/info/'+key">
                        <img v-bind:src="imgurl+key+'.png'" height="50" width="50" />
                    </mt-cell>
            </mt-tab-container-item>
            <mt-tab-container-item id="sr">
                <mt-cell v-for="(n,key) in sr" :key="n.id" :title="n.name" is-link :to="'/info/'+key">
                    <img v-bind:src="imgurl+key+'.png'" height="50" width="50" />
                </mt-cell>
            </mt-tab-container-item>
            <mt-tab-container-item id="r">
                <mt-cell v-for="(n,key) in r" :key="n.id" :title="n.name" is-link :to="'/info/'+key">
                    <img v-bind:src="imgurl+key+'.png'" height="50" width="50" />
                </mt-cell>
            </mt-tab-container-item>
            <mt-tab-container-item id="n">
                <mt-cell v-for="(n,key) in n" :key="n.id" :title="n.name" is-link :to="'/info/'+key">
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
            ssr:[],
            sr: [],
            r: [],
            n: [],
            imgurl: ''
        }
    },
    props: ['selected'],
    created:function(){
        // this.imgurl = 'https://yys.res.netease.com/pc/zt/20161108171335/data/shishen/302.png'; ssr -4
        this.imgurl = 'https://yys.res.netease.com/pc/zt/20161108171335/data/shishen/';
        this.getData("4");
        this.getData("3");
        this.getData("2");
        this.getData("1");
    },
    watch:{
        active: function(){
            let retype;
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
        }
    },
    methods: {
        getData: function(type) {
            this.$indicator.open('loading...');
            this.$http.jsonp('https://g37simulator.webapp.163.com/get_heroid_list?rarity='+type+'&page=1&per_page=200')
            .then(function(response) {
                console.log(response.data.data);
                let ss = response.data.data;
                if("4"===type){
                    this.ssr = ss;
                }else if("3"===type){
                    this.sr = ss;
                }else if("2"===type){
                    this.r = ss;
                }else if("1"===type){
                    this.n = ss;
                }
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
