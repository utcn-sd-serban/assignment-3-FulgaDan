import React, { Component } from 'react';
import questionModel from "../model/QuestionModel"
import QuestionList from './QuestionList';
import questionsListPresenter from '../presenter/questionsListPresenter';

const mapModelStateToComponentState = modelState => ({
    questions: modelState.questions
});

export default class SmartQuestionsList extends Component {
    constructor() {
        super();
        this.state = {
            ...mapModelStateToComponentState(questionModel.state),
            titleFilter: '',
            tagsFilter: '',
            results: [],
        };
        this.listener = modelState => this.setState(mapModelStateToComponentState(modelState));
        questionModel.addListener("change", this.listener);
        questionsListPresenter.onInitt();
    }


    componentWillUnmount() {
        questionModel.removeListener("change", this.listener);
    }

    getQuestions() {
        const { titleFilter, tagsFilter, results, questions } = this.state;
        return (titleFilter || tagsFilter) ? results : questions;
    }

    render() {
        return (
            <QuestionList
                onCreateQuestion={questionsListPresenter.onCreateQuestion}
                questions={this.getQuestions()}
                applyTitleFilter={event => {
                    const titleFilter = event.target.value;
                    this.setState({ titleFilter });
                    const results = this.state.questions.filter(q => q.title.includes(titleFilter) && q.tags.join().includes(this.state.tagsFilter));
                    this.setState({ results });
                }}
                applyTagsFilter={event => {
                    const tagsFilter = event.target.value;
                    this.setState({ tagsFilter });
                    const results = this.state.questions.filter(q => q.title.includes(this.state.titleFilter) && q.tags.join().includes(tagsFilter));
                    this.setState({ results });
                }}
                titleFilter={this.state.titleFilter}
                tagsFilter={this.state.tagsFilter}
            />
        );
    }
}