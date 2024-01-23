import { getCsrfInfo } from './modules/csrf.js'

const saveButton = document.querySelector('.btn-primary')
// eslint-disable-next-line consistent-return
export async function saveAlbum() {
    const row = saveButton.parentNode.parentNode
    const id = row.getAttribute('album-id')

    const response = await fetch(`/api/albums/${id}`, {
        method: 'PATCH',
        headers: {
            'Content-Type': 'application/json',
            ...getCsrfInfo()
        },
        body: JSON.stringify({ name: document.querySelector('input').value })
    })
    if (response.status === 200) {
        const album = await response.json()
        window.location.reload()
        // eslint-disable-next-line no-alert
        return album
    }
    if (response.status !== 200) {
        // eslint-disable-next-line no-alert
        alert(`Error: ${response}`)
    }
}

saveButton.addEventListener('click', saveAlbum)
