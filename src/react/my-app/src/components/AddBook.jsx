import React, { useState, useEffect } from 'react';
import DialogModal from './DialogModal.jsx';


export default function AddBook({fetchAllBooks}) {
    const[show, setShow] = useState(false);

    return (
        <>
            <button className='add-button' onClick={() => setShow(true)}>Add Book</button>
            <DialogModal isOpen={show} setOpen={setShow} fetchAllBooks={fetchAllBooks}>
            </DialogModal>
        </>
    )
}