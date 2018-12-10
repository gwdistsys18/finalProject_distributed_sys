import React, { Component } from 'react';
import PropTypes from 'prop-types';
import axios from '../../config/http';

import './index.scss';

import Header from '../../commons/Header';

class Index extends Component {
  render() {
    return (
      <div>
        <Header/>
        <div className="index">
          Love In DC.
        </div>
      </div>
    )
  }
}

export default Index;
