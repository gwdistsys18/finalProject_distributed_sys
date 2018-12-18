import axios from '../config/http';

import qs from 'qs';

const url = '/personalInfo'

export const getUserInfo = (res, rej) => {
  axios.get(url + '/findSelf')
  .then(res)
  .catch(rej);
}

export const updateUserInfo = (data, res, rej) => {
  axios.post(url + '/update', qs.stringify(data))
  .then(res)
  .catch(rej);
}