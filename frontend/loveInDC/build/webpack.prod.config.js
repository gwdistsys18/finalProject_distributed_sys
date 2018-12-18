const path = require('path');
const merge = require('webpack-merge');
const HtmlWebpackPlugin = require('html-webpack-plugin');
const CleanWebpackPlugin = require('clean-webpack-plugin');
const baseWebpackConfig = require('./webpack.base.config.js');

module.exports = merge(baseWebpackConfig, {
  mode: 'production',
  output: {
    publicPath: 'http://18.234.207.159/'
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
    new CleanWebpackPlugin(['../dist'], {allowExternal: true})
  ],
});
