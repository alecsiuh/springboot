import { getCsrfInfo } from './modules/csrf.js'

export async function deleteAlbum(id) {
    return fetch(`/api/albums/${id}`, {
        method: 'DELETE',
        headers: {
            'Content-Type': 'application/json',
            ...getCsrfInfo()
        }
    })
}

const deleteButtons = document.querySelectorAll('.delete-album')
deleteButtons.forEach((button) => {
    button.addEventListener('click', async () => {
        const row = button.parentNode.parentNode
        const id = row.getAttribute('album-id')
        const response = await deleteAlbum(id)
        if (response.ok) {
            window.location.href = '/albums'
        } else {
            // eslint-disable-next-line no-alert
            alert('Something went wrong')
        }
    })
})
