import { useRef } from 'react';
import { libraryService } from '../services/api';
import BookList from './BookList';


export default function DialogModal({isOpen, setOpen}) {
    const modalRef = useRef();
    const titleRef = useRef();
    const authorRef = useRef();

    function click() {
        const dialog = modalRef.current;
        dialog.close();
        setOpen(false);
    }
    async function handleSubmit(e) {
        e.preventDefault();
        await libraryService.addBook(titleRef.current.value, authorRef.current.value);
        titleRef.current.value = "";
        authorRef.current.value = "";  
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
                <button className='add-button' onClick={click} type="submit">
                    Add Book
                </button>
            </form>
        </dialog>
    )
}