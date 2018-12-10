const merge = require('webpack-merge');
const baseWebpackConfig = require('./webpack.base.config.js');

module.exports = merge(baseWebpackConfig, {
  mode: 'production',
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
