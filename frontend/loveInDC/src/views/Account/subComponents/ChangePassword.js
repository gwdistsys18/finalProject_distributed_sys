import React, { Component } from 'react';
import PropTypes from 'prop-types';

class ChangePassword extends Component {
  render() {
    let {title} = this.props;
    return (
      <div className="setting-info">
        <h3>{title}</h3>
        <form>

        </form>
      </div>
    )
  }
}

ChangePassword.propTypes = {
  title: PropTypes.string
}

export default ChangePassword;
