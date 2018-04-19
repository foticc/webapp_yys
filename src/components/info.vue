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
                        <td colspan="2" style="padding-left:115px;">觉醒前</td>
                        <td>觉醒后</td>
                    
                    </tr>
                    <tr>
                        <td>攻击</td>
                        <td>2</td>
                        <td>3</td>
                    </tr>
                    <tr>
                        <td>生命</td>
                        <td>5</td>
                        <td>6</td>
                    </tr>
                    <tr>
                        <td>防御</td>
                        <td>8</td>
                        <td>9</td>
                    </tr>
                    <tr>
                        <td>速度</td>
                        <td></td>
                        <td></td>
                    </tr>
                    <tr>
                        <td>暴击</td>
                        <td></td>
                        <td></td>
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
           
    </div>
</div>  
</template>

<script>
export default {
    name: 'info',
    data() {
        return {
            story: [],
            skill:[],
            awake:{
                critPower: 0.0,
                defense: 0,
                speed: 0,
                attack: 0,
                maxHp: 0,
            }
        }
    },
    created: function(){
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
}
</style>
