<script lang="ts" setup>
import { useDark } from "@vueuse/core"
import { Sunny,Moon } from "@element-plus/icons-vue"

const isDark = useDark()
</script>

<template>
    <el-switch size="large" v-model="isDark"
        :active-icon="Moon" :inactive-icon="Sunny" inline-prompt
        style="--el-switch-on-color: #000000; --el-switch-off-color: #ebb563;"
        />
</template>
