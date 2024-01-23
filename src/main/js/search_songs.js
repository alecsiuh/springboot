import '../scss/search.css'

const searchInput = document.getElementById('searchValue')
const searchResults = document.getElementById('searchResults')
const table = document.getElementById('table')
const tableBody = searchResults.querySelector('tbody')

export async function searchAlbum() {
    const searchTerm = searchInput.value
    if (searchTerm && searchTerm.trim().length >= 3) {
        const response = await fetch(`api/songs?searchValue=${searchTerm}`, {
            method: 'GET',
            headers: {
                Accept: 'application/json'
            }
        })
        if (response.status === 200) {
            const album = await response.json()
            searchResults.style.visibility = 'visible'
            table.style.visibility = 'hidden'
            album.forEach((object) => {
                tableBody.innerHTML += `
                    <tr>
                      <td>${object.songName}</td>
                      <td>${object.duration}</td>
                      <td>${object.genre}</td>
                    </tr>`
            })
        }
        if (response.status !== 200) {
            // eslint-disable-next-line no-alert
            alert('No matching results')
        }
    }
}

searchInput.addEventListener('input', searchAlbum)
