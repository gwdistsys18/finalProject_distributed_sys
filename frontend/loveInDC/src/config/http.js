import axios from 'axios';

axios.defaults.headers = {
  "Content-Type": "application/x-www-form-urlencoded"
};

export default axios.create({
  baseURL:"http://18.234.207.159/api",
  timeout: 5000,
  withCredentials: true
});
