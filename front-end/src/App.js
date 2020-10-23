import React from 'react';
import './App.css';
import Header from './component/Header'
import {Route, BrowserRouter, Switch} from 'react-router-dom';
import Products from './component/Products'
import Orders from './component/Orders'
import Router from 'react-router-dom/es/Router'
import AddGoods from './component/AddGoods'

function App() {
  return (
	  <div className="App">
		<BrowserRouter>
		  <Header></Header>
		  <main>
			<Switch>
			  <Route exact path="/" component={Products} />
			  <Route exact path="/addGoods" component={AddGoods}/>
			  {/*<Orders></Orders>*/}
			</Switch>
		  </main>
		</BrowserRouter>
	  </div>

  );
}

export default App;
