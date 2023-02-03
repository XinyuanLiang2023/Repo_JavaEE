<script setup lang="ts">

import HelloWorld from '../components/HelloWorld.vue'
import Img from '@/assets/images/my.png'

</script>

<template>
  <header>
    
    <div class="wrapper">
      <HelloWorld msg="You did it!" />
    </div>
  </header>
  <img :src="Img" width="600" height="400"> 

</template>

<style scoped>
header {
  line-height: 1.5;
}

.logo {
  display: block;
  margin: 0 auto 2rem;
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
