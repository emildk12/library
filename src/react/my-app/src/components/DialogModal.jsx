import { useRef } from 'react';
import { libraryService } from '../services/api';


export default function DialogModal({isOpen, setOpen, fetchAllBooks}) {
    const modalRef = useRef();
    const titleRef = useRef();
    const authorRef = useRef();

    function close() {
        const dialog = modalRef.current;
        titleRef.current.value = "";
        authorRef.current.value = "";  
        dialog.close();
        setOpen(false);
    }
    async function handleSubmit(e) {
        e.preventDefault();
        await libraryService.addBook(titleRef.current.value, authorRef.current.value);
        fetchAllBooks();
        close();
    }

    if(isOpen) {
        const dialog = modalRef.current;
        dialog.showModal();  
    }

    return (
        <dialog ref={modalRef} className='dialog-box'> 
            <form onSubmit={handleSubmit}>
                <div>
                    Title
                </div>
                <div>
                    <input className='input-field' ref={titleRef}></input>
                </div> 
                <div>
                    Author
                </div>
                <div>
                    <input className='input-field' ref={authorRef}></input>
                </div> 
                <button className='add-button' type="submit">
                    Add Book
                </button>
                <button className='delete-button' onClick={close}>
                    Cancel
                </button>
            </form>
        </dialog>
    )
}