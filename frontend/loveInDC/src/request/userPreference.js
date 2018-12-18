import axios from '../config/http';

import qs from 'qs';

const url = "/userpreference";

export const getUserInfoById = (id, res, rej) => {
  axios.get(url + `/preference/${id}`, {})
    .then(res)
    .catch(rej);
}

export const addUserInfoById = (id, res, rej) => {
  axios.post(url + `/preference/${id}`)
  .then(res)
  .catch(rej);
}

export const updateUserPreferenceById = (id, data, res, rej) => {
  axios.put(url + `/preference`, qs.stringify({
    ...data,
    id: id
  }))
  .then(res)
  .catch(rej);
}
