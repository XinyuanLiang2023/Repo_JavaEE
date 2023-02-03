
  
  <script lang="ts" setup>
  import { affixProps, ElMessageBox } from 'element-plus'
  import { reactive, ref, watchEffect } from 'vue'
  import type { FormInstance, FormRules } from 'element-plus'
  import axios from 'axios'
  const API_URL = 'http://localhost:8080/user-rest/add'
  const users = ref<Array<object>>([])
  
  watchEffect(async () => {
    try {
      const res = await fetch(API_URL)
      users.value = await res.json()
      console.log('status: ' + res.status)
    }
    catch (error) {
      console.log('Error! Could not reach the API.'+ error)
  }
  })
  
  const formSize = ref('default')
  const ruleFormRef = ref<FormInstance>()
  const ruleForm = reactive({
    name: '',
    email: '',
  })
  
  const rules = reactive<FormRules>({
    name: [
      { required: true, message: 'Please input your name', trigger: 'blur' },
      { min: 4, max: 15, message: 'Length should be 4 to 15', trigger: 'blur' },
    ],
    email: [
      {
        required: true,
        type: 'email',
        message: 'Please input correct email address',
        trigger: ['blur', 'change'],
      },
    ]
  })
  
  const submitForm = async (formEl: FormInstance | undefined) => {
    if (!formEl) return
    await formEl.validate((valid, fields) => {
      if (valid) {
        console.log('submit!')
        axios.post(API_URL,ruleForm);
      } else {
        console.log('error submit!', fields)
      }
    })
  }
  
  const resetForm = (formEl: FormInstance | undefined) => {
    if (!formEl) return
    formEl.resetFields()
  }
  
  
  const dialogVisible = ref(false)
  
  
  </script>
 <template>
    <el-button type="primary" @click="dialogVisible = true">Add</el-button>
    
    <el-dialog v-model="dialogVisible" title="Add a User" width="30%">
      <el-form ref="ruleFormRef" :model="ruleForm" :rules="rules" label-width="120px" class="demo-ruleForm"
        :size="formSize" status-icon>
        <!-- name -->
        <el-form-item label="Name" prop="name">
          <el-input v-model="ruleForm.name" />
        </el-form-item>
  
        <!-- email -->
        <el-form-item label="Email" prop="email">
          <el-input v-model="ruleForm.email" />
        </el-form-item>
  
        <el-form-item>
          <el-button @click="resetForm(ruleFormRef)">Reset</el-button>
          <el-button type="primary" @click="submitForm(ruleFormRef)">Confirm</el-button>
        </el-form-item>
      </el-form>
    </el-dialog>
  </template> 
  