const api = "http://localhost:8080"

const authSection = document.getElementById("authSection");
const courseSection = document.getElementById("courseSection");
const logoutBtn = document.getElementById("logoutBtn");
const registerForm = document.getElementById("registerForm");
const loginForm = document.getElementById("loginForm");

const regName = document.getElementById("regName");
const regEmail = document.getElementById("regEmail");
const regPassword = document.getElementById("regPassword");
const loginEmail = document.getElementById("loginEmail");
const loginPassword = document.getElementById("loginPassword");

const btn = document.getElementById("register");
const loginBtn = document.getElementById("login");



btn.addEventListener('click', async () => {
    const response = await fetch(`${api}/students/register`, {
        method: "POST",
        headers: {
            "Content-Type": "application/json"
        },
        body: JSON.stringify({
            name: regName.value,
            email: regEmail.value,
            password: regPassword.value
        })
    });

    const data = await response.json();
    console.log(data);
});


async function loadcourse() {
    const response = await fetch(`${api}/course/all`, {
        method: "GET",
        headers: {
            "Content-Type": "application/json"
        }
    });

    const data = await response.json();
    console.log(data);

    data.forEach(element => {
        const row = document.createElement("tr");
        const table = document.getElementById("courseList");

        row.innerHTML += `
        <td>${element.name}</td>
        <td>${element.instructor}</td>
        <td>${element.duration}</td>
        <td>${element.status}</td>
        <td><button onclick="enrollment(${element.id})">Enroll</button></td>
        `
        table.appendChild(row);
    });
}



function showCourses() {
    authSection.style.display = "none";
    courseSection.style.display = "block";
    logoutBtn.style.display = "inline";
    loadcourse();
}

function showRegister() {
    registerForm.style.display = "block";
    loginForm.style.display = "none";
}

function showLogin() {
    loginForm.style.display = "block";
    registerForm.style.display = "none";
}

loginBtn.addEventListener('click', async () => {
    const response = await fetch(`${api}/students/login`, {
        method: "POST",
        headers: {
            "Content-Type": "application/json"
        },
        body: JSON.stringify({
            email: loginEmail.value,
            password: loginPassword.value
        })
    });

    const data = await response.json();
    localStorage.setItem("studentID",data.email);
    console.log(data);

    if (response.ok) {
        showCourses();
    }
});

if(localStorage.getItem("studentID")){
    showCourses();
}

async function enrollment(courseid){
    const studentID = localStorage.getItem("studentID");
    const response = await fetch(`${api}/enrollment/create`, {
        method: "POST",
        headers: {
            "Content-Type": "application/json"
        },
        body: JSON.stringify({
            studentemail: studentID,
            courseid: courseid
        })
    })

    const data = await response.json();
    console.log(data);
}

logoutBtn.addEventListener('click', () => {
    authSection.style.display = "block";
    courseSection.style.display = "none";
    logoutBtn.style.display = "none";
    registerForm.style.display = "none";
    loginForm.style.display = "none";
});
