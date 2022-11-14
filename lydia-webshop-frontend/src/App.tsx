import React from 'react';
import Products from './components/products/Products';
import axios from 'axios';

import 'bootstrap/dist/css/bootstrap.min.css';

axios.defaults.baseURL = process.env.REACT_APP_BACKEND_URL;

const App = () => {
  return (
    <div>
      Lydia-webshop
      <Products />
    </div>
  );
}

export default App;
