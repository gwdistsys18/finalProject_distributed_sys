import React, { Component } from 'react';
import PropTypes from 'prop-types';

import './index.scss';

class UiInput extends Component {
  constructor(props) {
    super(props);
  }

  render() {
    let {type, name, value} = this.props;
    let {handleChange} = this.props;
    return (
      <div className="ui-input">
        <input type={type} placeholder={name} 
          value={ value }
          onChange={e => handleChange(e.target.value)}/>
      </div>
    )
  }
}

UiInput.propTypes = {
  name: PropTypes.string,
  value: PropTypes.string,
  handleChange: PropTypes.func,
  type: PropTypes.string
}

UiInput.defaultProps = {    
  type: 'text'
}

export default UiInput;
