import React, { useState, useEffect } from 'react';
import { libraryService } from '../services/api';

function DeleteButton({id, fetchBookList}) {
    async function deleteClick() {
        await libraryService.deleteBook(id);
        fetchBookList();
    }

    return (
        <button className='delete-button' onClick={deleteClick}>
            Delete
        </button>
    );
}
export default DeleteButton;