import React, {Component} from 'react';
import Login from './Login';
import userModel from '../model/UserModel';
import loginPresenter from '../presenter/loginPresenter';

const mapModelStateToComponentState = modelState => ({
    username: modelState.newUser.username,
    password: modelState.newUser.password
});


export default class SmartLogin extends Component{
    constructor(){
        super();
        this.state = mapModelStateToComponentState(userModel.state);
        this.listener = modelState => this.setState(mapModelStateToComponentState(modelState));
        userModel.addListener("change", this.listener);
    }
    render(){
        return(
            <Login onLogin = {loginPresenter.onLogin}
                   onChange = {loginPresenter.onChange}
                   username = {this.state.username}
                   password = {this.state.password} />
        );
    }
}