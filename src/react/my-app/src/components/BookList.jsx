import DeleteButton from './DeleteButton';

export default function BookList({error, loading, books, fetchAllBooks}) {


    if (error) {
        return <div className='alert alert-danger'>{error}</div>;
    }
    if (loading) {
        // fetchAllBooks();
        return <div>loading</div>
    }

    const listBooks = books.map(book => 
        <li key={book.id} className='container'>
            <div className='li-text'>
                {book.title} by {book.author}
            </div>
            <div className='li-button'>
                <DeleteButton 
                    id={book.id}
                    fetchBookList = {fetchAllBooks}
                />
            </div>    
        </li>
    );

    return (
        <ul className='no-bullets-list'>{listBooks}</ul>
    );
};