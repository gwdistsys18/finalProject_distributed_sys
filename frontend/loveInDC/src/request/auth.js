import axios from '../config/http';

import qs from 'qs';

export const login = ({username, password}, res, rej) => {
  axios.post("/login", qs.stringify({
    username,
    password
  }))
  .then(res)
  .catch(rej);
}

export const signup = ({username, password}, res, rej) => {
  axios.post("/signup", qs.stringify({
    username,
    password
  }))
  .then(res)
  .catch(rej);
}
