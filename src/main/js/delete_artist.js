import { getCsrfInfo } from './modules/csrf.js'

export async function deleteArtist(id) {
    return fetch(`/api/artists/${id}`, {
        method: 'DELETE',
        headers: {
            'Content-Type': 'application/json',
            ...getCsrfInfo()
        }
    })
}
const deleteButtons = document.querySelectorAll('.delete-artist')
deleteButtons.forEach((button) => {
    button.addEventListener('click', async () => {
        const row = button.parentNode.parentNode
        const id = row.getAttribute('artist-id')
        const response = await deleteArtist(id)
        if (response.ok) {
            window.location.href = '/artists'
        } else {
            // eslint-disable-next-line no-alert
            alert('Something went wrong')
        }
    })
})
