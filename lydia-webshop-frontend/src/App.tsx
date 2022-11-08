import React from 'react';
import Products from './components/products/Products';
import axios from 'axios';

import 'bootstrap/dist/css/bootstrap.min.css';

const backendUrl = "http://localhost:8080";
axios.defaults.baseURL = backendUrl;

const App = () => {
  return (
    <div>
      Lydia-webshop
      <Products />
    </div>
  );
}

export default App;
