import React from 'react';
import ReactDOM from 'react-dom';
import './index.css';
import * as serviceWorker from './serviceWorker';
//import App from './app'
import LoginContainer from './login/login-container';


import 'bootstrap/dist/css/bootstrap.min.css';

ReactDOM.render(
    <LoginContainer />,
    document.getElementById('root'));

// If you want your app to work offline and load faster, you can change
// unregister() to register() below. Note this comes with some pitfalls.
// Learn more about service workers: http://bit.ly/CRA-PWA
serviceWorker.unregister();
