# Lydia-webshop


The frontend is prepared to use env variables with the nginx docker image, 
but currently this works only on Linux because of the Linux scripts.
If you want to run the frontend locally on Windows, delete the "prestart" script from package.json,
and use process.env instead of window._env_ to get environment variables in App.tsx:
```
axios.defaults.baseURL = process.env.REACT_APP_BACKEND_URL;
```
