import axios from 'axios';

const API_BASE_URL = "http://localhost:8080/api";
const api = axios.create({
    baseURL: API_BASE_URL,
    headers: {
        'Content-Type': 'application/json'
    }
});

export const libraryService = {
    findAllBooks: () => api.get("/findallbooks"),
    findBook: (id) => api.get("/findbook?id=" + id),
    addBook: (title, author) => api.post("/addbook?title=" + title + "&" + author),
    deleteBook: (id) => api.delete("/deletebook?id=" + id)
}
export default api;