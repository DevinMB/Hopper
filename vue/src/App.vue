<template>
  <div id="app">
    <header id="routerLinkTest">
      <router-link class="routerlinks" v-bind:to="{ name: 'home' }">
        <img
          class="hopperLogo"
          src="../src/resources/logoAndName.png"
          alt="HopperLogo"
        />
      </router-link>
    </header>
    <body>
      <div class="nav">
        <!-- would like to make this one router link that references a method... if there is time -DMB -->
        <div class="nav-header">
          <div class="nav-home">
            <router-link
              tag="a"
              class="home"
              v-bind:to="{ name: 'home' }"
              v-if="
                $store.state.token == '' ||
                $store.state.user.authorities[0].name == 'ROLE_USER'
              "
              >Home</router-link
            >
            <router-link
              tag="a"
              class="home"
              v-bind:to="{ name: 'AdminHome' }"
              v-if="
                $store.state.token != '' &&
                $store.state.user.authorities[0].name == 'ROLE_ADMIN'
              "
              >Home
            </router-link>
            <router-link
              tag="a"
              class="home"
              v-bind:to="{
                name: 'brewerHome',
                params: { id: this.$store.state.brewerHomeBrewery },
              }"
              v-if="
                $store.state.token != '' &&
                $store.state.user.authorities[0].name == 'ROLE_BREWER'
              "
              >Brewer Page
            </router-link>
          </div>
          <span
            class="nav-home"
            v-if="
              $store.state.token != '' &&
              $store.state.user.authorities[0].name == 'ROLE_BREWER'
            "
            >&nbsp;|&nbsp;</span
          >
          <div class="nav-home">
            <router-link
              class="home"
              v-bind:to="{ name: 'home' }"
              v-if="
                $store.state.token != '' &&
                $store.state.user.authorities[0].name == 'ROLE_BREWER'
              "
              >Breweries
            </router-link>
          </div>
        </div>
        <div class="nav-links">
          <span class="welcome">
            {{
              $store.state.token == ""
                ? ""
                : `Welcome, ${$store.state.user.username}`
            }}
          </span>
          <router-link
            v-bind:to="{ name: 'logout' }"
            v-if="$store.state.token != ''"
            id="logout"
            >Logout</router-link
          >
          <router-link
            id="login"
            v-bind:to="{ name: 'login' }"
            v-if="$store.state.token == ''"
            >Login
          </router-link>
          <span class="nav-links" v-if="$store.state.token == ''"
            >&nbsp;|&nbsp;</span
          >
          <router-link
            id="register"
            v-bind:to="{ name: 'register' }"
            v-if="$store.state.token == ''"
            >Register</router-link
          >
          <!-- Not sure what order the nav should be, CSS designers figure it out please -->
        </div>
      </div>

      <router-view />
    </body>
    <footer>
      <div>Copyright © NLR Cohort 6 Hopper Capstone</div>
      <div>Isaac - Neville - Luigi - Logan - Devin</div>
    </footer>
  </div>
</template>
<script>
export default {
  methods: {
    getBreweryIdByOwnerId() {
      for (let i = 0; i < this.$store.state.breweries.length; ++i) {
        if (
          this.$store.state.breweries[i].ownerId == this.$store.state.user.id
        ) {
          let id = (this.activeBreweryId =
            this.$store.state.breweries[i].breweryId);
          this.$store.commit("SET_ACTIVE_BREWERY", id);
        }
      }
    },
  },
  created() {
    this.getBreweryIdByOwnerId();
  },
};
</script>
<style>
@import url("https://fonts.googleapis.com/css2?family=Bebas+Neue&family=Londrina+Sketch&family=Questrial&display=swap");
body {
  background-image: url(../src/resources/41587_2021_1202_Figa_HTMLgrey.jpg);
  background-repeat: no-repeat;
  background-attachment: fixed;
  background-size: cover;
  background-color: rgb(129, 167, 129);
  margin-left: 0;
  margin-right: 0;
  font-family: "Questrial", sans-serif;
  margin-top: 0;
  margin-bottom: -1em;

}
header {
  display: flex;
  width: 100%;
  margin: -1em 0em;
  background-color: rgb(129, 167, 129);
  justify-content: center;
}
#nav {
  border: 1pm solid black;
}
.hopperLogo {
  width: 17%;
  padding: 1em;
}
footer {
  display: flex;
  justify-content: center;
  align-content: center;
  flex-direction: column;
  height: 5em;
  background-color: rgb(129, 167, 129);
  justify-content: center;
  align-content: center;
  align-items: center;
  margin: 1em 0em -1em 0em;
  bottom: 0;
  
  width: 100%;
}
.nav {
  height: 4.5vh;
  width: 100%;
  background-color: #252121;
  position: relative;
  margin-top: -5px;
}
.nav > .nav-header {
  display: inline;
}
.nav a {
  text-decoration: none;
  color: white;
}
.nav > .nav-header > .nav-title {
  display: inline-block;
  color: #fff;
  padding: 10px 10px 10px 10px;
}
.nav > .nav-btn {
  display: none;
}
.nav > .nav-links {
  display: inline;
  float: right;
}
.nav > .nav-links > a {
  display: inline-block;
  padding: 13px 10px 13px 10px;
  text-decoration: none;
  color: #efefef;
}
.nav > .nav-links > span {
  display: inline-block;
  padding: 13px 10px 13px 10px;
  text-decoration: none;
  color: #efefef;
}
.nav > .nav-header > .nav-home {
  display: inline-block;
  color: #fff;
  padding: 13px 10px 13px 10px;
  transition: all 0.3s ease-in;
  overflow-y: hidden;
  top: 50px;
  left: 0px;
}
.nav > .nav-header > .nav-home:hover {
  background-color: rgba(0, 0, 0, 0.3);
}
.nav > .nav-links > .welcome {
  display: inline-block;
  padding: 13px 10px 13px 10px;
  text-decoration: none;
  color: #efefef;
}
.nav > .nav-links > a:hover {
  background-color: rgba(0, 0, 0, 0.3);
}
.nav > #nav-check {
  display: none;
}
@media (max-width: 600px) {
  .nav > .nav-btn {
    display: inline-block;
    position: absolute;
    right: 0px;
    top: 0px;
  }
  .nav > .nav-btn > label {
    display: inline-block;
    width: 50px;
    height: 50px;
    padding: 13px;
  }
  .nav > .nav-btn > label:hover,
  .nav #nav-check:checked ~ .nav-btn > label {
    background-color: rgba(0, 0, 0, 0.3);
  }
  .nav > .nav-btn > label > span {
    display: block;
    width: 25px;
    height: 10px;
    border-top: 2px solid #eee;
  }
  .nav > .nav-links {
    position: absolute;
    display: block;
    width: 100%;
    background-color: #333;
    height: 0px;
    transition: all 0.3s ease-in;
    overflow-y: hidden;
    top: 50px;
    left: 0px;
  }
  .nav > .nav-links > a {
    display: block;
    width: 100%;
  }
  .nav > #nav-check:not(:checked) ~ .nav-links {
    height: 0px;
  }
  .nav > #nav-check:checked ~ .nav-links {
    height: calc(100vh - 50px);
    overflow-y: auto;
  }

  #routerLinkTest {
    border: 1px solid black;
  }

  #routerLinkTest.routerlinks {
    border: 2px solid red;
  }
}
</style>