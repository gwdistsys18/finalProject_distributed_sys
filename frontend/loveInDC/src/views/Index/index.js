import React, { Component } from 'react';
import PropTypes from 'prop-types';
import axios from '../../config/http';

import './index.scss';

class Index extends Component {
  test() {
    axios.get("/userpreference/test")
      .then((ret) => {
        console.log(ret);
      });
  }

  render() {
    return (
      <div className="index">
        Love In DC.
        <button onClick={() => this.test()}/>
      </div>
    )
  }
}

export default Index;
