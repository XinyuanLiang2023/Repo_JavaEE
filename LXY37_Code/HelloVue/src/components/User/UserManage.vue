<script lang="ts" setup>

import { ref, watchEffect } from 'vue'
import { Edit, Delete } from '@element-plus/icons-vue'
import UserAddVue from './UserAdd.vue';  
import DarkThemeVue from '../DarkTheme.vue';



const API_URL = 'http://localhost:8080/user-rest/all'
const user = ref<Array<object>>([])

watchEffect(async () => {
        const res = await fetch(API_URL)
        user.value = await res.json()
})

</script>
<template>
    <el-row justify="space-between">
    <el-col :span="2">
      <user-add-vue/>
    </el-col>
    <el-col :span="2">
      <dark-theme-vue/>
    </el-col>
</el-row>
<el-divider/>


<el-table :data="user" stripe style="width: 100%">
    <el-table-column prop="id" label="ID" width="50"/>
    <el-table-column prop="name" label="Name" width="150"/>
    <el-table-column prop="email" label="Email"/>
    <el-table-column label="operations" width="150">
      <template #default="scope">
        <el-button size="small" @click="handleEdit(scope.$index, scope.row)"
          >Edit</el-button
        >
        <el-button
          size="small"
          type="danger"
          @click="handleDelete(scope.$index, scope.row)"
          >Delete</el-button
        >
    </template>
   </el-table-column>
  </el-table>
</template>