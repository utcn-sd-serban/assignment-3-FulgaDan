import React from 'react'

const CreateQuestion = ({ title, text, author, date, 
                        tags, onCreate, onChange}) => (
    <div>
        <h1 className = "title">{"Add question"}</h1>
        <div className = "container is-fluid">
            <div className = "notification">
            <label className = "label">Title: </label>
            <input value = {title} onChange ={ e=> onChange("title", e.target.value)} />
            <br />
            <label className = "label">Text: </label>
            <input value = {text} onChange = {e => onChange("text", e.target.value)} />
            <br />
            <label className = "label">Tags: </label>
            <input value = {tags} onChange = {e => onChange("tags", e.target.value)} />
            <br />
            <button onClick = {onCreate}>Create!</button>
            <hr />
            </div>                 
        </div>
    </div>
);

export default CreateQuestion;