import { useRef } from 'react';

export default function DialogModal({ isOpen, setOpen}) {
    const ref = useRef();

    function click() {
        const dialog = ref.current;
        dialog.close();
        setOpen(false);
    }

    if(isOpen) {
        const dialog = ref.current;
        dialog.showModal();  
    }

    return (
        <dialog ref={ref}>        
            <button className='add-button' onClick={click}>
                Add Book
            </button>
        </dialog>
    )
}