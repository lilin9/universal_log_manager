<template>

    <div class="pnl_wraper">
      <div class="layer bg" id="login"></div>
        <div class="flex-center pnl_content">
            <div class="pnl_desc">
              <a class="icon_log" target="_blank" href="https://github.com/lilin9"></a>
              <p>一个简单好用的Java日志组件</p>
              <p>支持上万条日志并发</p>
              <p>可以更方便快捷的去查询管理日志</p>
            </div>
            <div class="pnl_login">
                <div class="title">登录</div>
                <div class="pnl_input">
                    <input v-model="formData.username" type="text" placeholder="输入用户名" id="txtUserName" /><br/>
                    <input v-model="formData.password" type="password" placeholder="输入密码" @keyup.enter="submit" id="txtPassWord" /><br/>
                    <input @click="submit" type="button" value="提交" id="btn_login"/>
                </div>
            </div>
        </div>
    </div>
</template>
<script>
require('particles.js')
import config from './config/nasa.js'
import router from "@/router";
    import axios from 'axios'
    export default {
        name: "Login",
      data() {
          return {
            formData: {
              username:null,
              password:null
            }
          }
      },
      mounted() {
        particlesJS('login', config)
        axios.post(process.env.VUE_APP_API+ '/logout').then(res=> {
          console.log(res.data)
        })
      },
      methods: {
          submit() {
            axios.post(process.env.VUE_APP_API+ '/login', this.formData).then(res=> {
              if(res.data.code === 402) {
                alert("用户名或密码错误！")
              } else {
                router.replace({
                  path: '/'
                })
              }
            })
          }
      }
    }
</script>
<style lang="less" scoped>
.navbar {
  justify-content: flex-start;
  .icon_log
  {
    background: url('../assets/icon_name.png') no-repeat;
    background-size: contain;
    padding-left: 150px;
    height:40px;
  }
  .navbar-nav{
    position: absolute;
    right:15px;
    flex-direction:row;
    .nav-link{
      color:#fff;
      opacity: .6;
      font-family: Avenir-Medium;
      font-size: 16px;
      font-weight: bold;
      padding-right: 1.5rem;
      padding-left: .5rem;
    }
  }
  .version
  {
    position: absolute;
    top:16px;
    right:20px;
    font-size: 15px;
    color:#5584ff;
  }
}
    .pnl_wraper{
        color:#fff;
        background: url("../assets/black_dot.png") 0% 0% repeat;
        height: 100vh;
      .layer {
        position: absolute;
        height: 100%;
        width: 100%;
        &.flex-center {
          display: flex;
          justify-content: center;
          align-items: center;
          flex-direction: column;
        }
      }
        .pnl_content
        {
            position: relative;
            .pnl_desc
            {
                position: absolute;
                top:200px;
                left:100px;
                text-align: left;
                font-family: Avenir-Medium,Inter,-apple-system,BlinkMacSystemFont,Segoe UI,Helvetica,Arial,sans-serif,Apple Color Emoji,Segoe UI Emoji,Segoe UI Symbol;
                width:500px;

                .title{
                    font-size:50px;
                }
                .desc{
                    font-size:20px;
                }
                .icon_log
                {
                  display: block;
                  background: url('../assets/icon_name.png') no-repeat;
                  background-size: contain;
                  padding-left: 150px;
                  height:140px;
                }
              p {
                opacity: .8;
                font-family: Avenir-Medium;
                font-size: 24px;
                color: #fff;
                max-width: 780px;
                text-align: left;
              }
            }
            .pnl_login
            {
                position: absolute;
                top: 100px;
                right: 100px;
                height:450px;
                width:450px;
                //border-radius: 20px;
                background: #fff;

                .title{
                    margin-top: 30px;
                    font-size:32px;
                    color:#000;
                }

                .pnl_input
                {
                    margin-top:50px;
                    #txtUserName,#txtPassWord
                    {
                        outline-color: #5584ff;
                        outline-width: 1px;
                        height:50px;
                        font-size:16px;
                        text-indent: 10px;
                        border:1px solid #ccc;
                        width:300px;
                        margin-bottom: 30px;
                    }
                }

                #btn_login
                {
                    display: inline-block;
                    width:300px;
                    height:50px;
                    line-height: 50px;
                    color:#fff;
                    font-size:16px;
                    background: #5584ff;
                    border:none;
                }
            }
        }
    }
</style>
