// eslint-disable-next-line import/no-extraneous-dependencies
// import bcrypt from 'bcrypt'

import { getCsrfInfo } from './modules/csrf.js'

const form = document.getElementById('addUserForm')
const usernameInput = document.getElementById('username')
const emailInput = document.getElementById('email')
const passwordInput = document.getElementById('password')
const submitButton = document.querySelector('#addUserForm > button')
// const saltRounds = 10
// bcrypt
//     .hash(passwordInput, saltRounds)
//     .then((hash) => {
//         console.log('Hash ', hash)
//     })
//     .catch((err) => console.error(err.message))

// eslint-disable-next-line no-use-before-define
submitButton.addEventListener('click', trySubmitForm)

function trySubmitForm() {
    const formIsValid = form.checkValidity()
    form.classList.add('was-validated')

    if (formIsValid) {
        fetch('/api/users', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json',
                ...getCsrfInfo()
            },
            body: JSON.stringify({
                username: usernameInput.value,
                email: emailInput.value,
                password: passwordInput.value
            })
        }).then((response) => {
            if (response.status === 201) {
                form.reset()
                form.classList.remove('was-validated')
            }
        })
    }
}
