const worker = new Worker("worker.js");

async function fetchUsers() {
    try {
        const response = await fetch("https://dummyapi.com/users");

        if (!response.ok) {
            throw new Error("Failed to fetch users");
        }

        const users = await response.json();

        worker.postMessage(users);
    } catch (error) {
        console.error("Error:", error.message);
    }
}

worker.onmessage = function (event) {
    if (event.data.error) {
        console.error(event.data.error);
    } else {
        event.data.users.forEach(user => console.log(user));
    }
};

fetchUsers();