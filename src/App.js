import React from 'react';
import { Route, Switch } from 'react-router-dom';

import './App.css';
import './Login.css';

import Login from './pages/Login';
import Home from './pages/Home';
import SingleRoom from './pages/SingleRoom';
import Rooms from './pages/Rooms';
import Contacts from './pages/Contacts';
import About from './pages/About';
import Navbar from './components/Navbar';

function App() {
  return (
    <>
      <Route>
        <Switch>
          <Route exact path="/" component={Login} />
          <div>
        <Navbar />
          <Route exact path="/Home" component={Home} />
          <Route exact path="/rooms" component={Rooms} />
          <Route exact path="/rooms/:slug" component={SingleRoom} />
          <Route exact path="/Contacts" component={Contacts} />
          <Route exact path="/About" component={About} />
          </div>
        </Switch>
      </Route>
    </>
  );
}

export default App;
