import React, { Component } from 'react'


export default class QuestionList extends Component {
    render() {
        const { pageTitle, questions, onCreateQuestion, applyTitleFilter, titleFilter, applyTagsFilter, tagsFilter } = this.props;
        return (
            <div>
                <section className="hero">
                    <div className="hero-body">
                        <div className="container">
                            <h1 className="title">Welcome!</h1>
                            <h2 className="subtitle">{pageTitle || "These are the questions"}</h2>
                        </div>
                    </div>
                </section>
                <div>
                    <tablee className= "table is-narrow" border="1">
                        <thead>
                            <tr>
                                <th>Title</th>
                                <th>Text</th>
                                <th>Author</th>
                                <th>Date</th>
                                <th>Tags</th>
                            </tr>
                        </thead>
                        <tbody>
                            {
                                questions.map((question, index) => (
                                    <tr key={index}>
                                        <td>{question.title}</td>
                                        <td>{question.text}</td>
                                        <td>{question.author}</td>
                                        <td>{question.date}</td>
                                        <td>{question.tags}</td>
                                    </tr>
                                ))
                            }
                        </tbody>
                    </tablee>
                    <br />
                    <br />
                    <button onClick={onCreateQuestion}>Add new question</button>
                    <br />
                    <br />
                    <span>Title Filter: </span><input type="text" value={titleFilter} onChange={applyTitleFilter} />
                    <br />
                    <span>Tags Filter: </span><input type="text" value={tagsFilter} onChange={applyTagsFilter} />
                    <footer className="footer">
                        <div className="content has-text-centered">
                            <p>
                                <strong>Stack-Overflow</strong> by <a href="https://github.com/utcn-sd-serban/assignment-2-FulgaDan">Fulga Dan</a>.
                    Source code can be found on <a href="https://github.com/utcn-sd-serban/assignment-2-FulgaDan">Github</a>.
                            </p>
                        </div>
                    </footer>
                </div>
            </div>
        );
    }
}