import questionModel from "../model/QuestionModel";


class QuestionsListPresenter {
    onCreateQuestion() {
        window.location.assign("#/create-question");
    } 

    onInitt(){
        questionModel.loadQuestions();
    }
}

const questionsListPresenter = new QuestionsListPresenter();

export default questionsListPresenter;