import React, { useState, useEffect } from 'react';
import { libraryService } from '../services/api';
import BookList from './BookList';

function DeleteButton(props) {
    function deleteClick() {
        libraryService.deleteBook(props.message);
    }

    return (
        <button className='delete-button' onClick={deleteClick}>
            Delete
        </button>
    );
}
export default DeleteButton;