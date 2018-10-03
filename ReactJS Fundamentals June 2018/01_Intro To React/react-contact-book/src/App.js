import React from 'react';
import './App.css';
import './style/contactBook.css';
import ContactList from './app/contacts.json';
import rerender from './index';

let contactIndex = 0;

const makeContact = (data, currentIndex) => (
  <div className="contact" key={data.phone} onClick={e => selectDetailsContact(currentIndex)} data-id="id">
    <span className="avatar small">&#9787;</span>
    <span className="title">{data.firstName} {data.lastName}</span>
  </div>
);

const selectDetailsContact = index => {
  contactIndex = index;
  rerender(App(), document.getElementById('root'));
};

const renderList = () => {
  const resultList = [];

  for (let contact of ContactList) {
    resultList.push(makeContact(contact, resultList.length));
  }

  return resultList;
}

const showContactDetails = contact => (
  <div id="details">
    <h1>Details</h1>
    <div className="content">
      <div className="info">
        <div className="col">
          <span className="avatar">&#9787;</span>
        </div>
        <div className="col">
          <span className="name">{contact.firstName}</span>
          <span className="name">{contact.lastName}</span>
        </div>
      </div>
      <div className="info">
        <span className="info-line">&phone; {contact.phone}</span>
        <span className="info-line">&#9993; {contact.email}</span>
      </div>
    </div>
  </div>
);

const App = () => (
  <div className="container">
    <header>&#9993; Contact Book</header>
    <div id="book">
      <div id="list">
        <h1>Contacts</h1>
        <div className="content">
          {renderList()}
        </div>
      </div>
      <div id="details">
        <h1>Details</h1>
        {showContactDetails(ContactList[contactIndex])}
      </div>
    </div>
    <footer>Contact Book SPA &copy; 2017</footer>
  </div>
);

export default App;
