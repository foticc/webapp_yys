<template>
   <div>
    <div>
        <!-- <img src="https://yys.res.netease.com/pc/zt/20161108171335/data/shishen_big_beforeAwake/200.png" width="25%" height="25%"> -->
    </div>
    <div>
        <p v-for="s in story" :key="s.key">
            {{s}}
        </p>
    </div>
    <div>
        <ul>
            <li>
                <p class="title">式神属性</p>
                <table>
                    <tr>
                        <td></td>
                        <td >觉醒前</td>
                        <td>觉醒后</td>
                    
                    </tr>
                    <tr>
                        <td>攻击</td>
                        <td>{{beforewake.attack}}</td>
                        <td>{{afterwake.attack}}</td>
                    </tr>
                    <tr>
                        <td>生命</td>
                        <td>{{beforewake.maxHp}}</td>
                        <td>{{afterwake.maxHp}}</td>
                    </tr>
                    <tr>
                        <td>防御</td>
                        <td>{{beforewake.defense}}</td>
                        <td>{{afterwake.defense}}</td>
                    </tr>
                    <tr>
                        <td>速度</td>
                        <td>{{beforewake.speed}}</td>
                        <td>{{afterwake.speed}}</td>
                    </tr>
                    <tr>
                        <td>暴击</td>
                        <td>{{beforewake.critPower*10}}</td>
                        <td>{{afterwake.critPower==null?'':afterwake.critPower*10}}</td>
                    </tr>
                    <tr>
                        <td>暴击伤害</td>
                        <td></td>
                        <td></td>
                    </tr>
                    <tr>
                        <td>效果抵抗</td>
                        <td></td>
                        <td></td>
                    </tr>
                    <tr>
                        <td>效果命中</td>
                        <td></td>
                        <td></td>
                    </tr>
                </table>
            </li>
            <li>
                <p class="title">觉醒材料</p>
                <table class="wakeitem">
                    <tr>
                        <td></td>
                        <td></td>
                        <td></td>
                        <td></td>
                    </tr>
                    <tr>
                        <td v-for="item in beforewake.awakeitem" :key="item.id">
                            {{item[0]}}*{{item[2]}}
                        </td>
                    </tr>
                </table>
            </li>    
            <li>
                <p class="title">式神技能</p>
                
                    <p v-for="(ski,id) in skill" :key="id">
                        <img :src="'https://yys.res.netease.com/pc/zt/20161108171335/data/skill/'+id+'.png'"/>
                        {{ski.name}}<br/>
                        {{ski.normaldesc}}<br/>
                        <a v-for="a of ski.desc" :key="a.id">
                            <p>{{a}}</p>
                        </a>
                        
                    </p>
                    <hr/>
                
            </li>
        </ul>
        <p v-if="wakeadd.add_type == '3'">
            {{wakeadd.add}} 
        </p>
        <p v-else-if="wakeadd.add_type == '2'">
             <p1 v-for="(ski,id) in wakeadd" :key="id">
                <img :src="'https://yys.res.netease.com/pc/zt/20161108171335/data/skill/'+id+'.png'"/>
                {{ski.name}}<br/>
                {{ski.normaldesc}}<br/>
                <a v-for="a of ski.desc" :key="a.id">
                    <p>{{a}}</p>
                </a>
            </p1>
             {{wakeadd}} 
        </p>
        <p v-else-if="wakeadd.add_type == '1'">
            <p1 v-for="(ski,id) in wakeadd" :key="id">
                <img :src="'https://yys.res.netease.com/pc/zt/20161108171335/data/skill/'+id+'.png'"/>
                {{ski.name}}<br/>
                {{ski.normaldesc}}<br/>
                <a v-for="a of ski.desc" :key="a.id">
                    <p>{{a}}</p>
                </a>
            </p1>
            {{wakeadd}} 
        </p>
          
    </div>
</div>  
</template>

<script>
export default {
    name: 'info',
    data() {
        return {
            id:this.$route.params.id,
            story: [],
            skill:[],
            beforewake:{
                awakeitem:[],
                critPower: 0.0,
                defense: 0,
                speed: 0,
                attack: 0,
                maxHp: 0,
            }, 
            afterwake: {},
            wakeadd: {}  
        }
    },
    created: function(){
        this.getAfterAttr();
        this.getBeforeAttr();
        this.getWakeAdd();
        let id = this.$route.params.id;
        console.log("info is created");
        this.$indicator.open('loading...');
        this.$http.jsonp('https://g37simulator.webapp.163.com/get_hero_story?heroid='+id).then(function(response) {
            console.log(response.data.data.story);
            this.story = response.data.data.story;
            // this.$set("ss",response.data.data)
            this.$indicator.close();
        });
        //https://g37simulator.webapp.163.com/get_hero_skill?callback=jQuery111308569171892580948_1509002252967&heroid=217&awake=1&level=0&star=2&_=1509002252968  afterawake
        this.$http.jsonp('https://g37simulator.webapp.163.com/get_hero_skill?heroid='+id+'&awake=0&level=0&star=2').then(function(response) {
            console.log(response.data.data);
            let temp = response.data.data;
            delete temp.add;
            delete temp.add_type;
            this.skill = temp;
            // this.$set("ss",response.data.data)
            this.$indicator.close();
        });
    },
    methods:{
        getInfo: function() {
            this.$http.jsonp('https://g37simulator.webapp.163.com/get_hero_skill?heroid=' + this.id + '&awake=0&level=0&star=2')
            .then(function(response) {
                console.log(response.data.data);
                let temp = response.data.data;
                delete temp.add;
                delete temp.add_type;
                this.skill = temp;
                // this.$set("ss",response.data.data)
                this.$indicator.close();
            });
        },
        getBeforeAttr:function(){
            this.$http.jsonp('https://g37simulator.webapp.163.com/get_hero_attr?heroid='+this.id+'&awake=0&level=2&star=2&_=1524293310677')
            .then(function(response){
                let temp = response.data.data;
                this.beforewake = temp;
            });
        },
        getAfterAttr:function(){
            this.$http.jsonp('https://g37simulator.webapp.163.com/get_hero_attr?heroid='+this.id+'&awake=1&level=2&star=2&_=1524293310677')
            .then(function(response){
                let temp = response.data.data;
                this.afterwake = temp;
            });
        },
        getWakeAdd: function(){
             this.$http.jsonp('https://g37simulator.webapp.163.com/get_hero_skill?heroid='+this.id+'&awake=1&level=0&star=2&_=1524293310677')
            .then(function(response){
                let temp = response.data.data;
                this.wakeadd = temp;
            });
        }
    }
}
</script>

<style>
li {
    list-style-type: none;
    margin-left: 10px;
    margin-right: 10px;
}

ul {
    display: inline;
    text-align: left;
}

li>p.title {
    background-color: gray;
    border: none;
    color: white;
    text-indent: 1em;
}
td{
    text-align: center;
    width: 5%;
}
/* table.wakeitem{
    font-size: 6px;
} */
</style>
