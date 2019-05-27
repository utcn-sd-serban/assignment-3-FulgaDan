import userModel from '../model/UserModel';

class LoginPresenter{
    onLogin(){
        const newUser = userModel.state.newUser;
        userModel.login(newUser.username, newUser.password).then( () => {
            userModel.changeNewSOUserProperty("username", "");
            userModel.changeNewSOUserProperty("password", "");
            window.location.assign("#/question-list");
        });
        window.location.assign("#/"); 
    }

    onChange(property, value){
        userModel.changeNewUserProperty(property, value);
    }
}

const loginPresenter = new LoginPresenter();
export default loginPresenter;