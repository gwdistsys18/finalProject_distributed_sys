import React, { Component } from 'react';
import PropTypes from 'prop-types';

import './index.scss';

class UiFormGroup extends Component {
  render() {
    let {
      name, 
      disabled, 
      typeName
    } = this.props;
    
    return (
      <div className="form-group">
        <label>{name}</label>
        <input type={typeName} placeholder={this.props.holder} 
          value={ this.props.value }
          onChange={e => this.props.handleChange(e.target.value)}
          disabled={disabled}/>
      </div>
    )
  }
}

UiFormGroup.propTypes = {
  name: PropTypes.string,
  holder: PropTypes.string,
  value: PropTypes.string,
  handleChange: PropTypes.func,
  typeName: PropTypes.string,
  disabled: PropTypes.bool
}

UiFormGroup.defaultProps = {
  holder: '', 
  typeName: 'text',
  disabled: false
}

export default UiFormGroup;
