import React, { useState, useEffect } from 'react';
import { libraryService } from '../services/api';
import DeleteButton from './DeleteButton';

const BookList = () => {
    const [books, setBooks] = useState([]);
    const [error, setError] = useState(null);
    const [loading, setLoading] = useState(true);
    useEffect( () => {
        const fetchAllBooks = async () => {
            try {
                const allBooksRespones = await libraryService.findAllBooks();
                console.log("resp: " + allBooksRespones.data);
                setBooks(allBooksRespones.data);
                setLoading(false);
            }
            catch (e) {
                setError("Failed to fetch books");
                setLoading(false);
                console.error(e);
            }
        };
        fetchAllBooks();
    }, []);

    if (error) {
        return <div className='alert alert-danger'>{error}</div>;
    }
    if (loading) {
        return <div>loading</div>
    }

    const listBooks = books.map(book => 
        <li key={book.id}>
        <p>
            {book.title} by {book.author}
            <DeleteButton message={book.id}/>
        </p>
        </li>
    );

    return (
        <ul className='no-bullets-list'>{listBooks}</ul>
    );
};
export default BookList;