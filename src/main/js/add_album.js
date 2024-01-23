import Joi from 'joi'
import { getCsrfInfo } from './modules/csrf.js'

const form = document.getElementById('addAlbumForm')
const title = document.getElementById('title')
const amountOfSongs = document.getElementById('amountOfSongs')
const releaseDate = document.getElementById('releaseDate')
const submitButton = document.querySelector('#addAlbumForm > button')

const keysToInputs = new Map()
keysToInputs.set('title', title)
keysToInputs.set('amountOfSongs', amountOfSongs)
keysToInputs.set('releaseDate', releaseDate)

const albumSchema = Joi.object({
    title: Joi.string()
        .required(),
    amountOfSongs: Joi.number()
        .required()
        .min(1),
    releaseDate: Joi.date()
        .required()
})

function trySubmitForm() {
    const albumObject = {
        title: title.value,
        amountOfSongs: amountOfSongs.value,
        releaseDate: releaseDate.value
    }
    const validationResult = albumSchema.validate(albumObject, { abortEarly: false })
    console.log(validationResult)

    title.setCustomValidity('')
    amountOfSongs.setCustomValidity('')
    releaseDate.setCustomValidity('')

    if (validationResult.error) {
        for (const errorDetail of validationResult.error.details) {
            const inputField = keysToInputs.get(errorDetail.context.key)
            inputField.setCustomValidity(errorDetail.message)
            inputField.nextElementSibling.innerHTML = errorDetail.message
        }
    }

    form.classList.add('was-validated')

    if (!validationResult.error) {
        fetch('/api/albums', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json',
                ...getCsrfInfo()
            },
            body: JSON.stringify(albumObject)
        })
            .then((response) => {
                if (response.status === 201) {
                    form.reset()
                    form.classList.remove('was-validated')
                }
            })
    }
}

submitButton.addEventListener('click', trySubmitForm)
