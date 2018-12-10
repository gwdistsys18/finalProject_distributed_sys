import React, { Component } from 'react';
import PropTypes from 'prop-types';

import './index.scss';

class UiButton extends Component {
  constructor(props) {
    super(props);
  }

  render() {
    return (
      <button className={"ui-button " + this.props.buttonType} 
        type="submit" disabled={this.props.disabled}>
        { this.props.buttonName }
      </button>
    )
  }
}

UiButton.propTypes = {
  buttonName: PropTypes.string,
  buttonType: PropTypes.string,
  buttonDisabled: PropTypes.bool
}

UiButton.defaultProps = {    
  disabled: false
}

export default UiButton;
