import Products from './components/products/Products';
import axios from 'axios';

import 'bootstrap/dist/css/bootstrap.min.css';

axios.defaults.baseURL = window._env_.REACT_APP_BACKEND_URL;

// if you want to run it locally on windows
// delete the prestart script from package.json
// and use process.env instead of window._env_ to get the environment variable:
// axios.defaults.baseURL = process.env.REACT_APP_BACKEND_URL;

const App = () => {
  return (
    <div>
      Lydia-webshop
      <Products />
    </div>
  );
}

export default App;
