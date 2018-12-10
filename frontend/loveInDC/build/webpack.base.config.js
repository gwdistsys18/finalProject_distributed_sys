const path = require('path');
const webpack = require('webpack');
const HtmlWebpackPlugin = require('html-webpack-plugin');
const CleanWebpackPlugin = require('clean-webpack-plugin');
const MiniCssExtractPlugin = require('mini-css-extract-plugin');
const proxy = require('http-proxy-middleware');

module.exports = {
  entry: {
    app: path.join(__dirname, '../src/index.js'),
    vendor: ['react', 'react-dom', 'axios']
  },
  output: {
    filename: '[name].[chunkhash].js',
    path: path.join(__dirname, '../dist')
  },
  module: {
    rules: [
      {
        test: /.js$/,
        loader: 'babel-loader',
        include: path.resolve(__dirname, '../src')
      },
      {
        test: /\.css$/,
        loader: ['style-loader', 'css-loader']
      },
      {
        test: /\.scss$/,
        loaders: ['style-loader', 'css-loader', 'sass-loader']
      },
      {
        test: /\.(png|jpg)$/,
        loader: 'url-loader'
      },
      {
        test: /\.(woff|woff2|eot|ttf|svg)$/,
        loader: 'url-loader'
      }
    ]
  },
  optimization: {
    splitChunks: {
      chunks: "all",
      minChunks: 1,
      minSize: 0,
      cacheGroups: {
        vendor: {
          test: "vendor",
          name: "vendor"
        }
      }
    }
  }
};