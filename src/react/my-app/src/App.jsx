import './App.css'
import axios from 'axios';
import React, { useState, useEffect } from 'react';


function App() {
  const [books, setBooks] = useState([]);
  const [error, setError] = useState(null);
  const [loading, setLoading] = useState(true);
  useEffect( () => {
    const findAllBooks = async () => {
      try {
        const resp = await axios.get('http://localhost:8080/api/findAllBooks');
        console.log(resp.data);
        setBooks(resp.data);
        setLoading(false);
      }
      catch (e) {
        setError("Could not fetch list of books");
        setLoading(false);
        console.log(e);
      }

    };
    findAllBooks();
  }, []);
  if (error) {
    return <div>{error}</div>
  }
  if (loading) {
        console.log("loading");
    return <div>{loading}</div>
  }
  const bookList = books.map(book =>
    <li key={book.id}>
      <button>
        {book.title} by {book.author}
      </button>
    </li>
  );
  return (
    <div>
      <ul className='no-bullets-list'>
        {bookList}
      </ul>
    </div>
    
  )
}


export default App
