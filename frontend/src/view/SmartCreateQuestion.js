import React, {Component} from 'react';
import questionModel from '../model/QuestionModel'

import CreateQuestion from '../view/CreateQuestion'
import createQuestionPresenter from '../presenter/createQuestionPresenter'

const mapModelStateToComponentState = modelState => ({
    title : modelState.newQuestion.title,
    text: modelState.newQuestion.text,
    author: modelState.newQuestion.author,
    date: modelState.newQuestion.date,
    tags: modelState.newQuestion.tags
});

export default class SmartCreateQuestion extends Component{
    constructor() {
        super();
        this.state = mapModelStateToComponentState(questionModel.state);
        this.listener = modelState => this.setState(mapModelStateToComponentState(modelState));
        questionModel.addListener("change", this.listener);
    }

    
    componentWillUnmount(){
        questionModel.removeListener("change", this.listener);
    }

    render(){
        return(
            <CreateQuestion onCreate = {createQuestionPresenter.onCreate} 
                            onChange = {createQuestionPresenter.onChange}
                            title = {this.state.title}
                            text = {this.state.text}
                            author = {this.state.author}
                            date = {this.state.date}
                            tags = {this.state.tags}/>
        );
    }
}