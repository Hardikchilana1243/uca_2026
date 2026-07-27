self.onmessage = function (event) {
    const users = event.data;

    if (!users || users.length === 0) {
        self.postMessage({
            error: "No users returned from the API."
        });
        return;
    }

    const result = users.map(user => {
        return `${user.name} - ${user.active ? "Active" : "Inactive"}`;
    });

    self.postMessage({
        users: result
    });
};