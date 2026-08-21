const worker = new Worker("worker.js");

const usersDiv = document.getElementById("users");

worker.postMessage("fetch");

worker.onmessage = function (event) {

    if (event.data.error) {
        usersDiv.innerHTML = "<p>No users found</p>";
        return;
    }

    usersDiv.innerHTML = "";

    event.data.users.forEach(user => {

        const p = document.createElement("p");

        p.textContent = `${user.name} - ${user.active ? "Active" : "Inactive"}`;

        usersDiv.appendChild(p);

    });

};