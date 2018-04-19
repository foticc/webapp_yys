<template>
    <div>
        <div>
            <img src="https://yys.res.netease.com/pc/zt/20161108171335/data/shishen_big_beforeAwake/200.png" width="25%" height="25%">
        </div>
        <div>
            <p>{{id}}</p>
        </div>
        <div>
            <ul>
                <li>
                    <p class="title">fffffffffffffffffffffffffff</p>
                </li>
                <li>
                    <p class="title">fffffffffffffffffffffffffff</p>

                </li>
                <li>
                    <table>
                        <tr>
                            <td colspan="2" style="text-align:right">Q</td>
                            <td>h</td>

                        </tr>
                        <tr>
                            <td>1</td>
                            <td>2</td>
                            <td>3</td>
                        </tr>
                        <tr>
                            <td>4</td>
                            <td>5</td>
                            <td>6</td>
                        </tr>
                        <tr>
                            <td>7</td>
                            <td>8</td>
                            <td>9</td>
                        </tr>
                        <tr>
                            <td></td>
                            <td></td>
                            <td></td>
                        </tr>
                        <tr>
                            <td></td>
                            <td></td>
                            <td></td>
                        </tr>
                        <tr>
                            <td></td>
                            <td></td>
                            <td></td>
                        </tr>
                        <tr>
                            <td></td>
                            <td></td>
                            <td></td>
                        </tr>
                    </table>
                </li>
                <li>
                    <p class="title">fffffffffffffffffffffffffff</p>
                    <p>
                        <img src="" alt="">x fasdfasdf
                        <hr>
                    </p>
                </li>
                <li>
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
            id: this.$route.params.id,
            skill:[]
        }
    },
    created: function(){
        this.getInfo();
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
