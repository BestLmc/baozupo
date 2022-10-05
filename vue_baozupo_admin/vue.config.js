const { defineConfig } = require('@vue/cli-service')
module.exports = defineConfig({
  transpileDependencies: true,
  devServer:{
    client: {
      overlay: {
        warnings: true,
        errors: true,
      },
    },
  },
  lintOnSave: true
})
