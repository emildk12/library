import './App.css'
import BookList from './components/BookList';
import AddBook from './components/AddBook';
import { useState, useEffect } from 'react';
import { libraryService } from './services/api';


function App() {
    const [books, setBooks] = useState([]);
    const [error, setError] = useState(null);
    const [loading, setLoading] = useState(true);

    async function fetchAllBooks() {
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
    useEffect( () => {
        fetchAllBooks();
    }, []);
    return (
        <>
            <AddBook fetchAllBooks={fetchAllBooks}/>
            <BookList error={error} loading={loading} books={books} fetchAllBooks={fetchAllBooks}/>
        </>
    )
}

export default App