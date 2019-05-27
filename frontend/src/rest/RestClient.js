const BASE_URL = "http://localhost:8080";

export default class RestClient{
    constructor(username, password){
        this.username = "";
        this.password = "";
        this.authorization = "Basic" + btoa(username + ":" + password);
    }

    loadAllQuestions(){
        return fetch(BASE_URL + "/questions", {
            method: "GET",
            headers: {
                "Authorization": this.authorization
            }
        }).then(response => response.json());
    }

    createQuestion(title, text, tags) {
        return fetch(BASE_URL + "/questions", {
            method: "POST",
            body: JSON.stringify({
                title: title,
                text: text,
                tags: tags
            }),
            headers: {
                "Authorization": this.authorization,
                "Content-Type": "application/json"
            }
        }).then(response => response.json());
    }

    loginUser = (username, password) => {
        return fetch(BASE_URL + "/", {
            method: "POST",
            body: JSON.stringify({
                username: username,
                password: password
            }),
            headers: {
                "Content-type": "application/json"
            }
        });
    };
}