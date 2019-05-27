import {EventEmitter} from 'events'
import RestClient from '../rest/RestClient';
import WebSocketListener from '../ws/WebSocketListener';

const client = new RestClient();
const listener = new WebSocketListener();

class QuestionModel extends EventEmitter {
    constructor(){
        super();
        this.state = {
            questions: [/*{
                title: "How to dispatch an action?",
                text: "I need to dispatch an action using Redux",
                author: "Dave",
                date: "04/05/2019",
                tags: ["React ", "React-Native"]
            },
            {
                title: "maven dependency failing",
                text: "maven fails to install",
                author: "Anna",
                date: "03/05/2019",
                tags: ["Java ", "Maven"]
            }*/],

            newQuestion: {
                title: "",
                text: "",
                tags: []
            }
        };
    }

    loadQuestions(){
        return client.loadAllQuestions().then(questions => {
            this.state = {
                ...this.state,
                questions: questions
            };
            this.emit("change", this.state);
        })
    }

    addQuestion(title, text, tags){
        return client.createQuestion(title, text, tags).then(question => this.appendQuestion(question));
        
    }

    appendQuestion(question){
        this.state = {
            ...this.state,
            questions: this.state.questions.concat([question])
        };
        this.emit("change", this.state);
    }

    changeNewQuestionProperty(property, value){
        this.state = {
            ...this.state,
            newQuestion: {
                ...this.state.newQuestion,
                [property]: value
            }
        };
        this.emit("change", this.state);
    }
}

listener.on("event", event => {
    if(event.type == "QUESTION_CREATED"){
        questionModel.appendQuestion(event.question);
    }
});

const questionModel = new QuestionModel();
export default questionModel;