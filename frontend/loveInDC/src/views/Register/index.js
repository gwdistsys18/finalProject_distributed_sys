import React, { Component } from 'react';
import PropTypes from 'prop-types';

import './index.scss';

import UiInput from '../../components/UiInput';
import UiButton from '../../components/UiButton';

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

  changeEmail(email) {
    this.setState({
      email: email
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

  isDisabled() {
    return this.state.email == "" 
      || this.state.password == ""
      || this.state.rePassword == "";
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
          <UiInput name={"Password"} typeName={"password"} value={this.state.password} handleChange={this.changePassword.bind(this)}/>
          <UiInput name={"Repeat Password"} typeName={"password"} value={this.state.rePassword} handleChange={this.changeRePassword.bind(this)}/>
          <UiButton buttonName={"SignUp"}
            buttonType={"ui-button--primary"}
            disabled={this.isDisabled()}/>
        </div>
      </form>
    )
  }
}

export default Register;
