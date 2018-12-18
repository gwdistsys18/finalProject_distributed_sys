import React, { Component } from 'react';
import PropTypes from 'prop-types';

import qs from 'qs';

import './index.scss';

import UiInput from '../../components/UiInput';
import UiButton from '../../components/UiButton';

import { login } from '../../request/auth';
import { validEmail } from '../../utils/validate';
import info from '../../utils/store';

class Login extends Component {
  constructor(props) {
    super(props);
    this.state = {
      email: "",
      password: "",
      errMsg: ""
    };
  }

  changeEmail(email) {
    let errMsg = "";
    if (!validEmail(email)) {
      errMsg = "Invalid Email Foramt";
    }

    this.setState({
      email: email,
      errMsg: errMsg
    });
  }

  changePassword(password) {
    this.setState({
      password: password
    });
  }

  checkEmpty() {
    return this.state.email == "" || this.state.password == ""; 
  }

  isDisabled() {
    return this.checkEmpty();
  }

  login() {
    let { email, password } = this.state;
    // if email is empty or password is empty
    if (this.checkEmpty()) return;
    // check if email is valid
    if (!validEmail(email)) return;
    login({
      username: email,
      password: password
    }, ({data}) => {
      if (data.code == 0) {
        localStorage.setItem("userId", data.data.id)
        location.href = '/#/account';
      }
    }, (err) => {
      
    });
  }

  render() {
    let state = this.state;
    let props = this.props;
    return (
      <form className="login-form">
        <div className="form-head">
          <h2>Login</h2>
          <p>
            No account?&nbsp;
            <a href="/#/signup">Register</a>
          </p>
        </div>
        <div className="form-body">
          <p className="err-msg" >{this.state.errMsg}</p>
          <UiInput name={"Email"} value={state.email} 
            handleChange={this.changeEmail.bind(this)}/>
          <UiInput name={"Password"} type={"password"} value={state.password} 
            handleChange={this.changePassword.bind(this)}/>
          <UiButton buttonName={"Login"}
            buttonType={"ui-button--primary"}
            clickEvent={() => this.login()}
            disabled={this.isDisabled()}/>
        </div>
      </form>
    )
  }
}

export default Login;
