import React, { Component } from 'react';
import PropTypes from 'prop-types';

import './index.scss';

import UiInput from '../../components/UiInput';
import UiButton from '../../components/UiButton';

class Login extends Component {
  constructor(props) {
    super(props);
    this.state = {
      email: "",
      password: ""
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

  isDisabled() {
    return this.state.email == "" || this.state.password == "";
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
          <UiInput name={"Email"} value={state.email} handleChange={this.changeEmail.bind(this)}/>
          <UiInput name={"Password"} value={state.password} handleChange={this.changePassword.bind(this)}/>
          <UiButton buttonName={"Login"} 
            buttonType={"ui-button--primary"}
            disabled={this.isDisabled()}/>
        </div>
      </form>
    )
  }
}

export default Login;
