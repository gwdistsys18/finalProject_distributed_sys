const webpack = require('webpack');
const path = require('path');
const merge = require('webpack-merge');
const HtmlWebpackPlugin = require('html-webpack-plugin');
const baseWebpackConfig = require('./webpack.base.config.js');

module.exports = merge(baseWebpackConfig, {
  mode: 'development',
  output: {
    filename: '[name].[hash:16].js',
  },
  plugins: [
    new HtmlWebpackPlugin({
      template: path.join(__dirname, '../public/index.html'),
      hash: true,
      minify: {
        removeComments: true,
        collapseWhitespace: false
      }
    }),
    new webpack.HotModuleReplacementPlugin()
  ],
  devServer: {
    port: '3000',
    contentBase: path.join(__dirname, '../dist'),
    compress: true,
    hot: true,
    https: false,
    noInfo: true,
    open: true,
    proxy: {}
  },
  devtool: "#source-map"
});
