import { getCsrfInfo } from './modules/csrf.js'

export async function deleteSong(id) {
    return fetch(`/api/songs/${id}`, {
        method: 'DELETE',
        headers: {
            'Content-Type': 'application/json',
            ...getCsrfInfo()
        }
    })
}
const deleteButtons = document.querySelectorAll('.delete-song')
deleteButtons.forEach((button) => {
    button.addEventListener('click', async () => {
        const row = button.parentNode.parentNode
        const id = row.getAttribute('song-id')
        const response = await deleteSong(id)
        if (response.ok) {
            window.location.href = '/songs'
        } else {
            // eslint-disable-next-line no-alert
            alert('Something went wrong')
        }
    })
})
