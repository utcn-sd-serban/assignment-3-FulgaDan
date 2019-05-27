import React from 'react';
import './App.css';
import SmartQuestionsList from './view/SmartQuestionList';
import SmartLogin from './view/SmartLogin';
import {HashRouter, Switch, Route} from 'react-router-dom';
import SmartCreateQuestion from './view/SmartCreateQuestion';

const App = () => (
  <div className="App">
      <HashRouter>
        <Switch>
          <Route exact = {true} component = {SmartLogin} path = "/" />
          <Route exact = {true} component = {SmartQuestionsList} path = "/question-list" />
          <Route exact = {true} component = {SmartCreateQuestion} path = "/create-question" />
        </Switch>
      </HashRouter>
    </div>
);

export default App;
