import Vue from 'vue'
import Vuex from 'vuex'
import getters from './getters'

import { createStore } from 'vuex'
// Vue.use(Vuex)

// https://webpack.js.org/guides/dependency-management/#requirecontext
const modulesFiles = require.context('./modules', true, /\.js$/)

// you do not need `import app from './modules/app'`
// it will auto require all vuex module from modules file
const modules = modulesFiles.keys().reduce((modules, modulePath) => {
  // set './app.js' => 'app'
  const moduleName = modulePath.replace(/^\.\/(.*)\.\w+$/, '$1')
  const value = modulesFiles(modulePath)
  modules[moduleName] = value.default
  return modules
}, {})

// const store = new Vuex.Store({
//   modules,
//   getters
// })

const store = createStore({
  state: {
    name:'test',
    sum:0
  },
  mutations: {
  },
  actions: {
  },
  // 应用时机：state中的数据需要经过加工后在使用时
  // getters: {
    
  // },
  getters,
  // modules: {
    
  // }
  modules
  
  
})
console.log(store.state);
export default store
