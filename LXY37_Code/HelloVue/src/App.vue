<script setup>
import {RouterLink,RouterView} from 'vue-router'

</script>

<template>
  
  <header>
    <img alt="Vue logo" class="logo" src="./assets/logo.svg" width="125" height="125" />
    <div class="wrapper">
    <nav>
    <RouterLink to="/">Home</RouterLink>&nbsp;
    <RouterLink to="/user">User Manage</RouterLink>
    </nav>
    </div>

  </header>
<RouterView/>
</template>

<style scoped>
header {
  line-height: 1.5;
  max-height:100vh;
}

.logo {
  display: block;
  margin: 0 auto 2rem;
}
nav {
  
  font-size: 20px;
  
}
@media (min-width: 1024px) {
  header {
    display: flex;
    place-items: center;
    padding-right: calc(var(--section-gap) / 2);
  }

  .logo {
    margin: 0 2rem 0 0;
  }

  header .wrapper {
    display: flex;
    place-items: flex-start;
    flex-wrap: wrap;
  }
}

.el-link {
  margin-right: 8px;
}
.el-link .el-icon--right.el-icon {
  vertical-align: text-bottom;
}
</style>
