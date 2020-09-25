import React from 'react';
import './App.css';
import Header from './component/Header'
import {Route, BrowserRouter, Switch} from 'react-router-dom';
import Products from './component/Products'

function App() {
  return (
	  <div className="App">
		<BrowserRouter>
		  <Header></Header>
		  <Products></Products>
		</BrowserRouter>
	  </div>
  );
}

export default App;
