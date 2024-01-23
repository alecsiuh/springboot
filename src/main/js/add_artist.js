import Joi from 'joi'
import { getCsrfInfo } from './modules/csrf.js'

const form = document.getElementById('addArtistForm')
const name = document.getElementById('name')
const gender = document.getElementById('gender')
const debutYear = document.getElementById('debutYear')
const submitButton = document.querySelector('#addArtistForm > button')

const keysToInputs = new Map()
keysToInputs.set('name', name)
keysToInputs.set('gender', gender)
keysToInputs.set('debutYear', debutYear)

const artistSchema = Joi.object({
    name: Joi.string()
        .required(),
    gender: Joi.string()
        .required(),
    debutYear: Joi.number()
        .required()
        .min(1)
})

function trySubmitForm() {
    const artistObject = {
        name: name.value,
        gender: gender.value,
        debutYear: debutYear.value
    }
    const validationResult = artistSchema.validate(artistObject, { abortEarly: false })
    console.log(validationResult)

    name.setCustomValidity('')
    gender.setCustomValidity('')
    debutYear.setCustomValidity('')

    if (validationResult.error) {
        for (const errorDetail of validationResult.error.details) {
            const inputField = keysToInputs.get(errorDetail.context.key)
            inputField.setCustomValidity(errorDetail.message)
            inputField.nextElementSibling.innerHTML = errorDetail.message
        }
    }

    form.classList.add('was-validated')

    if (!validationResult.error) {
        fetch('/api/artists', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json',
                ...getCsrfInfo()
            },
            body: JSON.stringify(artistObject)
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
