const path = require('path')
const { defineConfig } = require('@vue/cli-service')
const NodePolyfillPlugin = require('node-polyfill-webpack-plugin')

module.exports = defineConfig({
  transpileDependencies: true,
  devServer:{
    client: {
      overlay: {
        warnings: false,
        errors: true,
      },
    },
  },
  lintOnSave: false,
  // webpack5引入polyfills
  configureWebpack: {
    resolve: {
      alias: {},
      fallback: {
        //其他的如果不启用可以用 keyname :false，例如：crypto:false, 
        "crypto": require.resolve("crypto-browserify"),
        "stream": require.resolve("stream-browserify")
      },
    },
    plugins: [new NodePolyfillPlugin()]
  }
})
