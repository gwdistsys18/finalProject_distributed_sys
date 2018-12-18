import React, { Component } from 'react';
import PropTypes from 'prop-types';

import './index.scss';

// Components
import UiInput from '../../components/UiInput';
import UiButton from '../../components/UiButton';

// Request
import { signup } from '../../request/auth';
import { addUserInfoById } from '../../request/userPreference';

// Utils
import { validEmail } from '../../utils/validate';

const errStyle = {
  display: 'none'
};

class Register extends Component {
  constructor(props) {
    super(props);
    this.state = {
      email: "",
      password: "",
      rePassword: "",
      errMsg: ""
    }
  }

  signUp() {
    let {email, password} = this.state;
    if (!validEmail(email)) return;
    if (this.checkEmpty()) return;
    signup({
      username: email,
      password: password
    }, ({data}) => {
      if (data.code == 0) {
        alert("Sign Up Success");
        location.href="/#/account";
      } else {
        alert(data.msg);
      }
    }, (err) => {
      console.log(err);
    });
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

  changeRePassword(rePassword) {
    let errMsg = "";
    if (rePassword != "" && (this.state.password != rePassword)) {
      errMsg = "Different Password";
    }
    this.setState({
      rePassword: rePassword,
      errMsg: errMsg
    });
  }

  checkEmpty() {
    return this.state.email == "" 
      || this.state.password == ""
      || this.state.rePassword == "";
  }

  isDisabled() {
    return this.checkEmpty();
  }

  render() {
    
    return (
      <form className="register-form">
        <div className="form-head">
          <h2>Sign Up</h2>
          <p>
            Already has account?&nbsp;
            <a href="/#/login">Login</a>
          </p>
        </div>
        <div className="form-body">
          <p className="err-msg" >{this.state.errMsg}</p>
          <UiInput name={"Email"} value={this.state.email} handleChange={this.changeEmail.bind(this)}/>
          <UiInput name={"Password"} type={"password"} value={this.state.password} handleChange={this.changePassword.bind(this)}/>
          <UiInput name={"Repeat Password"} type={"password"} value={this.state.rePassword} handleChange={this.changeRePassword.bind(this)}/>
          <UiButton buttonName={"SignUp"}
            buttonType={"ui-button--primary"}
            clickEvent={() => this.signUp()}
            disabled={this.isDisabled()}/>
        </div>
      </form>
    )
  }
}

export default Register;
